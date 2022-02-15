/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import DBOperations.DBOperationsGeneral;
import Objects.Grade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author massvm
 */
public class DBOperationsGrade {
    
      public ArrayList<Grade> getGrades(String username){
        
          ArrayList<Grade> grades = new ArrayList<>();
        String sql = "select * from ma_grade where username = ?;";
        
        try{
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            
            
            String assignmentID ="";
            String mark ="";
            String isVisible ="";
            
            
            while (rs.next()){
                assignmentID = rs.getString(1);
                mark = rs.getString(3);
                isVisible = rs.getString(4);
                
                Grade grade = new Grade(username,assignmentID,mark,isVisible);
                
                grades.add(grade);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return grades;
    }
      
      public ArrayList<Grade> getCourseGrades (String studentUsername, String courseID){
          ArrayList<Grade> courseGrades = new ArrayList<>();
          String sql = "select g.assignment_id, g.mark, g.is_visible\n" +
                        "from ma_grade g, ma_assignment a, ma_lesson_assignment la, ma_lesson l, ma_course_lesson cl\n" +
                        "where g.username = ?\n" +
                        "and g.assignment_id = a.assignment_id\n" +
                        "and a.assignment_id = la.assignment_id\n" +
                        "and la.lesson_id = l.lesson_id\n" +
                        "and l.lesson_id = cl.lesson_id\n" +
                        "and cl.course_id = ?;";
          
          try{
            Connection conn = DBOperationsGeneral.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentUsername);
            st.setString(2, courseID);
            ResultSet rs = st.executeQuery();
            
            String assignmentID ="";
            String mark ="";
            String isVisible ="";
            
            while (rs.next()){
                
                assignmentID = rs.getString(1);
                mark = rs.getString(2);
                isVisible = rs.getString(3);
                
                Grade grade = new Grade(studentUsername,assignmentID,mark,isVisible);
                courseGrades.add(grade);
                System.out.println("course grade query was successful");
            }
            
            
          }
          catch(SQLException ex){
              ex.printStackTrace();
          }
          
          return courseGrades;
      }
      
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
                
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            
            return lessonName;
        }
    
}
