package j25.stream_gatherers;

import module java.base;

public class CombinerDemo {
    void main() {
        long n =
                IntStream.rangeClosed(1, 400)
                        .parallel()
                        .boxed()// IntStream -> Stream<Integer> (gatherers work on object streams)
                        .gather(countElementsInParallel())
                        .findFirst()// as the gatherer just emits one element
                        .orElseThrow();

        IO.println(n); // 400
    }
//    Gatherer<T, A, R> is conceptually:
//      T = input element type (what comes into the gatherer) - Integer here
//		A = integrator/state type (the per-subtask mutable state) - Counter here
//            - initializer creates it
//            - integrator mutates it
//            - combiner merges two of them
//            - finisher turns it into output
//            - because Counter is a local class (declared inside the method), we hide A with '?'
//		R = output element type (what the gatherer emits downstream) - Long here
    static <T> Gatherer<T, ?, Long> countElementsInParallel() {
        final class Counter { long n; } // local class: cannot be static

        return Gatherer.of( // not Gatherer.ofSequential(..) this time
                // initializer (a mutable low-cost object e.g. array is also an option)
                // called once per subtask; multiple subtasks => multiple Counters, possibly created/used in parallel
                Counter::new,
                Gatherer.Integrator.ofGreedy((Counter state, T _, Gatherer.Downstream<? super Long> downstream) -> {
                    // integrator - process all the elements in a particular subtask
                    state.n++; // just counting the elements
                    return !downstream.isRejecting();
                }),
                // combiner
                (Counter left, Counter right) -> {
                    // 'left' and 'right' are two partial states (each may already represent merged subtasks)
                    // add them together into 'left'; keep 'left' and discard 'right'
                    left.n += right.n;
                    return left;
                },
                // finisher
                (Counter state, Gatherer.Downstream<? super Long> downstream) ->
                        // push our overall number downstream
                        downstream.push(state.n)
        );
    }
}
