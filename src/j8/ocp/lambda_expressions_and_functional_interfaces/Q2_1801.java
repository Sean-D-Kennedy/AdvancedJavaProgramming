package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.Arrays;
import java.util.List;

public class Q2_1801 {
    public static void main(String[] args) {
        List<StringBuilder> messages = Arrays.asList(new StringBuilder(), 
                                                     new StringBuilder()); 
        // Stream::forEach(Consumer c) - terminal operation
        // Consumer     void accept(T t)
        messages.stream()
                .forEach(s->s.append("helloworld"));

        // List extends Iterable
        // Iterable::forEach(Consumer c)
        messages.forEach(s->{     
            s.insert(5,",");     
            System.out.println(s); 
        });    
    }
}
