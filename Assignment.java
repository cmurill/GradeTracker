/**
 * @author Matthew Taulton
 * COMPSCI 2120 - 21305 - P001
 *  Group Assignment
 *
 *  Built to create and track Assignment Objects and the Grades received;
 *
 * @version 1.0;
 *
 * @since 2/13/23
 */

import java.io.Serializable;

public class Assignment implements Serializable {

    protected String assignName;
    protected int assignGrade;

    protected int maxPossibleGrade;

    /**
     * The Assignment constructor.
     * @param assignName String to give the Assignment a name;
     * @param maxPossibleGrade int that represents the maximum point total of the assignment;
     * @param assignGrade int that represents the grade received for the Assignment;
     *
     * @custom.Require assignName != null;
     *                 maxPossibleGrade !< 1;
     *                 assignGrade !< 0;
     */
    public Assignment(String assignName,int maxPossibleGrade, int assignGrade){
        this.assignName = assignName;
        this.assignGrade = assignGrade;
        this.maxPossibleGrade = maxPossibleGrade;


    }

    /**
     * Same as other constructor but without assignGrade ( meant to represent an ungraded assignment)
     * @param assignName String to give the Assignment a name;
     * @param maxPossibleGrade int that represents the maximum point total of the assignment;
     */
    public Assignment(String assignName, int maxPossibleGrade) {
        this.assignName = assignName;
        this.maxPossibleGrade = maxPossibleGrade;
    }

    /**
     * This method takes in a String and sets it as the new Assignment name;
     * @param newAssignName != null;
     */
    public void setAssignName(String newAssignName) {
        this.assignName = newAssignName;
    }

    /**
     * this method takes in an integer that will be set as the maximum possible grade of the assignment;
     * @param newMaxPossibleGrade > 0;
     */
    public void setMaxPossibleGrade(int newMaxPossibleGrade) {
        this.maxPossibleGrade = newMaxPossibleGrade;
    }

    /**
     * this method takes in an integer that will be set as the grade received for the assignment;
     * @param newAssignGrade >=0;
     */
    public void setAssignGrade(int newAssignGrade){
        this.assignGrade = newAssignGrade;
    }

    /**
     * this method returns the current assignments name;
     * @return String this.assignName != null;
     */
    public String getAssignName() {
        return assignName;
    }

    /**
     * this method returns the maximum possible grade for the current assignment.
     * @return integer this.MaxPossibleGrade > 0;
     */
    public int getMaxPossibleGrade() {
        return maxPossibleGrade;
    }

    /**
     * this method returns an integer that represents the grade received for the current assignment;
     * @return integer this.assignGrade >= 0;
     */
    public int getAssignGrade() {
        return assignGrade;
    }


    /**
     * this method takes in the grade received for an assignment and the max possible grade to find the percentage grade
     * for the current assignment;
     * @return double percentageGrade > = 0;
     */
    public String getGradePercentage(){
        double percentageGrade = (double) assignGrade / maxPossibleGrade * 100;
        return String.format("%.2f%%", percentageGrade);

    }

    /**
     * this method returns a String that represents the current assignment object in its current state.
     * @return formatted String assignmentReturn != null;
     */
    public String toString(){
        String assignmentReturn = "Assignment: " + assignName + " Total Point Value: " + maxPossibleGrade + " Points Earned "
                + assignGrade + " Percentage Grade " + getGradePercentage();
        return assignmentReturn;
    }

}