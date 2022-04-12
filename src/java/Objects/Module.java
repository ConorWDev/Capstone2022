/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Administrator
 */
public class Module {
    
    private String lessonId;
    private String name;
    private String description;

    /**
     *
     */
    public Module() {
    }

    /**
     *
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
     *
     * @return
     */
    public String getLessonId() {
        return lessonId;
    }

    /**
     *
     * @param lessonId
     */
    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}