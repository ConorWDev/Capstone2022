/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Announcement;
import Objects.CourseAnnouncement;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * This class handles any DBOperations for cohort and course announcements. 
 */
public class DBOperationsAnnouncement {
    
    /**
     *
     * @param cohortId
     * @return
     */
    public ArrayList<Announcement> getCohortAnnouncements (String cohortId){
        
        ArrayList<Announcement> cohortAnnouncements = new ArrayList<>();
        String sql = "select * from ma_announcement where cohort_id=?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortId);
            ResultSet rs = st.executeQuery();
            
          String announcementId ="";
            String startDate ="";
            String endDate = "";
            String text = "";
            String isVisible = "";
            
            while (rs.next()) {
                announcementId = rs.getString(1);
                startDate = rs.getString(3);
                endDate = rs.getString(4);
                text = rs.getString(5);
                isVisible = rs.getString(6);
                
                Announcement announcement = new Announcement(announcementId, cohortId,startDate,endDate,text,isVisible);
                cohortAnnouncements.add(announcement);
                
            }
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
            return cohortAnnouncements;
    }
    
    /**
     *
     * @param courseId
     * @return
     */
    public ArrayList<CourseAnnouncement> getCourseAnnouncements (String courseId){
        
        ArrayList<CourseAnnouncement> courseAnnouncements = new ArrayList<>();
        String sql = "select * from ma_course_announcement where course_id=?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseId);
            ResultSet rs = st.executeQuery();
            
            String announcementID ="";
            String courseID = "";
            String startDate ="";
            String endDate = "";
            String text = "";
            String isVisible = "";
            
            while (rs.next()) {
                announcementID = rs.getString(1);
                courseID = rs.getString(2);
                startDate = rs.getString(3);
                endDate = rs.getString(4);
                text = rs.getString(5);
                isVisible = rs.getString(6);
                
                CourseAnnouncement announcement = new CourseAnnouncement(announcementID,courseID,startDate,endDate,text,isVisible);
                courseAnnouncements.add(announcement);
                
            }
            st.close();
            rs.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
            return courseAnnouncements;
    }
    
    /*
    In this method we are creating a course announcement. To do this we are currently feeding in the course ID and text entered by the user.
    Right now we are inserting dummy data into the start/end time columns. The db has been updated to auto increment the primary key. The pk is
    changed to an int to achieve this
    */

    /**
     *
     * @param courseID
     * @param text
     * @return
     */

    public boolean createCourseAnnouncement(String courseID, String text){
        boolean result = false;
        //currently insert dummy values for start/end date
        String sql = "insert into ma_course_announcement (course_id,start_time,end_time,text) values (?,?,?,?);";
       
        ConnectionPool cp = ConnectionPool.getInstance();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = LocalDate.now().format(formatter);
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseID);
            st.setString(2, date);
            st.setString(3, date);
            st.setString(4, text);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
            return result;
    }
        
    //obtain a particular courseannouncment from a given courseannouncementID. This is done to save the
    //course announcement to the session scope when faculty is editing a course announcement

    /**
     *
     * @param courseAnnouncementID
     * @return
     */
    public CourseAnnouncement getCourseAnnouncement (String courseAnnouncementID){
        CourseAnnouncement announcement = null;
        String sql = "select * from ma_course_announcement where annnouncement_id = ?;";
        
        
         ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseAnnouncementID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                String announcementID = rs.getString(1);
                String cohort_id = rs.getString(2);
                String start_time = rs.getString(3);
                String end_time = rs.getString(4);
                String text = rs.getString(5);
                String isVisible = rs.getString(6);
                
                announcement = new CourseAnnouncement(announcementID,cohort_id,start_time,end_time,text,isVisible);
            }
            
           
            rs.close();
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}    
        
        return announcement;
    }
    
    //method used when editing courseAnnouncements. Input courseAnnouncementID and new text that will replace it

    /**
     *
     * @param courseAnnouncementID
     * @param newText
     * @return
     */
    public boolean editCourseAnnouncement (String courseAnnouncementID, String newText){
        boolean result = false;
        String sql = "update ma_course_announcement set text = ? where annnouncement_id = ?;";
         ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, newText);
            st.setString(2, courseAnnouncementID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
            
        return result;
    }
    
    //method used when deleting courseAnnouncements

    /**
     *
     * @param courseAnnouncementID
     * @return
     */
    public boolean deleteCourseAnnouncement (String courseAnnouncementID) {
        boolean result = false;
        String sql = "delete from ma_course_announcement where annnouncement_id = ?";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseAnnouncementID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);          
        } catch(Exception e){}
            return result;
    }
    
    /**
     *
     * @param cohortID
     * @param text
     * @return
     */
    public boolean createCohortAnnouncement(String cohortID, String text){
        boolean result = false;
        //currently insert dummy values for start/end date
        String sql = "insert into ma_announcement (cohort_id,start_time,end_time,text) values (?,?,?,?);";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = LocalDate.now().format(formatter);
       
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            st.setString(2, date);
            st.setString(3, date);
            st.setString(4, text);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
            return result;
    }
     
    /**
     *
     * @param announcementID
     * @return
     */
    public Announcement getCohortAnnouncement (String announcementID){
        Announcement announcement = null;
        String sql = "select * from ma_announcement where announcement_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, announcementID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                
                String cohort_id = rs.getString(2);
                String start_time = rs.getString(3);
                String end_time = rs.getString(4);
                String text = rs.getString(5);
                String isVisible = rs.getString(6);
                
                announcement = new Announcement(announcementID,cohort_id,start_time,end_time,text,isVisible);
            }
            
            rs.close();
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}    
        
        
        return announcement;
    }
    
    //method used when editing courseAnnouncements. Input courseAnnouncementID and new text that will replace it

    /**
     *
     * @param cohortAnnouncementID
     * @param newText
     * @return
     */
    public boolean editCohortAnnouncement (String cohortAnnouncementID, String newText){
        boolean result = false;
        String sql = "update ma_announcement set text = ? where announcement_id = ?;";
         ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, newText);
            st.setString(2, cohortAnnouncementID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
            
        return result;
    }
    
    //method used when deleting cohortAnnouncements. Input courseAnnouncementID and new text that will be deletec

    /**
     *
     * @param cohortAnnouncementID
     * @return
     */
    public boolean deleteCohortAnnouncement (String cohortAnnouncementID){
        boolean result = false;
        String sql = "DELETE from ma_announcement where announcement_id = ?;";
         ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortAnnouncementID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
            
        return result;
    }
    
    /**
     *
     * @param cohortID
     * @return
     */
    public ArrayList<Announcement> getAnnouncementsByCohort(String cohortID){
       ArrayList<Announcement> announcements = new ArrayList<>();
       String sql = "select * from ma_announcement where cohort_id = ?;";
         ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            ResultSet rs = st.executeQuery();
            
            String announcementId ="";
            String cohortId = "";
            String startDate ="";
            String endDate = "";
            String text = "";
            String isVisible = "";
            
            while (rs.next()) {
                announcementId = rs.getString(1);
                cohortId = rs.getString(2);
                startDate = rs.getString(3);
                endDate = rs.getString(4);
                text = rs.getString(5);
                isVisible = rs.getString(6);
                
                Announcement announcement = new Announcement(announcementId, cohortId,startDate,endDate,text,isVisible);
                announcements.add(announcement);
                
            }
            st.close();
            rs.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        return announcements;
   } 
   
    
    
}
        
    
        
