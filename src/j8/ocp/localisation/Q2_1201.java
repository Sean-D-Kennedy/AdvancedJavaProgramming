package j8.ocp.localisation;

import java.util.Locale;
import java.util.ResourceBundle;

public class Q2_1201 {
    public static void main(String[] args) {
        Locale locIrl = new Locale("en", "IE");// en_IE

        ResourceBundle rb = ResourceBundle.getBundle("j8.ocp.localisation.Labels", locIrl);
        System.out.println(rb.getObject("orgn"));// found in: Labels_en_IE.class
        
    }
}
