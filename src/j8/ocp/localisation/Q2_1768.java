package j8.ocp.localisation;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public class Q2_1768 {
    public static void main(String[] args) {
        Locale myloc = new Locale.Builder().setLanguage("en").setRegion("UK").build(); //L1 
        ResourceBundle msgs = ResourceBundle.getBundle("j8.ocp.localisation.mymsgs", myloc);  
        Set<String> keys = msgs.keySet(); 
        System.out.println(keys);// [noLabel, cancelLabel, okLabel]
        keys.forEach(key -> System.out.println(key + " : " + msgs.getString(key)));
//        Enumeration<String> en = msgs.getKeys(); 
//        while(en.hasMoreElements()){     
//            String key = en.nextElement();     
//            String val = msgs.getString(key);     
//            System.out.println(key+" : "+val); 
//        }
    }
   
}
