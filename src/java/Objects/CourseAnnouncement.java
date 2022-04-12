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

    /**
     *
     * @param announcementID
     * @param courseID
     * @param startDate
     * @param endDate
     * @param text
     * @param isVisible
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
     *
     * @return
     */
    public String getAnnouncementID() {
        return announcementID;
    }

    /**
     *
     * @param announcementID
     */
    public void setAnnouncementID(String announcementID) {
        this.announcementID = announcementID;
    }

    /**
     *
     * @return
     */
    public String getCourseID() {
        return courseID;
    }

    /**
     *
     * @param courseID
     */
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    /**
     *
     * @return
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public Boolean getIsVisible() {
        return isVisible;
    }

    /**
     *
     * @param isVisible
     */
    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
    
}
