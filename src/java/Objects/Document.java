/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author 816601
 */
public class Document {
    
    String documentID="";
    String name="";
    String description ="";
    String url="";
            
    
    public Document(String documentID, String name, String description, String url){
        this.documentID = documentID;
        this.name = name;
        this.description = description;
        this.url = url;
    }
    
       public Document(String name, String description, String url){
        this.documentID = "null";
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
