/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Users;

import DBOperations.DBOperationsAdmin;

/**
 * Admin.java
 * 
 * The Admin object is a transitory Java Bean object that helps 
 * a user call specific information based on their unique identity. In this
 * case, its admin.
 * @author ryanc
 */
public class Admin {
    
    DBOperationsAdmin dbOps = new DBOperationsAdmin();
    
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
     * gets the admin information based on user id
     * @param userID String
     */
    public Admin(String userID){
        this.userID = userID;
        this.fullName = dbOps.getAdminName(userID);
        this.email = dbOps.getAdminEmail(userID); 
        
        this.firstName = dbOps.getFirstname(userID);
        this.middleName = dbOps.getMiddlename(userID);
        this.lastName = dbOps.getLastname(userID);
    }

    /**
     * gets the first name of the particular admin
     * @return firstName String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name of the particular admin
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets the middle name of the particular admin
     * @return middleName String
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * sets the middle name of the particular admin
     * @param middleName String
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * gets the last name of the particular admin
     * @return lastName String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name of the particular admin
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets the particular admin contained in the database
     * @return dbOps DBOperationsAdmin
     */
    public DBOperationsAdmin getDbOps() {
        return dbOps;
    }

    /**
     * sets the particular admin contained in the database
     * @param dbOps DBOperationsAdmin
     */
    public void setDbOps(DBOperationsAdmin dbOps) {
        this.dbOps = dbOps;
    }

    /**
     * gets the user id of the particular admin
     * @return userID String
     */
    public String getUserID() {
        return userID;
    }

    /**
     * sets the user id of the particular admin
     * @param userID String
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * gets the email of the particular admin
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the email of the particular admin
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets the full name of the particular admin
     * @return fullName String
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * sets the full name of the particular admin
     * @param fullName String
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}
