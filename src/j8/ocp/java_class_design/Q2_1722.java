package j8.ocp.java_class_design;

interface Classic {     
    int version = 1;    // public, static, final
    public void read() ; 
}  
class MediaReader implements Classic{     
    int version = 2;    // pkg-private, instance, non-final
    public void read() {          
        //Insert code here   
//        System.out.println(version);        // 2
//        System.out.println((Classic)version);
//        System.out.println(((Classic)this).version);// 1
//        System.out.println(this.version);   // 2
//        System.out.println(super.version);// no 'version' in Object
//        System.out.println(this.Classic.version);// 1
        System.out.println(Classic.version);// 1
    } 
}
public class Q2_1722 {
    public static void main(String[] args) {
        MediaReader mr = new MediaReader();         
        mr.read();
    }
    
}
