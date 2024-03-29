/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The DBOperationsLogin class is used to query the database in order to find the user-type of a given
 * user who is attempting to login. The following methods isStudent, isFaculty, and isAdmin will attempt to find a matching username
 * and password within their respective DB tables and return a boolean. 
 * 
 * A possible error to look into is that, in the rare case that a matching username and password is found within MORE THAN ONE of the
 * database tables (ex, a faculty and admin have the same username and password) then some unexpected behavior will occur as a result of
 * the logic layed out within LogonCon.java. This will be looked into further in the future --written Feb.19
 * @author Ryan Checora
 */
public class DBOperationsLogin {
    
    
    /*
    isStudent
    This method takes the username and password input by the user and queries the ma_student table
    for a matching result. If there is a match found, the SQL statement will return a string "1".
    */

    /**
     * Enter username and password. If the the username and password exists within
     * the ma_student table, a Boolean true is returned
     * @param webUsername
     * @param webPassword
     * @return isStudent Boolean
     */

    public boolean isStudent(String webUsername,String webPassword) {
        
        Boolean isStudent = false;
        String result = "";
            String sql = "SELECT COUNT(username) FROM ma_student WHERE username = ? AND password = ? ;";
            ConnectionPool cp = ConnectionPool.getInstance();

            try {
                //Connection conn = DBOperationsGeneral.getConnection();
                Connection conn = cp.getConnection();
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, webUsername);
                st.setString(2, webPassword);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    result = rs.getString(1);
                }
                
                rs.close();
                st.close();
                cp.freeConnection(conn);
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            if (result.equals("1")){
                isStudent = true;
            }
            return isStudent;     
    }
    
    /**
     *Enter username and password. If the the username and password exists within
     * the ma_faculty table, a Boolean true is returned
     * @param webUsername
     * @param webPassword
     * @return isFaculty Boolean
     */
    public boolean isFaculty(String webUsername,String webPassword) {
        
      
        Boolean isFaculty = false;
        String result = "";
            String sql = "SELECT COUNT(username) FROM ma_faculty WHERE username = ? AND password = ? ;";
            ConnectionPool cp = ConnectionPool.getInstance();

            try {
                //Connection conn = DBOperationsGeneral.getConnection();
                Connection conn = cp.getConnection();
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, webUsername);
                st.setString(2, webPassword);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    result = rs.getString(1);
                }
                
                rs.close();
                st.close();
                cp.freeConnection(conn);
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            if (result.equals("1")){
                isFaculty = true;
            }
            return isFaculty; 
         
    }
    
    /**
     *Enter username and password. If the the username and password exists within
     * the ma_admin table, a Boolean true is returned
     * @param webUsername
     * @param webPassword
     * @return isAdmin Boolean
     */
    public boolean isAdmin(String webUsername,String webPassword) {
         
       
        Boolean isAdmin = false;
        String result = "";
            String sql = "SELECT COUNT(username) FROM ma_admin WHERE username = ? AND password = ? ;";
            ConnectionPool cp = ConnectionPool.getInstance();

            try {
                //Connection conn = DBOperationsGeneral.getConnection();
                Connection conn = cp.getConnection();
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, webUsername);
                st.setString(2, webPassword);
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    result = rs.getString(1);
                }
                
                rs.close();
                st.close();
                cp.freeConnection(conn);
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            if (result.equals("1")){
                isAdmin = true;
            }
            return isAdmin; 
    }
    
}
