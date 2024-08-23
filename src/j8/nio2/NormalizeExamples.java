package j8.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeExamples {
    public static void main(String[] args) {
        Path p1 = Path.of("./x/y/../sean.txt"); // remove the ./ (redundant)
        System.out.println(p1.normalize());     // x\sean.txt
        
        Path p2 = Path.of("/x/y/../z");
        System.out.println(p2.normalize());     // \x\z

//        Path p3 = Path.of("./a");             // both are the same
        Path p3 = Path.of(".\\a");              // remove the .\ (or ./)
        System.out.println(p3.normalize());     // a

        Path p4 = Path.of("../x/y");           // no directory before the .. => can't be simplified
        System.out.println(p4.normalize());    // ..\x\y

        // using normalize() to better compare different paths
        Path p5 = Paths.get("/a/b/../../x.y");  // absolute
        Path p6 = Paths.get("/x.y");            // absolute
        System.out.println(p5.normalize());     // \x.y
        System.out.println(p6.normalize());     // \x.y
        System.out.println(p5.equals(p6));      // false
        System.out.println(p5.normalize().equals(p6.normalize()));// true
    }
}






/*
        Path p4 = Path.of(".a");                // filename, can't be simplified
        System.out.println(p4.normalize());     // .a
        
        Path p4b = Path.of("/.a");              // a filename, can't be simplified
        System.out.println(p4b.normalize());    // \.a

*/