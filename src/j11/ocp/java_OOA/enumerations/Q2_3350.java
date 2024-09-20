package j11.ocp.java_OOA.enumerations;

enum Coffee{
    ESPRESSO("Very Strong"), MOCHA("Bold"), LATTE("Mild");
    public String strength;
    Coffee(String strength)
    {
        this.strength = strength;
    }
//    public String toString(){
//        return String.valueOf(strength); // return strength; is ok also 
//    }
}
public class Q2_3350 {
    public static void main(String[] args) {
        System.out.println(Coffee.ESPRESSO); // Very Strong

        Coffee c = Coffee.valueOf("ESPRESSO"); // arg is the constant required
        System.out.println(c);// Very Strong
 
        Coffee[] coffees = Coffee.values();
        for(Coffee coffee:coffees){
            System.out.println(coffee); // Very Strong, Bold, Mild
        }
    }
}
