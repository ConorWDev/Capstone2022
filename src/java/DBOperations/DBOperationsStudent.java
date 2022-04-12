/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Interface.Users.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ryan Checora. This class contains methods that are specific to obtaining student information
 */
public class DBOperationsStudent {
    
    //get the student name from the studentUsername
   
    public String getStudentName(String studentUsername){
        String result ="";
        String sql = "select first_name, last_name from ma_student where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentUsername);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                result = rs.getString(1) + " " + rs.getString(2);
            }
            
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return result;
    }
    
    
    //get the student email from the studentUsername
    public String getStudentEmail(String studentUsername){
        String result = "";
        String sql = "select email from ma_student where username =?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        
         try{
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentUsername);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                result = rs.getString(1);
            }
            
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return result;
    }
    
     //get the cohortCode from the studentUsername
    public String getCohortID(String studentUsername){
        
        String result = "";
        String sql = "select sc.cohort_id from ma_student_cohort sc, ma_student s\n"
                    + "where s.username = sc.username\n"
                    + "and s.username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
         try{
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentUsername);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String cohortCode = rs.getString(1);
                result = cohortCode;
            }
            
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return result;
    }
    
    public ArrayList<Student> getStudentsByCohort(String cohortID){
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select s.username from ma_student s, ma_student_cohort sc\n" +
                     "where s.username = sc.username \n" +
                     "and sc.cohort_id =?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
         
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String username = rs.getString(1);
                Student student = new Student(username);
                students.add(student);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        
        
        return students;
    }
    
    //search student name functionality used in fac_grades.jsp page. enter the search name and cohort
    public ArrayList<Student> searchStudents (String search, String cohortID){
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT s.username, sc.cohort_id\n" +
                     "FROM ma_student s, ma_student_cohort sc\n" +
                     "WHERE s.username = sc.username\n" +
                     "AND sc.cohort_id = ?\n" +
                     "AND s.first_name LIKE ?\n" +
                     "OR s.last_name LIKE ?;";
        
         ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
         
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            st.setString(2, search + "%");
            st.setString(3, search + "%");
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String username = rs.getString(1);
                Student student = new Student(username);
                students.add(student);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            System.out.print("error during search");
            ex.printStackTrace();
        }
         
        
        return students;
    }
    
    //get all students method used within the SiteNavigationAdmin controller
    public ArrayList<Student> getAllStudents (){
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select username from ma_student;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                Student student = new Student(rs.getString(1));
                students.add(student);
            }
            
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return students;
    }
    
    
    public String getFirstname (String studentID){
        String name = "";
        String sql = "select first_name from ma_student where username = ?;";
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
    
     public String getMiddlename (String studentID){
        String name = "";
        String sql = "select middle_name from ma_student where username = ?;";
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
     
     public String getLastname (String studentID){
        String name = "";
        String sql = "select last_name from ma_student where username = ?;";
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
     
     
     public boolean deleteGrades (String studentID){
         boolean result = false;
         String sql = "delete from ma_grade where username = ?;";
         ConnectionPool cp = ConnectionPool.getInstance();
         
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
        }

       
           return result;
     }
}
