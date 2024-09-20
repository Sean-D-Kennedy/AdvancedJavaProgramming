package j8.ocp.generics_and_collections;

import java.util.*; 

public class Q2_1471{      
    public static void main(String[] args) {
        TreeSet<Integer> s = new TreeSet<Integer>();         
        TreeSet<Integer> subs = new TreeSet<Integer>();          

// 1. Demonstrate the IllegalArgumentException.
//        for(int i = 328; i>=324; i--){             
//            s.add(i);         
//        }         
//        subs = (TreeSet) s.subSet(326, true, 328, true );         
//        subs.add(329); // IllegalArgumentException: key out of range        
//        System.out.println(s+" "+subs);              

// 2. Demonstrate what "backed" means.
//        for(int i = 320; i<=330; i+=2){             
//            s.add(i);         
//        }         
//        subs = (TreeSet) s.subSet(322, true, 328, true );         
//        subs.add(327);         
//        System.out.println(s+" "+subs); // [320, 322, 324, 326, 327, 328, 330] [322, 324, 326, 327, 328]     

// 3. Demonstrate what "false" does in the subSet() method?
        for(int i = 320; i<=330; i++){             
            s.add(i);         
        }         
        subs = (TreeSet) s.subSet(326, false, 328, false );         
        System.out.println(s+" "+subs); // [320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330] [327]             

    }  
}