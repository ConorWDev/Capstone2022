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

public class DBOperationsModule {

    public ArrayList<Module> getAllModules(String courseID){
        
        ArrayList<Module> modules = new ArrayList<>();
        String sql = "select l.lesson_id, l.name, l.description  \n" +
                     "from ma_lesson l, ma_course_lesson cl where\n" +
                     "l.lesson_id = cl.lesson_id \n" +
                      "and cl.course_id = ?;";
        
        try {
            Connection conn = DBOperationsGeneral.getConnection();
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
                
                Module module = new Module(courseID, name, description);
                
                modules.add(module);
            }
            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            }
          
        return modules;
    }    

    
    
    public String getLessonId (String lessonId) throws SQLException{
        String result = "";
        String sql = "select lesson_id from ma_lesson where lesson_id=?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, lessonId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(1);
                    }
                    
                    st.close();
                    rs.close();
                    conn.close();
                    
                } catch(Exception e){}
                
                return result;
    }
    
    public String getName (String lessonId) throws SQLException{
        String result = "";
        String sql = "select name from ma_lesson where lesson_id = ?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, lessonId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(2);
                    }
                    
                    st.close();
                    rs.close();
                    conn.close();
                    
                } catch(Exception e){}
                
                return result;
    }
    
    public String getDescription (String lessonId) throws SQLException{
        String result = "";
        String sql = "select description from ma_lesson where lesson_id = ?;";
        
                try{
                    Connection conn = DBOperationsGeneral.getConnection();
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, lessonId);
                    ResultSet rs = st.executeQuery(sql);
                    
                    while (rs.next()) {
                        result = rs.getString(3);
                    }
                    
                    
                    st.close();
                    rs.close();
                    conn.close();
                    
                } catch(Exception e){}
                
                return result;
    }

    
}