package j11.ocp.arrays_and_collections.arrays;

public class Q2_3576 {
    public static void main(String[] args) {
        try {      
            System.out.println(args[args.length-1]);        
        }
//        catch (ArrayIndexOutOfBoundsException e) { 
        catch (NullPointerException e) { 
            System.out.println("exc");
        }
    }
    
}
