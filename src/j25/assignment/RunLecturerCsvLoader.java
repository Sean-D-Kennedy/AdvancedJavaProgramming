import j25.assignment.LecturerCsvLoader; // Compact source files can't declare a package, so this file is in the default package.
import j25.assignment.LecturerRecord;
// LecturerCsvLoader is in j25.assignment, so we must import it.

void main()  {
    var workingDir = Path.of("").toAbsolutePath(); // current working directory (where relative paths start)
    var csvPath = workingDir.resolve("src/j25/assignment/lecturers.csv"); // path relative to working dir

    System.out.println("Working dir: " + workingDir);
    System.out.println("CSV path:    " + csvPath);

    if (!Files.exists(csvPath)) {
        throw new IllegalStateException("CSV not found. Check working directory and file location: " + csvPath);
    }
    try {
        var lecturers = LecturerCsvLoader.load(csvPath);
        if (!lecturers.isEmpty()) {
            System.out.println(retirementSummary(lecturers.getFirst()));
        }

        System.out.println("Loaded " + lecturers.size() + " lecturers:");
        lecturers.forEach(System.out::println);
    }
    catch (IOException _) {
        System.out.println("Could not read CSV file at: " + csvPath);
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