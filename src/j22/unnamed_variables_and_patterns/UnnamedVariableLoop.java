package j22.unnamed_variables_and_patterns;

// Using an unnamed variable in a for-each loop
public class UnnamedVariableLoop {
    public static void main(String[] args) {
        String[] data = {"April", "Brendan"};

        for (String name : data) {  // 'name' not used
            System.out.println("Performing a side-effect...");
        }
        for (String _ : data) { // 'name' not even mentioned
            System.out.println("Performing a side-effect...");
        }
    }
}