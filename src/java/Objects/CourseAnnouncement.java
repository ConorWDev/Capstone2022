/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * This CourseAnnouncement object holds the announcements for a particular course
 * @author massvm
 */
public class CourseAnnouncement {
    
    String announcementID;
    String courseID;
    String startDate;
    String endDate;
    String text;
    Boolean isVisible;

    /**
     * Constructor
     * @param announcementID String
     * @param courseID String
     * @param startDate String
     * @param endDate String
     * @param text String
     * @param isVisible String
     */
    public CourseAnnouncement(String announcementID, String courseID, String startDate, String endDate, String text, String isVisible) {
        this.announcementID = announcementID;
        this.courseID = courseID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.text = text;
        
         if (isVisible.equalsIgnoreCase("Y")) {
            this.isVisible = true;
        } else {
            this.isVisible = false;
        }
    }

    /**
     * gets the id of the announcement
     * @return announcementID String
     */
    public String getAnnouncementID() {
        return announcementID;
    }

    /**
     * sets the id of the announcement
     * @param announcementID String
     */
    public void setAnnouncementID(String announcementID) {
        this.announcementID = announcementID;
    }

    /**
     * gets the id of the course
     * @return courseID String
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     * sets the id of the course
     * @param courseID String
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     * gets the start date of the announcement
     * @return startDate String
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * sets the start date of the announcement
     * @param startDate String
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * gets the end date of the announcement
     * @return endDate String
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * sets the end date of the announcement
     * @param endDate String
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * gets the text of the announcement
     * @return text String
     */
    public String getText() {
        return text;
    }

    /**
     * sets the text of the announcement
     * @param text String
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * checks and gets whether the announcement is visible or not
     * @return isVisible Boolean
     */
    public Boolean getIsVisible() {
        return isVisible;
    }

    /**
     * checks and sets whether the announcement is visible or not
     * @param isVisible Boolean
     */
    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
    
}
