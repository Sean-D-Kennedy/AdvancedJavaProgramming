package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyDeleteMove {
    public static void main(String[] args) throws IOException {
        // current directory: C:\Users\skennedy\Documents\NetbeansProjects\Udemy   (Windows)
        //                  : /Users/seankennedy/aUdemy/Source Code/Advanced Java and Spring Boot   (Mac)
        System.out.println(System.getProperty("user.dir"));

        Path source  = Paths.get("nio2/source.txt"); // no file created on hard disk by any of these commands
        Path target  = Paths.get("nio2/target.txt");
        Path target2 = Paths.get("nio2/target2.txt");
        
        Files.createDirectories(Paths.get("nio2") ); // relative directory created
        if(Files.exists(source)){
            // If source and target were directories then this would be a 'shallow' copy i.e. the files and
            // sub-directories within the source directory are NOT copied. We will perform a 'deep' copy, 
            // where the whole tree is copied with streams later.
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);  // no exception        
            Files.move(target, target2, StandardCopyOption.REPLACE_EXISTING); // now we have source and target2 files
            // source and target2 files remaining
        }else {
            Files.createFile(source);    // create source file
            Files.copy(source, target);  // now we have source and target files
            Files.move(target, target2); // now we have source and target2 files
            Files.delete(target2);       // only the source file left
        }

    }
    
}
