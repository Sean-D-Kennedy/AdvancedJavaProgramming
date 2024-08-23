package j8.generics;

class MyGeneric<T>{
    T instance;
    MyGeneric(T instance){
        this.instance=instance;
    }
    T getT(){
        return instance;
    }
}

public class TestGenericClass {
    public static void main(String []args){
        // String on LHS maps to T and "SK" on RHS maps to 'instance' 
        MyGeneric<String> g = new MyGeneric<>("SK");
        System.out.println(g.getT());
        // Integer on LHS maps to T and 1 on RHS maps to 'instance' 
        MyGeneric<Integer> g2 = new MyGeneric<>(1);
        System.out.println(g2.getT());
    }    
}
