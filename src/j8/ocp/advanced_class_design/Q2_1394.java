package j8.ocp.advanced_class_design;

class Outer{
    private int op=3;
    
    class Inner extends Object{
        private int ip=5;
        
        void innerM(){
            // Outer.this.op gives the same result
            System.out.println("Outer private data == "+op);
        }
    }
    void outerM(){
        System.out.println("Inner private data == "+new Inner().ip);
    }
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.innerM();
        
        new Outer().outerM();
    }
}
public class Q2_1394 {
}
