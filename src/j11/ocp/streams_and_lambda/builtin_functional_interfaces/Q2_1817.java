package j11.ocp.streams_and_lambda.builtin_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Q2_1817 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "aa", "aaa"); 
        Function<String, Integer> f = x->x.length(); 
        Consumer<Integer> c = x->System.out.print("Len:"+x+" "); 
        strList.stream().map(f).forEach(c); 
    }
    
}
