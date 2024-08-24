package j21.record_patterns;

//public record Dog(String name, Integer age) {}

public class Dog{
    private final String name;
    private final Integer age;

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String name() {
        return name;
    }
    public Integer age() {
        return age;
    }
    // also toString(), equals() and hashCode() generated
}
