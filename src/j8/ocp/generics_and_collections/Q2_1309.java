package j8.ocp.generics_and_collections;

import java.util.*; 
public class Q2_1309 { 
    
    public < E extends CharSequence > Collection < E > getWordsStartingWith( Collection< E > input , char ch ) {
            Collection<E> returnValue = new ArrayList< E >();
            int len = input.size();
            for(E e : input) { 
                if(e.charAt(0) == ch)
                    returnValue.add(e);
            }
            return returnValue;
        } 
        public void checkIt(){
            List<String> a = new ArrayList<String>();
            a.add("apple"); a.add("cherry"); 
            Set<StringBuffer> b = new HashSet<StringBuffer>();
            b.add( new StringBuffer("pineapple")); 
            Collection<String> ac = getWordsStartingWith(a, 'a'); 
            Collection<StringBuffer> bc = getWordsStartingWith(b, 'b'); 
        }
        public static void main(String[] args){
            new Q2_1309().checkIt();
        } 
} 
