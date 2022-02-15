/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RyanChecora
 * I have created the DBOperationsGeneral class to handle all general database operations. At this point i believe  that we will
 * create other more specific dbOperations within other specific db classes (i.e. grade db operations, announcement db operations)
 * to allow for greater organization.
 * 
 */
public class DBOperationsGeneral {
    
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/massupdated","admin","password");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return conn;
    }
      
    public String getStudentName(String username){
        String result ="";
        String sql = "select first_name, last_name from ma_student where username = ?;";
        
         try{
            Connection conn = getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                result = rs.getString(1) + " " + rs.getString(2);
            }
            
            st.close();
            rs.close();
            conn.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return result;
    }
    
    /*
    *getAssignmentName
    *This method returns an assignment name from a given assignmentID
    */
      public String getAssignmentName(String assignmentID){
        String result ="";
        String sql = "select name from ma_assignment where assignment_id = ?;";
        
         try{
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, assignmentID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                result = rs.getString(1);
            }
            
            st.close();
            rs.close();
            conn.close();
            
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return result;
    }
      
       /*
        getLessonName
        This method obtains the lesson name associated with a given assignment
        */
        public String getLessonName(String assignmentID){
            String lessonName = "";
            String sql = "select l.name from " +
            "ma_assignment a, ma_lesson_assignment la, ma_lesson l " +
            "where a.assignment_id  = la.assignment_id " +
            "and la.lesson_id  = l.lesson_id " +
            "and a.assignment_id = ?;";
            
            try{
                Connection conn = DBOperationsGeneral.getConnection();
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, assignmentID);
                ResultSet rs = st.executeQuery();
                
                while (rs.next()){
                lessonName = rs.getString(1);
                 System.out.println("assignment name query was successful");
                }
                
                st.close();
                rs.close();
                conn.close();
                
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            
            return lessonName;
        }
        
        
    
    
}
