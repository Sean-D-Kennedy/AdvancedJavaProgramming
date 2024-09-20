package j11.ocp.java_io_api.character_and_binary_streams;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Q2_1716 {
    public static void main(String[] args) {
        try {
//            RandomAccessFile raf = new RandomAccessFile("file.txt", "rw");
//            raf.seek( raf.length() );
//            raf.writeChars("FINAL TEXT");
            RandomAccessFile raf = new RandomAccessFile("file.txt", "rw"); 
            raf.writeChars("FINAL TEXT");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Q2_1716.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Q2_1716.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
