package j8.ocp.java_date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Q2_1760 {
    public static void main(String[] args) {
        // "z" needed at end else DateTimeParseException
        // API: "The string must represent a valid instant in UTC..."
        Instant start = Instant.parse("2015-06-25T16:13:30.00Z"); // UTC/GMT/"Z"ulu time
        Instant newStart = start.plus(10, ChronoUnit.HOURS); 
        System.out.println("Unchanged: " +start);   // 2015-06-25T16:13:30Z  (immutable)
        System.out.println("Changed: "+newStart);   // 2015-06-26T02:13:30Z  (2am next day)

        Duration timeToCook = Duration.ofHours(1); 
        Instant readyTime = start.plus(timeToCook); 
        System.out.println(readyTime);              // 2015-06-25T17:13:30Z
        LocalDateTime ldt = LocalDateTime.ofInstant(readyTime, 
                                                    ZoneId.of("GMT+2"));// 2015-06-25T19:13:30
        System.out.println(ldt);
        ldt = LocalDateTime.ofInstant(readyTime, 
                                      ZoneId.of("GMT+12"));             // 2015-06-26T05:13:30
        System.out.println(ldt);
        // DST (Daylight Savings Time), March-October, means that in June, US/Eastern 
        // is -4hrs behind GMT. Other than that, US/Eastern is -5hrs behind GMT.
        ldt = LocalDateTime.ofInstant(readyTime, 
                                      ZoneId.of("US/Eastern"));         // 2015-06-25T13:13:30
        System.out.println(ldt);
    }
    
}
