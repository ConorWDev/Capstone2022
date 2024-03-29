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

/**
 * This class handles database operations involving schedule objects
 * @author Administrator
 */
public class DBOperationsSchedule {

    /**
     *Enter a scheduleID and get an arrayList of schedules with the matching ID
     * @param scheduleId
     * @return schedules ArrayList
     */
    public ArrayList<Schedule> getSchedules(String scheduleId){
        
        ArrayList<Schedule> schedules = new ArrayList<>();
        String sql = "select * from ma_schedule where schedule_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
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
            //conn.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
          
        return schedules;
    }    

    /**
     *Enter a scheduleId and return a scheduleID
     * @param scheduleId
     * @return result String
     * @throws SQLException
     */
    public String getScheduleId (String scheduleId) throws SQLException{
        String result = "";
        String sql = "select schedule_id from ma_schedule where cohort_id=?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
                try{
                    Connection conn = cp.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, scheduleId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(1);
                    }
                    
                    st.close();
                    rs.close();
                    cp.freeConnection(conn);
                    
                } catch(Exception e){}
                
                return result;
    }
    
    /**
     *Enter a scheduleID and return a corresponding cohortID
     * @param scheduleId
     * @return result String
     * @throws SQLException
     */
    public String getCohortId (String scheduleId) throws SQLException{
        String result = "";
        String sql = "select cohort_id from ma_schedule where schedule_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
                try{
                    //Connection conn = DBOperationsGeneral.getConnection();
                    Connection conn = cp.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, scheduleId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(2);
                    }
                    
                    st.close();
                    rs.close();
                    //conn.close();
                    cp.freeConnection(conn);
                } catch(Exception e){}
                
                return result;
    }
    
    /**
     **Enter a scheduleID and return a corresponding url
     * @param scheduleID
     * @return url String
     */

     public String getUrl (String scheduleID){
          String url = "";
          String sql = "select url from ma_schedule where schedule_id = ?;";
          ConnectionPool cp = ConnectionPool.getInstance();
          try{
             
             Connection conn = cp.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             st.setString(1,scheduleID);
             ResultSet rs = st.executeQuery();
             
             while (rs.next()){
                 url = rs.getString(1);
             }
             
             st.close();
             rs.close();
             cp.freeConnection(conn);
          }
          catch(SQLException ex){
              ex.printStackTrace();
          }
          
          
          return url;
      }
      
    /**
     * Enter a cohortID and url. This adds a new schedule record to
     * the database
     * @param cohortID
     * @param url
     * @return result boolean
     */
    public boolean addSchedule (String cohortID, String url){
        boolean result = false;
        String sql = "insert into ma_schedule (cohort_id, url) values (?,?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, cohortID);
            st.setString(2, url);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        return result;
    }

    /**
     *
     * Enter a schedule ID. Delete from the database wherever
     * this ID is present
     * @param ID
     * @return result boolean
     */
    public boolean deleteSchedule(String ID) {
        boolean result = false;
        String sql = "delete from ma_schedule where cohort_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, ID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        return result;
    }

    /**
     *
     * Enter a cohortID return a corresponding Schedule object
     * @param cohortID
     * @return schedule Schedule
     */
    public Schedule getSchedule(String cohortID) {
        Schedule schedule = null;
        String sql = "select * from ma_schedule where cohort_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
       try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                String scheduleId = rs.getString(1);
                String cohortId = rs.getString(2);
                String url = rs.getString(3);
                
                schedule = new Schedule(scheduleId, cohortId, url);
                
                
            }
            st.close();
            rs.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
        return schedule;
    }
}
