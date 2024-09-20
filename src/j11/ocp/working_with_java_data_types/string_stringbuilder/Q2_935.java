package j11.ocp.working_with_java_data_types.string_stringbuilder;

class TestClass{    
    int i;    
    public TestClass(int i) { 
        this.i = i;  
    }    
    public String toString(){        
        if(i == 0) return null;        
        else return ""+i;    
    }    
    public static void main(String[ ] args){       
        /*
        PrintStream::println(Object o)
            -> String.valueOf(o) where the logic is:
                    if(o==null) return "null";
                    else o.toString();
                    => unless the object reference passed in to println() is 'null' then toString() is called!
        */
        TestClass t1 = new TestClass(0);       
        TestClass t2 = new TestClass(2);       
        System.out.println(t2);     // 2                    String.valueOf(Object x) -> toString(x) returning "2"
        System.out.println(""+t1);  // null (due to line 9) String.valueOf(Object x) -> toString(x) returning null
        System.out.println(t1);     // null                     (as above)
        Object o = null;
        System.out.println(o);      // null                 String.valueOf(Object) returns "null" i.e. toString() not called
        
//        System.out.println(null);   // ambiguous: 
//                                    //   println(char[])
//                                    //   println(String)
//        char[] ca = null;
//        String s  = null;
    } 
}
public class Q2_935 {
    
}
