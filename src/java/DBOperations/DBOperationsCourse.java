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
        try{
            Connection conn = DBOperationsGeneral.getConnection();
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
            conn.close();
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return courses;
    }
    
}
