# 02 — Compact Source File Runner

## Goal
Create a **compact source file** that runs the CSV loader and prints the results.

This file is a small runnable “demo”:
- it loads `lecturers.csv`
- prints the number of lecturers loaded
- prints each `LecturerRecord`

---

## Step 1 — Confirm the CSV file exists

Make sure you have:

`src/j25/assignment/lecturers.csv`

---

## Step 2 — Create the compact source file

Create this file:

`src/j25/assignment/RunLecturerCsvLoader.java`

Paste this code:

```java
package j25.assignment;

import module java.base;

void main() throws Exception {
    // Path relative to the project root (simple and predictable)
    var path = Path.of("src/j25/assignment/lecturers.csv");

    var lecturers = LecturerCsvLoader.load(path);

    System.out.println("Loaded " + lecturers.size() + " lecturers:");
    lecturers.forEach(System.out::println);
}