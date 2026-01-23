import j25.assignment.LecturerCsvLoader;

void main() throws Exception {
    // Path relative to the project root
    var path = Path.of("src/j25/assignment/lecturers.csv");

    var lecturers = LecturerCsvLoader.load(path);

    System.out.println("Loaded " + lecturers.size() + " lecturers:");
    lecturers.forEach(System.out::println);
}