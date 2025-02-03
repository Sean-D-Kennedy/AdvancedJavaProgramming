package j21.iterating_over_collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

public class TraversingCollections {
    public static void main(String []args){
        // Adding to a list
//        addListUnsupportedOperationException();
//        addListConcurrentModificationException();
//        addListUsingListIterator();
//        addListUsingCopyOnWriteCollection();
        // Removing from a list
//        removeListUsingIterator();
//        removeListUsingRemoveIf();

        // Adding to a set
//        addSetDeferredInsertion();
        addSetUsingCopyOnWriteCollection();
        // Removing from a set
//        removeSetUsingIterator();
//        removeSetUsingRemoveIf();

        // Adding to a map
//        addMapDeferredInsertion();
//        addMapUsingConcurrentHashMap();
        // Removing from a map
//        removeMapUsingIterator();
//        removeMapUsingStreams();
    }
    public static void addListUnsupportedOperationException(){
        // 1. UnsupportedOperationException with either Arrays.asList() or List.of().
        // Arrays.asList() creates a list that is fixed in size.
        // List.of() (and Set.of()) creates a list that is immutable.
        // In both cases, you cannot modify the collection by adding or deleting elements.
        // You can modify the elements of the list (update values at existing indices).
//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> names = List.of("Alice", "Bob", "Charlie");
        names.add("SK"); // ❌ Throws UnsupportedOperationException (unmodifiable list)

        // You can modify the elements that already exist.
//        names.set(0,names.get(0).toUpperCase() ) ;
//        System.out.println(names);
    }
    public static void addListConcurrentModificationException(){
        // 2. ConcurrentModificationException
        // Wrap unmodifiable list so we can modify it
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        for (String name : names) {
            if (name.equals("Bob")) {
                // Lists add() will have a problem...
                names.add("David"); // ❌ Throws ConcurrentModificationException
            }
        }
    }
    public static void addListUsingListIterator(){
        // 3. ListIterator
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        // Iterator has no add() method but ListIterator has. The extra complexity of where to
        // insert the element in the List (where order is important) is contained within ListIterator.
        for (var iterator = names.listIterator(); iterator.hasNext(); ) {
            //ListIterator<String> iterator = names.listIterator();
            //while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.equals("Bob")) {
                iterator.add("David"); // ✅ Safe addition using Iterator's add()
            }
        }
        System.out.println(names); // Output: [Alice, Bob, David, Charlie]
    }
    public static void addListUsingCopyOnWriteCollection() {
        // 4. Concurrency...
        // no need for iterator as mods are made to copies; possible performance hit
        // if there are many mods
        List<String> names = new CopyOnWriteArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        for (String name : names) {
            if (name.equals("Bob")) {
                names.add("David"); // using List's add()
            }
        }
        System.out.println(names); // Output: [Alice, Bob, Charlie, David]
    }
    // Removing from a list
    public static void removeListUsingIterator(){
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Bob"));// works
        // Iterator has a remove() method.
        for(var iterator=names.iterator(); iterator.hasNext();) {
            String name = iterator.next();
            if (name.equals("Bob")) {
                iterator.remove();  // ✅ Safe removal, optional method (not every impl. with have it)
                                    // Unmodifiable collections will throw UnsupportedOperationException
            }
        }
        System.out.println(names); // Output: [Alice, Charlie]
    }
    public static void removeListUsingRemoveIf(){
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Bob"));
        names.removeIf(name -> name.equals("Bob"));
        System.out.println(names); // Output: [Alice, Charlie]
    }
    // Adding to a set
    public static void addSetDeferredInsertion(){
        Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));
        // Set's iterator has no add() method
        // deferred insertion
        Set<String> toAdd = new HashSet<>();
        for (String element : names) {
            if ("Alice".equals(element)) {
                toAdd.add("Emily");
            }
        }
        names.addAll(toAdd);
        System.out.println(names); // Output: [Emily, Bob, Alice, Charlie]
    }
    public static void addSetUsingCopyOnWriteCollection(){
        Set<String> names = new CopyOnWriteArraySet<>(Set.of("Bob", "Alice", "Charlie"));
        // no need for deferred adding as mods are made to copies;
        // possible performance hit if there are many mods
        for (String name : names) {
            if (name.equals("Alice")) {
                names.add("Emily"); // using Set's add()
            }
        }
        System.out.println(names); // Output: [Alice, Bob, Charlie, Emily]
    }
    public static void removeSetUsingIterator(){
        // Wrap unmodifiable list in a HashSet (so we can modify it)
        Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));
        // Iterator has a remove() method.
        for(var iterator=names.iterator(); iterator.hasNext();) {
            String name = iterator.next();
            if (name.equals("Charlie")) {
                iterator.remove();  // ✅ Safe removal, optional method (not every impl. with have it)
                                    // Unmodifiable collections will throw UnsupportedOperationException
            }
        }
        System.out.println(names); // Output: [Bob, Alice]
    }
    public static void removeSetUsingRemoveIf(){
        Set<String> names = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));
        names.removeIf(name -> name.equals("Alice"));// only one Alice in the Set anyway
        System.out.println(names); // Output: [Bob, Charlie]
    }
    public static void addMapDeferredInsertion() {
        Map<String, Integer> names = new TreeMap<>(); // sorted by keys
        // again, Iterator has no add() method
        names.put("Charlie", 25);
        names.put("Alice", 31);
        names.put("Bob", 21);

        Map<String, Integer> toAdd = new HashMap<>();
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if ("Alice".equals(entry.getKey())) {
                toAdd.put("Alice", 32); // Alice's birthday!
            }
        }
        names.putAll(toAdd);
        System.out.println(names);  // {Alice=32, Bob=21, Charlie=25}
    }
    public static void addMapUsingConcurrentHashMap(){
        Map<String, Integer> names = new ConcurrentHashMap<>();
        names.put("Alice", 31);
        names.put("Bob", 21);
        names.put("Charlie", 39);
        names.put("Andrew", 31);
        for (var entry : names.entrySet()) {
            if (entry.getKey().equals("Alice")) {
                names.put("Emily", 24); // using Map's put() method
            }
        }
        System.out.println(names); // Output: {Emily=24, Bob=21, Andrew=31, Alice=31, Charlie=39}
    }
    public static void removeMapUsingIterator() {
        Map<String, Integer> names = new TreeMap<>();
        names.put("Alice", 31);
        names.put("Bob", 21);
        names.put("Charlie", 39);
        names.put("Andrew", 31);

        // An iterator is possible here also but remember Map does not inherit from Collection so
        // we get an EntrySet version first (i.e. a Set, which IS-A Collection) and work from there.
        Iterator<Map.Entry<String, Integer>> iterator = names.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 30) { // removes Bob
                iterator.remove();  // Safe removal during iteration
            }
        }
        System.out.println(names);// {Alice=31, Andrew=31, Charlie=39}
    }
    public static void removeMapUsingStreams() {
        Map<String, Integer> names = new TreeMap<>();
        names.put("Alice", 31);
        names.put("Bob", 21);
        names.put("Charlie", 39);
        names.put("Andrew", 31);

        // filter out/remove all names that begin with "A"
        // overwriting my original map on purpose
        names = names.entrySet()    // Map is not a Collection so we convert it to a Set (which IS-A Collection)
                .stream()
                .filter(mapEntry -> !mapEntry.getKey().startsWith("A")) // filter out names beginning with "A"
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(names);// {Bob=21, Charlie=39}
    }
}
