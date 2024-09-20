//package j11.ocp.streams_and_lambda.lambda_operations_on_streams;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//class Student {
//    static enum Grade{ A, B , C, D, F}    
//
//    private String name;
//    private Grade grade;
//    public Student(String name, Grade grade){
//        this.name = name;
//        this.grade = grade;
//    }
//    public String toString(){
//        return name+":"+grade;
//    }
//    //getters and setters not shown
//}
//
////What can be inserted in the code below so that it will print:
////{C=[S3:C], A=[S1:A, S2:A]}
//
//public class Q2_1803 {
//    public static void main(String[] args) {
//        List<Student> ls = Arrays.asList(new Student("S1", Student.Grade.A), new Student("S2", Student.Grade.A), new Student("S3", Student.Grade.C));
//
//  // (d)      Map<Integer, List<Student>> grouping = ls.stream().map(Collectors.groupingBy(s ->s.getGrade()));
//        Map<Integer, List<Student>> grouping = ls.stream().groupBy(
//                Collectors.mapping( Student::getGrade, new ArrayList()));
//        System.out.println(grouping);
//    }
//    
//}
