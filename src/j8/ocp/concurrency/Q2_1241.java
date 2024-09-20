package j8.ocp.concurrency;

import java.util.concurrent.ForkJoinPool; 
import java.util.concurrent.RecursiveAction;   

class ComplicatedAction extends RecursiveAction{ 
    int[] ia;
    int low; int high; 
    ComplicatedAction(int[] ia, int low, int high){ 
        this.ia = ia;
        this.low = low; 
        this.high = high; 
    } 
    @Override
    protected void compute() { 
        // is it small enough?
        if(low == high){ // Y => implement the logic
            //Update the value using logic implemented somewhere else.             
            ia[low] = UtilityClass.utilityMethod(ia[low]);
        }else{ // N => sub-divide, fork-compute-join
            int mid = (low+high)/2; 
            ComplicatedAction newtask1 = new ComplicatedAction(ia, low, mid); 
            ComplicatedAction newtask2 = new ComplicatedAction(ia, mid+1, high); 
//            newtask2.fork(); 
//            newtask1.compute(); 
//            newtask2.join(); 
            invokeAll(newtask1, newtask2);
        }
    } 
    public static void main(String[] args) {
        int ia[] = new int[]{ 1, 2, 3, 4 , 5, 6, 7}; 
        ForkJoinPool fjp = new ForkJoinPool(); 
        ComplicatedAction st = new ComplicatedAction(ia, 0, 6); 
        fjp.invoke(st); 
        System.out.print("New Array Values = "); 
        for(int i : ia) System.out.print(i+" "); 
    }
}  
class UtilityClass{ 
    public static int utilityMethod(int x) { 
        return x+1; 
    } 
}
public class Q2_1241 {
    
}
