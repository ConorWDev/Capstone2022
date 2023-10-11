/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * This Assignment object holds all of the information for a particular assignment.
 * @author Administrator
 */
public class Assignment {
    
    
    private String assignmentId = "";
    private String assignmentName = "";
    private String assignmentDescription = "";
    private String assignmentUrl = "";
    private double assignmentWeight;
    
    /**
     * Constructor
     * @param assignmentId String
     * @param assignmentName String
     * @param assignmentDescription String
     * @param assignmentUrl String
     * @param assignmentWeight double
     */
    public Assignment (String assignmentId, String assignmentName, String assignmentDescription, String assignmentUrl, double assignmentWeight){
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.assignmentUrl = assignmentUrl;
        this.assignmentWeight = assignmentWeight;
    }
    
    //when assignment is first created within admin assignment page, weight is not entered. URL is optional

    /**
     * Constructor Overloading
     * @param assignmentName
     * @param assignmentDescription
     * @param assignmentUrl
     */
    public Assignment (String assignmentName, String assignmentDescription, String assignmentUrl){
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.assignmentUrl = assignmentUrl;
        this.assignmentId = null;
        this.assignmentWeight = 1;
    }

    /**
     * gets the id of the particular assignment
     * @return assignmentId String
     */
    public String getassignmentId() {
        return assignmentId;
    }

    /**
     * sets the id of the particular assignment
     * @param assignmentId String
     */
    public void setassignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    /**
     * gets the name of the particular assignment
     * @return assignmentName String
     */
    public String getassignmentName() {
        return assignmentName;
    }

    /**
     * sets the name of the particular assignment
     * @param assignmentName String
     */
    public void setassignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     * gets the description of the particular assignment
     * @return assignmentDescription String
     */
    public String getassignmentDescription() {
        return assignmentDescription;
    }

    /**
     * sets the description of the particular assignment
     * @param assignmentDescription String
     */
    public void setassignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }
    
    /**
     * gets the url of the particular assignment
     * @return assignmentUrl String
     */
    public String getassignmentUrl() {
        return assignmentUrl;
    }
    
    /**
     * sets the url of the particular assignment
     * @param assignmentUrl String
     */
    public void setassignmentUrl(String assignmentUrl) {
        this.assignmentUrl = assignmentUrl;
    }
    
    /**
     * gets the weight of the particular assignment
     * @return assignmentWeight double
     */
    public double getassignmentWeight() {
        return assignmentWeight;
    }
    
    /**
     * sets the weight of the particular assignment
     * @param assignmentWeight double
     */
    public void setassignmentWeight(double assignmentWeight) {
        this.assignmentWeight = assignmentWeight;
    }
    
}
