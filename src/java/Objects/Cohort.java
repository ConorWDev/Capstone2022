/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * This Cohort object holds the id and name of a particular cohort
 * @author massvm
 */
public class Cohort {
    String cohortID;
    String cohortName;

    /**
     * Constructor
     * @param cohortID String
     * @param cohortName String
     */
    public Cohort(String cohortID, String cohortName) {
        this.cohortID = cohortID;
        this.cohortName = cohortName;
    }

    /**
     * gets the id of the particular cohort
     * @return cohortID String
     */
    public String getCohortID() {
        return cohortID;
    }

    /**
     * sets the id of the particular cohort
     * @param cohortID String
     */
    public void setCohortID(String cohortID) {
        this.cohortID = cohortID;
    }

    /**
     * gets the name of the particular cohort
     * @return cohortName String
     */
    public String getCohortName() {
        return cohortName;
    }

    /**
     * sets the name of the particular cohort
     * @param cohortName String
     */
    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }
    
}
