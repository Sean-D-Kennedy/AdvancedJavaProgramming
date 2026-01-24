import j25.assignment.LecturerCsvLoader; // Compact source files can't declare a package, so this file is in the default package.
import j25.assignment.LecturerRecord;
// LecturerCsvLoader and LecturerRecord are in j25.assignment, so we must import them.

void main()  {
    var workingDir = Path.of("").toAbsolutePath(); // current working directory (where relative paths start)
    var csvPath = workingDir.resolve("src/j25/assignment/lecturers.csv"); // path relative to working dir

    IO.println("Working dir: " + workingDir);
    IO.println("CSV path:    " + csvPath);

    if (!Files.exists(csvPath)) {
        throw new IllegalStateException("CSV not found. Check working directory and file location: " + csvPath);
    }
    try {
        var lecturers = LecturerCsvLoader.load(csvPath);
        if (!lecturers.isEmpty()) {
            IO.println(retirementSummary(lecturers.getFirst()));
        }

        IO.println("Loaded " + lecturers.size() + " lecturers:");
        lecturers.forEach(IO::println);
        var designGroups = lecturers.stream()
                .gather(Gatherers.windowFixed(3)) // groups of 3 lecturers for course design
                .toList();

        IO.println("\nCourse design groups (3 per group):");
        for (int i = 0; i < designGroups.size(); i++) {
            var group = designGroups.get(i);
            IO.println("Group " + (i + 1) + " (" + group.size() + " lecturers): " + group);
        }
    }
    catch (IOException _) {
        IO.println("Could not read CSV file at: " + csvPath);
    }
}

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