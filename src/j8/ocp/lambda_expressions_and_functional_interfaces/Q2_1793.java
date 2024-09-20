package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Q2_1793 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(10, 47, 33, 23);

// Function<T,U>
//   U apply(T)   == T is Integer and U is Integer
//   (Integer i) -> {return i;}

// Integer implements Comparable

        Function<Integer, Integer> fLE  = i -> i; 
        Function<Integer, Integer> fMR  = Integer::intValue; 

        int max = ls.stream()
                // Optional<Integer> max(Comparator)
                //                          |
                //                          |-> Comparator Comparator.comparing(Function) 
//                .max(Comparator.comparing(i->i))
//                .max(Comparator.comparing(fMR))
                .max(Comparator.comparing(fLE))
                .get();
        System.out.println(max);

        int max2 = ls.stream()
                // Optional<Integer> reduce(BinaryOperator<Integer> acc)
                // BinaryOperator<T> extends functional interface BiFunction<T,U,R>
                //    BiFunction's functional method is R apply(T t, U u)
//                .reduce((a, b)->a>b?a:b)
                .reduce((a, b)->Integer.max(a, b))
                .get();
        System.out.println(max2);

        int max3 = ls.stream()
                // Integer reduce(Integer identity, BinaryOperator<Integer> acc)
                // The identity element is both the initial value of the reduction 
                // and the default result if there are no elements in the stream. 
                .reduce(Integer.MIN_VALUE, (a, b)->Integer.max(a, b));
        System.out.println(max3);
    }
}
