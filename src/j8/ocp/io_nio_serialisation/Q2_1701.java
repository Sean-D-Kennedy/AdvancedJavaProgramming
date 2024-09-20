package j8.ocp.io_nio_serialisation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Boo implements Serializable {     
    transient int ti = 10;     
    static int si = 20; 
    int x=4;
}  
class TestClass {     
    public static void main(String[] args) throws Exception     {               
        Boo boo = new Boo();         
        boo.si++;         
        boo.x++;
        System.out.println(boo.ti+" "+boo.si+" "+boo.x);     // 10 21 5    
        FileOutputStream fos = new FileOutputStream("c:\\temp\\boo.ser");         
        ObjectOutputStream os = new ObjectOutputStream(fos);         
        os.writeObject(boo);         
        os.close();                  
        FileInputStream fis = new FileInputStream("c:\\temp\\boo.ser");         
        ObjectInputStream is = new ObjectInputStream(fis);         
        boo = (Boo) is.readObject();         
        is.close();                     
        System.out.println(boo.ti+" "+boo.si+" "+boo.x);     // 0 21 5
    } 
}
public class Q2_1701 {
    
}
