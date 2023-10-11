/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 * This Attendance object holds the id, name, whether student was present or not
 * and the date for the student
 * @author ryanc
 */
public class Attendance {
    
    String attendance_id;
    String student_username;
    Boolean present;
    String date;

    /**
     * Constructor
     * @param attendance_id String
     * @param student_username String
     * @param present String
     * @param date String
     */
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

    /**
     * gets the id of the attendance for the particular student
     * @return attendance_id String
     */
    public String getAttendance_id() {
        return attendance_id;
    }

    /**
     * sets the id of the attendance for the particular student
     * @param attendance_id String
     */
    public void setAttendance_id(String attendance_id) {
        this.attendance_id = attendance_id;
    }

    /**
     * gets the student name for the attendance 
     * @return student_username String
     */
    public String getStudent_username() {
        return student_username;
    }

    /**
     * sets the student name for the attendance 
     * @param student_username String
     */
    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    /**
     * checks and gets whether the student was present or not
     * @return present Boolean
     */
    public Boolean getPresent() {
        return present;
    }

    /**
     * checks and sets whether the student was present or not
     * @param present Boolean
     */
    public void setPresent(Boolean present) {
        this.present = present;
    }

    /**
     * gets the date for the attendance
     * @return date String
     */
    public String getDate() {
        return date;
    }

    /**
     * sets the date for the attendance
     * @param date String
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
}
