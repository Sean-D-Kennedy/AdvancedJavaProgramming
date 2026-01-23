# 01 — Module Import Declarations

## Goal
Create a new class called `LecturerCsvLoader` and use it to practise **Module Import Declarations**.

You will start with a version that uses multiple imports (the “old way”), then replace them with:

```java
import module java.base;
```

## Step 1 — Paste the starter code (with normal imports)

Create the file:

`src/j25/assignment/LecturerCsvLoader.java`

Then copy/paste this starter code:

```java
package j25.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class LecturerCsvLoader {

    private LecturerCsvLoader() { }

    public static List<LecturerRecord> load(Path path) throws IOException {
        // Read the entire file (simple for small CSVs)
        var lines = Files.readAllLines(path);
        if (lines.isEmpty()) return List.of();

        // Build results in a mutable list, then return an unmodifiable copy
        var result = new java.util.ArrayList<LecturerRecord>();

        // Skip header row: name,age,faculty,dept
        for (int i = 1; i < lines.size(); i++) {
            var line = lines.get(i).trim();
            if (line.isBlank()) continue;
            result.add(parseLine(line));
        }

        return List.copyOf(result);
    }

    private static LecturerRecord parseLine(String line) {
        var parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Bad CSV row (expected 4 columns): " + line);
        }

        var name = parts[0].trim();
        var age = Integer.valueOf(parts[1].trim());
        var faculty = parseFaculty(parts[2].trim());
        var dept = parseDepartment(parts[3].trim());

        return new LecturerRecord(name, age, faculty, dept);
    }

    private static Faculty parseFaculty(String code) {
        return switch (code) {
            case "ENGINEERING" -> new EngineeringFaculty();
            case "BUSINESS" -> new BusinessFaculty();
            case "HUMANITIES" -> new HumanitiesFaculty();
            default -> throw new IllegalArgumentException("Unknown faculty code: " + code);
        };
    }

    private static Department parseDepartment(String code) {
        return switch (code) {
            case "SOFTWARE_ENGINEERING" -> new SoftwareEngineeringDept();
            case "COMPUTER_ENGINEERING" -> new ComputerEngineeringDept();
            case "ACCOUNTING" -> new AccountingDept();
            case "SOCIAL_CARE" -> new SocialCareDept();
            default -> throw new IllegalArgumentException("Unknown department code: " + code);
        };
    }
}
```

## Step 2 — Replace imports with a module import
Replace:
```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
```
with
```java
import module java.base;
```
So the top of the file becomes:
```java
package j25.assignment;

import module java.base;
```
## Definition of Done
- `LecturerCsvLoader.java` compiles successfully
- The file uses `import module java.base;`
- The old individual `import java...` lines have been removed

