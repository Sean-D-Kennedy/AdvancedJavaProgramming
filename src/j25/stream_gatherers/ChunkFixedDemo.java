package j25.stream_gatherers;

import module java.base;

// 1. Why we need a Finisher.
// 2. Do not leak mutable state downstream.
public class ChunkFixedDemo {

    void main() {
        var nums = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        var chunks = nums.stream().gather(Gatherers.windowFixed(3)).toList();
        IO.println("Gatherers.windowFixed: "+chunks); // [[1, 2, 3], [4, 5, 6], [7, 8]]
        IO.println();

        chunks = nums.stream().gather(chunkFixedWithFinisher(3)).toList();
        IO.println("chunkFixedWithFinisher: "+chunks); // [[1, 2, 3], [4, 5, 6], [7, 8]]
//        chunks.get(0).add(99);   // cannot modify the emitted list - UnsupportedOperationException
        IO.println();

        chunks = nums.stream().gather(chunkFixedNoFlush(3)).toList();
        IO.println("chunkFixedNoFlush: "+chunks); // [[1, 2, 3], [4, 5, 6]]
    }

    // Same behavior as windowFixed: full chunks + final partial chunk.
    static <T> Gatherer<T, ArrayList<T>, List<T>> chunkFixedWithFinisher(int size) {
        return Gatherer.ofSequential(   // initializer, integrator, finisher
                // Initializer
                ArrayList::new, // stateful gatherer - create the 'buf' ArrayList state "memory"
                // Integrator
                Gatherer.Integrator.ofGreedy((buf, element, downstream) -> {
                    buf.add(element);
                    if (buf.size() == size) {
                        // Snapshot the buffer before emitting: don't leak our mutable state object downstream.
                        // List.copyOf() returns an unmodifiable list.
                        var chunk = List.copyOf(buf);
                        buf.clear(); // clear for the next 'chunk'
                        IO.println("  [integrator] emit full chunk: " + chunk);
                        return downstream.push(chunk);
                    }
                    return !downstream.isRejecting();
                }),
                // Finisher
                (buf, downstream) -> {
                    if (!buf.isEmpty()) {
                        var tail = List.copyOf(buf); // returns an unmodifiable list snapshot
                        IO.println("  [finisher] FLUSH leftover: " + tail);
                        downstream.push(tail);
                    } else {
                        IO.println("  [finisher] nothing to flush");
                    }
                }
        );
    }

    // Identical integrator, but finisher intentionally does NOT flush.
    // This proves the algorithm depends on the finisher to output the tail.
    static <T> Gatherer<T, ArrayList<T>, List<T>> chunkFixedNoFlush(int size) {
        return Gatherer.ofSequential(
                ArrayList::new,
                Gatherer.Integrator.ofGreedy((buf, element, downstream) -> {
                    buf.add(element);
                    if (buf.size() == size) {
                        var chunk = List.copyOf(buf);
                        buf.clear(); // this is EXACTLY why we do not push 'buf'
                        IO.println("  [integrator] emit full chunk: " + chunk);
                        return downstream.push(chunk);
                    }
                    return !downstream.isRejecting();
                })
                // No finisher (left out on purpose) => default finisher => no flush => tail is lost
        );
    }
}