package j22.unnamed_variables_and_patterns;

import java.util.List;
import java.util.stream.IntStream;

// Using an unnamed variable in a lambda expression
public class UnnamedVariableLambda {
    public static void main(String[] args) {
        List<String> names = List.of("April", "Brendan");
        names.forEach(name -> System.out.println("Side effect...")); // 'name' not used
        names.forEach(_ -> System.out.println("Side effect..."));    // 'name' not mentioned

        IntStream.range(0, 5).forEach(i -> System.out.println("Repeating action!")); // 'i' not used
        IntStream.range(0, 5).forEach(_ -> System.out.println("Repeating action!")); // 'i' not mentioned
    }
}