package j11.ocp.streams_and_lambda.java_stream_API;

import java.util.Arrays;
import java.util.List;

public class Q2_1792 {
    public static void main(String[] args) {
//        System.out.println(Integer.max(-2,-9));

//        List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7); // 9, 3, 9, Optional[3]
        List<Integer> ls = Arrays.asList(-4,3,6,9,2,5,7);
        System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b)->a>b?a:b)); //1
        System.out.println(ls.stream().max(Integer::max).get()); //2
        System.out.println(ls.stream().max(Integer::compare).get()); //3
        System.out.println(ls.stream().max((a, b)->a>b?a:b)); //4

    }
    
}
