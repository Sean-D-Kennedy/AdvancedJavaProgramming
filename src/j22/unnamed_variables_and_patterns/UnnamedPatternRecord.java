package j22.unnamed_variables_and_patterns;

record Somebody(String name, int age) {}

// unnamed pattern used when deconstructing a record
public class UnnamedPatternRecord {
    public static void main(String[] args) {
        Somebody somebody = new Somebody("Andrew", 30);

        if (somebody instanceof Somebody(String name, int age)) {   // 'age' not used
            System.out.println("Name: " + name);
        }
        if (somebody instanceof Somebody(String name, _)) {     // 'age' not mentioned
            System.out.println("Name: " + name);
        }
    }
}