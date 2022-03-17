/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author ryanc
 */
public class Attendance {
    
    String attendance_id;
    String student_username;
    Boolean present;
    String date;

    public Attendance(String attendance_id, String student_username, String present, String date) {
        this.attendance_id = attendance_id;
        this.student_username = student_username;
        this.date = date;
        
        if (present.equals("Y")){
            this.present = true;
        }
        else{
            this.present = false;
        }
    }

    public String getAttendance_id() {
        return attendance_id;
    }

    public void setAttendance_id(String attendance_id) {
        this.attendance_id = attendance_id;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public Boolean getPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}