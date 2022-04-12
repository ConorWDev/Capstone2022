/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * connection pool allows for multiple instances to access the database at one time.
 * All DBOperations should make connections to the database through the use of the ConnectionPool class
 */
public class ConnectionPool {
    private static ConnectionPool pool=null;
    private static DataSource dataSource=null;
    
    //Note that the constructor is private. This is by design. The connection pool uses a singleton design pattern.
    //To get an instance of connection pool you must use the getInstance method. Subisquently, to get a connection you
    //must use the getConnection method.
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/massupdated");
            
        }
        catch (NamingException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     *
     * @return
     */
    public static synchronized ConnectionPool getInstance() {
        if (pool==null) {
            pool = new ConnectionPool();
        }
        
        return pool;
    } 
    
    /**
     *
     * @return
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     *
     * @param conn
     */
    public void freeConnection(Connection conn) {
        try {
            conn.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
