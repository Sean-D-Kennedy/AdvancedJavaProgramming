package j8.ocp.java_stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q2_1804 {
    public static void main(String[] args) {
        List<Student> ls = Arrays.asList(
                new Student("S1", Student.Grade.A), 
                new Student("S2", Student.Grade.A), 
                new Student("S3", Student.Grade.C)); 
        Map<Student.Grade, List<String>> grouping = 
                ls.stream()
                  .collect(
                          // Function gives us the key in the Map
                          // The values in the Map are the entries that match the key.
                    Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(grouping); // 
    }
        
}
/*
        Map<Student.Grade, List<String>> grouping = 
                ls.stream()
                  .collect(
                          // Function gives us the key in the Map
                          // The values in the Map are the entries that match the key.
                    Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(grouping); // 
*/
/*
class Student {      
    public static enum Grade{ A, B , C, D, F}         
    private String name;     
    private Grade grade;     
    Student(String name, Grade grade){         
        this.name = name;         
        this.grade = grade;     
    }     
    public String getName() {
        return name;
    }
    public Grade getGrade() {
        return grade;
    }
    @Override
    public String toString(){         
        return name+":"+grade;     
    }     
}

*/