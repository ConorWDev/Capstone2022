/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Announcement;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author massvm
 */
public class DBOperationsAnnouncement {

    
    public ArrayList<Announcement> getAnnouncements(String announcementId){
        
        ArrayList<Announcement> announcements = new ArrayList<>();
        String sql = "select * from ma_announcement where announcement_id=?;";
        
        try {
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, announcementId);
            ResultSet rs = st.executeQuery();
            
           
            String cohortId = "";
            String startDate = "";
            String endDate = "";
            String isVisible = "";
            String text = "";
            
            while(rs.next()) {
                announcementId = rs.getString(1);
                cohortId = rs.getString(2);
                startDate = rs.getString(3);
                endDate = rs.getString(4);
                text = rs.getString(5);
                isVisible = rs.getString(6);
                
                Announcement announcement = new Announcement(announcementId,cohortId,startDate,endDate,text,isVisible);
                
                announcements.add(announcement);
            }
            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            }
          
        return announcements;
    }    
    
        public ArrayList<Announcement> getCohortAnnouncements (String announcementId, String cohortId) throws SQLException {
        ArrayList<Announcement> cohortAnnouncements = new ArrayList<>();
        
//      String result = "";
        String sql = "select a.text, a.is_visible from ma_announcement a, ma_cohort c where a.cohort_id = c.cohort_id;";
        
        try {
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, announcementId);
            st.setString(2, cohortId);
            ResultSet rs = st.executeQuery(sql);
            
            String startDate ="";
            String endDate = "";
            String text = "";
            String isVisible = "";
            
            while (rs.next()) {
                startDate = rs.getString(2);
                endDate = rs.getString(3);
                text = rs.getString(5);
                isVisible = rs.getString(6);
                
                Announcement announcement = new Announcement(announcementId,cohortId,startDate,endDate,text,isVisible);
                cohortAnnouncements.add(announcement);
            }
            st.close();
            rs.close();
            conn.close();
        } catch(Exception e){}
            return cohortAnnouncements;
    } 
    
    
    public ArrayList<Announcement> getCohortAnnouncements (String cohortId)  {
        ArrayList<Announcement> cohortAnnouncements = new ArrayList<>();
        
//      String result = "";
        String sql = "select * from ma_announcement where cohort_id=?;";
        
        try {
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortId);
//            st.setString(2, cohortId);
            ResultSet rs = st.executeQuery();
            
//            String announcementId ="";
            String startDate ="";
            String endDate = "";
            String text = "";
            String isVisible = "";
            
            while (rs.next()) {
                startDate = rs.getString(3);
                endDate = rs.getString(4);
                text = rs.getString(5);
                isVisible = rs.getString(6);
                
                Announcement announcement = new Announcement(cohortId,startDate,endDate,text,isVisible);
                cohortAnnouncements.add(announcement);
                
                System.out.print("Succeed");
                
            }
            
            System.out.print("Outside");
            st.close();
            rs.close();
            conn.close();
        } catch(Exception e){}
            return cohortAnnouncements;
    }   
    
    public String getAnnouncementId (String announcementId) throws SQLException{
        String result = "";
        String sql = "select announcement_id from ma_announcement where cohort_id=?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, announcementId);
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
    
    public String getCohortId (String announcementId) throws SQLException{
        String result = "";
        String sql = "select cohort_id from ma_announcement where announcement_id = ?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, announcementId);
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
    
    public String getStartDate (String announcementId) throws SQLException{
        String result = "";
        String sql = "select start_date from ma_announcement where announcement_id = ?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, announcementId);
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
    
    public String getEndDate (String announcementId) throws SQLException{
        String result = "";
        String sql = "select start_date from ma_announcement where announcement_id = ?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, announcementId);
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
    
        public String getText (String announcementId) throws SQLException{
        String result = "";
        String sql = "select text from ma_announcement where announcement_id = ?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, announcementId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(5);
                    }
                    
                    st.close();
                    rs.close();
                    conn.close();
                    
                } catch(Exception e){}
                return result;           
    }
    
}
        
    
        
