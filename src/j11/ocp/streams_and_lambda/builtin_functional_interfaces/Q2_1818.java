package j11.ocp.streams_and_lambda.builtin_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;

public class Q2_1818 {
    public static void main(String[] args) {
        List<Double> dList = Arrays.asList(10.0, 12.0); 
        DoubleFunction df = x->x+10; 
//        dList.stream().forEach(df);
        dList.stream().forEach(y->y+=1); 
        dList.stream().forEach(d->System.out.println(d)); 
    }
        
}
