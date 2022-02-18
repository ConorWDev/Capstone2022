/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Ryan Checora
 * The course class will hold the course_id, course name, and course description
 * This is useful for pulling information about a particular course and displaying it
 * on the screen.
 */
public class Course {
    
    private String courseID = "";
    private String courseName = "";
    private String courseDescription = "";
    
    public Course (String courseID, String courseName, String courseDescription){
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
}
