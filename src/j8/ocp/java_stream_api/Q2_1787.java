package j8.ocp.java_stream_api;
// Stream is a sequence of objects
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q2_1787 {

    public static void main(String[] args) {
        Stream<List<String>> streamOfLists = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("d", "c"),
                Arrays.asList("a", "c"));

        streamOfLists
                // Stream<List<String>> filter(Predicate)   Predicate == boolean test(T t)
                .filter(list -> list.contains("c"))
                // Stream<List<String>> peek(Consumer)
                .peek(list -> System.out.println("\n"+list)) // 1. [d,c]    2. [a,c]
                // Stream<String> flatMap(Function)  
                //      Function<T,R> == R apply(T t)
                //          Stream<String> apply(List<String> l)
                .flatMap(list -> list.stream())
//                .flatMap(List::stream)
               //     forEach() is a terminal operation
                .forEach(str -> System.out.print(str+ " ")); // 1.  d c     2.  a c  
        System.out.println();

//            List<String> list = Arrays.asList("a", "b", "c");
//            list.forEach(s -> System.out.println(s)); // Consumer == void accept(T t)
//            Stream<String> stream = list.stream();
//            stream.forEach(System.out::println);
    }

}
