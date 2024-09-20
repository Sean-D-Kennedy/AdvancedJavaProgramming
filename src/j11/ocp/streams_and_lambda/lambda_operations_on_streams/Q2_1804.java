package j11.ocp.streams_and_lambda.lambda_operations_on_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    static enum Grade{ A, B , C, D, F}    

    private String name;
    private Grade grade;
    public Student(String name, Grade grade){
        this.name = name;
        this.grade = grade;
    }
    public String toString(){
        return name+":"+grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
}
// {C=[Chloe], A=[Alan, Alice]}    grade->name
public class Q2_1804 {
    public static void main(String[] args) {
        List<Student> ls = Arrays.asList(
                new Student("Alan", Student.Grade.A), 
                new Student("Alice", Student.Grade.A), 
                new Student("Chloe", Student.Grade.C)); 

        // (c) - correct        {C=[Chloe], A=[Alan, Alice]}
        Map<Student.Grade, List<String>> grouping = ls
                .stream()
                .collect( 
                    Collectors.groupingBy(  
                        Student::getGrade,  // key
                        Collectors.mapping( student -> student.getName(),   // value
                                            Collectors.toList()
                        )
                    )
                );
        System.out.println(grouping);
        
        // (b) - does not compile2
        // fixed compiler error - output incorrect:
        //     {C={Chloe=[Chloe:C]}, A={Alice=[Alice:A], Alan=[Alan:A]}}
        Map<Student.Grade, Map<String, List<Student>>> grouping2 = ls
                .stream()
                .collect(Collectors.groupingBy(  
                            Student::getGrade, 
                            Collectors.groupingBy(Student::getName, Collectors.toList()))); 
        System.out.println(grouping2);
    }
    
}
