package j22.unnamed_variables_and_patterns;

public class UnnamedPatternSwitch {
    static void process(Object obj) {
        switch (obj) {
            // both 's' and 'i' are unused
            case String s -> System.out.println("It's a string.");
            case Integer i -> System.out.println("It's an integer.");
            case null, default -> System.out.println("Something else.");
        }
        switch (obj) {
            // now, both 's' and 'i' are not present; this makes it explicit
            // that we only care about the type of the object
            case String _ -> System.out.println("It's a string.");
            case Integer _ -> System.out.println("It's an integer.");
            case null, default -> System.out.println("Something else.");
        }
    }

    public static void main(String[] args) {
        process("Hello");
        process(42);
        process(3.14);
    }
}