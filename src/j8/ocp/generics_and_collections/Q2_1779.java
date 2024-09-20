package j8.ocp.generics_and_collections;

import java.util.ArrayList;
import java.util.Collections;

class Food implements Comparable<Food>{  // LINE 1
//class Food {  // LINE 1
  private String name;
  private int caloriesPerServing;
  public Food(String name, int calories){
    this.name = name; 
    this.caloriesPerServing = calories;
  }
  @Override
  public String toString(){
      return name;
  }
  //LINE 2
  public int compareTo(Food f){
    return this.name.compareTo(f.name); 
  }
}

public class Q2_1779 {
    public static void main(String[] args) {
        ArrayList<Food> al = new ArrayList<>();
        al.add(new Food("Cheese", 200));
        al.add(new Food("Milk", 300));
        al.add(new Food("Chocolate", 1000));
        al.add(new Food("Bread", 100));
        
        Collections.sort(al);   // sorting by name
        System.out.println(al);
    }
    
}
