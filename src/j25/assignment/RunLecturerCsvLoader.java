import j25.assignment.LecturerCsvLoader; // Compact source files can't declare a package, so this file is in the default package.
                                         // LecturerCsvLoader is in j25.assignment, so we must import it.

void main() throws Exception {
    var workingDir = Path.of("").toAbsolutePath(); // current working directory (where relative paths start)
    var csvPath = workingDir.resolve("src/j25/assignment/lecturers.csv"); // path relative to working dir

    System.out.println("Working dir: " + workingDir);
    System.out.println("CSV path:    " + csvPath);

    if (!Files.exists(csvPath)) {
        throw new IllegalStateException("CSV not found. Check working directory and file location: " + csvPath);
    }
    var lecturers = LecturerCsvLoader.load(csvPath);

    System.out.println("Loaded " + lecturers.size() + " lecturers:");
    lecturers.forEach(System.out::println);
}