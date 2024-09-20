package j11.ocp.streams_and_lambda.parallel_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;


public class Q2_1778 {
    public static void main(String[] args) {
        BinaryOperator<String> bo = (s1, s2) -> s1.concat(s2);
        List<String> names  = new ArrayList<>();
        names.add("Bill"); names.add("George"); names.add("Obama");
//        String finalvalue = names.stream().reduce("Hello : ", bo);
        String finalvalue = names.stream().filter(name -> name.startsWith("S")).reduce("Hello : ", bo);
        System.out.println(finalvalue);
    }
}
