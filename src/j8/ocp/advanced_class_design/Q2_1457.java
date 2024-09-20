package j8.ocp.advanced_class_design;

// Option 1
//enum Pets {
//        DOG("D"), CAT("C"), FISH("F");
//        String name;
//        Pets(String s) { }
//        public String getData(){ return String.valueOf(name); } 
//}

// Option 2
//enum Pets {
//    DOG("D"), CAT("C"), FISH("F");
//    final static String prefix = "I am "; 
//    String name;
//    Pets(String s) { 
//        name = prefix + s;
////        name = "SK" + s;
//    }
//    public String getData(){ return name; } 
//}

// Option 3
enum Pets {
    DOG(1, "D"), 
    CAT(2, "C") { 
        @Override
        public String getData(){ 
            return "CAT"+type+name; 
        } 
    }, 
    FISH(3, "F"); 
    int type; 
    String name;
    Pets(int t, String s) { 
        this.name = s; 
        this.type = t;
    } 
    public String getData(){ 
        return name+type; 
    } 
}
public class Q2_1457 {
    public static void main(String[] args) {
        Pets spot = Pets.DOG;
        System.out.println(spot.getData());     // D1
        
        Pets fluffy = Pets.CAT;
        System.out.println(fluffy.getData());   // CAT2C
    }
            
}
