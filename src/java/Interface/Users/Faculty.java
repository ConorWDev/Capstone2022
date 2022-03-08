/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Users;

import DBOperations.Faculty.DBOperationsFaculty;

/**
 *
 * @author massvm
 */
public class Faculty {
    
    DBOperationsFaculty dbOps = new DBOperationsFaculty();
    
    private String userID = "";
    private String email = "";
    //opting to store full name within one field
    private String fullName = "";
    private String cohortID = "";
    
    public Faculty(String userID){
        this.userID = userID;
        this.fullName = dbOps.getFacultyName(userID);
        this.email = dbOps.getFacultyEmail(userID);
        
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCohortID() {
        return cohortID;
    }

    public void setCohortID(String cohortID) {
        this.cohortID = cohortID;
    }
}
