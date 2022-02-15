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
 *
 * @author Ryan Checora
 * A StudentCourse object is a course that is related to a particular student. This
 * has been done so that a given student's average of all assignments within a course
 * can be calculated
 */
public class StudentCourse {
    
    DBOperationsGrade dbOps = new DBOperationsGrade();
    
    private String courseName;
    private double courseAvg;
    
    public StudentCourse(String studentUsername, String courseName, String courseID){
        this.courseName = courseName;
        this.courseAvg = caclculateCourseAvg(studentUsername,courseID);
    }
    
    private double caclculateCourseAvg(String studentUsername, String courseID){
        double courseAvg = 0;
        
        ArrayList<Grade> grades = dbOps.getCourseGrades(studentUsername, courseID);
        
        double gradeXweights = 0;
        double weightTotal = 0;
        for (int x = 0; x < grades.size(); x++){
            double mark = grades.get(x).getMark();
            double weight = grades.get(x).getWeight();
            double weightDec = weight/100.00;
            
            double gradeXweight = mark * weightDec;
            gradeXweights += gradeXweight;
            weightTotal += weight;
        }
        DecimalFormat df = new DecimalFormat("###.##");
        courseAvg = gradeXweights/weightTotal * 100;
        String formatedDouble = df.format(courseAvg);
        courseAvg = Double.parseDouble(formatedDouble);
        
        return courseAvg;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCourseAvg() {
        return courseAvg;
    }

    public void setCourseAvg(double courseAvg) {
        this.courseAvg = courseAvg;
    }
    
}
