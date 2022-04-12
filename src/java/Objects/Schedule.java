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
     *
     */
    public Schedule() {
    }

    /**
     *
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
     *
     * @param cohortId
     * @param url
     * @throws SQLException
     */
    public Schedule(String cohortId, String url) throws SQLException{
        this.cohortId = cohortId;
        this.url = url;
        
    }

    /**
     *
     * @return
     */
    public String getScheduleId() {
        return scheduleId;
    }

    /**
     *
     * @param scheduleId
     */
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    
    /**
     *
     * @return
     */
    public String getCohortId() {
        return cohortId;
    }

    /**
     *
     * @param cohortId
     */
    public void setCohortId(String cohortId) {
        this.cohortId = cohortId;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}