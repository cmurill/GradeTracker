import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    private Assignment assignmentOne = new Assignment("assignment one", 100);
    private Assignment assignmentTwo = new Assignment("assignment two", 100);
    private Assignment assignmentThree = new Assignment("assignment three", 100);
    private Assignment assignmentA = new Assignment("assignment one", 100, 85);
    private Assignment assignmentB = new Assignment("assignment two", 100, 80);
    private Assignment assignmentC = new Assignment("assignment three", 100, 90);
    private Course javaCourse;
    private Student studentOne;
    private Student studentTwo;
    private Student studentThree;
    private List<Assignment> assignments;
    private List<Student> students;

    @Test
    public void testAverageGrade() {
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
        javaCourse.getStudents().get(0).getAssignments().get(0).setAssignGrade(90);
        javaCourse.getStudents().get(0).getAssignments().get(1).setAssignGrade(85);
        javaCourse.getStudents().get(0).getAssignments().get(2).setAssignGrade(80);
        javaCourse.getStudents().get(0).averageGrade(javaCourse.getStudents().get(0).getAssignments());
        assertEquals(85,javaCourse.getStudents().get(0).getGrade());
    }

    /*@BeforeEach
    public void setUp() {
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
    }

    @Test
    public void testAssignGrade() {
        javaCourse.getStudents().get(0).getAssignments().get(0).setAssignGrade(90);
        assertEquals(90, javaCourse.getStudents().get(0).getAssignments().get(0).getAssignGrade());
    }

    @Test
    public void testAverageGrade1() {
        assignments = new ArrayList<Assignment>();
        assignments.add(assignmentA);
        assignments.add(assignmentB);
        assignments.add(assignmentC);
        Student a = new Student("a", 1, javaCourse);
        assertEquals(85, a.averageGrade(assignments));
    } */

}