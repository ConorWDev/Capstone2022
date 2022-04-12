/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author massvm
 */
public class Cohort {
    String cohortID;
    String cohortName;

    /**
     *
     * @param cohortID
     * @param cohortName
     */
    public Cohort(String cohortID, String cohortName) {
        this.cohortID = cohortID;
        this.cohortName = cohortName;
    }

    /**
     *
     * @return
     */
    public String getCohortID() {
        return cohortID;
    }

    /**
     *
     * @param cohortID
     */
    public void setCohortID(String cohortID) {
        this.cohortID = cohortID;
    }

    /**
     *
     * @return
     */
    public String getCohortName() {
        return cohortName;
    }

    /**
     *
     * @param cohortName
     */
    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }
    
}
