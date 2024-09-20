package j8.ocp.java_date_time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Q2_1749 {
    public static void main(String[] args) {
        LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0); // 2am
        System.out.println(ld1);// 2015-11-01T02:00
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern")); 
        System.out.println(zd1);// 2015-11-01T02:00-05:00[US/Eastern]
        LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0); // 1am
        System.out.println(ld2);// 2015-11-01T01:00
        ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern")); 
        System.out.println(zd2);// 2015-11-01T01:00-04:00[US/Eastern]

        // between(start, end)
        // between(0200, 0100) => negative answer as the 2nd arg. is earlier (in time)
        long x = ChronoUnit.HOURS.between(zd1, zd2); // 2am, 1am, backwards (-)
        System.out.println(x);// -2
        x = ChronoUnit.HOURS.between(zd2, zd1); // 1am, 2am, forwards (+)
        System.out.println(x);// 2
    }
    
}
