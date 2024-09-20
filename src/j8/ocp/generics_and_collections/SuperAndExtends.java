package j8.ocp.generics_and_collections;

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
        animals[1] = new Cat();// ArrayStoreException generated -  JVM knows the type
    }
    public static void addAnimal(List<Animal> animals){
        animals.add(new Dog());
    }
    public static void main(String[] args) {      
        // 1a. Polymorphic assignments.
        // Generics came in in Java 5. Type erasure required to support legacy code.
        // Thus, generics offer compile time protection.
        // Arrays have similar issues (polymorphic assignments) but the difference is
        // in how the compiler and JVM behave. Due to type erasure with generics, 
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




    /*
    public static void addAnimal(List<Animal> animals){
        animals.add(new Dog());
    }
    public static void polyAssignments(){
        // polyorphism ok for the base type; List -> ArrayList
        List<Cat> cats1 = new ArrayList<Cat>(); 
        // polyorphism not ok for the generic type; Animal -> Cat
//        List<Animal> animals = new ArrayList<Cat>();
        List<Cat> cats2 = new ArrayList<Cat>();
        addAnimal(cats2);
        
        List<? super Dog> dogs1 = new ArrayList<Dog>();
        dogs1.add(new Dog()); // now, can add to the list
        List<? super Dog> dogs2 = new ArrayList<Animal>();
        List<? super Dog> dogs3 = new ArrayList<Object>();
        List<? super Dog> dogs4 = new ArrayList<Terrier>();

        
        List<? extends Animal> animals1 = new ArrayList<Animal>();
        animals1.add(new Animal());// read-only
        List<? extends Animal> animals2 = new ArrayList<Dog>();
        List<? extends Animal> animals3 = new ArrayList<Cat>();
        List<? extends Animal> animals4 = new ArrayList<Terrier>();
        List<? extends Animal> animals5 = new ArrayList<Object>();

        
        List<Animal> animals = new ArrayList<Dog>();// poly not allowed unless ? used

    }

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>(); objects.add(new Object());
        List<Animal> animals = new ArrayList<>(); animals.add(new Animal());
        List<Cat> cats       = new ArrayList<>(); cats.add(new Cat());
        List<Dog> dogs       = new ArrayList<>(); dogs.add(new Dog());
        List<Manx> manxCats  = new ArrayList<>(); manxCats.add(new Manx());
        
        // super
        // List<? super Cat> => modifiable
        new Q2_1300().spr(objects); // Object is a supertype of Cat     - OK
        new Q2_1300().spr(animals); // Animal is a supertype of Cat     - OK
        new Q2_1300().spr(cats);    // Cat is-a Cat                     - OK
        new Q2_1300().spr(dogs);    // compiler error: Dog is not a Cat - not OK
        new Q2_1300().spr(manxCats);// compiler error: Manx is not Cat or a supertype of Cat
 
        // extends
        // List<? extends Animal> => readonly
        new Q5_Generics().ext(animals); // Animal is-an Animal - OK
        new Q5_Generics().ext(cats);    // Cat is-an Animal    - OK
        new Q5_Generics().ext(dogs);    // Dog is-an Animal    - OK
        new Q5_Generics().ext(objects); // Object is-not an Animal    - not OK
        new Q5_Generics().ext(manxCats);// Manx is-an Animal   - OK

    }
    public void spr(List<? super Cat> list){
        // "super" relates to the types of parameters that can be passed "in". Thus, this
        // method could get in a list of Cat's, Animal's and Object's. The only
        // objects that can safely be added are any type of Cat (including subtypes) because
        // I could be getting in a list of Animals or Objects (or Cats). The "lower-bound" is Cat.
        list.add(new Cat());    // Cat is-a Cat 
        list.add(new Manx());   // Manx is-a Cat 
        
        list.add(new Dog());    // compiler error - Dog is not a Cat
        list.add(new Animal()); // compiler error - Animal is not a Cat (Cat is an Animal)
        list.add(new Object()); // compiler error - Object is not a Cat (Cat is an Object)
        
        for(Cat cat:list){      // compiler errors when reading - 'list' passed in could be Animal's
            System.out.println(cat);
        }
        for(Animal a:list){      // compiler errors when reading - 'list' passed in could be Object's
            System.out.println(a);
        }
        for(Object o:list){        // ok - the only thing we can safely say is that the 'list'
            System.out.println(o); // coming in can all be treated as Object's
        }
    }
    public void ext(List<? extends Animal> list){
        // 'extends' implies read-only
        // if 'extends' allowed us to add to 'list', then we would be able to take 
        // in a List of Cat's and add a Dog to it - thereby breaking type safety.
        // The "upper-bound" is Animal.
        list.add(new Cat());      // compiler error if we try to modify 'list'
        list.add(new Dog());      // compiler error if we try to modify 'list'
        list.add(new Animal());   // compiler error if we try to modify 'list'
        for(Dog dog:list){        // compiler errors reading - 'list' could be a list of Cat's
            System.out.println(dog);
        }
        for(Animal animal:list){        // no compiler errors reading; whether I am passing in a list
            System.out.println(animal); // of Cat's or Dog's, they are all Animal's 
        }                               // i.e. the only thing I can safely say is that they are Animal's
    }
}
*/