package j11.ocp.streams_and_lambda.builtin_functional_interfaces;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class Q2_3339 {

    public static void generateMultiplicationTable(int number) {
        Stream<Integer> sin = Stream.of(1, 2, 3);
        Consumer<Integer> c1 = System.out::print;
        Consumer<Integer> c2 = x -> {
            System.out.println(" * " + number + " = " + x * number);
        };
        sin.forEach(c2.andThen(c1));
    }

    public static void main(String[] args) throws Exception {
        generateMultiplicationTable(2);
    }
}
