package j11.ocp.java_OOA.inner_and_final_classes;

public class Q2_1233{
   public class A{   }
   public static class B{   }
   public void useClasses()   {
      //1
      new Q2_1233().new A();
      new Q2_1233.B();

      new A();  // this implied
      this.new A();

      new Q2_1233.A(); // this.new A();
   }
   public static void m(){
      new Q2_1233().new A();
      new Q2_1233.B();

//      new A();  // this implied
//      this.new A();

//      new Q2_1233.A(); // this.new A();
   }
}
