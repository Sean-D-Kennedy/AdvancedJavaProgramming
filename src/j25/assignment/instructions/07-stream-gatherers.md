# 07 — Stream Gatherers

## Goal
Use **Stream Gatherers** to group the lecturers we loaded from the CSV into fixed-size “course design teams”.

---

### Why we’re doing this
Right now we have a `List<LecturerRecord>`.

If we want to split that list into groups (for example: teams of 3), we normally end up writing manual indexing code or doing a two-step collect-and-split.

With a **gatherer**, we can express the intent directly in the stream pipeline:
- “emit a list every N items”
- the final group may be smaller if the total is not a multiple of N

---

## Step 1 — Add a gatherer pipeline in the runner

Open:

`src/j25/assignment/RunLecturerCsvLoader.java`

Find the point where you already have:

```java
var lecturers = LecturerCsvLoader.load(csvPath);
```

Immediately after that line, add the following code:

```java
    var designGroups = lecturers.stream()
            .gather(Gatherers.windowFixed(3)) // groups of 3 lecturers for course design
            .toList();

    IO.println("\nCourse design groups (3 per group):");
    for (int i = 0; i < designGroups.size(); i++) {
        var group = designGroups.get(i);
        IO.println("Group " + (i + 1) + " (" + group.size() + " lecturers): " + group);
    }    
```
---

## Step 2 — Run and verify

Run `RunLecturerCsvLoader.java`.

With 5 lecturers in the CSV and a group size of 3, you should see:
- Group 1 with 3 lecturers
- Group 2 with 2 lecturers

---

## Definition of Done
- You used a stream pipeline containing `.gather(Gatherers.windowFixed(3))`
- The program prints “course design groups” to the console
- The output shows two groups (3 lecturers in the first group, 2 in the second) when there are 5 lecturers
