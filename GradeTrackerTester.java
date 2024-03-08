import java.util.ArrayList;
import java.util.List;

public class GradeTrackerTester {
    public static void main(String[] args) {
        Assignment assignmentOne = new Assignment("assignment one", 100);
        Assignment assignmentTwo = new Assignment("assignment two", 100);
        Assignment assignmentThree = new Assignment("assignment three", 100);
        Assignment assignmentA = new Assignment("assignment one", 100, 85);
        Assignment assignmentB = new Assignment("assignment two", 100, 80);
        Assignment assignmentC = new Assignment("assignment three", 100, 90);
        Course javaCourse;
        Student studentOne;
        Student studentTwo;
        Student studentThree;
        List<Assignment> assignments;
        List<Student> students;
        assignments = new ArrayList<Assignment>();
        assignments.add(assignmentOne);
        assignments.add(assignmentTwo);
        assignments.add(assignmentThree);
        students = new ArrayList<Student>();
        javaCourse = new Course("Java Two", students, assignments);
        studentOne = new Student("Rogelio", 001, javaCourse);
        studentTwo = new Student("Matthew", 002, javaCourse);
        studentThree = new Student("Carlos", 003, javaCourse);
        javaCourse.addStudent(studentOne);
        javaCourse.addStudent(studentTwo);
        javaCourse.addStudent(studentThree);
        assignments = new ArrayList<Assignment>();
        assignments.add(assignmentA);
        System.out.println(assignments.get(0).getAssignGrade());
        assignments.add(assignmentB);
        assignments.add(assignmentC);
        Student a = new Student("a", 1, javaCourse);
        averageGrade(assignments);
    }

    public static double averageGrade(List<Assignment> assignments){
        double result = 0;
        for(int i= 0; i<assignments.size();i++){
            result += assignments.get(i).getAssignGrade();
            System.out.println(result + "Inside the average grade method");
        }
        result = result / assignments.size();

        return result;
    }
}
