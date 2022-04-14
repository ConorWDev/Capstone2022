/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Cohort;
import DBOperations.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This DBOperationsCohort class handles all of the database operations for 
 * cohorts aspect of the application
 * @author massvm
 */
public class DBOperationsCohort {
    
    /*
    obtain the cohorts that are associated with a particular faculty member. As a faculty member
    can teach more than one cohort, return an arraylist of cohort objects
    */

    /**
     * gets all of the cohort based on a particular faculty member (username) via
     * database query
     * @param facultyUsername String
     * @return cohorts ArrayList
     */

    
    public ArrayList<Cohort> getCohorts(String facultyUsername){
        ArrayList<Cohort> cohorts = new ArrayList<>();
        String sql = "SELECT c.cohort_id, c.name\n" +
                     "FROM ma_cohort c, ma_cohort_faculty cf, ma_faculty f\n" +
                     "WHERE f.username = cf.username\n" +
                     "AND cf.cohort_id = c.cohort_id\n" +
                     "AND f.username =?;";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, facultyUsername);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String cohortID = rs.getString(1);
                String cohortName = rs.getString(2);
                
                Cohort cohort = new Cohort(cohortID,cohortName);
                cohorts.add(cohort);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return cohorts;
    }
    
    /**
     * gets the particular cohort object based on its id via database query
     * @param cohortID String
     * @return cohort Cohort
     */
    public Cohort getCohort (String cohortID){
        Cohort cohort = null;
        String sql= "select * from ma_cohort where cohort_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                cohort = new Cohort(rs.getString(1),rs.getString(2));
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return cohort;
    }
    
    /**
     * Method to create/add a particular cohort to database via
     * query
     * @param cohortName String
     * @return result Boolean
     */
    public boolean createCohort (String cohortName){
        boolean result = false;
        String sql = "insert into ma_cohort (name) values (?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortName);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
         
         return result;
    }
    
    /**
     * gets all of the cohorts from the database via query
     * @return cohorts ArrayList
     */
    public ArrayList<Cohort> getAllCohorts (){
        ArrayList<Cohort> cohorts = new ArrayList<>();
        String sql = "select * from ma_cohort;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String cohortID = rs.getString(1);
                String cohortName = rs.getString(2);
                
                Cohort cohort = new Cohort(cohortID,cohortName);
                cohorts.add(cohort);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         return cohorts;
    }
    
    /**
     * Method for deleting/ clearing the bridge between cohorts and courses via
     * database query
     * @param cohortID String
     * @return result Boolean
     */
    public boolean clearCohortCourseBridge (String cohortID){
        boolean result = false;
        String sql = "delete from ma_cohort_course where cohort_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
         
         return result;
    }
    
    /**
     * Method for bridging/connecting the cohorts with their corresponding courses
     * via database query
     * @param cohortID String
     * @param courseID String
     * @return result Boolean
     */
    public boolean bridgeCohortCourse (String cohortID, String courseID){
        boolean result = false;
        String sql = "insert into ma_cohort_course values (?,?);";
         ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            st.setString(2, courseID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
         
         return result;
    }
    
    /**
     * Method for deleting/clearing the bridge between cohorts and faculty via
     * database query
     * @param cohortID String
     * @return result Boolean
     */
    public boolean clearCohortFacultyBridge (String cohortID){
        boolean result = false;
        String sql = "delete from ma_cohort_faculty where cohort_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
         
         return result;
    }
     
    /**
     * Method for creating/adding a bridge between cohort and faculty via
     * database query
     * @param cohortID String
     * @param facultyID String
     * @return result Boolean
     */
    public boolean bridgeCohortFaculty (String cohortID, String facultyID){
        boolean result = false;
        String sql = "insert into ma_cohort_faculty values (?,?);";
         ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            st.setString(2, facultyID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
         
         return result;
    }
      
    /**
     * Method for deleting/clearing the bridge between cohorts and student via
     * database query
     * @param cohortID String
     * @return result Boolean
     */
    public boolean clearCohortStudentBridge (String cohortID){
        boolean result = false;
        String sql = "delete from ma_student_cohort where cohort_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
         
         return result;
    }
      
    /**
     * Method for creating/adding a bridge between cohort and students via
     * database query
     * @param cohortID String
     * @param studentID String
     * @return result Boolean
     */
    public boolean bridgeCohortStudents (String cohortID, String studentID){
        boolean result = false;
        String sql = "insert into ma_student_cohort values (?,?);";
         ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            st.setString(2, studentID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
         
         return result;
    }
       
    /**
     * Method for deleting a particular cohort based on its id via db query
     * @param cohortID String
     * @return result Boolean
     */
    public boolean deleteCohortByID (String cohortID){
           
           deleteBridges(cohortID);
           
           boolean result = false;
           String sql = "delete from ma_cohort where cohort_id = ?;";
           ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }

       
           return result;
       }
       
    /**
     * Method for deleting/clearing all of the bridges between cohort and courses,
     * cohorts and faculty, student and cohort, announcement, schedule via db queries
     * @param cohortID String
     * @return result Boolean
     */
    public boolean deleteBridges (String cohortID){
           boolean result = false;
           String sql = "delete from ma_cohort_course where cohort_id = ?;";
           String sql2 = "delete from ma_cohort_faculty where cohort_id = ?;";
           String sql3 = "delete from ma_student_cohort where cohort_id = ?;";
           String sql4 = "delete from ma_announcement where cohort_id = ?;";
           String sql5 = "delete from ma_schedule where cohort_id = ?;";
           
           ConnectionPool cp = ConnectionPool.getInstance();
           
            try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            PreparedStatement st2 = conn.prepareStatement(sql2);
            PreparedStatement st3 = conn.prepareStatement(sql3);
            PreparedStatement st4 = conn.prepareStatement(sql4);
            PreparedStatement st5 = conn.prepareStatement(sql5);
            
            st.setString(1, cohortID);
            st2.setString(1, cohortID);
            st3.setString(1, cohortID);
            st4.setString(1, cohortID);
            st5.setString(1, cohortID);
            
            int rowsAffected = st.executeUpdate();
            rowsAffected = st2.executeUpdate();
            rowsAffected = st3.executeUpdate();
            rowsAffected = st4.executeUpdate();
            rowsAffected = st5.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            st2.close();
            st3.close();
            st4.close();
            st5.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
         
         return result;
           
       }
       
    
}
