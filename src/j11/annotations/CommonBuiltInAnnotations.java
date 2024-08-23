package j11.annotations;

// 1. @Override - Person
//      a) commented out - Object::toString() called
//      b) comments removed - working
//      c) rename method to "tostring()" - with @Override, we get an error
// 2. @Override - Moveable
//      a) working
//      b) make the method package-private in the class - error
// 3. @FunctionalInterface - Moveable
//      a) working
//      b) if "run()" is uncommented, now we get an error
//      c) if "equals()" is uncommented, no error
@FunctionalInterface
interface Moveable {
    void move();
//    void run();
    boolean equals(Object o); // Object methods are not counted
}
//class Person extends Object implements Moveable{
class Person implements Moveable{
    private String name;
    Person(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
    @Override
    public void move(){ // note: must be 'public'
        System.out.println("Moving");
    }
}
public class CommonBuiltInAnnotations {
    public static void main(String[] args) {
        Person sk = new Person("Sean Kennedy");
        System.out.println(sk); // sk.toString() called in the background
        sk.move();
    }
    
}
