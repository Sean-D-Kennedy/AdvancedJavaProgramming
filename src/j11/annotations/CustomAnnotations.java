package j11.annotations;

enum Device {LAPTOP, PHONE};

// 1. Define the annotation.
// Can be public or package-private
@interface Human{} // marker annotation (no elements)

@interface OnWeb{
    // The elements - abstract and public by default
    //    - can't be protected, private or final
    int startTime() default 9;  // optional (due to default value)
    int hoursPerDay();          // required element (no default value)
    
    // As in interfaces, values are public static final by default.
    // Constants are not considered elements => marker interfaces can have constants.
    int PEAK_TIME_START=19;
    public static final int PEAK_TIME_END=22;

    // The element type must be a primitive type, a String, an enum, Class, another annotation or an array. 
//    Integer turnOff(); // wrapper types not allowed
    String name() default "SK";
    Device consume() default Device.LAPTOP;
    Class humanOrBot() default Human.class;
    Human extraInfo() default @Human; // Note: 'new' keyword never used for annotations
    String[] sites() default {"S", "K"}; // 1D-arrays only
}

// 2. Apply the annotation.
@OnWeb(hoursPerDay=6) @Human class Student{}

@OnWeb(hoursPerDay=3, startTime=18)
@Human
class Worker{}

public class CustomAnnotations {
    public static void main(String[] args) {
        
    }
}
