package j21.pattern_matching_switch;

sealed interface Colour permits Primary, Rainbow{}
enum Primary implements Colour{ RED, GREEN, BLUE}
enum Rainbow implements Colour{ RED, ORANGE, YELLOW, GREEN,
                                BLUE, INDIGO, VIOLET}

public class QualifiedEnumConstants {
    public static void switchColour(Colour colour){
        switch(colour){ // Note: switching on the interface type, not the enum type
//            case Primary primary when primary == Primary.RED: // verbose guarded pattern
//                System.out.println("Primary::Red"); break;
//            case Rainbow rainbow when rainbow == Rainbow.RED: // verbose guarded pattern
//                System.out.println("Rainbow::Red"); break;

            // Java 21 specific
            case Primary.RED:
                System.out.println("Primary.Red"); break;
            case Rainbow.RED:
                System.out.println("Rainbow.Red"); break;
            default:
                System.out.println("Other colour"); break;
        }
    }
    public static void switchPrimary(Primary primary){
        switch(primary){// Note: switching on the enum type, not the interface type
            case RED -> System.out.println("Primary::Red");
            case BLUE -> System.out.println("Primary::Blue");
        }
    }
    public static void switchRainbow(Rainbow rainbow){
        switch(rainbow){// Note: switching on the enum type, not the interface type
            case RED -> System.out.println("Rainbow::Red");
            case BLUE -> System.out.println("Rainbow::Blue");
        }
    }
    public static void main(String[] args) {
        switchPrimary(Primary.RED);
        switchRainbow(Rainbow.RED);
        switchColour(Primary.RED);
    }
}
