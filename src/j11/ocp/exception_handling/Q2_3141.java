package j11.ocp.exception_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q2_3141 {
    public static void main(String[] args) throws IOException { // "throws" here is for the try-with-resources
        // try-with-resources - no requirement for catch/finally
        // BufferedReader implements AutoCloseable
        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\sample.txt"))) {
            System.out.println(br.readLine()); 
        }   
        
        // try without resources - must have catch/finally
//        try {
            BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\sample.txt"));
            System.out.println(br.readLine()); 
//        }
        
//        try(BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\sample.txt"))){
            
//        }
    }
    
}
