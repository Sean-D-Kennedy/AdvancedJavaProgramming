package j8.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.List;

public class NIO2ReadingWritingExamples {

    public static void main(String[] args) {
        copyTextFile(false);
        // copyTextFile(true);
        copyBinaryFile(false);
        // copyBinaryFile(true);
    }

    public static void copyTextFile(boolean buffering) {
        Path src = Paths.get("/Users/seankennedy/aUdemy/Source Code/Advanced Java/src/j8/io/sample.txt");
        Path dest = Paths.get("/Users/seankennedy/aUdemy/Source Code/Advanced Java/src/j8/io/sample2.txt");

        try {
            if (buffering) {
                // Using Files.readAllLines() for reading the whole file into a list of strings
                List<String> lines = Files.readAllLines(src, StandardCharsets.UTF_8);
                Files.write(dest, lines, StandardCharsets.UTF_8);
            } else {
                // Using FileChannel to read and write one byte at a time
                try (FileChannel srcChannel = FileChannel.open(src, EnumSet.of(StandardOpenOption.READ));
                     FileChannel destChannel = FileChannel.open(dest, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (srcChannel.read(buffer) > 0) {
                        buffer.flip(); // Prepare buffer for writing
                        destChannel.write(buffer);
                        buffer.clear(); // Clear buffer for the next read
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void copyBinaryFile(boolean buffering) {
        Path src = Paths.get("/Users/seankennedy/aUdemy/Source Code/Advanced Java/src/j8/io/SampleImage.png");
        Path dest = Paths.get("/Users/seankennedy/aUdemy/Source Code/Advanced Java/src/j8/io/SampleImage2.png");

        try {
            if (buffering) {
                // Using FileChannel with a larger buffer for binary files
                try (FileChannel srcChannel = FileChannel.open(src, EnumSet.of(StandardOpenOption.READ));
                     FileChannel destChannel = FileChannel.open(dest, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead;
                    while ((bytesRead = srcChannel.read(buffer)) > 0) {
                        buffer.flip();
                        destChannel.write(buffer);
                        buffer.clear();
                    }
                }
            } else {
                // Without buffering, reading and writing one byte at a time
                try (FileChannel srcChannel = FileChannel.open(src, EnumSet.of(StandardOpenOption.READ));
                     FileChannel destChannel = FileChannel.open(dest, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {

                    ByteBuffer buffer = ByteBuffer.allocate(1);
                    while (srcChannel.read(buffer) > 0) {
                        buffer.flip();
                        destChannel.write(buffer);
                        buffer.clear();
                    }
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}