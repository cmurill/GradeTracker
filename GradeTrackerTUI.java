import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Matthew Taulton, Carlos Murillo, Rogelio Estrada
 * COMPSCI 2120 - 21305 - P001
 *  Group Assignment
 *
 *  This class is a User Interface for the GradeTracker program. It intakes
 *  user input to creat Courses, Students, and Assignments to track multiple students, their classes, and their gpa's;
 *
 * @version 1.0;
 *
 * @since 2/13/23
 */
public class GradeTrackerTUI {

    private CourseList listOfCourses;
    private Scanner input = new Scanner(System.in);
    public GradeTrackerTUI(CourseList listOfCourses) {
        this.listOfCourses = listOfCourses;
    }

    /**
     * run() method is used to generate the GradeTrackerUI and the model it will interact with.
     */
    public void run() {

        while(true) {

            System.out.println();
            System.out.println("_       __     __                             __           ______               __        ______                __            ");
            System.out.println("| |     / ___  / _________  ____ ___  ___     / /_____     / _____________ _____/ ___     /_  ___________ ______/ /_____  _____");
            System.out.println("| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\   / __/ __ \\   / / __/ ___/ __ `/ __  / _ \\     / / / ___/ __ `/ ___/ //_/ _ \\/ ___/");
            System.out.println("| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/  / /_/ /_/ /  / /_/ / /  / /_/ / /_/ /  __/    / / / /  / /_/ / /__/ ,< /  __/ /    ");
            System.out.println("|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/   \\__/\\____/   \\____/_/   \\__,_/\\__,_/\\___/    /_/ /_/   \\__,_/\\___/_/|_|\\___/_/     ");
	
            System.out.println("----------------------------------------------------------");
            System.out.println("Please select from the options below.");
            System.out.println("1. Create a class");
            System.out.println("2. Manage a class");
            System.out.println("3. Serialize");
            System.out.println("4. Deserialize");
            System.out.println("0. Exit program");
            try {

                int n = input.nextInt();
                System.out.println(n);
                input.nextLine();
                switch (n) {
                    case 1:
                        createACourse();
                        break;
                    case 2:
                        manageCourse();
                        break;
                    case 3:
                        CourseListSerializer.serializeCourseList(listOfCourses);
                        break;
                    case 4:
                        listOfCourses = CourseListSerializer.deserializeCourseList("Courses.ser");
                        break;
                    case 0:
                        System.exit(1);
                        break;
                    default:
                        System.out.println("Please choose one of the inputs specified above.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input use.");
                input.nextLine();
            }
        }
    }

    /**
     * createACourse() method is used to add a course to the model.
     */
    public void createACourse() {
        try {
            System.out.println("Please enter the following information for the course you would like to create.");
            System.out.print("Please enter the name of the course: ");
            String className = input.nextLine();
            if(!className.isEmpty()) {
                listOfCourses.add(new Course(className));
            }else{
                System.out.println("\nMake sure to type something in \n");
                createACourse();
            }
        }catch(Exception e ) {
            System.out.println("Error");
        }
    }

    /**
     * manageCourse() is used to select a Course from the List and edit its data;
     *Choices include Adding a student to the course and Managing a Student in the Course.;
     */
    public void manageCourse() {
        if(listOfCourses.getSize() != 0) {
            try {
                while (true) {
                    System.out.println("Please select which course you would like to manage.");
                    for (int i = 0; i < listOfCourses.getSize(); i++) {
                        System.out.println(i + ". " + listOfCourses.get(i).getCourseName());
                    }
                    int n = input.nextInt();
                    input.nextLine();
                    Course current = listOfCourses.get(n);
                    System.out.println("Please choose from the below options.");
                    System.out.println("1. Add a student to the course.");
                    System.out.println("2. Add an assignment.");
                    System.out.println("3. Manage a student.");
                    System.out.println("4. View the list of students in a course.");
                    System.out.println("0. Go back to the main menu.");
                    int a = input.nextInt();
                    input.nextLine();
                    switch (a) {
                        case 1:
                            addStudentToCourse(current);
                            break;
                        case 2:
                            addAssignmentToCourse(current);
                            break;
                        case 3:
                            manageStudent(current);
                            break;
                        case 4:
                            viewStudents(current);
                            break;
                        case 0:
                            run();
                            break;
                        default:
                            System.out.println("Please select one of the options listed above.");
                    }
                }
            }catch(Exception e){
                System.out.println("Invalid input used. Please try again");
                input.nextLine();
            }
        }else{
            System.out.println("Please create a course first");
            input.nextLine();
        }
    }

    /**
     * addStudentToCourse(Course) accesses' the provided Course and adds a Student Object to it using User input;
     * @param courseToAddStudent the current Course being edited by the User.;
     */
    public void addStudentToCourse(Course courseToAddStudent) {
        try {
            System.out.println("First we will need to create a Student.");
            System.out.print("Please enter the first name of the student you would like to add: ");
            String first = input.nextLine();
            System.out.print("Please enter the last name of the student you would like to add: ");
            String last = " " + input.nextLine();
            String fullName = first + last;
            System.out.print("Please enter the Student's I.D. number: ");
            int studID = input.nextInt();
            input.nextLine();
            Student currentStudent  = new Student(fullName,studID , courseToAddStudent); // this is assuming that we can remove the course from the constructor in student. discuss with group
            courseToAddStudent.addStudent(currentStudent);


        }catch(Exception e){
            System.out.println("\nInvalid input used. Please try again\n");
            input.nextLine();
            addStudentToCourse(courseToAddStudent);
        }
    }

    /**
     * manageStudent() method is used to print out the List of current students so the User can select one and edit
     * its data.;
     * @param current the current Course that is being edited by the user. Provided by input through the UI.
     */
    /**
     * A method that will print out the names of all the Students in a List of Student objects in a Course.
     * @param current Represents the Course object which we want to get the names of the Students printed out.
     */
    public void viewStudents(Course current) {
        if(current.getStudents().isEmpty()){
            System.out.println("No students in Course");
            return;
        }
        List<Student> kidsInCourse = current.getStudents();
        for(int i = 0; i < kidsInCourse.size(); i++) {
            System.out.println(kidsInCourse.get(i).getName() + " StudentID: " + kidsInCourse.get(i).getStudentID() + " Grade: "+ kidsInCourse.get(i).getGrade());
        }
        System.out.println();

    }
    // kidsInCourse return the List of Student objects
    // kidsInCourse.get(i) returns the Student at the index i
    // kidsInCourse.get(i).getName() returns the String that makes up the name of the student and will printout each in a loop
    public void manageStudent(Course current){
        while(true) {
            try {
                System.out.println("Please select which student you would like to manage.");
                for (int i = 0; i < current.getStudents().size(); i++) {
                    System.out.println(i + ". " + current.getStudents().get(i).getStudentID() + "  " + current.getStudents().get(i).getName());
                }
                int n = input.nextInt();
                input.nextLine();
                Student currentStudent = current.getStudents().get(n);
                System.out.println("Please choose from the below options.");
                System.out.println("1. Assign grade.");
                System.out.println("2. Back\n" + "3. View Grades.\n");

                int a = input.nextInt();
                switch (a) {
                    case 1:
                        addAssignmentGrade(currentStudent);
                        break;
                    case 2:
                        manageCourse();
                        break;
                    case 3:
                        viewGrades(currentStudent);
                        break;
                    default:
                        System.out.println("Please select one of the options listed above.");
                        break;
                }
            }catch(Exception e){
                System.out.println("\nInvalid input used. Please try again.\n");


            }
        }
    }

    /**
     * addAssignmentToCourse() method is used to add an Assignment Object to the List of Assignments for the Course
     * that was selected by the user via the UI.
     * @param current Course that was selected by the user via the UI to be edited.
     */
    public void addAssignmentToCourse(Course current){
        try {
            System.out.println("Enter the name of the Assignment");
            input.reset();
            String assignName = input.nextLine();
            System.out.println("How many points is the Assignment worth?");
            int assignMax = input.nextInt();
            int currentGrade = 0;
            Assignment newAssignment = new Assignment(assignName, assignMax, currentGrade);
            current.addAssignment(newAssignment);


        }catch(Exception e){
            System.out.println("Invalid input used. Please try again");
            addAssignmentToCourse(current);
        }

    }



    /**
     * addAssignmentGrade() method is used to access the Student selected by the User via the UI and print all of the
     * Assignments in the AssignmentList for the selected student. The user can then choose which Assignment has been graded
     * and insert the grade received for the Assignment.
     * @param current
     */
    public void addAssignmentGrade(Student current){
        if(!current.getAssignments().isEmpty()) {
            try {

                System.out.println("Please enter the corresponding number for the assignment that has been graded.");
                System.out.println();
                for (int i = 0; i < current.getAssignments().size(); i++) {
                    System.out.println(i + ". " + current.getAssignments().get(i).getAssignName());  // changed this
                }
                int assignChoice = input.nextInt();
                System.out.println("What was the grade received?");
                int grade = input.nextInt();
                current.setAssignGrade(assignChoice, grade);


            } catch (Exception e) {
                System.out.println("\nInvalid input used. Please try again\n");
                input.nextLine();
                addAssignmentGrade(current);
            }
        }else{
            System.out.println("No assignments, please add an assignment to student first");
            manageCourse();
        }

        current.setGrade( current.averageGrade(current.getAssignments()));
    }

    /**
     * This method prints out to console the chosen students' list of assignments with their respective grades
     * @param current the Student object that the method will act upon
     */
    public void viewGrades(Student current){
        if(current != null && current.getAssignments().size() != 0) {
            List<Assignment> list = current.getAssignments();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(current.getName() + " "+ list.get(i).getAssignName() + ": " + list.get(i).getAssignGrade() + "/" + list.get(i).getMaxPossibleGrade() + "  " + list.get(i).getGradePercentage());
            }
        }else if(current.getAssignments().size() == 0){
            System.out.println("This student currently has no Assignments");
        }
        else{
            System.out.println("Error: Student picked is null");
        }
    }



    public static void main(String[] args) {
        CourseList listOfCourses = new CourseList();
        GradeTrackerTUI runner = new GradeTrackerTUI(listOfCourses);
        runner.run();
    }
}