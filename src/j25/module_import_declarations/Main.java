package j25.module_import_declarations;

// Lots of import noise...
//import java.nio.file.Path;
//import java.nio.file.Files;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;

import module java.base;
import module java.desktop; // will cause an ambiguity with List
import java.util.List;      // this import takes precedence over the module imported versions
// Note: In compact source files, Java effectively behaves as if import module java.base;
//       is already there for you.  ￼

public class Main {
    void main() throws Exception {
        Path path = Path.of("data.txt"); // Path
        List<String> lines = Files.readAllLines(path); // List<String>
        // Map: (line length) -> (how many lines are of that length)
        Map<Integer, Long> lineLengthCounts =  // Map<Integer, Long>
                lines.stream()
                        .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(lineLengthCounts);       // {4=2, 5=1, 6=2, 10=1}

        String longest =   // String
                lines.stream()
                        .max(Comparator.comparingInt(String::length))
                        .orElse("<none>"); // returns the value, if present; or else returns "<none>"
        System.out.println("Longest: " + longest); // Longest: strawberry
    }
}
/* data.txt:
apple
banana
pear
strawberry
kiwi
banana
 */