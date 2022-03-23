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

    public String getAnnouncementID() {
        return announcementID;
    }

    public void setAnnouncementID(String announcementID) {
        this.announcementID = announcementID;
    }
     
        
    public String getcohortId(){
    return cohortId;
    }

    public void setcohortId(String cohortId){
        this.cohortId = cohortId;
    }    
    
    
    public String getStartDate(){
    return startDate;
    }

    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    
    public String getEndDate(){
    return endDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
    
    public String getText(){
    return text;
    }

    public void setText(String text){
        this.text = text;
    }
    
    public boolean getIsVisible(){
        return isVisible;
    }
    
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
}