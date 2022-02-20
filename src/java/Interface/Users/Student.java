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

    
    //Java Bean rule
    Student(){}
    
    //Overloaded Constructor
    public Student(String userID){
        this.userID = userID;
        this.fullName = dbOps.getStudentName(userID);
        this.email = dbOps.getStudentEmail(userID);
        this.cohortID = dbOps.getCohortID(userID);
    }

    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCohortID() {
        return cohortID;
    }

   
    
}
