package j21.pattern_matching_switch;

public class PatternMatching {
    public static void whatType(Object o){
        switch(o){ // switch statement does not cover all possible input values
            case String s -> System.out.println("String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognised");
        }
        System.out.println(
            switch (o) { // switch expression does not cover all possible input values
                case String s -> "String";
                case Integer i -> {yield "Integer";}
                case null -> "Null";
                default -> "Not recognised";
            }
        );

    }
    public static void infoOnType(Object o){
        switch(o){
            // Guarded patterns (Java 17, preview) are now replaced by the 'when' clause (Java 19, preview).
//            case String s && s.startsWith("A")-> System.out.println("String beginning with A : "+s);
//            case Integer i && i.intValue() > 10 -> System.out.println("Integer > 10 : "+i);
            case String s when s.startsWith("A")-> System.out.println("String beginning with A : "+s);
            case Integer i when i.intValue() > 10 -> System.out.println("Integer > 10 : "+i);

            case null -> System.out.println("Null");
            default -> System.out.println("Not recognised");
        }
    }

    public static void exceptionTest(){
        try{

        }catch(Exception e){
            e.printStackTrace();
//        }catch (NullPointerException npe){ // already caught
//            npe.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        whatType("ABC");        // String, String
//        whatType(122);          // Integer, Integer
//        whatType(null);         // Null, Null
//        whatType(32.39);        // Not recognised, Not recognised

        infoOnType("ABC");      // String beginning with A : ABC
        infoOnType("abc");      // Not recognised
        infoOnType(12);         // Integer > 10 : 12
        infoOnType(8);          // Not recognised
    }
}
