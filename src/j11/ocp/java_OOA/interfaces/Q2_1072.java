package j11.ocp.java_OOA.interfaces;

public class Q2_1072 implements T1, T2{    
    public void m1(){
        System.out.println("m1(): "+T1.VALUE+ " "+T2.VALUE); // m1(): 1 2
    } 
    public static void main(String[] args) {
        new Q2_1072().m1();
    }
    public void defMethod(){}
} 
interface T1{    
    int VALUE = 1;    
    void m1(); 
    default void defMethod(){}
} 
interface T2{    
    int VALUE = 2;    
    void m1(); 
    default void defMethod(){}
}
