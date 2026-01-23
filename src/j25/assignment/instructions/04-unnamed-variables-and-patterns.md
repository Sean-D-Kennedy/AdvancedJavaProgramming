# 04 — Unnamed Variables and Unnamed Patterns

## Goal
Practice **unnamed variables** (`_`) and **unnamed patterns** (`_`) using existing assignment code.

---

## Part A — Unnamed variable in a `catch` block

Open:

`src/j25/assignment/RunLecturerCsvLoader.java`

Find the `catch` block that currently looks like this:

```
    catch (IOException e) { // Part 04 will refactor `e` to `_`
        System.out.println("Could not read CSV file at: " + csvPath);
    }
```
Refactor it so the exception variable is unnamed:
```
    catch (IOException _) { // unnamed variable: we intentionally ignore the exception object
        System.out.println("Could not read CSV file at: " + csvPath);
    }
```
## Part B — Unnamed patterns in a `record` pattern

Still in `RunLecturerCsvLoader.java`, add this helper method (below `main()` is fine):
```java
static String retirementSummary(Object obj) {
    return switch (obj) {
        // Unnamed patterns: ignore faculty + department completely
        case LecturerRecord(String name, Integer age, _, _) when age >= 64 ->
                name + " is retirement age or close (" + age + ").";

        case LecturerRecord(String name, Integer age, _, _) ->
                name + " is not near retirement (" + age + ").";

        default -> "(Not a LecturerRecord)"; // exhaustive
    };
}
```
Now call it from `main()` after the lecturers are loaded (i.e., after `var lecturers = LecturerCsvLoader.load(csvPath);`
```
if (!lecturers.isEmpty()) {
System.out.println(retirementSummary(lecturers.getFirst()));
}
```
---

## Definition of Done
- You used an **unnamed variable** (`_`) in a `catch` block where the exception object is not needed.
- You used **unnamed patterns** (`_`) in a record pattern to ignore record components you don’t care about.
- The program compiles and runs successfully.
- Running the program prints the normal lecturer output plus one extra summary line from `retirementSummary(...)`.
