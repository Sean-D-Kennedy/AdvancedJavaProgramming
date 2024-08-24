package j21.record_patterns;

public class TestRecords {
    public static void main(String[] args) {
        records();
    }
    public static void records(){
        Person p1 = new Person("Joe Bloggs", 22);
        System.out.println(p1);                         // Person[name=Joe Bloggs, age=22]
        System.out.println(p1.name() + "; " + p1.age());// Joe Bloggs; 22
        patternMatching(p1);                            // PM: Joe Bloggs; 22
        patternMatching("abc");

        Pair<String> pairS  = new Pair<>("Sean", "Kennedy");
        Pair<Integer> pairI = new Pair<>(10, 20);
        patternMatching(pairS);    // PM: Sean; Kennedy
        patternMatching(pairI);    // PM: 10; 20
    }
    public static void patternMatching(Object obj){
        // "Person person" is a "type pattern". At runtime, "pattern matching" is
        // performed by instanceof to see if "obj" is referring to a Person object;
        // is so, "person" is made to refer to that Person object.
        if(obj instanceof Person person ){
            System.out.println("PM: "+person.name() + "; "+ person.age());
        } else if(obj instanceof Pair pair){
            System.out.println("PM: "+pair.x() + "; "+ pair.y());
        }

    }
}




// old pre-Java 16 instanceof-and-cast idiom
//        if(obj instanceof String){
//            String s = (String)obj;
//            System.out.println(s.toUpperCase());
//        }

// new post-Java 16 idiom
//        if(obj instanceof String s){
//            System.out.println(s.toUpperCase());
//        }
