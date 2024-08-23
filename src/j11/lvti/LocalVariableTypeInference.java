package j11.lvti;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableTypeInference {
    // 1. Where they can be used:
    //      - constructors, methods or init blocks
    // 2. Where they CANNOT be used
    //      - constructors/methods parameters or instance/class variables ("local")
    //      - caveat: j8.lambdas where the parameter type can be inferred!
    // 3. A var is always initialised on the same statement where it is declared.
    //      e.g. var x = 8;
    // 4. The value of var can change but the type cannot.
    // 5. var cannot be simply initialised to null; cast the null to a type first.
    // 6. var not allowed in multi-variable declarations.
    // 7. var is a reserved name but not a reserved word
    //      - var var = 8; //ok
    //      - identifiers can be called var but not type names e.g. classes, interfaces, enums.
/*
 Just uncomment this block to see the compiler errors.

    var z=3;            // 2.
    static var a=3;     // 2.
    
    { // init block
        var d = 4.5;    // 1. 'd' is now double
        d=98.9;         // 4. value can change
        d="sss";        // 4. type cannot change

        var x;          // 3. These 2 lines statements need
        x=2;            // 3. to be one statement.
    }
    LocalVariableTypeInference(var x){ // 2.
        var i =9;       // 1.
        
        var j = null;             // 5. is 'j' a String, Double, Integer etc... ?
        var s = (String)null;     // 5. cast null to a type first
    }
    public static void main(String[] args) {
        var s = "abc";  // 1.
        
        m(1);
    }
    public static void m(var x){    // 2.
        int a=3, b=4;       // 6.
        var c=3, d=4;       // 6.

        var var=9;          // 7.
        
        List<String> ls = new ArrayList<>();        // 2.
        ls.add("a");
        ls.add("a");
        ls.add("b");
        ls.removeIf( (var s) -> s.equals("a")); // Predicate, removes every "a"
        System.out.println(ls); // [b]
    }
*/
}
//class var{}       // fails to compile
//enum var{}        // fails to compile
//interface var{}   // fails to compile