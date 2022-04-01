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

    //Submit a new Document Obj
    //Author: Altamish Lalani
    public boolean submitDocument(Document inbound_Doc){
        boolean result = false;

        //Check if Document exists already

        //Check if Document URL works

        //If the two cases above pass, persist object into tables as needed.



        return result;
    }
    //Submit an updated Document Obj
    //Author: Altamish Lalani
    public boolean editDocument(Document inboundUpdated_Doc){
        boolean result = false;

        //Check if Document exists already

        //Check if new Document URL works

        //If the two cases above pass, Update the record in the tables correctly.

        

        return result;
    }
    
    public boolean createDocument (String name, String description, String url){
        boolean result = false;
        String sql = "insert into ma_document (name,description,url) values (?,?,?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, description);
            st.setString(3, url);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
      
        }
        
        
        return result;
    }
    
    public ArrayList<Document> getAllDocuments (){
        ArrayList<Document> documents = new ArrayList<>();
        String sql = "select * from ma_document;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
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
    
    public Document getDocumentByID(String documentID){
        Document document = null;
        String sql = "select * from ma_document where document_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, documentID);
            ResultSet rs = st.executeQuery();
            
            String id = "";
            String documentName = "";
            String docmentDescription = "";
            String documentURL = "";
            
            while(rs.next()){
                id = rs.getString(1);
                documentName = rs.getString(2);
                docmentDescription = rs.getString(3);
                documentURL = rs.getString(4);
                
                document = new Document (id,documentName,docmentDescription,documentURL);
            }
            
            st.close();
            rs.close();
            cp.freeConnection(conn);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        } 
        return document;
    }
    
    public boolean updateDoc (String id, String name, String description, String url){
        boolean result = false;
        String sql = "update ma_document set name = ?, description = ?, url = ? where document_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try {
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, description);
            st.setString(3, url);
            st.setString(4, id);
            
            int rowsAffected = st.executeUpdate();
            
            result = (rowsAffected > 0);
            
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
      
        }
        
        return result;
    }
    
    public boolean deleteDoc (String id){
        boolean result = false;
        String sql = "delete from ma_document where document_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            int rowsAffected = st.executeUpdate();
            result = (rowsAffected > 0);
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
      
        }
        
        return result;
    }
    
}
