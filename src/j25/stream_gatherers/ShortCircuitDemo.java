package j25.stream_gatherers;

import module java.base; // Imports (on demand) all public types in all packages exported by java.base.

public class ShortCircuitDemo{
    void main() {
        // Short-circuit: stop early using custom rule
        //    (Here: keep numbers until running sum would exceed maxTotal)
        IO.println("== Short-circuit (stop early) ==");
        var input = List.of(2, 2, 2, 3, 5, 1, 1, 3, 4);
        var takeUntil =
                input.stream()
                        .gather(takeUntilTotalExceeds(10)) // short-circuit gatherer
                        .toList();
        IO.println("Stop when nextTotal > 10 => " + takeUntil); // [2, 2, 2, 3]
    }
    static Gatherer<Integer, ?, Integer> takeUntilTotalExceeds(int maxTotal) {
//        int sum=0;
        class State { int sum; }
        return Gatherer.<Integer, State, Integer>ofSequential(
                State::new, // initializer (state supplier)
                // not using ofGreedy() here:
                // ofGreedy: integrator itself never short-circuits (consumes until upstream is exhausted,
                //          or downstream rejects via push()/isRejecting()).
                // of:      integrator may short-circuit on its own (stop consuming upstream early).
                Gatherer.Integrator.of((state, element, downstream) -> {
                    // Called once per element. Must remember prior elements => we need the 'state' parameter.
//                    sum += element; // 'sum' must be final or effectively final
                    int nextTotal = state.sum + element;
                    if (nextTotal > maxTotal) {
                        return false; // short-circuit
                    }
                    state.sum = nextTotal;
                    return downstream.push(element);
                })
                // omitting optional finisher in this example
                //     - once we short-circuit, there is nothing left to flush
        );
    }
}