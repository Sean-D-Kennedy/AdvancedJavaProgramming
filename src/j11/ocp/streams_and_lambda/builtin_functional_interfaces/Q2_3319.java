package j11.ocp.streams_and_lambda.builtin_functional_interfaces;

import java.util.function.Function;

public class Q2_3319 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdef"); 

        // Function<T,​R> 
        //   R apply(T t)
//        Function<Character, String> f = c->""+Character.valueOf((char)(c+1));
//        Function<Character, String> f = c->{
//            System.out.print("c == "+c+"\t");
//            // Character valueOf(char c)
//            System.out.println("returning: "+Character.valueOf((char)(c+1)));// c+1 is an int
//            return ""+Character.valueOf((char)(c+1));
//        };
        Function<Character,String> f = i->new String(i.toString()); // last option = "abcdef"
        
        for(int i = 0, k = sb.length(); i<k; i++){     
            //  char charAt(int index)  => Character is the input to the Function
            //  replace(startIncl, endExcl, String)
            sb.replace(i, i+1, f.apply(sb.charAt(i))); 
        } 
        System.out.println(sb);    // bcdefg
        
    }
}
