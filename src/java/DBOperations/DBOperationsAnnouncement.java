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

/**
 *
 * This class handles any DBOperations for cohort and course announcements. 
 */
public class DBOperationsAnnouncement {
    
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
            
//          String announcementId ="";
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
                
            }
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
            return cohortAnnouncements;
    }
    
    
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
    
    
}
        
    
        
