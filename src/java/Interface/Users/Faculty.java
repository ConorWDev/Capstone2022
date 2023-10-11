/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Users;

import DBOperations.DBOperationsFaculty;

/**
 * Faculty.java
 * 
 * The faculty object is a transitory Java Bean object that helps 
 * a user call specific information based on their unique identity. In this
 * case, its faculty member.
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
     * Constructor
     * gets the faculty information based on their user id
     * @param userID String
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
     * gets the first name of the particular faculty member
     * @return firstName String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name of the particular faculty member
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets the middle name of the particular faculty member
     * @return middleName String
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * sets the middle name of the particular faculty member
     * @param middleName String
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * gets the last name of the particular faculty member
     * @return lastName String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name of the particular faculty member
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets the user id of the particular faculty member
     * @return userID String
     */
    public String getUserID() {
        return userID;
    }

    /**
     * sets the userID of the particular faculty member
     * @param userID String
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * gets the email of the particular faculty member
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the email of the particular faculty member
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets the full name of the particular faculty member
     * @return fullName String
     */
    public String getFullName() {
        return fullName;
    }
    
    /**
     * gets the name to be displayed of the particular faculty member
     * @return fullName String
     */
    public String getDisplayName(){
        
        return fullName.toUpperCase();
    }

    /**
     * sets the full name of the particular faculty member
     * @param fullName String
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
