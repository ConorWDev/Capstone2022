/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import DBOperations.DBOperationsGrade;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * A StudentCourse object is a course that is related to a particular student. This
 * has been done so that a given student's average of all assignments within a course
 * can be calculated
 * @author Ryan Checora
 *
 */
public class StudentCourse {
    
    DBOperationsGrade dbOps = new DBOperationsGrade();
    
    private String courseID;
    private String courseName;
    private double courseAvg;
    
    /**
     * Constructor
     * 
     * @param studentUsername String
     * @param courseName String
     * @param courseID String
     * 
     */
    public StudentCourse(String studentUsername, String courseName, String courseID){
        this.courseName = courseName;
        this.courseAvg = caclculateCourseAvg(studentUsername,courseID);
        this.courseID = courseID;
    }
    
     /**
     * gets course grades from database, calculates and formats the 
     * average for the course of the student
     * 
     * @param studentUsername String
     * @param courseID String
     * @return courseAvg double
     */
    private double caclculateCourseAvg(String studentUsername, String courseID){
        double courseAvg = 0;
        
        ArrayList<Grade> grades = dbOps.getCourseGrades(studentUsername, courseID);
        
        double gradeXweights = 0;
        double weightTotal = 0;
        for (int x = 0; x < grades.size(); x++){
            if (grades.get(x).isIsVisible()){
                double mark = grades.get(x).getMark();
                double weight = grades.get(x).getWeight();
                double weightDec = weight/100.00;

                double gradeXweight = mark * weightDec;
                gradeXweights += gradeXweight;
                weightTotal += weight;
            }
        }
        DecimalFormat df = new DecimalFormat("###.##");
        courseAvg = gradeXweights/weightTotal * 100;
        String formatedDouble = df.format(courseAvg);
        courseAvg = Double.parseDouble(formatedDouble);
        
        return courseAvg;
    }

    /**
     * gets the course id of the course
     * @return courseID String
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * sets the course id of the course
     * @param courseID String
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * gets the course name of the course
     * @return courseName String
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * sets the course name of the course
     * @param courseName String
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * gets the course average of the students course
     * @return courseAvg double
     */
    public double getCourseAvg() {
        return courseAvg;
    }

    /**
     * sets the course average of the students course
     * @param courseAvg double
     */
    public void setCourseAvg(double courseAvg) {
        this.courseAvg = courseAvg;
    }
    
}
