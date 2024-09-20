package j11.ocp.java_OOA.declaration_and_instantiation;

import java.time.LocalDate;

public class Q2_3139 {
    public static void main(String[] args) {
        for(var i=0; i<5; i++){
            if(i>2){
                continue;
            }else{
                System.out.println(i);
            }
        }

        
//        LocalDate d1 = LocalDate.now();         
//        System.out.println("d1 == "+d1);    // d1 == 2021-04-06
//        System.out.println(d1.plusDays(10));// 2021-04-16         
//        LocalDate d2 = d1.minusWeeks(1);         
//        System.out.println("d2 == "+d2);    // d2 == 2021-03-30
//        d1 = null;         
//        LocalDate d3 = LocalDate.now().plusYears(3).minusMonths(4);         
//        System.out.println("d3 == "+d3);    // d3 == 2023-12-06
//        System.out.println(d2.plusWeeks(5));// 2021-05-04         
//        d1 = d2;    
    }
}
