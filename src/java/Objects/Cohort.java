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

    public Cohort(String cohortID, String cohortName) {
        this.cohortID = cohortID;
        this.cohortName = cohortName;
    }

    public String getCohortID() {
        return cohortID;
    }

    public void setCohortID(String cohortID) {
        this.cohortID = cohortID;
    }

    public String getCohortName() {
        return cohortName;
    }

    public void setCohortName(String cohortName) {
        this.cohortName = cohortName;
    }
    
}
