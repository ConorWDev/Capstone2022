/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import DBOperations.ConnectionPool;
import Interface.Users.Faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This DBOperationsFaculty class handles all of the database operations for the
 * faculty members
 * @author massvm
 */
public class DBOperationsFaculty {
    
    //get faculty name from username

    /**
     * gets the name of the faculty member based on their username via db query
     * @param facultyUsername String
     * @return result Boolean
     */
     public String getFacultyName(String facultyUsername){
        String result ="";
        String sql = "select first_name, last_name from ma_faculty where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, facultyUsername);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                result = rs.getString(1) + " " + rs.getString(2);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return result;
    }
     
     //get the faculty email from the facultyUsername

    /**
     * gets the email of the faculty member based on their username via db query
     * @param facultyUsername String
     * @return result Boolean
     */
    public String getFacultyEmail(String facultyUsername){
        String result = "";
        String sql = "select email from ma_faculty where username =?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, facultyUsername);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                result = rs.getString(1);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return result;
    }
    
    /**
     * gets all of the faculty members via db query
     * @return faculty ArrayList
     */
    public ArrayList<Faculty> getAllFaculty(){
        ArrayList<Faculty> faculty = new ArrayList<Faculty>();
        
         String sql = "select username from ma_faculty;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                Faculty facultyMember = new Faculty(rs.getString(1));
                faculty.add(facultyMember);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return faculty;
    }
    
    /**
     * gets the first name of the faculty member via db query
     * @param studentID String
     * @return name String
     */
    public String getFirstname (String studentID){
        String name = "";
        String sql = "select first_name from ma_faculty where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                name = rs.getString(1);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return name;
    }
    
    /**
     * gets the middle name of the faculty member via db query
     * @param studentID String
     * @return name String
     */
    public String getMiddlename (String studentID){
        String name = "";
        String sql = "select middle_name from ma_faculty where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                name = rs.getString(1);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return name;
    }
     
    /**
     * gets the last name of the faculty member via db query
     * @param studentID String
     * @return name String
     */
    public String getLastname (String studentID){
        String name = "";
        String sql = "select last_name from ma_faculty where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                name = rs.getString(1);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return name;
    }
     
    /**
     * gets all of the faculty members based on a particular cohort via db query
     * @param cohortID String
     * @return faculty ArrayList
     */
    public ArrayList<Faculty> getFacultyByCohort (String cohortID){
        ArrayList<Faculty> faculty = new ArrayList<>();
        String sql = "SELECT f.username \n" +
                     "FROM ma_faculty f, ma_cohort_faculty cf \n" +
                     "WHERE f.username = cf.username \n" +
                     "AND cf.cohort_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                Faculty facultyMember = new Faculty(rs.getString(1));
                faculty.add(facultyMember);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return faculty;
        
        
    }
    
}
