package j25.stream_gatherers;
import module java.base; // Imports (on demand) all public types in all packages exported by java.base.
// Drop the current element only if it has the same key as the immediately previous key.
public class DropConsecutiveDuplicatesByKeyDemo {
    void main(){
        // If email is the key, we want Users with emails: "a@x.com", "b@x.com", "c@x.com", "a@x.com"
        // If purchases is the key, we want Users with purchases: 2, 3, 5, 3
        var users = List.of(
                new User(1, "a@x.com", 2),
                new User(2, "a@x.com", 3), // consecutive duplicate email, drop
                new User(3, "b@x.com", 5),
                new User(4, "c@x.com", 3),
                new User(5, "c@x.com", 3), // consecutive duplicate email, drop
                new User(6, "a@x.com", 3)  // ok
        );
        // distinct() will not work - all Users are different according to equals(), as User (a record) uses all components in the comparison
        var distinctDropConsecutive =
                users.stream()
                        .distinct()
                        .toList();
        IO.println("distinct => " + distinctDropConsecutive);

        // Gatherer - email
        var dropConsecutiveEmails =
                users.stream()
                        .gather(dropConsecutiveDuplicatesByKey(User::email))
                        .toList();
        IO.println("gatherer - email     => " + dropConsecutiveEmails);

        // Gatherer - purchases
        var dropConsecutivePurchases =
                users.stream()
                        .gather(dropConsecutiveDuplicatesByKey(User::purchases))
                        .toList();
        IO.println("\ngatherer - purchases => " + dropConsecutivePurchases);
    }

    // Track state: drop consecutive duplicates by key (sequential)
    static <T, K> Gatherer<T, ?, T> dropConsecutiveDuplicatesByKey(Function<? super T, ? extends K> keyExtractor) {
        // State is a local class which holds "memory" across elements.
        // The same state instance is reused for the duration of this gather operation
        //      - its fields start out “empty/default” and then get mutated as you go.
        class State {
            K lastKey;
            boolean isFirstElement = true; // ensure very first element will be pushed downstream
        }
        return Gatherer.<T, State, T>ofSequential(
                State::new, // Supplier initializer, created once per gather run <=> State state = new State();
                Gatherer.Integrator.ofGreedy((state, element, downstream) -> {
                    K key = keyExtractor.apply(element);
                    // If this is the first element OR the key is different from the previous key
                    if (state.isFirstElement || !Objects.equals(state.lastKey, key)) {
                        state.lastKey = key;
                        state.isFirstElement = false;
                        return downstream.push(element); // return false to stop
                    }// otherwise, skip it, same value as last time
                    return !downstream.isRejecting(); // should I keep going? return false means stop
                })
        );
    }
}
