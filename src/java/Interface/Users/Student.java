/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Users;

import DBOperations.DBOperationsStudent;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Altamish Lalani
 * Student.java
 * 
 * The student object is a transitory Java Bean object that helps 
 * a user call specific information based on their unique identity.
 */
public class Student implements Serializable {
    
    DBOperationsStudent dbOps = new DBOperationsStudent();
    
    private String userID = "";
    private String email = "";
    //opting to store full name within one field
    private String fullName = "";
    private String cohortID = "";

    //for admin form, need separate first/middle/last name
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    
    //Java Bean rule
    Student(){}
    
    //Overloaded Constructor

    /**
     *
     * @param userID
     */
    public Student(String userID){
        this.userID = userID;
        this.fullName = dbOps.getStudentName(userID);
        this.email = dbOps.getStudentEmail(userID);
        this.cohortID = dbOps.getCohortID(userID);
        
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
     * @return
     */
    public String getEmail() {
        return email;
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
    public String getCohortID() {
        return cohortID;
    }

   
    
}
