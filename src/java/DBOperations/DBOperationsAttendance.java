/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Attendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ryanc
 */
public class DBOperationsAttendance {
   
    //add an attendance record that is marked present
    public boolean addAttendancePresent(String studentID, String date){
        boolean result = false;
        String sql = "insert into ma_attendance (username,present,date) values (?, 'Y', ?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        //if the attendance record already exists for that student on that day, we will update rather
        //than add a new record.
        String sqlUpdate = "update ma_attendance set present = 'Y' where username = ? and date = ?;";
        if (attendanceAlreadyInDatabase(studentID,date)){
            try {
            Connection conn = cp.getConnection();
            //here is the difference between the if and the else. Preparing sqlUpdate rather than sql
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, studentID);
            st.setString(2, date);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        }
        //else the attendance record for the particular student on the particular day is not within the database
        //so we must add it
        else{
            try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, date);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        }
        
        return result;
    }
    
    //add an attendance record that is marked not present
    public boolean addAttendanceNotPresent(String studentID, String date){
        boolean result = false;
        String sql = "insert into ma_attendance (username,present,date) values (?, 'N', ?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        //if the attendance record already exists for that student on that day, we will update rather
        //than add a new record.
        String sqlUpdate = "update ma_attendance set present = 'N' where username = ? and date = ?;";
        if (attendanceAlreadyInDatabase(studentID,date)){
            try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sqlUpdate);
            st.setString(1, studentID);
            st.setString(2, date);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        }
        //else the attendance record for the particular student on the particular day is not within the database
        //so we must add it
        else{
           try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, date);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){} 
        }
        
        
        return result;
    }
    
    //method used internally within DBOperationsAttendance to check if an entered attendance record
    //already exists within the DB. if it does, return true. This will be used within the above methods
    public boolean attendanceAlreadyInDatabase (String studentID, String date){
        boolean result =false;
        String sql = "select attendance_id from ma_attendance where username = ? and date = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentID);
            st.setString(2, date);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                result = true;
            }
            
            rs.close();
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){}    
        
        
        
        return result;
    }
    
    public ArrayList<Attendance> getAttendanceRecords (String studentID){
        ArrayList<Attendance> attendanceList = new ArrayList<>();
        String sql = "select * from ma_attendance where username = ? order by date;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, studentID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Attendance attendance = new Attendance(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                attendanceList.add(attendance);
            }
            st.close();
            rs.close();
            cp.freeConnection(conn);
        } catch(Exception e){}
        
        
        return attendanceList;
    }
}
