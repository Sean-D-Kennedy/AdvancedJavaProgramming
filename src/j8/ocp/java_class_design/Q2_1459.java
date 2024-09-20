package j8.ocp.java_class_design;

import java.util.Map;
import java.util.TreeMap;

class IntPair {
    private int a;    
    private int b;    
    public void setA(int i){ this.a = i; }    
    public int getA(){ return this.a;}
    public void setB(int i){ this.b = i; }    
    public int getB(int b){ return b;}
    @Override
    public boolean equals(Object obj)    {       
        return ( obj instanceof IntPair && 
                   this.a == ((IntPair) obj).a && this.b == ((IntPair) obj).b );
    }    
    @Override
    public int hashCode(){
//        return a;   // option a
//        return a*b;   // option b
//        return a+b;   // option c
        return b;   // option d
    }   
}
public class Q2_1459 {
    public static void main(String[] args) {
//        IntPair one = new IntPair();
//        one.setA(5);one.setB(10);
//        
//        IntPair two = new IntPair();
//        two.setA(5);two.setB(10);
//        
//        System.out.println(one.equals(two));                    // F
//        System.out.println(one.hashCode() == two.hashCode());   // T
        
        peopleExample();
    }
    static void peopleExample(){
        Person amy = new Person(); 
        amy.setName("Amy");
        Person may = new Person(); 
        may.setName("May");
        System.out.println("Are Amy and May equal ? "+amy.equals(may));
        System.out.println("Are Amy and Mays hashcodes equal? "+
                (amy.hashCode() == may.hashCode()) );
    }
}
class Person{
    private String name;

    void setName(String name){ this.name = name;}

    /*
        equals() and hashCode() are related:
        1. hashCode() is used to find the correct bucket 
        2. equals() is then used to locate the correct object (in that bucket).
    */
    @Override
    public boolean equals(Object obj)    {   
        return obj instanceof Person && this.name.equals(((Person)obj).name) ;
    }    
    @Override
    public int hashCode(){
        // "amy" and "may" will have the same hashcodes
        Integer totalValue = 0;
        for(char c:name.toCharArray()){
            totalValue += PeopleUtility.getLettersMap().get(Character.toString(c).toUpperCase());// Map contains uppercase letters only
        }
        return totalValue;
    }   
}

class PeopleUtility{
    private static Map<String, Integer> lettersMap = new TreeMap<>();
    private static String[] letters = 
        { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
          "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
          "U", "V", "W", "X", "Y", "Z"};

    static {
        int value=1;
        for(String letter:letters){
            lettersMap.put(letter, value++);
        }
    }    
    public static Map<String, Integer> getLettersMap() {
        return new TreeMap<String, Integer>(lettersMap);// properly encapsulated
    }
}