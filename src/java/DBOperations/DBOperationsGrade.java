/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import DBOperations.DBOperationsGeneral;
import Objects.Grade;
import Objects.StudentCourse;
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
    
    
    /*
    *getGrades
    This method returns all grades of a given student, regarless of
    *course. This method may not currently be in use as students can only
    *view grades in a course-by-course basis. May delete this method if
    *neccessary
    */
    
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
            
            st.close();
            rs.close();
            conn.close();
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return grades;
    }
      
      /*
      *getCourseGrades
      *This method takes two parameters. A student username and a courseID. These parameters
      *are used to query the database for all grade information of a particular student and a
      *particular course. The resulting grade information is used to construct grade objects.
      *These objects are placed within an arrayList of grade objects which are then returned.
      *This method is used for functionality in the course grade page.
      */
      
      
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
            }
            
            st.close();
            rs.close();
            conn.close();
            
          }
          catch(SQLException ex){
              ex.printStackTrace();
          }
          
          return courseGrades;
      }
      
      /*
      *getWeight
      This method takes the assignmentID of any assignment and
      returns the weight of that assignment as it is held within
      the database
      */
      
      public String getWeight (String assignmentID){
          String weight = "";
          String sql = "select weight from ma_assignment where assignment_id = ?;";
          try{
             Connection conn = DBOperationsGeneral.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             st.setString(1,assignmentID);
             ResultSet rs = st.executeQuery();
             
             while (rs.next()){
                 weight = rs.getString(1);
             }
             
             st.close();
             rs.close();
             conn.close();
          }
          catch(SQLException ex){
              ex.printStackTrace();
          }
          
          
          return weight;
      }
      
      /*
      getStudentCourses
      This method takes as input the student username.
      It returns an arrayList of StudentCourse objects. Student course objects
      are objects that link together a particular course with a particular
      student. This is useful for calculating student averages for entire
      courses.
      */
      
      public ArrayList<StudentCourse> getStudentCourses (String studentUsername){
          ArrayList<StudentCourse> courses = new ArrayList<>();
          String sql = "select cou.name, cou.course_id from\n" +
                        "ma_student s, ma_student_cohort sc, ma_cohort c, ma_cohort_course cc, ma_course cou\n" +
                        "where s.username = ?\n" +
                        "and s.username = sc.username\n" +
                        "and sc.cohort_id = c.cohort_id\n" +
                        "and c.cohort_id = cc.cohort_id\n" +
                        "and cc.course_id = cou.course_id;";
          
          try{
              
             Connection conn = DBOperationsGeneral.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             st.setString(1,studentUsername);
             ResultSet rs = st.executeQuery();
              
             while (rs.next()){
                String courseName = rs.getString(1);
                String courseID = rs.getString(2);
                StudentCourse course = new StudentCourse(studentUsername, courseName, courseID);
                
                courses.add(course);
             }
              
             st.close();
             rs.close();
             conn.close();
          }
          catch(SQLException ex){
              ex.printStackTrace();
          }
          
          
          return courses;
      }
       
}
