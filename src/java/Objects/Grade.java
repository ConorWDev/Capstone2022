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
 * This Grade object holds the grades of a particular assignment for a particular student
 * @author Administrator
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
     * Constructor
     * @param studentUsername String
     * @param assignmentID String
     * @param mark String
     * @param isVisible String
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
     * gets how much weight an assignment has for the student
     * @return weight double
     */
    public double getWeight() {
        return weight;
    }

    /**
     * sets how much weight an assignment has for the student
     * @param weight double
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * gets the name of the lesson for the student
     * @return lessonName String
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     * sets the name of the lesson for the student
     * @param lessonName String
     */
    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    /**
     * gets the name of the particular student
     * @return studentName String
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * sets the name of the particular student
     * @param studentName String
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * gets the name of the assignment fo the student
     * @return assignmentName String
     */
    public String getAssignmentName() {
        return assignmentName;
    }

    /**
     * sets the name of the assignment fo the student
     * @param assignmentName String
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     * gets the mark the student got for the assignment
     * @return mark double
     */
    public double getMark() {
        return mark;
    }

    /**
     * sets the mark the student got for the assignment
     * @param mark double
     */
    public void setMark(double mark) {
        this.mark = mark;
    }

    /**
     * checks and gets whether the mark is visible or not for the student
     * @return isVisible Boolean
     */
    public boolean isIsVisible() {
        return isVisible;
    }

    /**
     * checks and sets whether the mark is visible or not for the student
     * @param isVisible Boolean
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
}
