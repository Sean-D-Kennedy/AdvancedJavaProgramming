package j11.ocp.working_with_java_data_types.lvti;

import java.util.ArrayList;

public class Q2_3068 {
    public static void main(String[] args) {
        var values = new ArrayList<String>();
        values.add("d");
        values.add("c");
        values.add("x");
        values.add("a");
        // option a
        // sort(Comparator) => int compare(T o1, T o2)
        //      String implements Comparable => int compareTo(T o)
        values.sort((var a, var b)->a.compareTo(b)); 

        // options b
        values.sort( (a, b) -> a.compareTo(b) ); 
        values.forEach( s -> System.out.println(s) ); // forEach(Consumer) =>  void accept(T t)
        values.forEach( System.out::println ); // forEach(Consumer) =>  void accept(T t)
        
        // option d 
        values.add("a");
        System.out.println();
        // removes all elements that satisfy the given Predicate i.e. every "a"
        //     Predicate => boolean test(T t)
        values.removeIf((var k)->k.equals("a") ); 
        values.forEach( System.out::println );
        
        // option e
//        String[] sa = (String [])values.toArray();
        System.out.println();
        String[] sa = values.toArray(new String[0]);
        for(String s : sa){
           System.out.println("s == "+s);
        }
    }
    
}
