package j8.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingWritingExamples {
    public static void main(String[] args) {
        copyTextFile(false);
//      copyTextFile(true);
        copyBinaryFile(false);
//        copyBinaryFile(true);
    }
    public static void copyTextFile(boolean buffering){
//        File src = new File ("C:\\Users\\skennedy\\Documents\\NetbeansProjects\\Udemy\\src\\main\\java\\lets_get_certified\\j8\\io\\ReadingWritingExamples.java"); // Windows
//        File dest = new File ("C:\\Users\\skennedy\\Documents\\NetbeansProjects\\Udemy\\src\\main\\java\\lets_get_certified\\j8\\io\\ReadingWritingExamples2.java");
        File src = new File ("/Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot/src/j8/io/sample.txt"); // Mac
        File dest = new File ("/Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot/src/j8/io/sample2.txt");

        // in-built close() with try-with-resources
        try(var rdr = new BufferedReader(new FileReader(src));
            var wtr = new BufferedWriter(new FileWriter(dest))){

            if(buffering){
                // Using BufferedReader and BufferWriter API's
                String str=null;      
                // readLine() is specific to BufferedReader 
                while((str = rdr.readLine()) != null ){
                    wtr.write(str);
                    wtr.newLine();  // readLine() strips out the end of line character
                }
            } else{
                // no buffering i.e. read one byte at a time; an int is used because 
                // Java uses -1 to signal the end of the stream
                int b;
                while((b = rdr.read()) != -1){
                    wtr.write(b);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static void copyBinaryFile(boolean buffering){
        // 1. Using / instead of \
        // 2. Using relative path instead of absolute path
//        System.out.println("Working Directory = " + System.getProperty("user.dir"));// C:\Users\skennedy\Documents\NetbeansProjects\Udemy   (Windows)
        System.out.println("Working Directory = " + System.getProperty("user.dir"));// /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot   (Mac)
        File src = new File ("/Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot/src/j8/io/SampleImage.png"); // Mac
        File dest = new File ("/Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot/src/j8/io/SampleImage2.png");

        // in-built close() with try-with-resourcse
        try(var in = new BufferedInputStream(new FileInputStream(src));
            var out = new BufferedOutputStream(new FileOutputStream(dest))){

            if(buffering){
                var buffer = new byte[1024];            
                int numBytesRead=0;
                while((numBytesRead = in.read(buffer)) > 0 ){
                    // As the file is unlikely to be an exact multiple of 1024 bytes, 'numBytesRead' helps
                    // us to write out exactly the number of extra bytes above that multiple
                    // e.g. 2058 = 1024 + 1024 + 10
                    // write(byte[], int, int) is in FileOutputStream and BufferedOutputStream
                    out.write(buffer, 0, numBytesRead);
                    out.flush();
                }
            }else {
                // no buffering i.e. read one byte at a time; an int is used because 
                // Java uses -1 to signal the end of the stream
                int b;
                while((b = in.read()) != -1){
                    out.write(b);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
