package j25.flexible_constructors;

import java.util.Objects;

public class Animal {
    private String theName;
    public Animal(String aName){
        // check name is valid
        String name = Objects.requireNonNull(aName, "name must not be null").trim(); // NPE
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        // name is valid
        theName = aName;
        // Note: It is bad practice for a constructor to invoke an overridable method
        // Making logDetails() 'final' or 'private' solves this
        logDetails();
    }
    // a polymorphic method
    public void logDetails(){
        IO.println("The Animal name is "+theName);
    }
    public Animal(){}
}
