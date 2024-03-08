import java.util.Scanner;
public class GradeTrackerRunner {
    public static void main(String[] args) {
        System.out.println("GRADE TRACKER");
        System.out.println("Create course: 0");
        System.out.println("Manage course: 1");
        System.out.print("Please enter whether you'd like to create a course or manage a course: ");
        Scanner input = new Scanner(System.in);
        Course courseOne = null;
        Course courseTwo = null;
        Course courseThree = null;
        Course courseFour = null;


        int courseOption = input.nextInt();
        if (courseOption == 0) {
            System.out.print("Please enter an integer value for how many courses you would like to create: ");
            int numberOfCourses = input.nextInt();
            for (int i = 0; i < numberOfCourses; i++) {

            }
            System.out.print("Please enter the course name: ");
            String courseName = input.nextLine();

        } else if(courseOption == 1) {

        } else {
            System.out.println("Incorrect input. Please pass in either 0 or 1.");
        }
    }
}
