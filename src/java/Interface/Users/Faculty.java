/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Users;

import DBOperations.DBOperationsFaculty;

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
    
    //for admin form, need separate first/middle/last name
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    
    /**
     *
     * @param userID
     */
    public Faculty(String userID){
        this.userID = userID;
        this.fullName = dbOps.getFacultyName(userID);
        this.email = dbOps.getFacultyEmail(userID); 
        
        this.firstName = dbOps.getFirstname(userID);
        this.middleName = dbOps.getMiddlename(userID);
        this.lastName = dbOps.getLastname(userID);
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     *
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getFullName() {
        return fullName;
    }
    
    /**
     *
     * @return
     */
    public String getDisplayName(){
        
        return fullName.toUpperCase();
    }

    /**
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
