# 05 — Flexible Constructors

## Goal
Refactor `LecturerCsvLoader` so it only reads and splits CSV lines, and move the code-to-object construction logic into `LecturerRecord`.

This makes `LecturerRecord` the **single source of truth** for:
- normalising input (e.g., trimming and uppercasing codes)
- mapping CSV codes to `Faculty` / `Department` objects

In other words: **CSV loading stays simple**, and **construction rules live with the type being constructed**.

---

## Step 1 — Add a flexible constructor to `LecturerRecord`


Open:

`src/j25/assignment/LecturerRecord.java`

Inside the record body (keep your existing compact constructor exactly as-is), add a **new convenience constructor** that accepts CSV-style codes and delegates to the canonical constructor:

```java
public LecturerRecord(String name, Integer age, String facultyCode, String deptCode) {
    // Normalise codes first (trim + uppercase keeps CSV forgiving)
    var fCode = facultyCode.trim().toUpperCase();
    var dCode = deptCode.trim().toUpperCase();
    // Delegate to the canonical record constructor
    this(name, age, facultyFromCode(fCode), deptFromCode(dCode));
}
```
---

## Step 2 — Add mapping helpers to `LecturerRecord`
Still in `LecturerRecord.java`, add these helper methods (below the new constructor is fine):
```java
private static Faculty facultyFromCode(String code) {
    return switch (code) {
        case "ENGINEERING" -> new EngineeringFaculty();
        case "BUSINESS" -> new BusinessFaculty();
        case "HUMANITIES" -> new HumanitiesFaculty();
        default -> throw new IllegalArgumentException("Unknown faculty code: " + code);
    };
}
private static Department deptFromCode(String code) {
    return switch (code) {
        case "SOFTWARE_ENGINEERING" -> new SoftwareEngineeringDept();
        case "COMPUTER_ENGINEERING" -> new ComputerEngineeringDept();
        case "ACCOUNTING" -> new AccountingDept();
        case "SOCIAL_CARE" -> new SocialCareDept();
            default -> throw new IllegalArgumentException("Unknown department code: " + code);
    };
}
```
---

## Step 3 — Refactor `LecturerCsvLoader.parseLine(...)` to use the new constructor

Open:

`src/j25/assignment/LecturerCsvLoader.java`

In `parseLine(...)`, replace the section that creates `faculty` and `dept` objects with code that passes the raw codes to the record.

Replace this:
```java
var faculty = parseFaculty(parts[2].trim());
var dept = parseDepartment(parts[3].trim());

return new LecturerRecord(name, age, faculty, dept);
```
with this:
```java
var facultyCode = parts[2].trim();
var deptCode = parts[3].trim();

return new LecturerRecord(name, age, facultyCode, deptCode);
```

## Step 4 — Remove unused parsing methods from `LecturerCsvLoader`

If IntelliJ now shows `parseFaculty(...)` and `parseDepartment(...)` as unused, delete them from `LecturerCsvLoader.java`.

That keeps the loader focused purely on file reading + splitting.

---

## Step 5 — Run and verify

Run `RunLecturerCsvLoader.java` again and confirm:
- lecturers still load and print correctly
- there are no compilation warnings/errors
- invalid codes still produce a clear `IllegalArgumentException`

---

## Definition of Done
- `LecturerRecord` contains a new constructor that accepts `facultyCode` and `deptCode` and delegates using `this(...)`
- Code normalisation (trim/uppercase) happens in `LecturerRecord`, not the loader
- `LecturerCsvLoader.parseLine(...)` no longer calls `parseFaculty(...)` or `parseDepartment(...)`
- The program still loads and prints lecturers successfully
