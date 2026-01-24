package j25.assignment;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.List;
import module java.base;

public final class LecturerCsvLoader {

    private LecturerCsvLoader() { }

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
    public static List<LecturerRecord> load(Path path) throws IOException {
        // 1) Read the entire file into memory as a list of lines.
        //    For small assignment CSVs, this keeps the code very simple.
        var lines = Files.readAllLines(path);

        // 2) If the file is empty, there is nothing to parse.
        if (lines.isEmpty()) return List.of();

        // 3) We'll build the results in a mutable list,
        //    then return an unmodifiable copy at the end.
        var result = new java.util.ArrayList<LecturerRecord>();

        // 4) Start at index 1 to skip the header row:
        //    name,age,faculty,dept
        for (int i = 1; i < lines.size(); i++) {
            var line = lines.get(i).trim();

            // 5) Ignore blank lines (helps if the file ends with a newline).
            if (line.isBlank()) continue;

            // 6) Convert a CSV line into a LecturerRecord and store it.
            result.add(parseLine(line));
        }

        // 7) Return an unmodifiable snapshot so callers can't mutate the internal list.
        return List.copyOf(result);
    }

    private static LecturerRecord parseLine(String line) {
        // Expect exactly 4 columns:
        // name, age, facultyCode, deptCode
        var parts = line.split(",");

        // Defensive check: makes errors clearer when the CSV row is malformed.
        if (parts.length != 4) {
            throw new IllegalArgumentException("Bad CSV row (expected 4 columns): " + line);
        }

        var name        = parts[0].trim();
        var age         = Integer.valueOf(parts[1].trim());
        var facultyCode = parts[2].trim();
        var deptCode    = parts[3].trim();

        return new LecturerRecord(name, age, facultyCode, deptCode);
    }

}