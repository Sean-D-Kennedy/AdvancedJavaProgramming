# 02 — Compact Source File Runner

## Goal
Create a **compact source file** that runs the CSV loader and prints the loaded lecturers.

This file is a small runnable “demo”:
- compact source files (top-level `void main()`)
- default package behavior (no `package ...;`)
- how to debug file paths using the working directory

> Note: A compact source file **cannot** have a `package` declaration, so it lives in the **default package**.
> Because `LecturerCsvLoader` is in the package `j25.assignment`, we import it.

---

## Step 1 — Confirm the CSV file exists

Make sure this file exists:

`src/j25/assignment/lecturers.csv`

---

## Step 2 — Create the compact source file

Create this file:

`src/j25/assignment/RunLecturerCsvLoader.java`

Paste this code:

```java
import j25.assignment.LecturerCsvLoader; // Compact source files can't declare a package, so this file is in the default package.
                                         // LecturerCsvLoader is in j25.assignment, so we must import it.

void main() throws Exception {
    var workingDir = Path.of("").toAbsolutePath(); // current working directory (where relative paths start)
    var csvPath = workingDir.resolve("src/j25/assignment/lecturers.csv"); // path relative to working dir

    System.out.println("Working dir: " + workingDir);
    System.out.println("CSV path:    " + csvPath);

    if (!Files.exists(csvPath)) {
        throw new IllegalStateException("CSV not found. Check working directory and file location: " + csvPath);
    }
    var lecturers = LecturerCsvLoader.load(csvPath);

    System.out.println("Loaded " + lecturers.size() + " lecturers:");
    lecturers.forEach(System.out::println);
}
```
## Step 3 — Run it
Expected output:
- The working directory
- The absolute CSV path
- Loaded X lecturers:
- The list of lecturers
## Definition of Done
- The file compiles and runs as a compact source file (top-level void main())
- It successfully loads and prints lecturers from lecturers.csv
- If the CSV is missing, it fails with a clear error message
