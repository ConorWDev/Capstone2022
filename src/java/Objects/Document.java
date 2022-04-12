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
            
    /**
     *
     * @param documentID
     * @param name
     * @param description
     * @param url
     */
    public Document(String documentID, String name, String description, String url){
        this.documentID = documentID;
        this.name = name;
        this.description = description;
        this.url = url;
    }
    
    /**
     *
     * @param name
     * @param description
     * @param url
     */
    public Document(String name, String description, String url){
        this.documentID = "null";
        this.name = name;
        this.description = description;
        this.url = url;
    }

    /**
     *
     * @return
     */
    public String getDocumentID() {
        return documentID;
    }

    /**
     *
     * @param documentID
     */
    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
