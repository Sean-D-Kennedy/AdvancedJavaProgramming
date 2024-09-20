package j11.ocp.java_io_api.character_and_binary_streams;

import java.io.RandomAccessFile;

public class Q2_1717 {
    public static void main(String[] args) {
        try {
            var raf = new RandomAccessFile("c:\\temp\\test.txt", "rwd");
//            raf.writeChars("abcdefghiljkl"); 
            raf.writeChars("hello"); 
            raf.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
