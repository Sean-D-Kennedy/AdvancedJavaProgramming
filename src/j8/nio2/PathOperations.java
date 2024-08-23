package j8.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

// current directory: C:\Users\skennedy\Documents\NetbeansProjects\Udemy   (Windows)
//                  : /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot   (Mac)
public class PathOperations {
    public static void main(String[] args) {
        pathInfo(Paths.get("/Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot/.gitignore"));
        //pathInfo(Path.of("abc\\def\\ghi\\jkl"));
    }
    public static void pathInfo(Path path){
        System.out.println("toString: "+path);// /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot/.gitignore
        System.out.println("getNameCount: " + path.getNameCount()); // 6
        for(int i=0; i<path.getNameCount(); i++){
            // getName(0): Users   => root is NOT a name element (see Path.of("/").getName(0); on line 22)
            System.out.println("getName("+i+"): "+path.getName(i));
        }
        System.out.println("getFileName: " + path.getFileName());   // .gitignore
        System.out.println("getParent: " + path.getParent());       // /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot
        System.out.println("getRoot: " + path.getRoot());           // /
//        System.out.println("exception: " + Path.of("/").getName(0)); // java.lang.IllegalArgumentException

        System.out.println("subpath(0,3): "+path.subpath(0, 3));    // Users/seankennedy/aUdemy
        System.out.println("subpath(1,4): "+path.subpath(1, 4));    // seankennedy/aUdemy/Source Code
        System.out.println("subpath(2,3): "+path.subpath(2, 3));    // aUdemy
        
        System.out.println("isAbsolute: "+path.isAbsolute());       // true
    }
}
