/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * The course class will hold the course_id, course name, and course description
 * This is useful for pulling information about a particular course and displaying it
 * on the screen.
 * @author Ryan Checora
 * 
 */
public class Course {
    
    private String courseID = "";
    private String courseName = "";
    private String courseDescription = "";
    
    /**
     * Constructor
     * @param courseID String
     * @param courseName String
     * @param courseDescription String
     * 
     */
    public Course (String courseID, String courseName, String courseDescription){
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }
    
    /**
     * gets the id of the particular course
     * @return courseID String
     */
    public String getCourseID() {
        return courseID;
    }
    
    /**
     * sets the id of the particular course
     * @param courseID String
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    
    /**
     * gets the name of the particular course
     * @return announcementID String
     */
    public String getCourseName() {
        return courseName;
    }
    
    /**
     * sets the name of the particular course
     * @param courseName String
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    /**
     * gets the description of the particular course
     * @return courseDescription String
     */
    public String getCourseDescription() {
        return courseDescription;
    }
    
    /**
     * sets the description of the particular course
     * @param courseDescription String
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
}
