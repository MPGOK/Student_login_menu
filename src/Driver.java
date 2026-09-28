import java.awt.event.WindowAdapter;
import java.util.Scanner;

public class Driver {

    private Scanner input = new Scanner(System.in);
    private Course course;

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        runMenu();
    }

    private int mainMenu() {
        //Display the menu options
        System.out.println("\n------ COURSE MENU ------");
        System.out.println("1. Add a student");
        System.out.println("2. List all students");
        System.out.println("3. Show course average");
        System.out.println("4. List registered students-");
        System.out.println("0. Exit");

        // Ask the user to enter their option
        System.out.print("Enter your choice");
        int option = input.nextInt();
        return option;
    }

    private void runMenu() {
        System.out.println("Course Name");
        String cName = input.nextLine();
        System.out.print("How many students are in the course? ");
        int numberStudents = input.nextInt();

        course = new Course(cName, numberStudents);

        int option = -1;
        while (option != 0) {

            //Display the menu and get the users choice
            option = mainMenu();

            //Setting up how to handle the users choise with if-else statements.
            if (option == 1) {
                addStudent(); //Adds the new studnet
            } else if (option == 2) {
                System.out.println(course.listStudents()); //Lists all the studnets
            } else if (option == 3) {
                //Show the average mark on the course.
                System.out.println("Course Average: " + course.calculateCourseAverage());
            } else if (option == 4) {
                //Lists only registered students
                listRegisteredStudents();
            } else if (option == 0) {
                System.out.println("Exiting...bye");
            }


            //TODO write switch or if stmt to execute the correct code as
            //TODO the menu option choosen
        }
    }



       private void addStudent() {
        input.nextLine();

        System.out.print("Enter the Student's Name: ");
        String studentName = input.nextLine();
        if (studentName.isEmpty()) {
            System.out.println("Student name cannot be empty. Try again.");
            return;
        }

        studentName = Utilities.truncateString(studentName, 20); //Turncate name to 20 characters

        int studentId = -1;
        while (studentId < 0) {
            System.out.print("Enter the student's ID: ");
             if(input.hasNextInt()){
            studentId = input.nextInt();
            if (studentId < 0) {
                System.out.println("ID must be a positive number. Please Try again.");
                 }
            } else {
                System.out.println("ID is valid. Please enter valid ID number");
                input.nextLine();
            }
        }


        String registeredInput = "";
        while (registeredInput.isEmpty()) {
            System.out.print("Is the student registered? (Y/N): ");
            registeredInput = input.nextLine();
            if (registeredInput.isEmpty()) {
                System.out.println("Please enter Y or N");
            }
        }

        boolean registered = Utilities.YNtoBoolean(registeredInput.charAt(0));

        double[] marks = new double[6];
        for (int i = 0; i < marks.length; i++) {
            while (true) {
                System.out.print("Enter the student's mark for grade " + (i + 1) + "(0-100): ");
                if (input.hasNextDouble()) {
                    marks[i] = input.nextDouble();
                    if (marks[i] < 0 || marks[i] > 100) {
                        System.out.println("Mark must be between 0 and 100. Please Try again.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Mark is valid. Please enter valid mark number");
                    input.nextLine();
                }
            }
        }

        Student student = new Student(studentName, String.valueOf(studentId), true);

        // Add the student to the course
        if (course.addStudent(student)){
        System.out.println("Student added successfully");
        } else {
            System.out.println("Failed to add student in the course.");
        }

        //TODO Ask user for student id, registered
        // TODO create Studentng object by calling Student constructor and passing it the correct values
        //TODO pass Student object to add method in Course class
        //TODO print whether add was successful or not

    }
        private void listRegisteredStudents() {
            if (course.listStudents().equals("Course: " + course.getCourseName() + "\n")) {
                System.out.println("No students are registered in the course.");
            } else {
                System.out.println("Registered students in the course: ");
                System.out.println(course.listStudents());
            }
        }


    //TODO - Add 2 methods to call the 2 extra methods
    // that you created in Course


}
