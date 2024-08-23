package j8.generics;

import java.util.ArrayList;
import java.util.List;

public class PolymorphicIssueWithGenerics {
    public static void showList(List<Object> list){
        for(Object o:list){
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        // The issue
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(12.3);
//        List<Object> objects = doubles; // COMPILER ERROR
//        objects.add("This is a String");

        // A different variation
        List<String> names = new ArrayList<String>();
        names.add("Sean");
//        showList(names); // List<Object> list = new ArrayList<String>();
    }
}



/*
package lets_get_certified.j8.generics;

import java.util.ArrayList;
import java.util.List;

public class PolymorphicIssueWithGenerics {
    
    public static void showList(List<Object> list){
//    public static void showList(List<?> list){ // any type is ok
        for(Object o:list){
            System.out.println(o);
        }
        //list.add("test"); // cannot add when <?>
    }
    public static void main(String[] args) {
        // The issue
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(12.3);
        List<Object> objects = doubles; // COMPILER ERROR
        objects.add("This is a String");

        // A different variation
        List<String> names = new ArrayList<String>();
        names.add("Sean");
        showList(names); // List<Object> list = new ArrayList<String>();
    }
    
}

*/