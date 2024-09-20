package j11.ocp.java_OOA.object_initialisation;

public class OrderOfInitialisation {
  public static void main(String[] args) {
    new Dishwasher();   // Bowl(3), Dishwasher()
  }
  static Table t        = new Table();      // Bowl(1), Bowl(2), Table()
  static Dishwasher dw  = new Dishwasher(); // Bowl(4), Bowl(5), Bowl(3), Dishwasher()
}
class Bowl {
  Bowl(int marker) {
    System.out.println("Bowl(" + marker + ")");
  }
}

class Table {
  static Bowl b1 = new Bowl(1);
  Table() {
    System.out.println("Table()\n");
  }
  static Bowl b2 = new Bowl(2);
}

class Dishwasher {
  Bowl b3 = new Bowl(3);
  static Bowl b4 = new Bowl(4);
  Dishwasher() {
    System.out.println("Dishwasher()\n");
  }
  static Bowl b5 = new Bowl(5);
}

