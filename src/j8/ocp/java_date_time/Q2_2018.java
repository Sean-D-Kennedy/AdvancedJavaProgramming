package j8.ocp.java_date_time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Q2_2018 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.of(2021, 02, 26, 17, 0, 0);          
        System.out.println(ldt); // 2021-02-26T17:00
        ZonedDateTime nyZdt = ldt.atZone(ZoneId.of("America/New_York")); 
        System.out.println(nyZdt); // 2021-02-26T17:00-05:00[America/New_York]
        ZonedDateTime laZdt = ldt.atZone(ZoneId.of("America/Los_Angeles")); 
        System.out.println(laZdt); // 2021-02-26T17:00-08:00[America/Los_Angeles]
        // Duration.between(start, end); // end-start
        // Read it left to right: NY is ? with respect to LA?
        Duration d = Duration.between(nyZdt, laZdt); // 8-5=+3, PT3H, NY is +3 hours ahead of LA
        System.out.println(d); 

//      // reversing them gives "PT-3H"
        // Read it left to right: LA is ? with respect to NY?
        d = Duration.between(laZdt, nyZdt); //  end-start = 5-8=-3, PT-3H, LA is -3 hours behind NY
        System.out.println(d); 
    }
    
}
