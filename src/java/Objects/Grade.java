/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import DBOperations.DBOperationsGrade;

/**
 *
 * @author massvm
 */
public class Grade {
    
    DBOperationsGrade dbOps = new DBOperationsGrade();
    
    private String studentName;
    private String assignmentName;
    
    //TODO add lessonName courseName attributes via further DB queries
    //private String lessonName;
    //private String courseName;
    
    private double mark;
    
    private boolean isVisible;
    
    
    public Grade(String studentUsername, String assignmentID, String mark, String isVisible){
        
        this.studentName =  dbOps.getName(studentUsername);
        this.assignmentName = dbOps.getAssignmentName(assignmentID);
        
        this.mark = Double.parseDouble(mark);
        if (isVisible.equalsIgnoreCase("Y")){
            this.isVisible = true;
        }
        else{
            this.isVisible = false;
        }
    }

    public TestDBOperations getDbOps() {
        return dbOps;
    }

    public void setDbOps(TestDBOperations dbOps) {
        this.dbOps = dbOps;
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
