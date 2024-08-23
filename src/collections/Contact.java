package collections;

public class Contact {
    private int age;
    private String name;

    public Contact(String name, int age) {
        this.age  = age;
        this.name = name;
    }
    @Override
    public int hashCode() {         // both instance variables 'age' and 'name' are used 
        int hash = 7;
        hash = 89 * hash + this.age;
        hash = 89 * hash + this.name.length(); // a weak algorithm - demo purposes
        return hash;
    }
    @Override
    public boolean equals(Object obj) { // same instance variables used as in equals()! 
        if (obj instanceof Contact) {
            Contact otherContact = (Contact) obj;
            return this.name.equals(otherContact.name) && this.age == otherContact.age;
        } 
        return false;        
    }
    @Override
    public String toString(){
        return name + ", " + age;
    }
}
