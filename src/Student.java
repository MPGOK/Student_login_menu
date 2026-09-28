import java.util.Arrays;

/**
 * Student Class
 *
 * @author
 * @version 1
 */

//USE YOUR CLASS FROM ASSIGNMENT 2

public class Student {
    private String name;
    private String studentId;
    private boolean registered;
    private double[] marks;

    public Student(String name, String studentId, boolean registered) {
        this.name = name;
        this.studentId = studentId;
        this.registered = registered;
        this.marks = new double[6];
    }

    public String getName () {
        return name;
    }

    public String getStudentId () {
        return studentId;
    }

    public boolean isRegistered () {
        return registered;
    }

    public double[] getMarks () {
        return marks;
    }

    //Calculate the average mark
    public double calculateAverage () {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total/marks.length;
    }

    public String toString () {
        return "Name: " + name +
                ", ID: " + studentId +
                ", Registered: " + (registered ? "Y" : "N")
                + ", Marks: " + Utilities.toTwoDecimalPlaces(calculateAverage()) +"\n";

    }



    //TODO : add 4 fields to store the required information for a student, these fields can only be accessed
    //      through public methods
    //       studentId - String
    //      name - String
    //      registered - boolean
    //      marks - int array to store 6 grades
    //TODO Add the constructor, Student(String, String, boolean) that adheres to the below validation rules
    //TODO The student id must be must be 8 chars long - default is 00000000


    //TODO The student name
    //     Default value is "".
    //     When creating the student, truncate the name to 20 characters.
    //     When updating an existing student, only update the name if it is 20 characters or less. (setter)

    //TODO registered does not require any validation, defaults to false

    //TODO marks array
    //      all values default to 0 at construction
    //      on update each mark must be between 0 and 100 (setter)


    //TODO Add a getter and setter for each field, that adheres to the above validation rules


    //TODO The toString should return the string containing each of the field values


    //TODO  Add a Method to calculate the average mark of the marks array called getAverageMark()
    //      returns an int

}
