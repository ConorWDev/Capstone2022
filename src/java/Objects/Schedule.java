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

public class Schedule implements Serializable {
    
    DBOperationsSchedule dbOpsSch = new DBOperationsSchedule();
    DBOperationsGeneral dbOpsGen = new DBOperationsGeneral();
    private String scheduleId;
    private String cohortId;
    private String url;

    public Schedule() {
    }

    public Schedule(String scheduleId, String cohortId, String url) throws SQLException {
        this.scheduleId = dbOpsSch.getScheduleId(scheduleId);
        this.cohortId = dbOpsSch.getCohortId(scheduleId);
        this.url = dbOpsSch.getUrl(scheduleId);
        
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    
    public String getCohortId() {
        return cohortId;
    }

    public void setCohortId(String cohortId) {
        this.cohortId = cohortId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}