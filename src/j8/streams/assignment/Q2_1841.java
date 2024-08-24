package j8.streams.assignment;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Q2_1841 {

    public static void main(String[] args) {
//        AtomicInteger ai = new AtomicInteger(); // initial value of 0
//        Stream.of(11, 11, 22, 33)
//                .parallel()
//                .filter(n -> {
//                    ai.incrementAndGet();
//                    return n % 2 == 0;
//                })
//                .forEach(System.out::println);//22
//        System.out.println(ai);//4

// 1 of 2
//        AtomicInteger ai = new AtomicInteger(); // initial value of 0
//        Stream<Integer> stream = Stream.of(11, 11, 22, 33).parallel();
//        stream.filter( e->{     
//            ai.incrementAndGet();     
//            return e%2==0; }); 
//        stream.forEach(System.out::println);// java.lang.IllegalStateException
//        System.out.println(ai);

// 2 of 2
        AtomicInteger ai = new AtomicInteger(); // initial value of 0
        Stream<Integer> stream = Stream.of(11, 11, 22, 33, 34).parallel();
        Stream<Integer> stream2 = stream.filter( e->{     
            ai.incrementAndGet();     
            return e%2==0; }); 
        stream2.forEach(System.out::println);// 22
        System.out.println(ai);
    }

}
