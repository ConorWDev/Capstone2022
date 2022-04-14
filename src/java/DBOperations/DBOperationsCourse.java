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
 * This DBOperationsCourse class handles all of the database operations for the 
 * courses
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

    /**
     * gets the courses for a particular student based on their username via
     * db query
     * @param studentUsername String
     * @return courses ArrayList
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

    /**
     * get the courses for the particular cohort based on its id via
     * db query
     * @param cohortID String
     * @return courses ArrayList
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

    /**
     * gets name of the particular course based on course id via
     * db query
     * @param courseID String
     * @return courseName String
     */
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

    /**
     * gets the course object based on course id via
     * db query
     * @param courseID
     * @return
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
    
    /**
     * Method for creating/adding a particular course via
     * db query
     * @param courseName String
     * @param courseDescription String
     * @return result Boolean
     */
    public boolean createCourse (String courseName, String courseDescription){
        boolean result = false;
        String sql = "insert into ma_course (name, description) values (?,?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseName);
            st.setString(2, courseDescription);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }
        return result;
    }
    
    /**
     * gets all of the courses via db query
     * @return courses ArrayList
     */
    public ArrayList<Course> getAllCourses (){
        ArrayList<Course> courses = new ArrayList<>();
        String sql = "select * from ma_course;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
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
    
    /**
     * Method for deleting/clearing the bridge between course and module/lesson based on
     * course id
     * @param courseID String
     * @return result Boolean
     */
    public boolean clearBridge (String courseID){
        boolean result = false;
        String sql = "delete from ma_course_lesson where course_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseID);
            
            int rowsAffected = st.executeUpdate();
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
         
         return result;
    }
    
    /**
     * Method for creating/adding a bridge between course and module/lesson based
     * on their ids via db query
     * @param courseID String
     * @param moduleID String
     * @return result Boolean
     */
    public boolean bridgeCourseModule (String courseID, String moduleID){
        boolean result = false;
        String sql = "insert into ma_course_lesson values (?,?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseID);
            st.setString(2, moduleID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        return result;
    }
    
    /**
     * Method for updating the particular course via db query
     * @param courseID String
     * @param courseName String
     * @param courseDescription String
     * @return result Boolean
     */
    public boolean updateCourse (String courseID, String courseName, String courseDescription){
        boolean result = false;
        String sql = "update ma_course set name = ?, description = ? where course_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseName);
            st.setString(2, courseDescription);
            st.setString(3, courseID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        return result;
    }
    
    /**
     * Method for the deleting the particular course based on its id via
     * db query
     * @param courseID String
     * @return result Boolean
     */
    public boolean deleteCourseByID (String courseID){
        
        deleteBridges(courseID);
        
        boolean result = false;
        String sql = "delete from ma_course where course_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
       try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseID);
            
            
            int rowsAffected = st.executeUpdate();
            result = (rowsAffected > 0);
            
            st.close();
            
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        
        return result;
    }
    
    /**
     * Method for deleting/clearing the bridges between course and announcement,
     * course and module, cohort and course based on course id via db queries
     * @param courseID String
     * @return result Boolean
     */
    public boolean deleteBridges(String courseID){
        boolean result = false;
        String sql = "delete from ma_course_announcement where course_id = ?;";
        String sql2 = "delete from ma_course_lesson where course_id = ?;";
        String sql3 = "delete from ma_cohort_course where course_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
       try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            PreparedStatement st2 = conn.prepareStatement(sql2);
            PreparedStatement st3 = conn.prepareStatement(sql3);
            
            st.setString(1, courseID);
            st2.setString(1, courseID);
            st3.setString(1, courseID);
            
            int rowsAffected = st.executeUpdate();
            rowsAffected = st2.executeUpdate();
            rowsAffected = st3.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            st2.close();
            st3.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        
        return result;
    }
    
}
