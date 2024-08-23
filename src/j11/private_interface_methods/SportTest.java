package j11.private_interface_methods;

interface Tennis{
    private static void hit(String stroke){
        System.out.println("Hitting a "+stroke);
    }
    private void smash(){ hit("smash"); }
    default void forehand(){ hit("forehand"); }
    static void backhand(){ 
//        smash();// static to instance not allowed!
        hit("backhand"); 
    }
}
public class SportTest implements Tennis{
    public static void main(String[] args) {
        new SportTest().forehand(); // Hitting a forehand
        Tennis.backhand();          // Hitting a backhand
//        new SportTest().hit("dropshot"); // private access
//        new SportTest().smash(); // private access
    }
}



