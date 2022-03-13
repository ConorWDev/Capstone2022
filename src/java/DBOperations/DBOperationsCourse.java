/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author massvm
 */
public class DBOperationsCourse {
    
    /*
    *getCourses
    *This method will take as a parameter a student's username.
    *From this the database will be queried for all courses that the student
    *is associated with. This information will then be used to create course objects
    *which will be added the an arraylist of courses which is then returned.
    */
    public ArrayList<Course> getCourses (String studentUsername){
        ArrayList<Course> courses = new ArrayList<>();
        String sql="select cou.course_id, cou.name, cou.description  from\n" +
                    "ma_student s, ma_student_cohort sc, ma_cohort c, ma_cohort_course cc, ma_course cou\n" +
                    "where s.username = ?\n" +
                    "and s.username = sc.username\n" +
                    "and sc.cohort_id = c.cohort_id\n" +
                    "and c.cohort_id = cc.cohort_id\n" +
                    "and cc.course_id = cou.course_id;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentUsername);
            ResultSet rs = st.executeQuery();
            
            String courseID = "";
            String courseName = "";
            String courseDescription = "";
            
            while(rs.next()){
                courseID = rs.getString(1);
                courseName = rs.getString(2);
                courseDescription = rs.getString(3);
                
                Course course = new Course (courseID,courseName,courseDescription);
                
                courses.add(course);
            }
            
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return courses;
    }
    
    /*
    obtain list of courses associated with a particular cohortID. (Currently used within SiteNavigationFaculty)
    */
    public ArrayList<Course> getCoursesByCohort (String cohortID){
        ArrayList<Course> courses = new ArrayList<>();
        String sql ="SELECT cou.course_id,cou.name,cou.description, c.name\n" +
                    "FROM ma_cohort c, ma_cohort_course cc, ma_course cou\n" +
                    "WHERE c.cohort_id = cc.cohort_id\n" +
                    "AND cc.course_id = cou.course_id\n" +
                    "AND c.cohort_id = ?;";
        
         ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            ResultSet rs = st.executeQuery();
            
            String courseID = "";
            String courseName = "";
            String courseDescription = "";
            
            while(rs.next()){
                courseID = rs.getString(1);
                courseName = rs.getString(2);
                courseDescription = rs.getString(3);
                
                Course course = new Course (courseID,courseName,courseDescription);
                
                courses.add(course);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return courses;
    }
    
    //enter the courseId and get the courseName in return
    public String getCourseName (String courseID){
        String courseName = "";
        String sql="select name from ma_course where course_id =?;";
        ConnectionPool cp = ConnectionPool.getInstance();
                
        try{
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseID);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                courseName = rs.getString(1);
            }
            
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return courseName;
    }
    
    /*
    This method returns a course object for a given course id entered. This is used within SiteNavigationFaculty when navigating to the
    course main page and setting the particular module object as "module" within the session scope of the application. This may
    depreicate getCourseName method, as this one method can be called, and from the resulting object, all datafields of the course can be retrieved
    */
    public Course getCourse (String courseID){
        Course course = null;
        String sql ="select * from ma_course where course_id = ?";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseID);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                course = new Course(rs.getString(1),rs.getString(2),rs.getString(3));
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return course;
    }
    
}
