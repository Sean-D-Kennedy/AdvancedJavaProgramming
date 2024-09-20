package j11.ocp.working_with_java_data_types.using_primitives_and_wrapper_classes;

public class Q2_3140 {
    public static void main(String[] args) {         
        String str = "10";
        int iVal = 0;         
        Double dVal = 0.0;         
        try{             
            iVal = Integer.parseInt(str, 2);//1             
            if((dVal = Double.parseDouble(str)) == iVal){ //2                 
                System.out.println("Equal");             
            }         
        }catch(NumberFormatException e){             
            System.out.println("Exception in parsing");         
        }         
        System.out.println(iVal+" "+dVal);              }    
}
