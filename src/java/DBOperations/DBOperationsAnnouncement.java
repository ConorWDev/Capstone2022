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
 * This class handles any DBOperations for announcements. 
 */
public class DBOperationsAnnouncement {
    
    public ArrayList<Announcement> getCohortAnnouncements (String cohortId){
        
        ArrayList<Announcement> cohortAnnouncements = new ArrayList<>();
        String sql = "select * from ma_announcement where cohort_id=?;";
        
        try {
            Connection conn = DBOperationsGeneral.getConnection();
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
            conn.close();
        } catch(Exception e){}
            return cohortAnnouncements;
    }
}
        
    
        
