/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Users;

import DBOperations.DBOperationsAdmin;

/**
 *
 * @author ryanc
 */
public class Admin {
    
    DBOperationsAdmin dbOps = new DBOperationsAdmin();
    
    private String userID = "";
    private String email = "";
    //opting to store full name within one field
    private String fullName = "";
    
    public Admin(String userID){
        this.userID = userID;
        this.fullName = dbOps.getAdminName(userID);
        this.email = dbOps.getAdminEmail(userID); 
    }

    public DBOperationsAdmin getDbOps() {
        return dbOps;
    }

    public void setDbOps(DBOperationsAdmin dbOps) {
        this.dbOps = dbOps;
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
    
}
