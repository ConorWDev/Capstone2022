/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import java.sql.Connection;
import java.sql.DriverManager;
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
    
    private Connection getConnection(){
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
    
}
