/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Objects.Schedule;
import java.sql.SQLException;

public class DBOperationsSchedule {

    public ArrayList<Schedule> getSchedules(String scheduleId){
        
        ArrayList<Schedule> schedules = new ArrayList<>();
        String sql = "select * from ma_schedule where schedule_id = ?;";
        
        try {
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, scheduleId);
            ResultSet rs = st.executeQuery();
            
           
            String cohortId;
            String url;
           
            
            while(rs.next()) {
                scheduleId = rs.getString(1);
                cohortId = rs.getString(2);
                url = rs.getString(3);
                
                Schedule schedule = new Schedule(scheduleId, cohortId, url);
                
                schedules.add(schedule);
            }
            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            }
          
        return schedules;
    }    

    
    
    public String getScheduleId (String scheduleId) throws SQLException{
        String result = "";
        String sql = "select schedule_id from ma_schedule where schedule_id=?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, scheduleId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(1);
                    }
                    
                    st.close();
                    rs.close();
                    conn.close();
                    
                } catch(Exception e){}
                
                return result;
    }
    
    public String getCohortId (String scheduleId) throws SQLException{
        String result = "";
        String sql = "select cohort_id from ma_schedule where schedule_id = ?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, scheduleId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(2);
                    }
                    
                    st.close();
                    rs.close();
                    conn.close();
                    
                } catch(Exception e){}
                
                return result;
    }
    
    public String getUrl (String scheduleId) throws SQLException{
        String result = "";
        String sql = "select url from ma_schedule where schedule_id = ?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, scheduleId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(3);
                    }
                    
                    
                    st.close();
                    rs.close();
                    conn.close();
                    
                } catch(Exception e){}
                
                return result;
    }
}