package j8.collections.sorting;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Worker{
    private int id;

    Worker(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }    

    @Override
    public String toString() {
        return "Worker{" + "id=" + id + '}';
    }
    
}
class Boss implements Comparable<Boss>{
    private int id;

    Boss(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public int compareTo(Boss otherBoss){
        return this.id - otherBoss.getId();
    }

    @Override
    public String toString() {
        return "Boss{" + "id=" + id + '}';
    }
    
}
public class ComparatorIsUseful {
    public static void main(String[] args) {
//        Set<Boss> bosses = new TreeSet<>();
//        bosses.add(new Boss(20));
//        bosses.add(new Boss(10));
//        bosses.add(new Boss(15));
//        System.out.println(bosses); // [Boss{id=10}, Boss{id=15}, Boss{id=20}]
        
//        Set<Worker> workers = new TreeSet<>();// ClassCastException: class Worker cannot be cast to Comparable
//        Set<Worker> workers = new TreeSet<>( (worker1, worker2) -> worker1.getId() - worker2.getId());
        Set<Worker> workers = new TreeSet<>( Comparator.comparing( worker -> worker.getId()));
//        Set<Worker> workers = new TreeSet<>( Comparator.comparing(Worker::getId));// unbound meth reference

        
        workers.add(new Worker(30));
        workers.add(new Worker(20));
        workers.add(new Worker(10));
        workers.add(new Worker(21));
        System.out.println(workers); // [Worker{id=10}, Worker{id=20}, Worker{id=21}, Worker{id=30}]
    }
}
