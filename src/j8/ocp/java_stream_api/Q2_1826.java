package j8.ocp.java_stream_api;

import java.util.Optional;

public class Q2_1826 {
    public static Optional<String> getGrade(int marks){
        Optional<String> grade = Optional.empty();
        if(marks>50){
            grade = Optional.of("PASS");
        }
        else {
            grade.of("FAIL");// Optionals are immutable!
        }
        return grade;
    }
    public static void main(String[] args) {
        Optional<String> grade1 = getGrade(50);// returns an empty Optional
        Optional<String> grade2 = getGrade(55);// returns "PASS" Optional
        System.out.println(grade1.orElse("UNKNOWN"));// UNKNOWN
        if(grade2.isPresent()){
            grade2.ifPresent(x->System.out.println(x));// PASS
        }else{
            System.out.println(grade2.orElse("Empty"));
        }
    }
}

