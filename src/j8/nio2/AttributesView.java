package j8.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class AttributesView {
    public static void main(String[] args) throws IOException {
        // reading - Files.readAttributes()
        var path = Path.of("./src/j8/nio2/Attributes.java");
        System.out.println(path);
        BasicFileAttributes view = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("isDirectory: "+view.isDirectory());          // false
        System.out.println("isRegularFile: "+view.isRegularFile());      // true
        System.out.println("isSymbolicLink: "+view.isSymbolicLink());    // false
        System.out.println("size: "+view.size());                        // 1936
        System.out.println("lastModifiedTime: "+view.lastModifiedTime());// 2022-05-05T09:25:06.91Z Zulu/UTC/GMT
        
        // changing - Files.getFileAttributeView and then BasicFileAttributeView::readAttributes()
        BasicFileAttributeView updView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        BasicFileAttributes attrs = updView.readAttributes(); // not using Files version here
        final long THIRTY_MINS_MSEC = 1000 * 60 * 30;   // 1000 msec/sec * 60 sec/min * 30 mins  = 1_800_000 mecs in 30 mins
        FileTime lastModifiedTime = FileTime.fromMillis(attrs.lastModifiedTime().toMillis() + THIRTY_MINS_MSEC); 
        // not changing last access time or creation time - pass in null for them
        updView.setTimes(lastModifiedTime, null, null);

        view = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("lastModifiedTime: "+view.lastModifiedTime());// 2022-05-05T09:55:06.91Z Zulu/UTC/GMT
    }
    
}
