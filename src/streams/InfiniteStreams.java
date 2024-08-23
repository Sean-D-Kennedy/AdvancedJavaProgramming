package streams;

import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
//        for(int i=1; i<50; i++){
//            System.out.println(rand());
//        }

        iterate();
//        iterateWithLimit();


    }
    public static int rand(){
        return (int) (Math.random() * 10);
    }

    public static void iterate(){
        
        // infinite stream of ordered numbers 
        //    2, 4, 6, 8, 10, 12 etc...
        // iterate(T seed, UnaryOperator<T> fn)
        //   UnaryOperator is-a Function<T, T>
        //     T apply(T t)
        Stream<Integer> infStream = Stream.iterate(2, n -> n + 2);

        // keeps going until I kill it.
        infStream.forEach(System.out::println);
        
    }
    public static void iterateWithLimit(){
        
        // finite stream of ordered numbers 
        // 2, 4, 6, 8, 10, 12, 14, 16, 18, 20
        Stream
            .iterate(2, n -> n + 2)
            // limit() is a short-circuiting stateful
            // intermediate operation
            .limit(10) 
            // forEach(Consumer) is a terminal operation
            .forEach(System.out::println);
        
    }
    
    public static void generate(){
        // infinite stream of random unordered numbers 
        // between 0..9 inclusive
        //    Stream<T> generate(Supplier<T> s)
        //      Supplier is a functional interface:
        //          T get()
        Stream<Integer> infStream = Stream.generate(() -> {
            return (int) (Math.random() * 10);
        });
        // keeps going until I kill it.
        infStream.forEach(System.out::println);
    }
}
