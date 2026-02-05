# Java 25 Assignment — Instructions

This folder contains the step-by-step instructions for a Java 25 practice assignment.

You will recreate the final working result by following the instruction files in order.

---

## Starter ZIP (recommended starting point)

Use the starter template ZIP in this folder:

- `Java25-Assignment-Starter.zip`

Unzip it, then copy the `src/` folder into your project (so you end up with `src/j25/assignment/...`).
> If you previously cloned this GitHub repo: ignore the repo’s `src/` folder for now.
> Replace it with the ZIP’s `src/` folder (delete/rename your existing `src/`, then copy in the ZIP’s `src/`).

The starter ZIP contains:
- the supporting domain types (Faculty/Department + implementations)
- `LecturerRecord.java` (starter “domain model” version)
- `lecturers.csv`

The starter ZIP intentionally does **not** include:
- `LecturerCsvLoader.java`
- `RunLecturerCsvLoader.java`

You will create those by following Parts 01–07. 

`Start here`: src/j25/assignment/instructions/README.md


---

## What you will (and won’t) work on

### Files you WILL create from scratch
These two files are intentionally treated as “learner-written” files:

- `LecturerCsvLoader.java`
- `RunLecturerCsvLoader.java`

### Files you WILL edit
This file already exists in the starter ZIP and acts as your “domain model”.
You will refactor it during later steps:

- `LecturerRecord.java`

You will also use:
- `lecturers.csv` (you will briefly edit it to test error handling)

### Files you SHOULD NOT edit
Everything else in `j25/assignment` is supporting code used by the files above.

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

## Reference solution (when stuck)

This GitHub repo contains a finished working version.
Use it only to compare if you get stuck.