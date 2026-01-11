package j25.flexible_constructors;

import java.util.Objects;
public class Dog extends Animal{
    private String theBreed;
    public Dog(String aName, String aBreed){
//        super(aName);  // pre-Java 25, super(..) or this(..) had to be 1st line in ctor
        // check breed is valid, if not valid, fail fast
        // Pre-Java 25, if breed is invalid, the super(aName) was unecessary effort...
        String breed = Objects.requireNonNull(aBreed, "breed must not be null").trim();
        if (breed.isEmpty()) {
            throw new IllegalArgumentException("breed must not be blank");
        }
        // breed is valid
        this.theBreed = aBreed; // init is ok in prologue
//        logDetails(); // cannot call instance methods before super(...)
//        String b = this.breed; // cannot read this...
//        super(aName);
    }
    @Override
    public void logDetails(){
        super.logDetails(); // Animal name
        IO.println("The Dog breed is "+theBreed);
    }
    void main(){
        Animal aDog = new Dog("Rex", "Terrier");
//        aDog.logDetails(); //ok
    }
    public Dog(){
        super(); // would be inserted by the compiler, if no explicit call present
    }
}

// Instance main() needs a no-arg constructor