package j11.annotations;

import java.lang.annotation.Repeatable;

@interface Batteries {      // by convention, the plural of the annotation is used
    Battery[] value();      // must be value()
}

@Repeatable(Batteries.class)
@interface Battery{
    String level();
    boolean recharge();
}

@Battery(level="high", recharge=false)
@Battery(level="low", recharge=true)
class ElectricCar{}

public class RepeatableExample {
    
}
