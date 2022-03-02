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
public class Assignment {
    
    
    private String assignmentId = "";
    private String assignmentName = "";
    private String assignmentDescription = "";
    private String assignmentUrl = "";
    private double assignmentWeight;
    
    
    public Assignment (String assignmentId, String assignmentName, String assignmentDescription, String assignmentUrl, double assignmentWeight){
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.assignmentUrl = assignmentUrl;
        this.assignmentWeight = assignmentWeight;
    }


    public String getassignmentId() {
        return assignmentId;
    }

    public void setassignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getassignmentName() {
        return assignmentName;
    }

    public void setassignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getassignmentDescription() {
        return assignmentDescription;
    }

    public void setassignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }
    
    public String getassignmentUrl() {
        return assignmentUrl;
    }
    
    public void setassignmentUrl(String assignmentUrl) {
        this.assignmentUrl = assignmentUrl;
    }
    
    public double getassignmentWeight() {
        return assignmentWeight;
    }
    
    public void setassignmentWeight(double assignmentWeight) {
        this.assignmentWeight = assignmentWeight;
    }
    
}
