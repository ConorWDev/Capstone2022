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
 *The student object is a transitory Java Bean object that helps a user call specific information based on their unique identity. 
 * In this case, its a student.
 * @author Altamish Lalani
 * Student.java
 * 
 * 
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
     * gets the student information based on user id
     * @param userID String
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
     * gets the first name of the particular student
     * @return firstName String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name of the particular student
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets the middle name of the particular student
     * @return middleName String
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * sets the middle name of the particular student
     * @param middleName String
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * gets the last name of the particular student
     * @return lastName String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name of the particular student
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets the user id of the particular student
     * @return userID String
     */
    public String getUserID() {
        return userID;
    }

    /**
     * gets the email of the particular student
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * gets the full name of the particular student
     * @return fullName String
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * gets the cohort id of the particular student
     * @return cohortID String
     */
    public String getCohortID() {
        return cohortID;
    }

   
    
}
