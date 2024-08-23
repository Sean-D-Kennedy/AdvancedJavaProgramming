package j8.generics;

interface Moveable<T>{
    void move(T t);
}
class MoveFeline implements Moveable<Cat>{
    public void move(Cat c){}
}
class MoveCanine implements Moveable<Dog>{
    public void move(Dog d){}
}
class SomeMoveable<U> implements Moveable<U>{
    public void move(U u){}
}
public class GenericInterface {
    public static void main(String[] args) {
        new MoveFeline().move(new Cat()); 
//        new MoveFeline().move(new Dog()); // compiler error
        new MoveCanine().move(new Dog()); 
//        new MoveCanine().move(new Cat()); // compiler error

        new SomeMoveable<Dog>().move(new Dog());
        new SomeMoveable<Cat>().move(new Cat());
    }
}



class RawMoveable implements Moveable{ // old way
    public void move(Object o){}
}
