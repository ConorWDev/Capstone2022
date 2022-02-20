/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;


public class Module {
    
    private String lessonId;
    private String name;
    private String description;

    public Module() {
    }

    public Module(String lessonId, String name, String description) {
        this.lessonId = lessonId;
        this.name = name;
        this.description = description;
        
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}