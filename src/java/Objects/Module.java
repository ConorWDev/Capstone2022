/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * A Module object is a module that is related to a particular lesson. This object
 * holds the module of a particular lesson for a particular student
 * @author Administrator
 */
public class Module {
    
    private String lessonId;
    private String name;
    private String description;

    /**
     * empty constructor
     */
    public Module() {
    }

    /**
     * Constructor Overloading 
     * @param lessonId
     * @param name
     * @param description
     */
    public Module(String lessonId, String name, String description) {
        this.lessonId = lessonId;
        this.name = name;
        this.description = description;
        
    }

    /**
     * gets the lesson id for the particular module
     * @return lessonId String
     */
    public String getLessonId() {
        return lessonId;
    }

    /**
     * sets the lesson id for the particular module
     * @param lessonId String
     */
    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
    
    /**
     * gets the name of the lesson for the particular module
     * @return name String
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the lesson for the particular module
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the description of the lesson for the particular module
     * @return description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the description of the lesson for the particular module
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

}