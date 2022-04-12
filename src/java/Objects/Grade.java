/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import DBOperations.DBOperationsGeneral;
import DBOperations.DBOperationsGrade;
import DBOperations.DBOperationsStudent;

/**
 *
 * @author This object holds the grade of a particular asignment for a particular student
 */
public class Grade {
    
    DBOperationsGrade dbOpsGrade = new DBOperationsGrade();
    DBOperationsGeneral dbOpsGen = new DBOperationsGeneral();
    DBOperationsStudent dbOpsStud = new DBOperationsStudent();
    
    private String studentName;
    private String assignmentName;
    private String lessonName;
    
    //possible TODO add courseName attributes via further DB queries
    //private String courseName;
    
    private double mark;
    //NOTE weight may not be applicable here. Weight should change for all assignments, not for one particular grade
    private double weight;
    
    private boolean isVisible;
    
    /**
     *
     * @param studentUsername
     * @param assignmentID
     * @param mark
     * @param isVisible
     */
    public Grade(String studentUsername, String assignmentID, String mark, String isVisible){
        
        this.studentName =  dbOpsStud.getStudentName(studentUsername);
        this.assignmentName = dbOpsGen.getAssignmentName(assignmentID);
        this.lessonName = dbOpsGen.getLessonName(assignmentID);
        this.weight = Double.parseDouble(dbOpsGrade.getWeight(assignmentID));
        
        this.mark = Double.parseDouble(mark);
        
        
        
        if (isVisible.equalsIgnoreCase("Y")){
            this.isVisible = true;
        }
        else{
            this.isVisible = false;
        }
    }
    
    /**
     *
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     *
     * @param lessonName
     */
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    /**
     *
     * @return
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     *
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     *
     * @return
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     *
     * @param assignmentName
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     *
     * @return
     */
    public double getMark() {
        return mark;
    }

    /**
     *
     * @param mark
     */
    public void setMark(double mark) {
        this.mark = mark;
    }

    /**
     *
     * @return
     */
    public boolean isIsVisible() {
        return isVisible;
    }

    /**
     *
     * @param isVisible
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
}
