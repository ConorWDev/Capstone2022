/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author massvm
 */
public class CourseAnnouncement {
    
    String announcementID;
    String courseID;
    String startDate;
    String endDate;
    String text;
    Boolean isVisible;

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

    public String getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(String announcementID) {
        this.announcementID = announcementID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
    
}
