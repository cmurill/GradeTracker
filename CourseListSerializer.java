/**
 *   @author Rogelio Estrada , Carlos Murillo, Matthew Taulton,
 *   @version 1.0
 *   @see Assignment
 *   @see Student
 *   @see CourseList
 *   @see GradeTrackerTUI
 *   @see CourseListSerializer
 *   @since 02/13/2023
 *   This class is used to serialize and deserialize CourseList objects
 */
import java.io.*;

public class CourseListSerializer {
    /**
     * Instance variable that is used to serialize
     */
        private static ObjectOutputStream outputCourseList;
    /**
     * Instance variable that is used to deserialize
     */
        private static ObjectInputStream inputCourseList;

    /**
     * This method takes in a CourseList object and serializes it into a file named Courses.ser
     * @param listOfCourses A list that has Course objects
     */
        public static void serializeCourseList(CourseList listOfCourses) {
            try {
                outputCourseList = new ObjectOutputStream(new FileOutputStream("Courses.ser"));
                outputCourseList.writeObject(listOfCourses);
                outputCourseList.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    /**
     * This method deserializes the file given in the parameter
     * @param fileName A string that represents the name of the File that is to be deserialized
     * @return A CourseList object that has been deserialized
     */
        public static CourseList deserializeCourseList(String fileName) {
            CourseList listOfCourses = null;
            try {
                inputCourseList = new ObjectInputStream(new FileInputStream(fileName));
                listOfCourses= (CourseList)inputCourseList.readObject();

            } catch (ClassNotFoundException e1) { // must include
                e1.printStackTrace();
                System.out.println("file does not exist make sure you have serialized this file before");
            } // end of catch block
            catch (IOException e2) { // must include
                e2.printStackTrace();
            }

            return listOfCourses;
        }
    }
