package j8.ocp.lambda_expressions_and_functional_interfaces;

interface A{    
    static void m1(){}; 
}  
interface AA extends A{    
    void m2(int x); 
}

public class Q2_1807 {
    public static void main(String[] args) {
        AA aa = (i) -> System.out.println("in m2() "+i);
        aa.m2(3);    // in m2()
    }
    
}
