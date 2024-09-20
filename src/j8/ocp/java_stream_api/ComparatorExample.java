package j8.ocp.java_stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                                new Person("Alan", "Burke",22),
                                new Person("Zoe", "Peters",20),
                                new Person("Peter", "Castle",29));
        Person oldestPerson = people.stream()
                // Optional<Person> max(Comparator)
                // Comparator Comparator.comparing(Comparable)
                // p.getAge() returns an Integer (is a Comparable)
                // comparing() takes the functional interface Function:
                //      R apply(T t)
                .max(Comparator.comparing(p->p.getAge())) 
                .get();
        System.out.println(oldestPerson);
                
        List<Integer> li = Arrays.asList(22,13,34);
        Optional<Integer> oi = li.stream()
                .max(Comparator.comparing(i->i));// Integer is a Comparable as Integer implements Comparable

        List<Integer> li2 = Arrays.asList(1,2,3);
        Integer sum = li2.stream()
                // IntStream mapToInt(ToIntFunction)
                // toIntFunction is s afunctional interface:
                //      int applyAsInt(T value)
                .mapToInt(i->i)
                .sum();
        System.out.println(sum);
    }
}
