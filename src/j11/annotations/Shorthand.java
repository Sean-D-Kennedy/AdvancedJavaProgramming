package j11.annotations;

// Example - "value" element for shorthand
@interface Team{
    // "value" element is the key!
    String value() default "Soccer"; // required or optional is fine
    int numPlayers() default 2;      // must be optional if we wish to use shorthand i.e. "value"
}
class Sport{
    @Team(numPlayers=6, value="Volleyball") void beach(){}; // all provided
    @Team(value="Tennis") void strawberriesAndCream(){};    // numPlayers omitted

    // Where shorthand is used (as in below), then there MUST be a "value" element.
    @Team("Curling") void slow(){};     // numPlayers omitted AND "value=" omitted
                                        // same as:   value="Curling"
}

// Example - shorthand for arrays with ONLY one element
@interface Quiz{
    String[] topics();
}
class Competitor{
    @Quiz(topics={"General Knowledge", "Music"}) String favouriteTopic;
    @Quiz(topics={"Sport"}) String leastFavouriteTopic;
    @Quiz(topics="Sport") String leastOtherFavouriteTopic; // shorthand - compiler inserts the {}

    // these do not compile
//    @Quiz(topics="Sport", "Jazz") String topic1;      // {} missing
//    @Quiz(topics=null) String topic1;                 // constant expression required (even {} is ok)
}

// Example - combining both shorthands
//           - value()
//           - arrays with ONLY one element
@interface Colours{
    String[] value();   // "value" element AND an array
}
class TestRainbow{
    @Colours(value={"Red"}) String colour1; // all details provided i.e. "value" and array {}
    @Colours(value="Red") String colour2;   // shorthand for single element array i.e. {} omitted
    @Colours({"Red"}) String colour3;       // shorthand for "value" element i.e. "value=" omitted, array {} included
    @Colours("Red") String colour4;         // shorthand for both "value" element and single element array 
                                            //   - "value=" omitted and array {} omitted
}

public class Shorthand {
    public static void main(String[] args) {
        
    }
}
