package j8.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console(); // not "new"
        if(console == null){
            System.err.println("Console not available");
        } else{
            String name = console.readLine("Please enter your %s:", "name");
            console.format("Hello there %s%n", name);
            console.printf("Welcome."); // varargs (0 args is valid)
            console.writer().println(); // blank line

            // If the following echoes the chars as you type, run from the command line or terminal (the IDE may be the issue)
            char []pwd       = console.readPassword("Enter password (between %d and %d characters):", 4, 10);
            char []pwdAgain  = console.readPassword("Verify password: ");
            boolean pwdMatch = Arrays.equals(pwd, pwdAgain);
            if(pwdMatch){
                console.printf("Passwords match!");
            }else{
                console.printf("Passwords do NOT match!");
            }
        }
    }
    
}
