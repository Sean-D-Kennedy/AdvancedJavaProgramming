package j8.ocp.lambda_expressions_and_functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Test {
    private final String name;

    Test(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public static int compareStrings(String s1, String s2){
        return s1.compareTo(s2);
    }
    public static void main(String[] args) {
//        Test t1 = new Test("Sean");
//        Test t2 = new Test("Desmond");
//
//        // Supplier<T>     T get()
//        // Both versions are BOUND - they "bind" to reference t2
//        Supplier<String> supplier1 = () -> t2.getName(); // lambda syntax     String get()
//        Supplier<String> supplier  = t2::getName;        // method reference  String get()
//
//        // No need to say which instance to call it on - the supplier is bound to t2            
//        System.out.println(supplier.get());//Desmond
//        
//        // Function<T, R>     R apply(T t)
//        // This is UNBOUND; when we call "apply" we will bind it then to
//        // a particular instance.
//        Function<Test, String> function = Test::getName; // String apply(Test)
//
//        // The function is unbound, so you need to specify which instance to call it on
//        System.out.println(function.apply(t1));//Sean
//        System.out.println(function.apply(t2));//Desmond
//        
//        // Static method references are considered UNBOUND also
////          int compare(T o1, T o2)
//        Comparator<String> comp  = (s1, s2) -> Test.compareStrings(s1, s2);
//        Comparator<String> comp2 = Test::compareStrings;   // pass the params auto.
//                                                           // deferred execution
//        List<String> ls = Arrays.asList("z", "p", "a");
//        System.out.println("Insertion order: "+ls);
//        Collections.sort(ls, Test::compareStrings);// ok
//        ls.sort(comp);                        // execution
//        System.out.println("Sorted: "+ls);
//        
//        // static method references (Collections.sort)
//        List<Integer> li = Arrays.asList(1,2,7,4,5);
//        // Consumer    void accept(T t)
//        Consumer<List<Integer>> lambda1 = l -> Collections.sort(l);//deferred execution
//        // Consumer takes one parameter => sort(List) is used, as opposed to Sort(List, Comparator)
//        Consumer<List<Integer>> mr1 = Collections::sort;
//        mr1.accept(li);// execution
//        lambda1.accept(li);
//        System.out.println(li);
//        
//        // bound method references
//        String str = "abc";
//        Predicate<String> lambda2   = s -> str.startsWith(s);// bound to 'str'
//        Predicate<String> mr2       = str::startsWith;
//        System.out.println(lambda2.test("x"));  // false
//        System.out.println(mr2.test("ab"));     // true
//
//        // unbound method references
//        Predicate<String> lambda3   = s -> s.isEmpty();
//        Predicate<String> mr3       = String::isEmpty;
//        // binds at runtime to the arg passed in to "test()"
//        System.out.println(lambda3.test("x"));  // false
//        System.out.println(mr3.test(""));       // true
//        
//        // constructor method references
//        Supplier<String> lambda4 = () -> new String();
//        Supplier<String> mr4     = String::new;
//        System.out.println(lambda4.get());
//        System.out.println(mr4.get());
//
//        BiPredicate<String, String> biLambda = (s, p) -> s.startsWith(p);
//        System.out.println(biLambda.test("abcd", "ab"));// true        
//        BiPredicate<String, String> biMR = String::startsWith;
//        // startsWith is invoked using the first arg ("vvv") and any other arguments
//        // are params to startsWith()
//        System.out.println(biMR.test("vvv", "ab"));// false
//
//        Function<Integer, List<String>> methodRef = ArrayList::new;
//        List<String> ls2 = methodRef.apply(22);
//        ls2.add("21");
//        System.out.println(ls2);//[21]
//
//        // ArrayList(int initialCapacity)
//        Function<Integer, List<String>> lambda = x -> new ArrayList(x);
//        List<String> ls3 = lambda.apply(22);
//        ls3.add("244");
//        System.out.println(ls3);//[244]
    }
}
public class BoundVersusUnboundMethodRefs {
}
