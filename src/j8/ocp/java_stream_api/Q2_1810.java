package j8.ocp.java_stream_api;

import java.util.Arrays;
import java.util.List;

public class Q2_1810 {
    public static void main(String[] args) {
        
        List<Person> friends = 
                Arrays.asList(  new Person("Bob", "Kelly", 31),
                                new Person("Paul", "Landers", 32),                                 
                                new Person("John", "Paters", 33)); 
        double averageAge = friends.stream()
                                // Stream<Person> filter(Predicate)
                                .filter(person->person.getAge()<30)     
                                // IntStream mapToInt(ToIntFunction)
                                //    ToIntFunction
                                //       int applyAsInt(T t)
                                .mapToInt(person->person.getAge())   
                                // OptionalDouble average()
                                .average()  
//                                .getAsDouble(); // NoSuchElementException: No value present
                                .orElse(0.0);//0.0
        System.out.println(averageAge);    }
    
}
