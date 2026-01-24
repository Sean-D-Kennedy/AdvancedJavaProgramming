# Java 25 Assignment — Instructions

This folder contains the step-by-step instructions for a Java 25 practice assignment.

You will recreate the same final working result by following the instruction files in order.

---

## What you will (and won’t) work on

### Files you WILL create from scratch
These two files are intentionally treated as “student-written” files.
You should create them by following the instruction steps exactly:

- `LecturerCsvLoader.java`
- `RunLecturerCsvLoader.java`

### Files you WILL edit (but NOT delete)
This file already exists and acts as your “domain model”.
You will refactor it during later steps, but you do not create it from scratch:

- `LecturerRecord.java`

You will also use:
- `lecturers.csv` (you will briefly edit it to test error handling)

### Files you SHOULD NOT edit
Everything else in the `assignment` folder is supporting code used by the three files above.

Do **not** edit these:
- `Faculty`, `Department`
- `EngineeringFaculty`, `BusinessFaculty`, `HumanitiesFaculty`
- `SoftwareEngineeringDept`, `ComputerEngineeringDept`, `AccountingDept`, `SocialCareDept`
- (and any other “*Faculty” / “*Dept” helpers)

---

## Instructions (do these in order)

Follow these files in sequence:

1. `01-module-import-declarations.md`
2. `02-compact-source-file.md`
3. `03-markdown-documentation-comments.md`
4. `04-unnamed-variables-and-patterns.md`
5. `05-flexible-constructors.md`
6. `06-scoped-values.md`
7. `07-stream-gatherers.md`

Each part ends with a **Definition of Done**. When you match that section, you are finished with that part.

---

## How to run the assignment

You run the program using:

- `RunLecturerCsvLoader.java`

`LecturerCsvLoader` is a utility/loader class and does **not** have a `main()` method, so you don’t run it directly.

---

## If you want the “full learning experience” (reset)

This repo already contains the final working result.

If you want to practise properly, reset yourself to a “blank slate” for the two student-written files:

1) Delete these two files only:
- `LecturerCsvLoader.java`
- `RunLecturerCsvLoader.java`

2) Recreate them by following the instruction MD files from Part 01 onward.

✅ Do **not** delete `LecturerRecord.java` — it is provided as the starting domain model and is refactored during later parts.