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
 *
 * @author Ryan Checora. This class contains methods that are specific to obtaining student information
 */
public class DBOperationsStudent {
    
    //get the student name from the studentUsername
   
    public String getStudentName(String studentUsername){
        String result ="";
        String sql = "select first_name, last_name from ma_student where username = ?;";
        
         try{
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentUsername);
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
    
    
    //get the student email from the studentUsername
    public String getStudentEmail(String studentUsername){
        String result = "";
        String sql = "select email from ma_student where username =?;";
        
        
         try{
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentUsername);
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
}
