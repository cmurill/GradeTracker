import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The CourseList class is used to create a list of Course objects within the Grade Tracker program.
 * CourseList implements the interface serializable to allow the List of Courses to be read in and out to a file.
 *
 * @author Carlos Murillo, Matthew Taulton, Rogelio Estrada
 * @see Assignment
 * @see Student
 * @see Course
 * @see GradeTrackerTUI
 * @see Serializable
 * @since 02/13/2023
 */
public class CourseList implements Serializable {
    /**
     * A List of Course objects given the name courses to store the Course objects in a CourseList
     */
    private List<Course> list;
    /**
     * An integer value to track the size of the CourseList.
     */
    private int size;

    /**
     * The constructor that initializes the instance variables, list and size, of this class.
     * The constructor initializes the List of Course objects as a new ArrayList and sets the size equal to 0.
     */
    public CourseList(){
        this.list = new ArrayList<>();
        this.size = 0;
    }//ends constructor

    /**
     * A getter method to get the size of the ArrayList
     * @return Returns an integer representing the amount of elements in the CourseList.
     */
    public int getSize(){
        return this.size;
    }

    /**
     * A getter method to return a Course object within the CourseList at a certain index
     * @param index The method takes in an integer value representing the index of the Course object in the CourseList that we would like to retrieve
     * @return Returns a Course object that corresponds with the index passed into the parameter
     */
    public Course get(int index){
        if (index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return list.get(index);

    }//ends getSize method

    /**
     * A method that will add a Course object to the List of Courses
     * @param element A Course object is passed into the parameter for it to be added to the CourseList
     */
    public void add(Course element) {
        this.list.add(element);
        size++;
    }

    /**
     * A method to add a Course object to the CourseList at a certain index.
     * @param element The method takes in a Course object to be inserted into the CourseList
     * @param index The method takes in an integer value representing the index for the Course object to be inserted into
     */
    public void add(Course element , int index){
        if (index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        this.list.add(index , element);
        size++;
    }

    /**
     * A method to remove a Course object in the CourseList from a specific index
     * @param index The method takes in an integer as a parameter for the index of the Course to be removed from the CourseList
     * @return Returns the Course object being removed from the CourseList.
     */
    public Course remove(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Course returnValue = list.get(index);
        list.remove(index);
        size--;
        return returnValue;
    }
}//ends class