package j8.ocp.advanced_class_design;

class A { } 
class TestClass {    
    public class A {       
        public void m() { }    
    }    
    class B extends A {    
    }    
    public static void main(String args[]){    
        // anonymous classes are always final
        new TestClass().new A() {   
            @Override
            public void m() { } 
        }; 
        //new B(); // works if B is static
    } 
}
public class Q2_1383 {
    
}
