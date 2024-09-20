package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Student {     
    private String name;
    private int marks;      

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public void show( ){
        System.out.println(this.name + " " + this.marks);
    }
    public void takeIn(String s){
        System.out.println(this.name + s);
    }
    public String retrieve(){
        return "SK";
    }
}
public class Q2_1800 {
    public static void main(String[] args) {
        // unbound - calling instance methods on a parameter (in the lambda)
        // Consumer<T> functional method is void accept(T t)
        Consumer<Student> lambda1 = s->s.show();   // lambda
        Consumer<Student> mr1     = Student::show; // method ref. (unbound)
        lambda1.accept(new Student("S4", 44));  // S4 44
        mr1.accept(new Student("S4", 44));      // S4 44

        // bound - calling instance methods on a particular object (in the lambda)
        // Supplier<T> functional method is T get()
        Student s3 = new Student("S3", 33); 
        Supplier<String> lambda2 = ()->s3.retrieve(); // lambda
        Supplier<String> mr2     = s3::retrieve;      // method ref. (bound)
        System.out.println(lambda2.get());      // SK
        System.out.println(mr2.get());          // SK

        // lambda where method takes an arg; first arg must be Student as the first arg. is used
        // to call the method 'takeIn'
        // unbound - calling instance methods on a parameter (in the lambda)
        // BiConsumer<T, U> functional method is void accept(T t, U u)
        BiConsumer<Student,String> bicLambda = (student,str) -> student.takeIn(str); // lambda         
        BiConsumer<Student,String> bicMR     = Student::takeIn; // method ref.
        bicLambda.accept(new Student("S5", 55), " Lecturer");   // S5 Lecturer
        bicMR.accept(new Student("S5", 55), " Lecturer");       // S5 Lecturer
    }
}






// Q2.1800
/*

    public void addMarks(int m){         
        this.marks += m;     
    }     
    public void debug(){         
        System.out.println(name+":"+marks);     
    } 

        List<Student> slist = 
                Arrays.asList(  new Student("S1", 40), 
                                new Student("S2", 35), 
                                new Student("S3", 30)); 
//        Consumer<Student> increaseMarks = s->s.addMarks(10); 
//        slist.forEach(increaseMarks); 
//        Consumer<Student> sDebug = s->s.debug();    // lambda version
//        slist.stream().forEach(Student::debug);     // method ref. version (unbound)


*/