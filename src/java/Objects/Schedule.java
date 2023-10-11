/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import DBOperations.DBOperationsGeneral;
import DBOperations.DBOperationsSchedule;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * A Schedule object is the schedule that is related to a particular student. This object
 * holds the schedule for a particular student
 * 
 * @author Administrator
 */
public class Schedule implements Serializable {
    
    DBOperationsSchedule dbOpsSch = new DBOperationsSchedule();
    DBOperationsGeneral dbOpsGen = new DBOperationsGeneral();
    private String scheduleId;
    private String cohortId;
    private String url;

    /**
     * empty constructor
     */
    public Schedule() {
    }

    /**
     * Constructor
     * @param scheduleId
     * @param cohortId
     * @param url
     * @throws SQLException
     */
    public Schedule(String scheduleId, String cohortId, String url) throws SQLException {
        this.scheduleId = scheduleId;
        this.cohortId = cohortId;
        this.url = url;
        
    }
    
    /**
     * Constructor Overloading
     * @param cohortId
     * @param url
     * @throws SQLException
     */
    public Schedule(String cohortId, String url) throws SQLException{
        this.cohortId = cohortId;
        this.url = url;
        
    }

    /**
     * gets the schedule id of the student
     * @return scheduleId String
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     * sets the schedule id of the student
     * @param scheduleId String
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    
    /**
     * gets the cohort id of the student
     * @return cohortId String
     */
    public String getCohortId() {
        return cohortId;
    }

    /**
     * sets the cohort id of the student
     * @param cohortId String
     */
    public void setCohortId(String cohortId) {
        this.cohortId = cohortId;
    }

    /**
     * gets the url of the schedule for the student
     * @return url String
     */
    public String getUrl() {
        return url;
    }

    /**
     * sets the url of the schedule for the student
     * @param url String
     */
    public void setUrl(String url) {
        this.url = url;
    }

}