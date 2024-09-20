package j8.ocp.java_class_design;

import java.io.IOException;

class Base {    
    int getStatusCode(Object obj) throws NullPointerException    {       
        return 1;
    } 
    Object covr(){
        return null;
    }
}
class Sub extends Base { 
//    @Override
//    int getStatusCode(String s){  // an overload not an override
//        return 1;
//    }
    
//    long getStatusCode(Object obj){ // if the return type in the parent class of
//        return 1;                   // an overridden method is primitive, then the 
//    }                               // return type in sub type overriding method must 
                                    // match

//    @Override
//    int getStatusCode(Object obj) throws ClassCastException    {       
//        return 2;
//    } 

//    @Override
//    int getStatusCode(Object obj) throws IOException    {       
//        return 2;
//    } 
    
    @Override
    String covr(){      // co-variant return (sub-type of overriden method in parent
        return "SK";    // class allowed in sub-type overriding method)
    }
}
public class Q2_1531 {
    public static void main(String[] args) {
        // Why can't the overriding method introduce new/extra *checked* exceptions
        // NB: The crucical point here is the compiler looks at the reference type and 
        // not the object type i.e. Base and not Sub. Thus, the compiler checks the
        // signature of getStatusCode() in Base and not Sub. As a result, the following 
        // code does NOT have any exceptions logic at all. Thats ok, as the
        // compiler does not check for RuntimeExceptions (hence they are called "unchecked").
        // Now, *IF* Sub's version of getStatusCode() was allowed to throw any (new/extra) *checked*
        // exceptions, there simply would be no code to handle it... That is why, the
        // overriding method CANNOT add new or extra checked exceptions to the method
        // signature.
        Base b = new Sub();
        b.getStatusCode( new Object() );
    }
    
}
