/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
