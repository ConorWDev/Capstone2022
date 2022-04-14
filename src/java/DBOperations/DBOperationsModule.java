/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Objects.Module;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DBOperationsModule {

    //return all modules for a given course

    /**
     *
     * Enter a courseID return an ArrayList of corresponding module objects
     * @param courseID
     * @return modules ArrayList
     */
    public ArrayList<Module> getCourseModules(String courseID){
        
        ArrayList<Module> modules = new ArrayList<>();
        String sql = "select l.lesson_id, l.name, l.description  \n" +
                     "from ma_lesson l, ma_course_lesson cl where\n" +
                     "l.lesson_id = cl.lesson_id \n" +
                      "and cl.course_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, courseID);
            ResultSet rs = st.executeQuery();
            
           
            String name;
            String description;
            String lessonID;
            
            while(rs.next()) {
                lessonID = rs.getString(1);
                name = rs.getString(2);
                description = rs.getString(3);
                
                Module module = new Module(lessonID, name, description);
                
                modules.add(module);
            }
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
          
        return modules;
    }
    
    //parameter moduleId. return module name

    /**
     *Enter a moduleID return a corresponding module name
     * @param moduleID
     * @return moduleName String
     */
    public String getModuleName(String moduleID){
        
        String moduleName = "";
        String sql = "select name from ma_lesson where lesson_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, moduleID);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                moduleName = rs.getString(1);
            }
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
          
        return moduleName;
    }
    
    
    //parameter moduleId. return module description

    /**
     *Enter a moduleID and return a corresponding module description
     * @param moduleID
     * @return moduleName String
     */
    public String getModuleDescription(String moduleID){
        
        String moduleName = "";
        String sql = "select description from ma_lesson where lesson_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            //Connection conn = DBOperationsGeneral.getConnection();
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, moduleID);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                moduleName = rs.getString(1);
            }
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
          
        return moduleName;
    }
    
    

    /**
     * This method returns a module object for a given module id entered. This is used when navigating to the
     * module main page and setting the particular module object as "module" within the session scope of the application. This may
     * deprecate the above methods, as this one method can be called, and from the resulting object, all datafields of the module can be retrieved
     *
     *
     * Also used during admin module mgmt
     * @param moduleID
     * @return module Module
     */

    public Module getModule (String moduleID){
        Module module = null;
        String sql = "select * from ma_lesson where lesson_id = ?";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, moduleID);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()) {
                module = new Module(rs.getString(1),rs.getString(2),rs.getString(3));
            }
            st.close();
            rs.close();
            cp.freeConnection(conn);
        } catch (Exception e) {
            
        }
          
        return module;
    }
    
    /**
     * Enter a name and description. This creates a new module within the database
     * @param name
     * @param description
     * @return result Boolean
     */
    public boolean createModule (String name, String description){
        boolean result = false;
        String sql = "insert into ma_lesson (name,description) values(?,?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, description);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        return result;
    }
    
    /**
     * Return an arrayList of all modules that exist within the database
     * @return modules ArrayList
     */
    public ArrayList<Module> getAllModules (){
        ArrayList<Module> modules = new ArrayList<>();
        String sql = "select * from ma_lesson;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
           
            String name;
            String description;
            String lessonID;
            
            while(rs.next()) {
                lessonID = rs.getString(1);
                name = rs.getString(2);
                description = rs.getString(3);
                
                Module module = new Module(lessonID, name, description);
                
                modules.add(module);
            }
            st.close();
            rs.close();
            
            cp.freeConnection(conn);
        } catch (Exception e) {
            }
        
        return modules;
    }
    
    /**
     *Enter a module ID, moduleName, and moduleDescription. This will update the module
     * where moduleID = moduleID.
     * @param moduleID
     * @param moduleName
     * @param moduleDescription
     * @return result Boolean
     */
    public boolean updateModule (String moduleID, String moduleName, String moduleDescription){
        boolean result = false;
        String sql = "update ma_lesson set name = ?, description = ? where lesson_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, moduleName);
            st.setString(2, moduleDescription);
            st.setString(3, moduleID);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        return result;
        
        
    }
    
    /**
     *Enter a moduleID. The module within the database with 
     * a corresponding ID is deleted
     * @param moduleID
     * @return result Boolean
     */
    public boolean deleteModuleByID (String moduleID){
        
        deleteBridges(moduleID);
        
        boolean result = false;
        String sql = "delete from ma_lesson where lesson_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, moduleID);
            
            int rowsAffected = st.executeUpdate();
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        return result;
    }

    
    /**
     *Delete the bridges necessary for deleting a module from the database
     * this method is called from within deleteModuleByID()
     * @param moduleID
     * @return result Boolean
     */
    private boolean deleteBridges(String moduleID) {
        boolean result = false;
        String sql = "delete from ma_lesson_document where lesson_id = ?;";
        String sql2 = "delete from ma_lesson_assignment where lesson_id = ?;";
        String sql3 = "delete from ma_course_lesson where lesson_id = ?;";
        
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            PreparedStatement st2 = conn.prepareStatement(sql2);
            PreparedStatement st3 = conn.prepareStatement(sql3);
            st.setString(1, moduleID);
            st2.setString(1, moduleID);
            st3.setString(1, moduleID);
            
            int rowsAffected = st.executeUpdate();
            rowsAffected = st2.executeUpdate();
            rowsAffected = st3.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
            
        }
        return true;
        
    }
}