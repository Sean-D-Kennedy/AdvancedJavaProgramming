package j25.scoped_values;

public class ThreadLocalExample {
    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();

    void main(){ // instance main()
        beginUser("SK-001");
        processUser();
        endUser();
        shouldNotSeeUserId();
    }
    static void beginUser(String userId){
        USER_ID.set(userId); // "set(..)" starts the "scope" (by convention)
//        USER_ID.set("XYZ"); // oops!
    }
    static void endUser(){
        // remove() ends the "scope" (by convention)
//        USER_ID.remove();  // don't forget to clear it!
    }
    static void processUser(){
        echo("begin");
        checkAccountStatus();
        echo("end");
    }
    static void checkAccountStatus(){
        echo("checkAccountStatus...");
        applyUserPreferences();
    }
    static void applyUserPreferences(){
        echo("applyUserPreferences...");
    }
    static void echo(String msg){
        // 3. Read the bound value within the scope
        IO.println("[" + Thread.currentThread().getName() + "] " + msg + " " + USER_ID.get());
    }
    static void shouldNotSeeUserId(){
        IO.println("[" + Thread.currentThread().getName() + "] " + "Should not see used id: " + " " + USER_ID.get());
    }
}
