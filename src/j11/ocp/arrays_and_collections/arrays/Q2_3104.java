package j11.ocp.arrays_and_collections.arrays;

import java.util.Arrays;

public class Q2_3104 {
    public static void main(String[] args) {
        var a = new int[]{ 1, 2, 3, 4, 5}; 
        var b = new int[]{ 1, 2, 3, 4, 5, 3}; 
        var c = new int[]{ 1, 2, 3, 4, 5, 6};          
        int x = Arrays.compare(a, c); 
        int y = Arrays.compare(b, c); 
        System.out.println(x+" "+y); 
    }
}
