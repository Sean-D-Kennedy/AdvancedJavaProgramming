package j8.ocp.generics_and_collections;

class GenericType<K>{
    K x;
    
    GenericType(K x){ this.x = x;}
    K getX(){ return x; }
    void setX(K x){ this.x = x; }
}
class Fish{ 
    @Override
    public String toString() { 
        return "This is a Fish";
    }
}
public class Q2_1110 {
    public static void main(String[] args) {
        GenericType<String> genS = new GenericType("Sean");
        System.out.println(genS.getX());// Sean
        GenericType<Integer> genI = new GenericType(new Integer(4));
        System.out.println(genI.getX() + 4);// 8 (not "44")
        GenericType<Fish> genF = new GenericType(new Fish());
        System.out.println(genF.getX());// This is a Fish
    }     
}



