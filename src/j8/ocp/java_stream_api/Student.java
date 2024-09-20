package j8.ocp.java_stream_api;

public class Student {      
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
