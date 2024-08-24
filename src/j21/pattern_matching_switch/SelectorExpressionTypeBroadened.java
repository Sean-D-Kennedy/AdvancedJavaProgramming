package j21.pattern_matching_switch;

record R(){}
enum E{ONE}
public class SelectorExpressionTypeBroadened {
    public static void main(String[] args) {
        selectorType("abc");        selectorType(new R());
        selectorType(E.ONE);        selectorType(null);
        selectorType(new double[]{2.1, 3.5});        selectorType(2);
    }
    public static void selectorType(Object obj){
        System.out.println(
            // selector expression type expanded to integral primitives (except 'long')
            // and any reference type
            switch(obj){
                case String s1 -> "String";
                case R r -> "Record";
                case E e -> "Enum";
                case null -> "null";
                case double[] da -> "double array";
                default -> "others";
            }
        );
    }
}
