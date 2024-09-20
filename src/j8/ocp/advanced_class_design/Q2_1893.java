package j8.ocp.advanced_class_design;

class BookStore {    
    private static final int taxId = 300_000; // constant
    private String name;    
    public String searchBook( final String criteria ){  
        // Local variables (includes method parameters) used in inner 
        // classes (or lambdas) must be final or effectively final
        int count = 0; //  not changed anywhere => effectively final
        int sum = 0;   //  changed on next line => NOT effectively final
        sum++;       
        class Enumerator{          
            String iterate( int k){            
                //line 1 - accessible           
                System.out.println(taxId); 
//                taxId++;

                System.out.println(name); 
                name += "sk";
                
                System.out.println(criteria);
                //criteria += "sk";
                
                //System.out.println(sum); // can't even output it!
                
                System.out.println(count);
                //count++;
                return "";          
            }
            // lots of code.....       
        }       
        Enumerator e = new Enumerator();
        e.iterate(5);

        //count=9;
        // IF the rule that local variables used in inner classes (or lambdas)
        // must be final or effectively final was NOT enforced, then you would 
        // have method searchBook() using one value of count (9) and method
        // iterate() in the Enumerator inner class using a different value (0)

        e.iterate(5);

        return "";    
    } 
}
public class Q2_1893 {
    
}
