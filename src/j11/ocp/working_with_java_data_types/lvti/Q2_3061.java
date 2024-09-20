package j11.ocp.working_with_java_data_types.lvti;

public class Q2_3061 {
    public static void main(String[] args) { 
        // Netbeans should flag this as an error! 
        // var is not allowed as an element type of an array.
//        var i[ ] = new int[] {1, 2} ; // error in javac!!!

        // option a
//        var i[][]= { { 1, 2 }, { 1},{},{1,2,3}}; // no, var and [][] on LHS
//        var i = { { 1, 2 }, { 1},{},{1,2,3}}; // no, array init needs target-type on RHS
//       var i1 = new int[][]{ { 1, 2 }, { 1}, {}, {1,2,3}}; // ok
        
        // option b 
//        var i2[] = new int[2] {1, 2} ; // does not compile
//        var i2a  = {1, 2} ;   // init list requires type info when 'var' used
//        int ia[] = {1,2}; // ok
//        var i2b  = new int[] {1, 2} ;   // type info given
//        var i2c[] = new int[] {1, 2} ;   // **Netbeans should flag this as an error!
        
        // option c
        var i3 = new int[ ][ ] { {1, 2, 3}, {4, 5, 6} } ;

        // option d
//        var i = { { 1, 2 }, new int[ 2 ] } ; // does not compile, new int[][] required on RHS
//        var i4 =  new int[][]{ { 1, 2 }, new int[ 2 ] } ; // does compile
        
        // option e
//        var i5[4] = new int[]{ 1, 2, 3, 4 } ;    // does not compile
//        var i5[] = new int[]{ 1, 2, 3, 4 } ;    // **Netbeans should flag this as an error!
//        var i5 = new int[]{ 1, 2, 3, 4 } ;    // compiles

        // option f
//        var fa = new Float{ 1.1F, 2.2F, 3.3F }; // error
//        var fa = new Float[]{ 1.1F, 2.2F, 3.3F }; // ok

    }
    
}