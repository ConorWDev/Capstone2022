/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RyanChecora
 * I have created the DBOperationsGeneral class to handle all general database operations. At this point i believe  that we will
 * create other more specific dbOperations within other specific db classes (i.e. grade db operations, announcement db operations)
 * to allow for greater organization.
 * 
 */
public class DBOperationsGeneral {
    
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/massupdated","admin","password");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return conn;
    }
      
    public String getName(String username){
        String result ="";
        String sql = "select first_name, last_name from ma_student where username = ?;";
        
         try{
            Connection conn = getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                result = rs.getString(1) + " " + rs.getString(2);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return result;
    }
    
}
