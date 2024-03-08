/**
 *   @author Rogelio Estrada , Carlos Murillo, Matthew Taulton,
 *   @version 1.0
 *   @see Assignment
 *   @see Student
 *   @see CourseList
 *   @see GradeTrackerTUI
 *   @see CourseListSerializer
 *   @since 02/13/2023
 *   This class is meant to represent a student in a course with a list of their assignments
 */

import java.util.List;
import java.io.Serializable;

public class Student implements Serializable {
    /**
     * String that represents the student name
     */
    private String Name;
    /**
     * Int that represents the Student's ID Number
     */
    private final int StudentID;
    /**
     * double that represents the average grade that the student has in the course
     */
    private double Grade;
    /**
     * A list that represents the student's list of assignments
     */
    private List<Assignment> assignments;

    /**
     * Constructor that creates a Student object with the given name , studentID and the course they belong to
     * @param Name
     * @param StudentID
     * @param classroom
     */
    public Student(String Name, int StudentID,Course classroom){
        this.Name = Name;
        this.StudentID = StudentID;
        this.assignments = classroom.getAssignment();
        this.Grade = averageGrade(assignments);
        //we should probably make the student array a list so that everytime we add a student we dont have to resize the array same thing for assignment array


    }

    /**
     * Method that uses a list of Assignment objects to get the average grade of the student
     * @param assignments a list of Assignment Objects
     * @return a double that represents the average grade in the class
     */
    public double averageGrade(List<Assignment> assignments){
        double result = 0;
        for(int i= 0; i<assignments.size();i++){
            result += assignments.get(i).getAssignGrade();
        }
        result = result / assignments.size();
        this.Grade = result;

        return result;
    }

    /**
     * Method that returns the instance variable assignments of the student object
     * @return a list of Assignment objects
     */
    public List<Assignment> getAssignments() {
        return this.assignments;
    }

    /**
     * This method sets the instance variable assignments to the one given
     * @param assignments a list of assignment objects
     */
    public void setAssignments(List<Assignment> assignments){
        this.assignments=assignments;
    }

    /**
     * Adds an Assignment object to the instance variable assignments
     * @param newAssignment
     */
    public void addAssignment(Assignment newAssignment){
        this.assignments.add(newAssignment);
    }

    /**
     * Sets the grade of one of the Assignment objects in the instance variable assignments
     * @param index an int that represents the index in the list of Assignments
     * @param grade an int that represents the grade received in a particular Assignment
     */
    public void setAssignGrade(int index, int grade){
        Assignment toEdit = this.assignments.get(index);
        toEdit.assignGrade = grade;

    }

    /**
     * Sets the instance variable Grade to the one given in parameter
     * @param grade an int that represents the grade of the student object
     */
    public void setGrade(double grade){
        this.Grade = grade;
    }

    /**
     * A method that returns the name of the Student
     * @return a String that represents the name of the student
     */
    public String getName(){
        return this.Name;
    }

    /**
     * a method that returns the StudentID number of the student object
     * @return an int that represents the student ID number
     */
    public int getStudentID(){
        return this.StudentID;
    }

    /**
     * A method that returns the value in the instance variable Grade
     * @return a double that represents the student object's average grade in the course
     */
    public double getGrade(){
        return this.Grade;
    }
}