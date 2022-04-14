/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Assignment;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This DBOperationsAssignments class handles all database operations for the 
 * assignments aspect of the application
 * 
 * @author massvm
 */
public class DBOperationsAssignments {
    
    //return all assignments for a given course

    /**
     * gets all of the assignments for a particular course via
     * database query
     * @param courseID String
     * @return assignments ArrayList
     */
    public ArrayList<Assignment> getCourseAssignments(String courseID){
        
        ArrayList<Assignment> assignments = new ArrayList<>();
        String sql = "select a.assignment_id, a.name, a.description, a.url, a.weight  \n" +
                     "from ma_assignment a, ma_lesson_assignment la, ma_lesson l, ma_course_lesson cl, ma_course c  where\n" +
                     "a.assignment_id = la.assignment_id \n" +
                     "and la.lesson_id = l.lesson_id \n" +
                     "and l.lesson_id = cl.lesson_id \n" +
                     "and cl.course_id = c.course_id \n" +
                     "and c.course_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
       
        
        try {
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseID);
            ResultSet rs = st.executeQuery();
            
            String assignmentUrl;
            double assignmentWeight;
            String assignmentName;
            String assignmentDescription;
            String assignmentId;
            
            while(rs.next()) {
                assignmentId = rs.getString(1);
                assignmentName = rs.getString(2);
                assignmentDescription = rs.getString(3);
                assignmentUrl = rs.getString(4);
                assignmentWeight = rs.getDouble(5);
                
                Assignment assignment = new Assignment(assignmentId, assignmentName, assignmentDescription, assignmentUrl, assignmentWeight);
                
                assignments.add(assignment);
            }
            st.close();
            rs.close();
            //con.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
          
        return assignments;
    }
    
    /**
     * gets all of the assignments for a particular module via
     * database query
     * @param moduleID String
     * @return assignments ArrayList
     */
    public ArrayList<Assignment> getModuleAssignments(String moduleID){
        
        ArrayList<Assignment> assignments = new ArrayList<>();
        String sql = "select a.assignment_id, a.name, a.description, a.url, a.weight\n" +
                     "from ma_assignment a, ma_lesson_assignment la, ma_lesson l\n" +
                     "where a.assignment_id  = la.assignment_id \n" +
                     "and la.lesson_id = l.lesson_id \n" +
                     "and l.lesson_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
       
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, moduleID);
            ResultSet rs = st.executeQuery();
            
            String assignmentUrl;
            double assignmentWeight;
            String assignmentName;
            String assignmentDescription;
            String assignmentId;
            
            while(rs.next()) {
                assignmentId = rs.getString(1);
                assignmentName = rs.getString(2);
                assignmentDescription = rs.getString(3);
                assignmentUrl = rs.getString(4);
                assignmentWeight = rs.getDouble(5);
                
                Assignment assignment = new Assignment(assignmentId, assignmentName, assignmentDescription, assignmentUrl, assignmentWeight);
                
                assignments.add(assignment);
            }
            st.close();
            rs.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
          
