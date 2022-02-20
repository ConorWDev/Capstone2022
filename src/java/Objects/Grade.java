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
 * @author massvm
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
    private double weight;
    
    private boolean isVisible;
    
    
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
    
     public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
}
