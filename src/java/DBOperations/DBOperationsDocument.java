/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Course;
import Objects.Document;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author massvm
 */
public class DBOperationsDocument {
    
    /*
    get all documents that are associated with the given module within the database
    */
    public ArrayList<Document> getModuleDocument (String moduleID){
        ArrayList<Document> documents= new ArrayList<>();
        String sql="select d.document_id, d.name, d.description, d.url\n" +
               "from ma_document d, ma_lesson_document ld\n" +
                "where d.document_id = ld.document_id\n" +
                "and ld.lesson_id = ?";
               
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, moduleID);
            ResultSet rs = st.executeQuery();
            
            String documentID = "";
            String documentName = "";
            String docmentDescription = "";
            String documentURL = "";
            
            while(rs.next()){
                documentID = rs.getString(1);
                documentName = rs.getString(2);
                docmentDescription = rs.getString(3);
                documentURL = rs.getString(4);
                
                Document document = new Document (documentID,documentName,docmentDescription,documentURL);
                
                documents.add(document);
            }
            
            st.close();
            rs.close();
            //conn.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return documents;
    }
    
}
