package j8.ocp.advanced_class_design;

class OuterWorld {   
    public InnerPeace i = new InnerPeace();   
    private class InnerPeace   {      
        private String reason = "none";   
    } 
}
class OuterOuterWorld extends OuterWorld{
    void m(){
        // both InnerPeace and reason are private in OuterWorld
        //System.out.println(new OuterWorld().i.reason);
    }
}
class SomeOtherWorld{
    void m(){
        // both InnerPeace and reason are private in OuterWorld
        //System.out.println(new OuterWorld().i.reason);
    }
}
public class Q2_1580 {
    
}
