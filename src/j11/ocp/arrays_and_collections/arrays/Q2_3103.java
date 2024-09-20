package j11.ocp.arrays_and_collections.arrays;

import java.util.Arrays;

public class Q2_3103 {
    public static void main(String[] args) {
        char[] a = { 'h', 'e', 'l', 'l'};         
        char[] b = { };                  
        int x = Arrays.compare(a, b);         
        int y = Arrays.mismatch(a, b);         
        System.out.println(x+" "+y); 
        System.out.println(b.length);//0
        /* API
        Two non-null arrays, a and b, share a proper prefix if the following expression is true:
            a.length != b.length &&
            Arrays.equals(a, 0, Math.min(a.length, b.length),
                          b, 0, Math.min(a.length, b.length))
        */
         boolean b1 = Arrays.equals(a, 0, Math.min(a.length, b.length),
                                    b, 0, Math.min(a.length, b.length));
         System.out.println(b1);//true
    }
    
}
