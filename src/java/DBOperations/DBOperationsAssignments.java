/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Assignment;
import java.util.ArrayList;
import java.sql.*;

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
    
    
    
}
