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
 *
 * @author 816601
 */
public class DBOperationsAssignments {
    
    //return all assignments for a given course
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
     public String submitAssignment(Assignment inbound_assignment){
       
        String result = "URL failed - Please check your link and try again.";
        boolean urlCheck = false;
        URL myUrl;
        
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
        if(urlCheck){
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
            ResultSet rs = st.executeQuery();
            System.out.println(rs);
          
            result = "Successful entry.";
            st.close();
            rs.close();
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
    public String editAssignment(Assignment inboundUpdated_assignment){
        String result = "URL failed - Please check your link and try again.";
        boolean urlCheck = false;
        URL myUrl;
        
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
        if(urlCheck){
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
            ResultSet rs = st.executeQuery();
            System.out.println(rs);
          
            result = "Successful entry.";
            st.close();
            rs.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
            
        }

        return result;
    }
    
    
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
    
}
