/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Administrator
 */
public class Assignment {
    
    
    private String assignmentId = "";
    private String assignmentName = "";
    private String assignmentDescription = "";
    private String assignmentUrl = "";
    private double assignmentWeight;
    
    /**
     *
     * @param assignmentId
     * @param assignmentName
     * @param assignmentDescription
     * @param assignmentUrl
     * @param assignmentWeight
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
     *
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
     *
     * @return
     */
    public String getassignmentId() {
        return assignmentId;
    }

    /**
     *
     * @param assignmentId
     */
    public void setassignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    /**
     *
     * @return
     */
    public String getassignmentName() {
        return assignmentName;
    }

    /**
     *
     * @param assignmentName
     */
    public void setassignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     *
     * @return
     */
    public String getassignmentDescription() {
        return assignmentDescription;
    }

    /**
     *
     * @param assignmentDescription
     */
    public void setassignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }
    
    /**
     *
     * @return
     */
    public String getassignmentUrl() {
        return assignmentUrl;
    }
    
    /**
     *
     * @param assignmentUrl
     */
    public void setassignmentUrl(String assignmentUrl) {
        this.assignmentUrl = assignmentUrl;
    }
    
    /**
     *
     * @return
     */
    public double getassignmentWeight() {
        return assignmentWeight;
    }
    
    /**
     *
     * @param assignmentWeight
     */
    public void setassignmentWeight(double assignmentWeight) {
        this.assignmentWeight = assignmentWeight;
    }
    
}
