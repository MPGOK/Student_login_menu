public class Course {
    private String courseName;
    private Student[] students; // Array of students
    private int studentCount; // To keep track of the number of students added

    // Constructor
    public Course(String courseName, int maxStudents) {
        this.courseName = courseName;
        this.students = new Student[maxStudents]; // Initialize the array with a maximum size
        this.studentCount = 0;
    }

    //Getter for course name
    public String getCourseName() {
        return courseName;
    }

    private boolean isEmpty() {
        return studentCount == 0;
    }

    private boolean isFull() {
        return studentCount == students.length;
    }

    // Method to add a student to the course
    public boolean addStudent(Student student) {
        if (isFull()) {
            return false;
        } else {
            students[studentCount] = student;
            studentCount++;
            return true;
        }

    }

    // Method to calculate the average mark of all students in the course
    public double calculateCourseAverage() {
        double total = 0;
        int numberOfMarks = 0;
        for (int i = 0; i < studentCount; i++) {
            for (double mark : students[i].getMarks()) {
                total += mark;
                numberOfMarks++;
            }
        }
        return  total / numberOfMarks;
    }

    // Method to print all students in the course
    public String listStudents() {
        String strListStudents = "Course: " + courseName + "\n";
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            strListStudents += i + " : " + student;
        }
        return strListStudents;
    }

    public String listStudentsWithAverages() {
        String output = "Student and their average marks: \n";
        for (int i = 0; i < studentCount; i++) {
            output += students[i].toString();
        }
        return output;
    }

    public String findStudnetByName (String name) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                return "Found" + students[i].toString();
            }
        }
        return "Student Not Found";
    }


    //TODO Add in another list method to list all students registered on course
    //TODO Add in another method that will be called from your menu


}
