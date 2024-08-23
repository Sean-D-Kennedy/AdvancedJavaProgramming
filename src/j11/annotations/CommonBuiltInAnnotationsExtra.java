package j11.annotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1. With no annotations.
// 2. Deprecate "print()"
//      a) show cmdline compiler error
//      b) uncomment @SuppressWarnings("deprecation") - error SHOULD disappear but does not
// 3. Uncomment "unchecked()" method.
//      a) show cmdline compiler error
//      b) uncomment @SuppressWarnings("unchecked") - error gone
// 4. @SafeVarargs
//      a) The rules around public/static/final and varargs
//      b) uncomment "abuseVarargs()" method and its method call
//          1. do it first without @SafeVarargs and observe the compiler error(s) 
//          2. insert @SafeVarargs and note the errors go away.
class Book{
//    /**
//     * How to consume the Book.
//     * @deprecated Use readOnline() instead.
//     */
//    @Deprecated(since="2.0", forRemoval=true)
    public static void print(){}
    public static void readOnline(){}
    public static Integer preview(List<String> pages){return pages.size();}
}
public class CommonBuiltInAnnotationsExtra {
    public static void main(String[] args) {
//        CommonBuiltInAnnotationsExtra ann = new CommonBuiltInAnnotationsExtra();
//        ann.testDeprecated();
//        ann.testUnchecked();

    //    abuseVarargs(new ArrayList<>());  
    }
    @SuppressWarnings("deprecation")
    public void testDeprecated() {
        Book.print();
    }
    @SuppressWarnings("unchecked")    // ignore warnings relating to the use of 'raw types'
    public void testUnchecked() {
        Book.preview(new ArrayList<>());
 //       Book.preview(new ArrayList());// this is a raw type - "new ArrayList<String>()" would be better
    }

    @SafeVarargs
    static int abuseVarargs(List<Integer>... list){ // must hava varargs and be private, static or final
        Object[] oa = list;
        oa[0] = Arrays.asList("uh-oh!");
        return list[0].get(0); // ClassCastException : String to Integer
    }
}










//     ok - static int abuseVarargs(List<Integer>... list){ // must hava varargs and be private, static or final
