package j8.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveExamples {
    public static void main(String[] args) {
        // current directory: C:\Users\skennedy\Documents\NetbeansProjects\Udemy   (Windows)
        //                  : /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot   (Mac)
        Path absolute = Paths.get("/Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot");
        Path relative = Path.of("nio2");
        Path file     = Path.of("name.txt");
        
        System.out.println("absolute.resolve(relative): "+ 
                absolute.resolve(relative));// /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot/j8.nio2
        System.out.println("absolute.resolve(file): "+ 
                absolute.resolve(file));// /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot/name.txt
        System.out.println("relative.resolve(file): "+ 
                relative.resolve(file));// j8.nio2/name.txt
        
        // trying to resolve an absolute path within anything just returns the absolute path 
        System.out.println("relative.resolve(absolute): "+ 
                relative.resolve(absolute));// /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot
        System.out.println("file.resolve(absolute): "+ 
                file.resolve(absolute));// /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot
        System.out.println("absolute.resolve(absolute): "+ 
                absolute.resolve(absolute));// /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot

        // interesting...
        Path p1  = Path.of("dir");
        Path p2  = Path.of("sk.txt");
        System.out.println("dir.resolve(sk.txt): "+ 
                p1.resolve(p2));// dir/sk.txt
        System.out.println("sk.txt.resolve(dir): "+     // sk.txt could be a directory and
                p2.resolve(p1));// sk.txt/dir           // dir could be a file
    }
    
}
