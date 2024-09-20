package j8.ocp.generics_and_collections;


import java.util.*;
class MyStringComparator implements Comparator{
    // comparison is not based on the values of the Strings themselves but on the
    // lengths of the Strings
    public int compare(Object o1, Object o2){
      int s1 = ((String) o1).length();
      int s2 = ((String) o2).length();
      return s1 - s2;
    }
}

public class Q2_1307 {
    public static void main(String[] args) {
        String[] sa = { "d", "bbb", "aaaa" };
        // Is there a String of length 2 in 'sa'?
        System.out.println(Arrays.binarySearch(sa, "cc", new MyStringComparator()));    // -2

        // Is there a String of length 1 in 'sa'?
        // It is NOT: can you find "c" in the array.
        System.out.println(Arrays.binarySearch(sa, "c", new MyStringComparator()));     // 0
    }
    
}
