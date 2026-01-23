# 03 — Documentation Comments (HTML in JavaDoc) + Generate Javadoc

## Goal
Add a well-formatted **Markdown documentation comment** to `LecturerCsvLoader.load(...)`, then generate **HTML Javadoc** to verify the documentation renders correctly.
> Important: Markdown-style text inside Javadoc does not reliably render as Markdown in generated Javadocs.
> To guarantee consistent formatting in the browser output, we’ll use HTML inside the Javadoc block (headings, code blocks, lists).

---

## Step 1 — Confirm the file and module import are in place

Open:

`src/j25/assignment/LecturerCsvLoader.java`

Make sure the top of the file includes:

```java
package j25.assignment;

import module java.base;
```
## Step 2 — Paste the JavaDoc comment above load(...)

Find this method signature:
```java
public static List<LecturerRecord> load(Path path) throws IOException
```

Paste the following JavaDoc block directly above it:
```java
/**
 * <h2>Load lecturers from a CSV file</h2>
 *
 * This method reads a CSV file and converts each data row into a {@link LecturerRecord}.
 *
 * <h3>CSV format</h3>
 * The file must contain a <b>header row</b>, followed by one lecturer per line:
 *
 * <pre><code>name,age,faculty,dept</code></pre>
 *
 * <h3>Example row</h3>
 * <pre><code>Dr. Ada Lovelace,37,ENGINEERING,SOFTWARE_ENGINEERING</code></pre>
 *
 * <h3>Notes</h3>
 * <ul>
 *   <li>Blank lines are ignored.</li>
 *   <li>The header row is skipped.</li>
 *   <li><code>faculty</code> and <code>dept</code> are codes mapped by
 *       {@code parseFaculty(...)} and {@code parseDepartment(...)}.</li>
 * </ul>
 *
 * @param path path to the CSV file (for example: {@code Path.of("lecturers.csv")})
 * @return an unmodifiable list of lecturers loaded from the CSV
 * @throws IOException if the file cannot be read
 * @throws IllegalArgumentException if a row is malformed or contains unknown codes
 */
```
## Step 3 — Generate the HTML Javadocs
In IntelliJ:
1.	Select LecturerCsvLoader.java in the Project tool window
2.	Go to: Tools → Generate JavaDoc…
3.	Choose File scope (only this one file)
4.	Set an output folder, for example:
•	out/javadoc/j25-assignment
5.	Click Generate
6.	Open the generated index.html in a browser

## Step 4 — Verify the result
## Step 4 — Verify the result

Open the generated `index.html` (in your output folder) and navigate to the documentation for:

- `LecturerCsvLoader`
- `load(Path path)`

You should see:

- Headings such as **CSV format**, **Example row**, and **Notes**
- Code blocks showing the CSV header and example row
- Bullet points under the Notes section

If you see raw tags like `<h2>` or `<pre>`, it usually means the Javadoc comment was not copied correctly or the wrong file/scope was generated.

---
## Definition of Done

- `load(Path path)` has a JavaDoc comment that uses HTML (headings, code blocks, list)
- Javadoc generation completes with no errors
- The generated HTML displays formatted headings, code blocks, and bullet points
