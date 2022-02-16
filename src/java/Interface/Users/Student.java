/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Users;

import java.io.Serializable;

/**
 *
 * @author Altamish Lalani
 * Student.java
 * 
 * The student object is a transitory Java Bean object that helps 
 * a user call specific information based on their unique identity.
 */
public class Student implements Serializable {
    
    //Fields
    private String userID = "";
    private String email;
    private String firstName = "";
    private String lastName = "";

    
    //Java Bean rule
    Student(){}
    
    //Overloaded Constructor
    public Student(String userID){
        this.email = "";
        this.firstName = "";
        this.lastName = "";
       
        //*********Write DBops methods
        /*
        Need to set email, firstname, lastname from DB.
         
        sample Java:
        
        this.email = dbOps.getStudentmail;
        this.firstName = dbOps.getStudentFname;
        this.lastName = dbOps.getStudentLname;
        
        */
        this.userID = userID;
       
    }

    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
}
