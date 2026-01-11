package j25.scoped_values;

public class ScopedValuesExample {
    // 1. Define a ScopedValue
    private static final ScopedValue<String> USER_ID = ScopedValue.newInstance();

    void main(){ // instance main()
        // 2. Bind a value to a scope
        // run(Runnable) - Runnable is a functional interface: void run()
        // run(Runnable) - executes the block on the current thread (does not start a new thread)
        ScopedValue.where(USER_ID, "SK-001").run(() -> processUser());
//        ScopedValue.where(USER_ID, "SK-002").run(() -> processUser());
        shouldNotSeeUserId();
    }
    static void processUser() {
        // Dynamic scope: USER_ID is visible here and in any method we call while inside run(...)
        // Lexical scope would be curly-brace based (like local variables): visibility depends on where code is written
        echo("begin");
        checkAccountStatus();
        echo("end");
    }
    static void checkAccountStatus(){
        echo("checkAccountStatus...");
        applyUserPreferences();  // dynamic scope
    }
    static void applyUserPreferences(){
        echo("applyUserPreferences...");
    }
    static void echo(String msg){
        // 3. Read the bound value within the scope
//        USER_ID.set   // no "set" option
        IO.println("[" + Thread.currentThread().getName() + "] " +
                   msg + " " + USER_ID.orElse("no user-id"));
    }
    static void shouldNotSeeUserId(){
        IO.println("[" + Thread.currentThread().getName() + "] " +
                   "Should not see used id: " + " " + USER_ID.orElse("no user-id"));
    }
}




// Nested scope: rebind USER_ID temporarily (inner wins)
//        ScopedValue.where(USER_ID, "INNER").run(() -> {
//            echo("inside inner"); // INNER
//            checkAccountStatus();      // INNER
//        });
//        echo("back to outer");         // outer value again

