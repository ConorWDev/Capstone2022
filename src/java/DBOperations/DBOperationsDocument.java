/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBOperations;

import Objects.Course;
import Objects.Document;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This DBOperationsDocument class handles all of the database operations for 
 * the documents
 * 
 * @author massvm
 */
public class DBOperationsDocument {
    
    /*
    get all documents that are associated with the given module within the database
    */

    /**
     * gets all of the documents for the particular module based on its id via
     * db query
     * @param moduleID String
     * @return documents ArrayList
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

    /**
     * Method for submitting a new document object
     * @param inbound_Doc Document
     * @return result String
     */
    public String submitDocument(Document inbound_Doc){
        String result = "URL failed - Please check your link and try again.";
        boolean urlCheck = false;
        URL myUrl;
        
        try {
            myUrl = new URL(inbound_Doc.getUrl());
            urlCheck = isSiteUp(myUrl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DBOperationsDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //documentID,documentName,docmentDescription,documentURL);
                       
        //Check if Document URL works
        if(urlCheck){
        /* If the case above passes, persist object into tables as needed.
           Else false result
        */
        String documentName = inbound_Doc.getName();
        String documentDescription = inbound_Doc.getDescription();
        String documentURL = inbound_Doc.getUrl(); 
            
        String sql="INSERT into ma_document (name, description, url) VALUES (?,?,?);";
               
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, documentName);
            st.setString(2, documentDescription);
            st.setString(3, documentURL);
            st.executeUpdate();
            //System.out.println(rs);
          
            result = "Successful entry.";
            st.close();
            //rs.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
            
        }
        

        return result;
    }
    //Submit an updated Document Obj
    //Author: Altamish Lalani

    /**
     * Method for editing and submitting the updated document object
     * @param inboundUpdated_Doc Document
     * @return result String
     */
    public String editDocument(Document inboundUpdated_Doc){
        
       String result = "URL failed - Please check your link and try again.";
        boolean urlCheck = false;
        URL myUrl;
        
        try {
            myUrl = new URL(inboundUpdated_Doc.getUrl());
            urlCheck = isSiteUp(myUrl);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DBOperationsDocument.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //documentID,documentName,docmentDescription,documentURL);
                       
        //Check if Document URL works
        if(urlCheck){
        /* If the case above passes, persist object into tables as needed.
           Else false result
        */
        String documentID = inboundUpdated_Doc.getDocumentID();
        String documentName = inboundUpdated_Doc.getName();
        String documentDescription = inboundUpdated_Doc.getDescription();
        String documentURL = inboundUpdated_Doc.getUrl(); 
            
        String sql="UPDATE ma_document SET name = ?, description = ?, url = ? WHERE document_id = ? ;";
               
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, documentName);
            st.setString(2, documentDescription);
            st.setString(3, documentURL);
            st.setString(4, documentID);
            
            st.executeUpdate();
            //ResultSet rs = st.executeQuery();
            //System.out.println(rs);
          
            result = "Successful entry.";
            st.close();
            //rs.close();
            cp.freeConnection(conn);
            }
        catch(SQLException ex){
            ex.printStackTrace();
            }
            
        }

        return result;
    }
   
    /**
     * gets all of the documents via database query
     * @return documents ArrayList
     */
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
    
    /**
     * gets the document object based its id via db query
     * @param documentID String
     * @return document Document
     */
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
    
    /**
     * Method for checking whether the site is up and working or not
     * @param site URL
     * @return true or false
     */
    public static boolean isSiteUp(URL site) {
        try {
            HttpURLConnection conn = (HttpURLConnection) site.openConnection();
            conn.getContent();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            }
            return false;
        } catch (SocketTimeoutException tout) {
            return false;
        } catch (IOException ioex) {
            // You may decide on more specific behaviour...
            return false;
        }
      }
    
    /**
     * Method for creating/adding a new document via db query
     * @param name String
     * @param description String
     * @param url String
     * @return result Boolean
     */
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
    
    /**
     * Method for updating/changing a particular document via db query
     * @param id String
     * @param name String
     * @param description String
     * @param url String
     * @return result Boolean
     */
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
    
    /**
     * Method for deleting the particular document
     * via db query
     * @param id 
     * @return
     */
    public boolean deleteDoc (String id){
        
        deleteBridge(id);
        
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
    
    //called within deleteDoc. delete bridge table row

    /**
     * Method for deleting/clearing the bridge table row for module/lesson
     * and document based of document id via db query
     * @param id String
     * @return result Boolean
     */
    public boolean deleteBridge(String id){
        boolean result = false;
        String sql = "delete from ma_lesson_document where document_id = ?;";
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
    
    //when updating documents in module mgmt, dropping all connections between a module and documents is done
    //enter in a moduleID and all of its associated documents are dropped

    /**
     * Method for deleting/clearing the bridge table row for module/lesson
     * and document based of module id via db query
     * @param moduleID String
     * @return result Boolean
     */
    public boolean clearBridge (String moduleID){
        boolean result = false;
        String sql = "delete from ma_lesson_document where lesson_id = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
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
     * Method for creating/adding a bridge table row between module and document
     * via db query
     * @param moduleID String
     * @param documentID String
     * @return result Boolean
     */
    public boolean bridgeDocumentModule(String moduleID, String documentID){
        boolean result = false;
        String sql = "insert into ma_lesson_document values (?,?);";
        ConnectionPool cp = ConnectionPool.getInstance();
        
        try{
            Connection conn = cp.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(2, moduleID);
            st.setString(1, documentID);
            
            int rowsAffected = st.executeUpdate();
            result = (rowsAffected > 0);
            st.close();
            cp.freeConnection(conn);
        } catch(Exception e){
      
        }
        
        return result;
        
    }
    
    /**
     * gets the id of the document via db query
     * @param doc Document
     * @return docID String
     */
    public String getDocumentID (Document doc){
        String docID = "";
        String sql ="select document_id from ma_document where name = ? and description = ? and url = ?;";
        ConnectionPool cp = ConnectionPool.getInstance();
        
         try{
             
             Connection conn = cp.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             st.setString(1,doc.getName());
             st.setString(2,doc.getDescription());
             st.setString(3,doc.getUrl());
             
             ResultSet rs = st.executeQuery();
             
             while (rs.next()){
                 docID = rs.getString(1);
             }
             
             st.close();
             rs.close();
             
             cp.freeConnection(conn);
          }
          catch(SQLException ex){
              ex.printStackTrace();
          }
        
        return docID;
    }

    
}
