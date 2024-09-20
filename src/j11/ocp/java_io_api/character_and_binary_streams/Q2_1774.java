package j11.ocp.java_io_api.character_and_binary_streams;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Q2_1774 {
    public static void main(String[] args) throws IOException{
//        var rafUTF = new RandomAccessFile("c:\\temp\\testUTF.txt", "rwd"); 
//        rafUTF.writeUTF("hello world");      // ok      
//        rafUTF.close();                  
//
//        var rafChars = new RandomAccessFile("c:\\temp\\testChars.txt", "rwd"); 
//        rafChars.writeChars("hello world"); // causes exception with readUTF     
//        rafChars.close();
        
        var dis = new DataInputStream(new FileInputStream("c:\\temp\\testChars.txt"));         
        String value = dis.readUTF();         
        System.out.print(value);         
        dis.close();
    }
    
}
