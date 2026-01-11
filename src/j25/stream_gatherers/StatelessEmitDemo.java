package j25.stream_gatherers;

import module java.base; // Imports (on demand) all public types in all packages exported by java.base.

// 1. What does a stateless gatherer look like.
// 2. How a custom gatherer can emit 0, 1 or more elements.

// Stream.filter is a built-in intermediate operation (emits 0 or 1 element per input).
// Gatherers generalize this idea to 0 or 1 or many outputs.
public class StatelessEmitDemo {
    void main() {
        var nums = List.of(1, 2, 3, 4);

        // 0 or 1 per input (filter-like)
        var evens =
                nums.stream()
                        .gather(filter(i -> i % 2 == 0))
                        .toList();
        IO.println("filter (evens) => " + evens);

        // many per input (duplicate each element)
        var doubled =
                nums.stream()
                        .gather(duplicateEach())
                        .toList();
        IO.println("duplicateEach (x2) => " + doubled);
    }
    // filter(...) here is a gatherer version of Stream.filter(predicate): emits 0 or 1 element per input.
    static <T> Gatherer<T, ?, T> filter(Predicate<? super T> predicate) {
        return Gatherer.ofSequential(
                // Using ofGreedy(): this integrator never self short-circuits.
                // Stateless gatherer: Gatherer<T, ?, T> hides an unused state type (hence the 'unused' parameter).
                //      - each decision depends only on the current element
                //      - we don't need to remember anything between elements (no local 'State' class)
                Gatherer.Integrator.ofGreedy((unused, element, downstream) -> {
                    if (predicate.test(element)) {
                        return downstream.push(element); // True means more elements can be sent
                    }
                    return !downstream.isRejecting(); // keep going unless downstream has cancelled
                })
                // omitting optional finisher in this example
        );
    }
    // duplicateEach() shows what Stream.filter cannot do: emit multiple outputs per input (here 2).
    static <T> Gatherer<T, ?, T> duplicateEach() {
        return Gatherer.ofSequential(
                Gatherer.Integrator.ofGreedy((unused, element, downstream) ->
                        downstream.push(element) && downstream.push(element)
                )
        );
    }
}
