package j17.pattern_matching_switch;

sealed abstract class Vehicle permits Car, Boat, Train{}
final class Car extends Vehicle {
    // custom Car method
    public String onRoad(){
        return "I can move on the road";
    }
}
final class Boat extends Vehicle{}
final class Train extends Vehicle{}

public class PatternMatchingSwitchExpressions {
    public static void ifStatements(Vehicle v){
        // Oracle: "...pattern matching introduces new language enhancements that enable you to
        // conditionally extract data from objects with code that's more concise and robust."
        // Pattern matching for instanceof is present since Java 16.
        if(v instanceof Car c){ // Note the 'c' here
            System.out.println("It's a Car: "+c.onRoad());
        }else if(v instanceof Boat){
            System.out.println("It's a Boat");
        }else if(v instanceof Train){
            System.out.println("It's a Train");
        }else {
            throw new IllegalArgumentException("Invalid type");
        }
    }
    public static void patternMatchingSwitch(Vehicle v) {
        switch(v){
            // switch expression pattern matching
            case Car c   -> {
                System.out.println("It's a Car");
                System.out.println("It's a Car: "+c.onRoad());
            }
            case Boat b  -> System.out.println("It's a Boat");
            case Train t -> System.out.println("It's a Train");
            default      -> throw new IllegalArgumentException("Invalid type");
        }
    }

    public static void main(String[] args) {
        ifStatements(new Car());
        ifStatements(new Boat());
        ifStatements(new Train());

        patternMatchingSwitch(new Car());
        patternMatchingSwitch(new Boat());
        patternMatchingSwitch(new Train());

    }
}
