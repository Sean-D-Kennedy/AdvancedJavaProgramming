package j8.ocp.generics_and_collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q2_1511 {
    public static void main(String[] args) {
        String[] names = new String[]{"25", "C", "c", "34", "D", "d"};
        List<String> list = Arrays.asList(names);
        Collections.sort(list);
        System.out.println(list);
        
    }
    
}

// correct = [25, 34, C, D, c, d]