package j8.generics;

import java.util.ArrayList;
import java.util.List;

public class WhyExtends {
    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<Dog>();
        dogList.add(new Dog());
        dogList.add(new Dog());
//        checkAnimals(dogList);
    }
    public static void checkAnimals(List<Animal> animals){
        // List<Animal> animals = new ArrayList<Dog>;
        animals.add(new Cat());
    }
}
