package j8.ocp.java_date_time;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Q2_1743 {
    public static void main(String[] args) {
        Duration d = Duration.ofDays(2); // units of time - hours, minutes and seconds
        System.out.println(d);  // PT48H (Period of Time, no days)
        d = Duration.ofDays(0); 
        System.out.println(d);  // PT0S
        d = Duration.ofHours(0); 
        System.out.println(d);  // PT0S
        d = Duration.ofMinutes(0); 
        System.out.println(d);  // PT0S
        d = Duration.ofSeconds(0); 
        System.out.println(d);  // PT0S     
        d = Duration.ofMillis(0); 
        System.out.println(d);  // PT0S     
        d = Duration.ofNanos(0); 
        System.out.println(d);  // PT0S    
        d = Duration.of(5, ChronoUnit.MINUTES);
        System.out.println(d);  // PT5M    
        
        Period p = Period.ofYears(0); // units of time - days, months and years (no weeks!)
        System.out.println(p);  // P0D
        p = Period.ofMonths(0); 
        System.out.println(p);  // P0D
        p = Period.ofDays(0); 
        System.out.println(p);  // P0D
        p = Period.of(1,2,3); 
        System.out.println(p);  // P1Y2M3D
        p = Period.ofWeeks(3); 
        System.out.println(p);  // P21D (no weeks)
    }
}