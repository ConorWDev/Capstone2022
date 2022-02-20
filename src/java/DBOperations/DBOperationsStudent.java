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
import java.util.ArrayList;

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
    
     //get the cohortList from the studentUsername. A student may be within one or more cohort
    //in their time at the school. As such we want an array of cohort data to represent this.
    //The method will return an arraylist of strings that are representative of a particular cohort code.
    public ArrayList<String> getCohortList(String studentUsername){
       
        ArrayList<String> cohortCodes = new ArrayList<>();
        String sql = "select sc.cohort_id from ma_student_cohort sc, ma_student s "
                    + "where s.username = sc.username"
                    + "and s.username = ?";
         try{
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentUsername);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String cohortCode = rs.getString(1);
                cohortCodes.add(cohortCode);
            }
            
            st.close();
            rs.close();
            conn.close();
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return cohortCodes;
    }
}
