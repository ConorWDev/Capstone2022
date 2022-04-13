/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * This Document object holds the document for a particular student
 * @author massvm
 */
public class Document {
    
    String documentID="";
    String name="";
    String description ="";
    String url="";
            
    /**
     * Constructor
     * @param documentID String
     * @param name String
     * @param description String
     * @param url String
     */
    public Document(String documentID, String name, String description, String url){
        this.documentID = documentID;
        this.name = name;
        this.description = description;
        this.url = url;
    }
    
    /**
     * Constructor Overloading
     * @param name String
     * @param description String
     * @param url String
     */
    public Document(String name, String description, String url){
        this.documentID = "null";
        this.name = name;
        this.description = description;
        this.url = url;
    }

    /**
     * gets the document id of the document
     * @return documentID String
     */
    public String getDocumentID() {
        return documentID;
    }

    /**
     * sets the document id of the document
     * @param documentID String
     */
    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    /**
     * gets the name of the document
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the document
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the description of the document
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description of the document
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gets the url of the document
     * @return url String
     */
    public String getUrl() {
        return url;
    }

    /**
     * sets the url of the document
     * @param url String
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
