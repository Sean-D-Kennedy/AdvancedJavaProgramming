package j8.localisation;

import java.util.Locale;
import java.util.ResourceBundle;

/*
   The hierarchy is decided upon the first filename (resource bundle) that exists when
   we are searching for resource bundles. 
    1. Find a resource bundle (based on filename) - this locks the hierarchy in place.
    2. Look for the key in the hierarchy
        - properties files and java/class files do not share a hierarchy.

NOTE: The editor copies the properties files into the correct "target" directory automatically. If you are
      copying the properties files in manually, copy them into "..\target\classes\j8\localisation".
      If you want to edit them via the editor, then copy them into "..\src\main\java\j8\localisation"
      also and edit them from there (the editor will copy the edited files into the "target" directory).
*/
public class BundleSearching {
    public static void main(String[] args) {
        defaultLocaleIrrelevant();
        ignoreAmericanBundle();
        usingDefaultLocale();
    }
    public static void defaultLocaleIrrelevant(){ // finds Mill_en_CA.properties
        Locale.setDefault(new Locale("en", "IE"));
        Locale localeCA = new Locale("en", "CA");
        // Search path:
        //  1a. Mill_en_CA.java
        //  1b. Mill_en_CA.properties (found this file - hierarchy is now decided!) 
        //  2.  Now we are locked into a specific hierachy (this means that the 
        //      default locale Mill_en_IE.java/properties is irrelevant).
        //      The hierarchy searched is now properties files only:
        //      - Mill_en_CA.properties
        //      - Mill_en.properties
        //      - Mill.properties (default bundle)
        ResourceBundle rb = ResourceBundle.getBundle("j8.localisation.Mill", localeCA);
        // Because we are locked into a hierarchy (see above), this is why "name" below
        // comes up with "Some Mill" even though the "name" key is in the default locale
        // as well i.e. Mill_en_IE.properties.
        System.out.println(rb.getString("name"));// Some Mill
        System.out.println("-------------");
    }
    public static void ignoreAmericanBundle(){ // finds Mill_en.properties
        Locale.setDefault(new Locale("en", "IE"));
        Locale localeUS = new Locale("en", "US");
        // Search path:
        //  1a. Mill_en_US.java
        //  1b. Mill_en_US.properties
        //  2a. Mill_en.java (remove country)
        //  2b. Mill_en.properties (found, lock the hierarchy)
        //  3.  Now we are locked into a specific hierachy (this means that the 
        //      default locale Mill_en_IE.java/properties is irrelevant).
        //      - Mill_en.properties
        //      - Mill.properties (default bundle)
        ResourceBundle rb = ResourceBundle.getBundle("j8.localisation.Mill", localeUS);
        System.out.println(rb.getString("open"));// is open
        System.out.println(rb.getString("name"));// Some Mill
        System.out.println("-------------");
    }
    public static void usingDefaultLocale(){ // finds Mill_en_IE.properties
        Locale.setDefault(new Locale("en", "IE"));
        Locale localeFR = new Locale("fr", "FR");// french in France (no such bundle)
        // Search path:
        //  1a. Mill_fr_FR.java
        //  1b. Mill_fr_FR.properties
        //  2a. Mill_fr.java (remove country)
        //  2b. Mill_fr.properties 
        //  3a. Mill_en_IE.java (default locale)
        //  3b. Mill_en_IE.properties (found!)
        //  3.  Now we are locked into a specific hierachy.
        //      - Mill_en_IE.properties (default locale) 
        //      - Mill_en.properties
        //      - Mill.properties (default bundle)        
        ResourceBundle rb = ResourceBundle.getBundle("j8.localisation.Mill", localeFR);
        System.out.println(rb.getString("open"));// is open
        System.out.println(rb.getString("name"));// Irish Mill
        System.out.println("-------------");
    }
}
