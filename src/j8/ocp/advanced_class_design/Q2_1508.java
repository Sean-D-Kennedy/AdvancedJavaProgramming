package j8.ocp.advanced_class_design;

import java.util.TreeSet;

enum SIZE{
    TALL, JUMBO, GRANDE;
}
class CoffeeMug{
    public static void main(String[] args) {
        TreeSet<SIZE> hs = new TreeSet<SIZE>();
        hs.add(SIZE.GRANDE); hs.add(SIZE.JUMBO); hs.add(SIZE.GRANDE);
        hs.add(SIZE.TALL); hs.add(SIZE.TALL); hs.add(SIZE.JUMBO);
        for(SIZE s:hs) System.out.println(s);
    }
}
public class Q2_1508 {
    
}
