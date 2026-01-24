package j25.assignment;

import module java.base;

public final class LecturerCsvLoader {
    static final ScopedValue<Path> CSV_PATH = ScopedValue.newInstance();
    static final ScopedValue<Integer> CSV_ROW = ScopedValue.newInstance();

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
    static String csvContext() {
        var sb = new StringBuilder();
        // A ScopedValue only exists inside a scope created by ScopedValue.where(...).
        // isBound() = "are we currently inside that scope?"
        // If yes, get() returns the current value; if no, we skip it to avoid errors.
        if (CSV_PATH.isBound()) sb.append(" file=").append(CSV_PATH.get());
        if (CSV_ROW.isBound()) sb.append(", row=").append(CSV_ROW.get());

        return sb.isEmpty() ? "" : " (" + sb + ")";
    }
    private static LecturerRecord parseLine(String line) {
        // Expect exactly 4 columns:
        // name, age, facultyCode, deptCode
        var parts = line.split(",");

        // Defensive check: makes errors clearer when the CSV row is malformed.
        if (parts.length != 4) {
            throw new IllegalArgumentException("Bad CSV row (expected 4 columns): " + line + csvContext());
        }

        var name        = parts[0].trim();
        var age         = Integer.valueOf(parts[1].trim());
        var facultyCode = parts[2].trim();
        var deptCode    = parts[3].trim();

        return new LecturerRecord(name, age, facultyCode, deptCode);
    }

}