package j8.ocp.advanced_class_design;


public class Q2_1463 {
    public enum EnumA{A,AA,AAA}
    public enum EnumB{B,BB,BBB}
    
    public static void main(String[] args) {
        EnumA a = EnumA.valueOf("A");
        System.out.println(a.name());// A
        
        EnumA aa = EnumA.valueOf("aa");
        
        for(EnumA ea:EnumA.values()){
            System.out.println(ea);// A, AA, AAA
        }
        
        //enum EnumC{C}
    }
}
