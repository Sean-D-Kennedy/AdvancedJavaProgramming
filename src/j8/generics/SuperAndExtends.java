package j8.generics;

import java.util.ArrayList;
import java.util.List;

class Animal{}
class Dog extends Animal {}
class Terrier extends Dog {}
class Cat extends Animal {}
class Manx extends Cat{}

public class SuperAndExtends {
    public static void addAnimal(Animal[] animals){
        animals[0] = new Dog();
//        animals[1] = new Cat();// ArrayStoreException generated -  JVM knows the type
    }
    public static void addAnimal(List<Animal> animals){
        animals.add(new Dog());
    }
    public static void main(String[] args) {      
        // 1a. Polymorphic assignments.
        // Generics came in in Java 5. Type erasure required to support legacy code.
        // Thus, j8.generics offer compile time protection.
        // Arrays have similar issues (polymorphic assignments) but the difference is
        // in how the compiler and JVM behave. Due to type erasure with j8.generics,
        // the JVM does not know the types; with arrays the JVM does.
        
        // First, let's look at arrays
        Dog[] dogs0 = {new Dog(), new Dog()};
        addAnimal(dogs0);
        
        // polyorphism ok for the base type; List -> ArrayList
        List<Cat> cats1 = new ArrayList<Cat>(); 
        // polyorphism not ok for the generic type; Animal -> Cat
 //       List<Animal> animals = new ArrayList<Cat>();
        List<Cat> cats2  = new ArrayList<Cat>(); // generic types on both sides must match
        List<Cat> cats3 = new ArrayList<>();     // or use type inference
        // As the JVM does not know the types (stripped out during type erasure), the
        // compiler has to step in. 
//        addAnimal(cats2);

        // 1b. 'extends' - polymorphic assignments
        // Note: extends is read-only
        List<? extends Animal> animals1 = new ArrayList<Animal>();
//        animals1.add(new Animal());// read-only
        List<? extends Animal> animals2 = new ArrayList<Dog>();
        List<? extends Animal> animals4 = new ArrayList<Terrier>();
        List<? extends Animal> animals3 = new ArrayList<Cat>();
        List<? extends Animal> animals5 = new ArrayList<Manx>();
//        List<? extends Animal> animals6 = new ArrayList<Object>();

        // 1c. 'super' - polymorphic assignments
        List<? super Dog> dogs1 = new ArrayList<Dog>();
        dogs1.add(new Dog()); // now, can add to the list
        List<? super Dog> dogs2 = new ArrayList<Animal>();
        List<? super Dog> dogs3 = new ArrayList<Object>();
//        List<? super Dog> dogs4 = new ArrayList<Terrier>();

        // 2. declarations for 'extends' and 'super' examples
        List<Object> objects   = new ArrayList<>(); objects.add(new Object());
        List<Animal> animals   = new ArrayList<>(); animals.add(new Animal());
        List<Cat> cats         = new ArrayList<>(); cats.add(new Cat());
        List<Manx> manxCats    = new ArrayList<>(); manxCats.add(new Manx());
        List<Dog> dogs         = new ArrayList<>(); dogs.add(new Dog());
        List<Terrier> terriers = new ArrayList<>(); terriers.add(new Terrier());
        
        // 3. extends
        //      ext(List<? extends Animal> list) => readonly
        ext(animals); // Animal is-an Animal        - OK
        ext(cats);    // Cat is-an Animal           - OK
        ext(manxCats);// Manx is-an Animal          - OK
        ext(dogs);    // Dog is-an Animal           - OK
        ext(terriers);// Terrier is-an Animal       - OK
//        ext(objects); // Object is-not an Animal    - not OK

        // 4. super
        //      spr(List<? super Cat> list) => modifiable
        spr(cats);    // Cat is Cat                     - OK
        spr(animals); // Animal is a supertype of Cat     - OK
        spr(objects); // Object is a supertype of Cat     - OK
//        spr(dogs);    // compiler error: Dog is not Cat or a supertype of Cat     - not OK
//        spr(terriers);// compiler error: Terrier is not Cat or a supertype of Cat - not OK
//        spr(manxCats);// compiler error: Manx is not Cat or a supertype of Cat    - not OK
    }
    public static void spr(List<? super Cat> list){ // The "lower-bound" is Cat.
        // IN: Cat, Animal, Object.
        // The only objects that can safely be added are any type of Cat (including subtypes) 
        // because the method could be getting in a list of Animals or Objects (or Cats).
        list.add(new Cat());    // Cat is-a Cat (Cat is-an Animal, Cat is-an Object) 
        list.add(new Manx());   // Manx is-a Cat (Manx is-an Animal, Manx is-an Object) 
        
//        list.add(new Dog());    // compiler error - Dog is not a Cat
//        list.add(new Animal()); // compiler error - Animal is not a Cat (Cat is an Animal)
//        list.add(new Object()); // compiler error - Object is not a Cat (Cat is an Object)
        
//        for(Cat cat:list){      // compiler errors when reading - 'list' passed in could be Animal's
//            System.out.println(cat);
//        }
//        for(Animal a:list){      // compiler errors when reading - 'list' passed in could be Object's
//            System.out.println(a);
//        }
        for(Object o:list){         // ok - the only thing we can safely say is that the 'list'
            System.out.println(o);  // coming in can all be treated as Object's
        }                           // Cat is-an Object, Animal is-an Object, Object is-an Object
    }
    public static void ext(List<? extends Animal> list){ // "upper-bound" is Animal
        // 'extends' implies read-only
        // IN: List<Animal>, List<Cat>, List<Manx>, List<Dog>, List<Terrier>
        // If 'extends' allowed us to add to 'list', then we could take in 
        // a List of Cat's and add a Dog to it - thereby breaking type safety.
//        list.add(new Cat());      // compiler error if we try to modify 'list'
//        list.add(new Dog());      // compiler error if we try to modify 'list'
//        list.add(new Animal());   // compiler error if we try to modify 'list'
//        for(Dog dog:list){        // compiler errors reading - 'list' could be a list of Cat's
//            System.out.println(dog);
//        }
        // No compiler errors reading once we treat them as Animal; whether this method receives 
        // in a list of Animal, Cat, Manx, Dog, or Terrier; they are *all* Animal.
        for(Animal animal:list){        
            System.out.println(animal);  
        }                               
    }
}
