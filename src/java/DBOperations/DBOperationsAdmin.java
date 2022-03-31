/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Interface.Users.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ryanc
 */
public class DBOperationsAdmin {
    
    //get faculty name from username
     public String getAdminName(String adminUsername){
        String result ="";
        String sql = "select first_name, last_name from ma_admin where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, adminUsername);
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
    public String getAdminEmail(String adminUsername){
        String result = "";
        String sql = "select email from ma_faculty where username =?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, adminUsername);
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
    
     public ArrayList<Admin> getAllAdmins(){
        ArrayList<Admin> admins = new ArrayList<Admin>();
        
         String sql = "select username from ma_admin;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                Admin admin = new Admin(rs.getString(1));
                admins.add(admin);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        
        return admins;
    }
    
     //get password from ma_student table. Password is not held withn student object for added security
    public String getStudentPass(String userID){
        String result = "";
        String sql = "select password from ma_student where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, userID);
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
    
     //get password from ma_student table. Password is not held withn student object for added security
    public String getFacultyPass(String userID){
        String result = "";
        String sql = "select password from ma_faculty where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, userID);
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
    
    public String getAdminPass(String userID){
        String result = "";
        String sql = "select password from ma_admin where username = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, userID);
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
    
    public String getFirstname (String studentID){
        String name = "";
        String sql = "select first_name from ma_admin where username = ?;";
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
        String sql = "select middle_name from  ma_admin where username = ?;";
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
        String sql = "select last_name from  ma_admin where username = ?;";
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
     
     public boolean editStudent (String user, String first, String middle, String last, String email, String pass){
         boolean result = false;
         String sql = "update ma_student set username= ?, first_name=?, middle_name=?,last_name=?,email=?,password=? where username=?";
         ConnectionPool cp = ConnectionPool.getInstance();
         
          try {
            Connection conn = cp.getConnection();
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, first);
            st.setString(3, middle);
            st.setString(4, last);
            st.setString(5, email);
            st.setString(6, pass);
            st.setString(7, user);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
     
     public boolean editFaculty (String user, String first, String middle, String last, String email, String pass){
         boolean result = false;
         String sql = "update ma_faculty set username= ?, first_name=?, middle_name=?,last_name=?,email=?,password=? where username=?";
         ConnectionPool cp = ConnectionPool.getInstance();
         
          try {
            Connection conn = cp.getConnection();
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, first);
            st.setString(3, middle);
            st.setString(4, last);
            st.setString(5, email);
            st.setString(6, pass);
            st.setString(7, user);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
     
     public boolean editAdmin (String user, String first, String middle, String last, String email, String pass){
         boolean result = false;
         String sql = "update ma_admin set username= ?, first_name=?, middle_name=?,last_name=?,email=?,password=? where username=?";
         ConnectionPool cp = ConnectionPool.getInstance();
         
          try {
            Connection conn = cp.getConnection();
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, first);
            st.setString(3, middle);
            st.setString(4, last);
            st.setString(5, email);
            st.setString(6, pass);
            st.setString(7, user);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
     
     //to delete a student we must remove them from all adjacent tables. This includes
     //the ma_attendance table, the ma_grade table, and the ma_student cohort table.
     //once the student has been deleted from these tables, the row in ma_student can be deleted
     public boolean deleteStudent (String user){
         //right now this method only returns true
         //if a user say does not have any grades and is deleted, this could spur a false negative
         boolean result = true;
         String sqlDeleteAttendance = "delete from ma_attendance where username = ?;";
         String sqlDeleteGrade = "delete from ma_grade where username = ?;";
         String sqlDeleteCohort = "delete from ma_student_cohort where username = ?;";
         String sqlDeleteStudent = "delete from ma_student where username = ?;";
         ConnectionPool cp = ConnectionPool.getInstance();
         
          try {
            Connection conn = cp.getConnection();
            PreparedStatement st1 = conn.prepareStatement(sqlDeleteAttendance);
            PreparedStatement st2 = conn.prepareStatement(sqlDeleteGrade);
            PreparedStatement st3 = conn.prepareStatement(sqlDeleteCohort);
            PreparedStatement st4 = conn.prepareStatement(sqlDeleteStudent);
            
            
            st1.setString(1, user);
            st2.setString(1, user);
            st3.setString(1, user);
            st4.setString(1, user);
            
            int rowsAffected1 = st1.executeUpdate();
            int rowsAffected2 = st2.executeUpdate();
            int rowsAffected3 = st3.executeUpdate();
            int rowsAffected4 = st4.executeUpdate();
            
            //result = (rowsAffected > 0);
            
            st1.close();
            st2.close();
            st3.close();
            st4.close();
            
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
     
     //to delete a faculty member, the adjacent ma_cohort_faculty table must also
     //be cleared of reference to that faculty member
     public boolean deleteFaculty (String user){
         //right now this method only returns true
         //if a user say does not have a cohort association this could spur a false negative
         boolean result = true;
         String sqlDeleteCohort = "delete from ma_cohort_faculty where username = ?;";
         String sqlDeleteFaculty = "delete from ma_faculty where username = ?;";
         ConnectionPool cp = ConnectionPool.getInstance();
         
          try {
            Connection conn = cp.getConnection();
            PreparedStatement st1 = conn.prepareStatement(sqlDeleteCohort);
            PreparedStatement st2 = conn.prepareStatement(sqlDeleteFaculty);
            
            st1.setString(1, user);
            st2.setString(1, user);
           
            
            int rowsAffected1 = st1.executeUpdate();
            int rowsAffected2 = st2.executeUpdate();
            
            
            //result = (rowsAffected > 0);
            
            st1.close();
            st2.close();
            
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
     
     //need a check here to ensure that there is always at least one admin
     public boolean deleteAdmin (String user){
         
         boolean result = false;
         String sql = "delete from ma_admin where username = ?;";
       
         ConnectionPool cp = ConnectionPool.getInstance();
         
          try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
     
     public boolean createStudent (String username, String first, String middle, String last, String pass, String email){
         boolean result = false;
         String sql = "insert into ma_student (username, first_name, middle_name, last_name, password, email) values (?,?,?,?,?,?);";
         ConnectionPool cp = ConnectionPool.getInstance();
         
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, first);
            st.setString(3, middle);
            st.setString(4, last);
            st.setString(5, pass);
            st.setString(6, email);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
     
      public boolean createFaculty (String username, String first, String middle, String last, String pass, String email){
         boolean result = false;
         String sql = "insert into ma_faculty (username, first_name, middle_name, last_name, password, email) values (?,?,?,?,?,?);";
         ConnectionPool cp = ConnectionPool.getInstance();
         
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, first);
            st.setString(3, middle);
            st.setString(4, last);
            st.setString(5, pass);
            st.setString(6, email);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
      
      public boolean createAdmin (String username, String first, String middle, String last, String pass, String email){
         boolean result = false;
         String sql = "insert into ma_admin (username, first_name, middle_name, last_name, password, email) values (?,?,?,?,?,?);";
         ConnectionPool cp = ConnectionPool.getInstance();
         
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, first);
            st.setString(3, middle);
            st.setString(4, last);
            st.setString(5, pass);
            st.setString(6, email);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        
         
         return result;
     }
}
