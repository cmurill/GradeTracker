import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Murillo, Matthew Taulton, Rogelio Estrada
 * @version 1.0
 * @see Assignment
 * @see Student
 * @see CourseList
 * @see GradeTrackerTUI
 * @see Serializable
 * @since 02/13/2023
 *
 * This class is used to create Course objects within the Grade Tracker program and implements the interface serializable to allow for the reading and writing of Courses.
 */

public class Course implements Serializable {

    /**
     * A String instance variable that is used to define the courseName of each Course object.
     */
    private String courseName;
    /**
     * A List of Student objects given the name students to store the students in each course.
     */
    private List<Student> students;
    /**
     * A List of Assignment objects given the name assignments to store the assignments in each course.
     */
    private List<Assignment> assignments;

    /**
     * The constructor that initializes the instance variables of this class.
     * @param courseName A String used to initialize the courseName instance variable.
     * The constructor initializes the List of Student objects and Assignment objects as a new ArrayList
     */
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<Student>();
        this.assignments = new ArrayList<Assignment>();
    }


    /**
     * The constructor for a Course object that takes in three parameters
     * @param courseName A String used to initialize the courseName instance variable
     * @param students A List of Student objects can be passed in to initialize the students list for the course
     * @param assignments A List of Assignment objects can be passed in to initialize the assignments list for the course
     */
    public Course(String courseName, List<Student> students, List<Assignment> assignments) {
        this.courseName = courseName;
        this.students = students;
        this.assignments = assignments;
    }

    /**
     * Method to add a student to the List of Student objects for the course
     * @param student Passes in a Student object as the parameter to add it to the list
     */
    public void addStudent(Student student) {
        students.add(student);
    }
    public void addAssignment(Assignment newAssignment){
        this.assignments.add(newAssignment);
    }


    /**
     * A method to return the name of the Course object
     * @return The String courseName is returned when the method is invoked
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * A setter method to set the name of a Course object
     * @param courseName A String defining the name of the Course object is passed into the parameter.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * A method that will return the List of all the Student objects in the students list.
     * @return Returns the entire List containing all the Student objects added to the Course
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * A method to get the number of Students in a Course.
     * @return Returns an integer of how many students there are in the List of Student objects.
     */
    public int getNumStudents() {
        return students.size();
    }

    /**
     * A setter method that takes a List in as the parameter and allows us to use the List passed in as the Student List.
     * @param students A List of Student objects named students is passed in and initializes the instance variable for students in the Course.
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * A setter method that takes a List in as the parameter and allows us to use the List passed in as the Assignment List.
     * @param assignments A List of Assignment objects named assignments is passed in and initializes the instance variable for assignments in the Course.
     */
    public void setAssignment(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    /**
     * A method that will return the List of Assignment objects in a Course
     * @return List of Assignment objects is returned.
     */
    public List<Assignment> getAssignment(){
        return this.assignments;
    }

}

