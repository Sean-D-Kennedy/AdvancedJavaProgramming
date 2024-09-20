package j8.ocp.threading;

public class Q2_1092  {    
    int i = 0;    
    public void run()    {       
        while(true)       {          
            if( i%2 == 0 ) System.out.println("Hello World");       
        }    
    } 
}