package j8.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeExamples {
    public static void main(String[] args) {
        relativePaths();
        absolutePaths();
        mixPaths(); // exceptions
    }
    public static void relativePaths(){
        // two relative paths - both are assumed to be in the same current working directory
        Path p1 = Paths.get("cattle.txt");      // file does not exist
        Path p2 = Path.of("farm/horses.txt");   // file does not exist
        
        // how do I get from p1 to p2?
        // file itself is one level => .. at start 
        System.out.println(p1.relativize(p2));   // ../farm/horses.txt   (Mac)
        // how do I get from p2 to p1?
        System.out.println(p2.relativize(p1));   // ../../cattle.txt    (Mac)
    }
    public static void absolutePaths(){
        // two absolute paths
        Path p1 = Paths.get("/cattle.txt");          // file does not exist
        Path p2 = Path.of("/home/farm/horses.txt");   // file does not exist

        System.out.println(p1.relativize(p2));   // ../home/farm/horses.txt   (Mac)
        System.out.println(p2.relativize(p1));   // ../../../cattle.txt  (Mac)
    }
    public static void mixPaths(){
        Path p1 = Paths.get("cattle.txt");      
        Path p2 = Paths.get("/cattle.txt");  // "c:\\cattle.txt" on Windows
        
//        System.out.println(p1.relativize(p2));   // java.lang.IllegalArgumentException
        System.out.println(p2.relativize(p1));   // java.lang.IllegalArgumentException
    }
}