        return assignments;
    }

    //Submit a new assignment Obj
    //Author: Altamish Lalani

    /**
     * Method that allows for the submission of a particular assignment via
     * database query
     * @param inbound_assignment Assignment
     * @return result String
     */
     public String submitAssignment(Assignment inbound_assignment){
       
        String result = "URL failed - Please check your link and try again.";
        boolean urlCheck = false;
        URL myUrl;
        
        //add functionality to leave out URL. In the case that an assignment does not have any doc attached
        boolean noUrl = false;
        if (inbound_assignment.getassignmentUrl() == null || inbound_assignment.getassignmentUrl().equals("")){
            noUrl = true;
        }
        
        
        try {
            myUrl = new URL(inbound_assignment.getassignmentUrl());
            urlCheck = isSiteUp(myUrl);
          } catch (MalformedURLException ex) {
           Logger.getLogger(DBOperationsAssignments.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
         
        //Weight Error Check.
        if(inbound_assignment.getassignmentWeight()< 0){
            result = "Error, assingment must not have a weight that is less than 0.";
            return result;
        }
        
        //Check if Assignment URL works
        if(urlCheck ||noUrl){
        /* If the case above passes, persist object into tables as needed.
           Else false result
        */
        
        String assignmentName = inbound_assignment.getassignmentName();
        String assignmentDescription = inbound_assignment.getassignmentDescription();
        String assignmentUrl = inbound_assignment.getassignmentUrl();
        double assignmentWeight = inbound_assignment.getassignmentWeight();
                   
        String sql="INSERT  into ma_assignment (name, description, url, weight)  VALUES (?,?,?,?);";
               
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, assignmentName);
            st.setString(2, assignmentDescription);
            st.setString(3, assignmentUrl);
            st.setDouble(4, assignmentWeight);
            st.executeUpdate();
            //ResultSet rs = st.executeQuery();
            //System.out.println(rs);
          
            result = "Successful entry.";
            st.close();
            //rs.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
            
        }

        return result;
    }
    //Update an updated assignment Obj
    //Author: Altamish Lalani

    /**
     * Method that allows for the editing/updating a particular assignment via
     * database query
     * @param inboundUpdated_assignment Assignment
     * @return result String
     */
    public String editAssignment(Assignment inboundUpdated_assignment){
        String result = "URL failed - Please check your link and try again.";
        boolean urlCheck = false;
        URL myUrl;
        
        //add functionality to leave out URL. In the case that an assignment does not have any doc attached
        boolean noUrl = false;
        if (inboundUpdated_assignment.getassignmentUrl() == null || inboundUpdated_assignment.getassignmentUrl().equals("")){
            noUrl = true;
        }
        
        
        try {
            myUrl = new URL(inboundUpdated_assignment.getassignmentUrl());
            urlCheck = isSiteUp(myUrl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DBOperationsAssignments.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        //Weight Error Check.
        if(inboundUpdated_assignment.getassignmentWeight()< 0){
            result = "Error, assingment must not have a weight that is less than 0.";
            return result;
        }
        
        //Check if Assignment URL works
        if(urlCheck || noUrl){
        /* If the case above passes, persist object into tables as needed.
           Else false result
        */
        String assignmentID = inboundUpdated_assignment.getassignmentId();
        String assignmentName = inboundUpdated_assignment.getassignmentName();
        String assignmentDescription = inboundUpdated_assignment.getassignmentDescription();
        String assignmentUrl = inboundUpdated_assignment.getassignmentUrl();
        double assignmentWeight = inboundUpdated_assignment.getassignmentWeight();
                   
        String sql="UPDATE ma_assignment  SET name = ?, description = ?, url = ?, weight = ? WHERE assignment_id  = ?;";
               
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, assignmentName);
            st.setString(2, assignmentDescription);
            st.setString(3, assignmentUrl);
            st.setDouble(4, assignmentWeight);
            st.setString(5, assignmentID);
            
            st.executeUpdate();
            //ResultSet rs = st.executeQuery();
           // System.out.println(rs);
          
            result = "Successful entry.";
            st.close();
            //rs.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
            
        }

        return result;
    }
    
    /**
     * Method that makes sure whether the site is up and working or not
     * @param site URL
     * @return true or false
     */
    public static boolean isSiteUp(URL site) {
        try {
            HttpURLConnection conn = (HttpURLConnection) site.openConnection();
            conn.getContent();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            }
            return false;
        } catch (SocketTimeoutException tout) {
            return false;
        } catch (IOException ioex) {
            // You may decide on more specific behaviour...
            return false;
        }
      }
    
    /**
     * gets all of the assignments for a particular student via
     * database query
     * @return assignments ArrayList
     */
    public ArrayList<Assignment> getAllAssignments (){
        ArrayList<Assignment> assignments = new ArrayList<>();
        String sql = "select * from ma_assignment;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            String assignmentUrl;
            double assignmentWeight;
            String assignmentName;
            String assignmentDescription;
            String assignmentId;
            
            while(rs.next()) {
                assignmentId = rs.getString(1);
                assignmentName = rs.getString(2);
                assignmentDescription = rs.getString(3);
                assignmentUrl = rs.getString(4);
                assignmentWeight = rs.getDouble(5);
                
                Assignment assignment = new Assignment(assignmentId, assignmentName, assignmentDescription, assignmentUrl, assignmentWeight);
                
                assignments.add(assignment);
            }
            st.close();
            rs.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
        return assignments;
    }
    
    /**
     * gets a particular assignment using assignmentID for a particular student
     * via database query
     * @param assignmentID String
     * @return assignment Assignment
     */
    public Assignment getAssignmentByID (String assignmentID){
        Assignment assignment = null;
        String sql = "select * from ma_assignment where assignment_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, assignmentID);
            ResultSet rs = st.executeQuery();
            
            String assignmentUrl;
            double assignmentWeight;
            String assignmentName;
            String assignmentDescription;
            String assignmentId;
            
            while(rs.next()) {
                assignmentId = rs.getString(1);
                assignmentName = rs.getString(2);
                assignmentDescription = rs.getString(3);
                assignmentUrl = rs.getString(4);
                assignmentWeight = rs.getDouble(5);
                
                assignment = new Assignment(assignmentId, assignmentName, assignmentDescription, assignmentUrl, assignmentWeight);
            }
            st.close();
            rs.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
        
        return assignment;
    }
    
    /**
     * Method that deletes the particular assignment based on its id via
     * database query
     * @param assignmentID String
     * @return result Boolean
     */
    public boolean deleteAssignmentByID (String assignmentID){
        
        deleteBridges(assignmentID);
        
        boolean result = false;
        String sql = "delete from ma_assignment where assignment_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, assignmentID);
            int rowsAffected = st.executeUpdate();
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
         
        return result;
    }
    
    //delete the occurences of assignment ID within the ma_lesson_assignment table and the ma_grades table.
    //this is required in order to delete from the ma_assignment table

    /**
     * Method that deletes the occurrences of assignment ID within the 
     * ma_lesson_assignment table and the ma_grades table via database query
     * @param assignmentID String
     * @return result Boolean
     */
    public boolean deleteBridges (String assignmentID){
        
         boolean result = false;
        String sql = "delete from ma_lesson_assignment where assignment_id = ?;";
        String sql2 = "delete from ma_grade where assignment_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            
            PreparedStatement st = conn.prepareStatement(sql);
            PreparedStatement st2 = conn.prepareStatement(sql2);
            
            st.setString(1, assignmentID);
            st2.setString(1,assignmentID);
                    
            int rowsAffected = st.executeUpdate();
            rowsAffected = st2.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
         
        return result;
        
    }
    
    /**
     * Method that edits the occurrences of assignment ID and module ID within the 
     * ma_lesson_assignment table via database query
     * @param moduleID String
     * @param assignmentID String
     * @return result Boolean
     */
    public boolean brigeAssignmentModule (String moduleID, String assignmentID){
        boolean result = false;
        String sql = "insert into ma_lesson_assignment values (?,?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, assignmentID);
            st.setString(2, moduleID);
            int rowsAffected = st.executeUpdate();
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
         
        return result;
    }

    /**
     * Method that deletes the occurrences of assignment ID and lesson ID within the 
     * ma_lesson_assignment table and the ma_grades table via database query
     * @param moduleID String
     * @param assignmentID String
     * @return result Boolean
     */
    public boolean severConnection(String moduleID, String assignmentID) {
        boolean result = false;
        String sql = "delete from ma_lesson_assignment where lesson_id = ? and assignment_id = ?;";
        String sql2 = "delete from ma_grade where assignment_id = ? ;";
         ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
             
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            PreparedStatement st2 = conn.prepareStatement(sql2);
            
            st2.setString(1, assignmentID);
            st.setString(1, moduleID);
            st.setString(2, assignmentID);
            int rowsAffected = st.executeUpdate();
            rowsAffected = st2.executeUpdate();
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
         
         return result;
    }
    
    /**
     * Method for creating/adding a particular assignment for a particular 
     * faculty member via database query
     * @param moduleID String
     * @param inbound_assignment Assignment
     * @return result String
     */
    public String createAssignmentFac (String moduleID, Assignment inbound_assignment){
        String result = "URL failed - Please check your link and try again.";
        boolean urlCheck = false;
        URL myUrl;
        
        //add functionality to leave out URL. In the case that an assignment does not have any doc attached
        boolean noUrl = false;
        if (inbound_assignment.getassignmentUrl() == null || inbound_assignment.getassignmentUrl().equals("")){
            noUrl = true;
        }
        
        
        try {
            myUrl = new URL(inbound_assignment.getassignmentUrl());
            urlCheck = isSiteUp(myUrl);
          } catch (MalformedURLException ex) {
           Logger.getLogger(DBOperationsAssignments.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
         
        //Weight Error Check.
        if(inbound_assignment.getassignmentWeight()< 0){
            result = "Error, assingment must not have a weight that is less than 0.";
            return result;
        }
        
        //Check if Assignment URL works
        if(urlCheck ||noUrl){
        /* If the case above passes, persist object into tables as needed.
           Else false result
        */
        
        String assignmentName = inbound_assignment.getassignmentName();
        String assignmentDescription = inbound_assignment.getassignmentDescription();
        String assignmentUrl = inbound_assignment.getassignmentUrl();
        double assignmentWeight = inbound_assignment.getassignmentWeight();
                   
        String sql="INSERT  into ma_assignment (name, description, url, weight)  VALUES (?,?,?,?);";
               
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, assignmentName);
            st.setString(2, assignmentDescription);
            st.setString(3, assignmentUrl);
            st.setDouble(4, assignmentWeight);
            st.executeUpdate();
            //ResultSet rs = st.executeQuery();
            //System.out.println(rs);
          
            result = "Successful entry.";
            st.close();
            //rs.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
            
        }

        return result;
    }
    
    /**
     * gets the assignment id for the particular assignment via database query
     * @param assignment Assignment
     * @return result String
     */
    public String getAssignmentID (Assignment assignment){
        String result = "";
        String sql = "select assignment_id from ma_assignment where name = ? and description = ? and url = ? and weight = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
          try{
             
             Connection conn = cp.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             st.setString(1,assignment.getassignmentName());
             st.setString(2,assignment.getassignmentDescription());
             st.setString(3,assignment.getassignmentUrl());
             st.setDouble(4,assignment.getassignmentWeight());
             
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
    
}
