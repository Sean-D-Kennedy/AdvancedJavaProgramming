package j11.ocp.working_with_java_data_types.lvti;

import java.util.Set;

class Student{    
    int marks; 
    void m(){
        var a = "s";
//        var b;
    }
}  
class TestClass {     
//    var k = new Student();//1      
    public static void main(String[] args) {         
        var s = new Student(){    //2                 
            @Override                 
            public String toString(){ 
                return "student obj";
            }
        };         
        System.out.println(s);  // student obj
        
        var slist = Set.of(new Student()); //3         
        for(var student : slist){  //4             
            System.out.println("student - "+student);        
        }     
        // removeIf(Predicate)
        // attempting to modify the unmodifiable Set!        
        slist.removeIf((var student) -> student.marks<0); //5   java.lang.UnsupportedOperationException
    } 
}
public class Q2_3062 {
//    var x = 9;
//    public static void main(String[] args) {
//        var i = 3;
//        var r = m(1);
//    }
    public static int m(int n){
        return 5;
    }
}
