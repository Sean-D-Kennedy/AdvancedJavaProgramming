package j11.ocp.java_OOA.object_initialisation;

class A{
   public A() { }
   public A(int i) {   System.out.println(i );    }
}
class B{
   static A s1 = new A(1);
   A a = new A(2);
   public static void main(String[] args){
//      B b = new B();
      A a = new A(3);
   }
   static A s2 = new A(4);
}

public class Q2_1170 {
    
}
