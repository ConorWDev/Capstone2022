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
 * This Announcement object holds all the information of the announcement for a 
 * particular cohort
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
     * Constructor
     * @param announcementID String
     * @param cohortId String
     * @param startDate String
     * @param endDate String
     * @param text String
     * @param isVisible String
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
     * gets the id of the announcement for a particular cohort
     * @return announcementID String
     */
    public String getAnnouncementID() {
        return announcementID;
    }

    /**
     * sets the id of the announcement for a particular cohort
     * @param announcementID String
     */
    public void setAnnouncementID(String announcementID) {
        this.announcementID = announcementID;
    }
        
    /**
     * gets the id of a particular cohort
     * @return cohortId String
     */
    public String getcohortId(){
    return cohortId;
    }

    /**
     * sets the id of a particular cohort
     * @param cohortId String
     */
    public void setcohortId(String cohortId){
        this.cohortId = cohortId;
    }    
    
    /**
     * gets the start date of the announcement for a particular cohort
     * @return startDate String
     */
    public String getStartDate(){
    return startDate;
    }

    /**
     * sets the start date of the announcement for a particular cohort
     * @param startDate String
     */
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    
    /**
     * gets the end date of the announcement for a particular cohort
     * @return endDate String
     */
    public String getEndDate(){
    return endDate;
    }

    /**
     * sets the end date of the announcement for a particular cohort
     * @param endDate String
     */
    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
    
    /**
     * gets the text of the announcement for a particular cohort
     * @return text String
     */
    public String getText(){
    return text;
    }

    /**
     * sets the text of the announcement for a particular cohort
     * @param text String
     */
    public void setText(String text){
        this.text = text;
    }
    
    /**
     * checks and gets whether the announcement is visible for a particular cohort
     * @return isVisible Boolean
     */
    public boolean getIsVisible(){
        return isVisible;
    }
    
    /**
     * checks and sets whether the announcement is visible for a particular cohort
     * @param isVisible Boolean
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
}