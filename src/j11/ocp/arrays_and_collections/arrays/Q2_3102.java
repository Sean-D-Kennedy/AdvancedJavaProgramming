package j11.ocp.arrays_and_collections.arrays;

import java.util.Arrays;

public class Q2_3102 {
    public static void main(String[] args) {
        compare();
//        mismatch();
    }
    public static void compare(){
        // Compares two arrays lexicographically.
        
         int[] a = { 'h', 'e', 'l'};         
         int[] b = { 'h', 'e', 'l', 'l', 'o'};
         // As 'a' is a proper prefix, we compare the lengths of the arrays
         System.out.println(Arrays.compare(a, b));     // -2    
         System.out.println(Arrays.compare(b, a));     // 2    
        
         // 'k' - 'z' = -1
         int[] c = { 'h', 'e', 'k'};         
         int[] d = { 'h', 'e', 'z', 'l', 'o'};
         System.out.println(Arrays.compare(c, d));     // -1    

         // 'x' - 'l' = 1
         int[] e = { 'h', 'e', 'x'};         
         int[] f = { 'h', 'e', 'l', 'l', 'o'};
         System.out.println(Arrays.compare(e, f));     // 1    

         // both arrays are the same => 0
         int[] g = { 'h', 'e', 'm'};         
         int[] h = { 'h', 'e', 'm'};
         System.out.println(Arrays.compare(g, h));     // 0    
    }
    public static void mismatch(){
        // Finds and returns the index of the first mismatch between two arrays, 
        // otherwise return -1 if no mismatch is found

        // proper prefix
         int[] a = { 'h', 'e', 'l'};         
         int[] b = { 'h', 'e', 'l', 'l', 'o'};
         System.out.println(Arrays.mismatch(a, b)); // 3, index of second 'l'
         System.out.println(Arrays.mismatch(b, a)); // 3, note: 3 is length of 'a'
        
         int[] c = { 'h', 'e', 'l'};         
         int[] d = { 'h', 'e', 'l'};
         System.out.println(Arrays.mismatch(c, d)); // -1, both the same
        
        // common prefix
         int[] e = { 'h', 'e', 'm'};         
         int[] f = { 'h', 'e', 'l', 'l', 'o'};
         System.out.println(Arrays.mismatch(e, f)); // 2, index of 'm' and first 'l'
    }
    
}
