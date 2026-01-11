package j25.stream_gatherers;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class BuiltInGatherersDemo {
    void main() {
        // CHUNKS (fixed windows) - no overlap, the last one may be shorter
        var fixed = Stream.of(1,2,3,4,5,6,7,8)
                .gather(Gatherers.windowFixed(3))
                .toList();
        IO.println("windowFixed(3)  => " + fixed);// [[1, 2, 3], [4, 5, 6], [7, 8]]

        // SLIDING WINDOWS - overlapping
        var sliding = Stream.of(1,2,3,4,5,6,7,8)
                .gather(Gatherers.windowSliding(3))
                .toList();
        IO.println("windowSliding(3)=> " + sliding);// [[1, 2, 3], [2, 3, 4], [3, 4, 5], [4, 5, 6], [5, 6, 7], [6, 7, 8]]

        // RUNNING TOTALS - emits one result per input element
        var runningTotals = Stream.of(1,2,3,4,5)
//                .gather(Gatherers.scan(() -> 0, (a, b) -> a + b)) // lambda version
                .gather(Gatherers.scan(() -> 0, Integer::sum))
                .toList();
        // Note: reduce() gives one final result at the end, scan() produces all the running totals along the way
        IO.println("scan(sum)       => " + runningTotals);// [1, 3, 6, 10, 15]
    }
}
