/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import DBOperations.DBOperationsAnnouncement;
import DBOperations.DBOperationsGeneral;
import java.sql.*;
import java.util.Date;

/**
 *
 * @author massvm
 */
public class Announcement {
    
    DBOperationsAnnouncement dbOpsAnnoun = new DBOperationsAnnouncement();
    DBOperationsGeneral dbOpsGen = new DBOperationsGeneral();
    
    private String announcementID;
    private String cohortId;
    private String text;
    private String startDate;
    private String endDate;
    private boolean isVisible;
    
    /**
     *
     * @param announcementID
     * @param cohortId
     * @param startDate
     * @param endDate
     * @param text
     * @param isVisible
     * @throws SQLException
     */
    public Announcement (String announcementID, String cohortId,String startDate,String endDate,String text,String isVisible) throws SQLException{
        this.announcementID = announcementID;
        this.cohortId = cohortId;
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
    public String getcohortId(){
    return cohortId;
    }

    /**
     *
     * @param cohortId
     */
    public void setcohortId(String cohortId){
        this.cohortId = cohortId;
    }    
    
    /**
     *
     * @return
     */
    public String getStartDate(){
    return startDate;
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    
    /**
     *
     * @return
     */
    public String getEndDate(){
    return endDate;
    }

    /**
     *
     * @param endDate
     */
    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
    
    /**
     *
     * @return
     */
    public String getText(){
    return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text){
        this.text = text;
    }
    
    /**
     *
     * @return
     */
    public boolean getIsVisible(){
        return isVisible;
    }
    
    /**
     *
     * @param isVisible
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
}