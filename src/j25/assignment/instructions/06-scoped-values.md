# 06 — Scoped Values

## Goal
Improve CSV error reporting by adding **Scoped Values** to carry “context” (the CSV file path and current row number) through the call chain **without** adding extra method parameters.

### Why we’re doing this
Right now, when something goes wrong (bad row format, unknown faculty/department code), the exception message only tells us *what* failed — but not *where* it failed.

After this refactor, any error thrown during parsing can automatically include:
- the CSV file path, and
- the exact row number

This is a big win because:
- we keep method signatures clean (no extra `path` / `row` parameters everywhere),
- but still get clear, debuggable error messages.

---

## Step 1 — Add Scoped Values to `LecturerCsvLoader`

Open:

`src/j25/assignment/LecturerCsvLoader.java`

Near the top of the class (e.g., above the constructor), add two scoped values:
```java
static final ScopedValue<Path> CSV_PATH = ScopedValue.newInstance();
static final ScopedValue<Integer> CSV_ROW = ScopedValue.newInstance();
```
---

## Step 2 — Bind the CSV path for the duration of `load(...)`

In `load(Path path)`, wrap the method body so the path is available to all code called inside the scope.
> **Note on `call()` vs `run()`:**
> - Use `run(...)` when the scoped block returns nothing (`void`).
> - Use `call(...)` when the scoped block must return a value. 
> - Here we use `call(...)` because `load(...)` must return a `List<LecturerRecord>`
> - We also use `call(...)` when binding `CSV_ROW` because `parseLine(...)` returns a `LecturerRecord`.

Change `load(Path path)` to:
```java
    public static List<LecturerRecord> load(Path path) throws IOException {
        // scoping CSV_PATH for the whole method; call() returns a value
        return ScopedValue.where(CSV_PATH, path).call(() -> {
            var lines = Files.readAllLines(path);
            if (lines.isEmpty()) return List.of(); // empty list

            // building a mutable list but will return an unmodifiable copy at the end
            var result = new java.util.ArrayList<LecturerRecord>();

            // Start at index 1 to skip the header row: name,age,faculty,dept
            for (int i = 1; i < lines.size(); i++) {
                var line = lines.get(i).trim();
                if (line.isBlank()) continue;

                var rowNumber = i + 1; // i==1 is the 2nd row etc..

                // Bind the row number for the duration of parsing this specific line
                var record =
                        ScopedValue.where(CSV_ROW, rowNumber)
                                .call(() -> parseLine(line));

                result.add(record);
            }

            // Return an unmodifiable snapshot so callers can't mutate the internal list
            return List.copyOf(result);
        });
    }
```

## Step 3 — Add a helper to format CSV context for error messages

Still in `LecturerCsvLoader.java`, add this helper method.
**Important:** do NOT make it `private` — `LecturerRecord` will call it in Step 4B.
```java
static String csvContext() {
    var sb = new StringBuilder();
    // A ScopedValue only exists inside a scope created by ScopedValue.where(...).
    // isBound() = "are we currently inside that scope?"
    // If yes, get() returns the current value; if no, we skip it to avoid errors.
    if (CSV_PATH.isBound()) sb.append(" file=").append(CSV_PATH.get());
    if (CSV_ROW.isBound()) sb.append(", row=").append(CSV_ROW.get());

    return sb.isEmpty() ? "" : " (" + sb + ")";
}
```


## Step 4 — Append CSV context to your exceptions

### 4A) Malformed row — `LecturerCsvLoader`

Stay in:

`src/j25/assignment/LecturerCsvLoader.java`

In `parseLine(String line)`, update the exception so it includes the scoped context.

Replace:
```java
throw new IllegalArgumentException("Bad CSV row (expected 4 columns): " + line);
```
with:
```java
throw new IllegalArgumentException("Bad CSV row (expected 4 columns): " + line + csvContext());
```
---

### 4B) Unknown faculty / department codes — `LecturerRecord`

Now switch to:

`src/j25/assignment/LecturerRecord.java`

Find the helper methods you added earlier:

- `facultyFromCode(String code)`
- `deptFromCode(String code)`

Update the `default` cases so they also append `csvContext()`.

For faculty (in `facultyFromCode`), change:
```java
default -> throw new IllegalArgumentException("Unknown faculty code: " + code);
```
to:
```java
default -> throw new IllegalArgumentException("Unknown faculty code: " + code + LecturerCsvLoader.csvContext());
```
And for department (in `deptFromCode`), change:
```java
default -> throw new IllegalArgumentException("Unknown department code: " + code);
```
to:
```java
default -> throw new IllegalArgumentException("Unknown department code: " + code + LecturerCsvLoader.csvContext());
```

## Step 5 — Verify it works

Run `RunLecturerCsvLoader.java` normally to confirm nothing changed when the CSV is valid.

Then introduce one deliberate error in `lecturers.csv` (pick one):

- Remove a column from a row (e.g., delete the department value), OR
- Use an unknown code (e.g., `ENGINEERINGX`)

Re-run and confirm the exception message now includes context like:

- `file=.../lecturers.csv`
- `row=...`

---

## Definition of Done
- `LecturerCsvLoader` defines scoped values for CSV path and row number
- `load(...)` binds the path for the duration of the load and binds the row number per parsed line
- Exceptions for malformed rows and unknown codes include `file=...` and `row=...`
- No method signatures were changed to “thread” context through parameters