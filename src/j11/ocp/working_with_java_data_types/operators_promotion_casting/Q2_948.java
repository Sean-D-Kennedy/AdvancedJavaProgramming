package j11.ocp.working_with_java_data_types.operators_promotion_casting;

public class Q2_948 {
    public static void main(String[] args) {
        boolean b=false, f=false;
        int a=0;
        
        // logical & (applied to boolean types)
        b = f & (++a > 0); // F & T
        System.out.println(b + " " + a); // false 1
        
        // bitwise & (applied to numeric types)
        int x=12, y=25; // 01100 & 
                        // 11001
                        // -----
        int z = x & y;  // 01000
        System.out.println(z);// 8
    }
    
}
