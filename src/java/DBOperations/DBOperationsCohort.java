/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Cohort;
import DBOperations.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author massvm
 */
public class DBOperationsCohort {
    
    /*
    obtain the cohorts that are associated with a particular faculty member. As a faculty member
    can teach more than one cohort, return an arraylist of cohort objects
    */
    
    public ArrayList<Cohort> getCohorts(String facultyUsername){
        ArrayList<Cohort> cohorts = new ArrayList<>();
        String sql = "SELECT c.cohort_id, c.name\n" +
                     "FROM ma_cohort c, ma_cohort_faculty cf, ma_faculty f\n" +
                     "WHERE f.username = cf.username\n" +
                     "AND cf.cohort_id = c.cohort_id\n" +
                     "AND f.username =?;";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, facultyUsername);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                String cohortID = rs.getString(1);
                String cohortName = rs.getString(2);
                
                Cohort cohort = new Cohort(cohortID,cohortName);
                cohorts.add(cohort);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
         
        return cohorts;
    }
    
    public Cohort getCohort (String cohortID){
        Cohort cohort = null;
        String sql= "select * from ma_cohort where cohort_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, cohortID);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){
                cohort = new Cohort(rs.getString(1),rs.getString(2));
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
         }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
        return cohort;
    }
    
}
