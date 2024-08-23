package j8.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

// current directory: C:\Users\skennedy\Documents\NetbeansProjects\Udemy   (Windows)
//                  : /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot   (Mac)
public class Attributes {
    public static void main(String[] args) {
        checkAttributes(Path.of("./src/j8/nio2/Attributes.java")); // file - regular
        System.out.println();
        checkAttributes(Path.of("./src/j8/nio2"));// file - directory
        System.out.println();
    }
    public static void checkAttributes(Path path){
        System.out.println(path);
        System.out.println("isDirectory: "+Files.isDirectory(path));
        System.out.println("isRegularFile: "+Files.isRegularFile(path));
        System.out.println("isSymbolicLink: "+Files.isSymbolicLink(path));
        System.out.println("isReadable: "+Files.isReadable(path));
        System.out.println("isWritable: "+Files.isWritable(path));
        System.out.println("isExecutable: "+Files.isExecutable(path));
        try {
            // isHidden(), size() and getLastModifiedTime() all throw IOException
            System.out.println("isHidden: "+Files.isHidden(path));
            System.out.println("size: "+Files.size(path));
            System.out.println("getLastModifiedTime: "+Files.getLastModifiedTime(path).toMillis());
            // epoch is 1970-01-01T00:00:00Z
            long millisFromEpoch = Files.getLastModifiedTime(path).toMillis(); // 1651740752448
            ZonedDateTime zdt = FileTime.fromMillis(millisFromEpoch).toInstant().atZone(ZoneId.of("Europe/Dublin"));
            System.out.println(zdt);// 2022-05-05T09:52:32.448+01:00[Europe/Dublin]
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
