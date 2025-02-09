package j22.unnamed_variables_and_patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UnnamedVariableTry {
    public static void main(String[] args) {
        try (BufferedReader in =    // 'in' not used
                     new BufferedReader(new FileReader("example.txt"))) {
            System.out.println("File opened successfully! Perform some side effects...");
        } catch (IOException ioe) { // 'ioe' not used
            System.out.println("Error reading the file.");
        }
        try (BufferedReader _ =     // 'in' not even named
                     new BufferedReader(new FileReader("example.txt"))) {
            System.out.println("File opened successfully! Perform some side effects...");
        } catch (IOException _) {   // 'ioe' not named
            System.out.println("Error reading the file.");
        }
    }
}