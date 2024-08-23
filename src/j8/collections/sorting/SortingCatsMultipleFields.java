package j8.collections.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingCatsMultipleFields {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Trixy", 5));
        cats.add(new Cat("Bella", 7));
        cats.add(new Cat("Bella", 2)); // second Bella
        Comparator<Cat> compCat = Comparator
                                        .comparing(Cat::getName)
                                        .thenComparingInt(Cat::getAge);
        Collections.sort(cats, compCat);
        System.out.println(cats);// [Cat{name=Bella, age=2}, Cat{name=Bella, age=7}, Cat{name=Trixy, age=5}]
    }
    
}
