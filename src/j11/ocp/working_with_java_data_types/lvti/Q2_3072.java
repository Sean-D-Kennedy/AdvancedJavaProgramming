package j11.ocp.working_with_java_data_types.lvti;

import java.util.ArrayList;

public class Q2_3072 {
    public static void main(String[] args) {
        var al = new ArrayList<String>();     
        al.forEach( k -> {              
            System.out.print(k.length());              
        }); 
    }
}
