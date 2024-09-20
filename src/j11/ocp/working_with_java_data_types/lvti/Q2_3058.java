package j11.ocp.working_with_java_data_types.lvti;

import java.util.*; 

class Student1{ }

//class var{}

public class Q2_3058 {
//    var students = new ArrayList<Student>(); //1     
    public static void main(String[] args)  {         
        var student  = new Student1();//2
        var allStudents = new ArrayList<>();  //3         
        allStudents.add(student); //4                
        for(var s : allStudents){ //5           
            System.out.println(s);        
        }        
        Student1 s2 = (Student1)allStudents.get(0); //6
        var var = "what?"; //7    
    }
}
