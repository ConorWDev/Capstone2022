/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package Controller.Navigation;
import DBOperations.DBOperationsAnnouncement;
import DBOperations.DBOperationsAssignments;
import DBOperations.DBOperationsCohort;
import DBOperations.DBOperationsCourse;
import DBOperations.DBOperationsDocument;
import DBOperations.DBOperationsGeneral;
import DBOperations.DBOperationsGrade;
import DBOperations.DBOperationsModule;
import DBOperations.DBOperationsSchedule;
import DBOperations.DBOperationsStudent;
import Interface.Users.Student;
import Objects.Announcement;
import Objects.Assignment;
import Objects.Cohort;
import Objects.Course;
import Objects.CourseAnnouncement;
import Objects.Document;
import Objects.Grade;
import Objects.Module;
import Objects.Schedule;
import Objects.StudentCourse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *The SiteNavigation is to help student user to navigate each student jsp page.
 * 'nav' functions as feeding to navigate different jsp page depending on the requests.
 * Each else if block requires specific variable to load related information
 * @author massvm
 * 
 */
@WebServlet(name = "SiteNavigation", urlPatterns = {"/SiteNavigation"})
public class SiteNavigation extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Getting Any Data We Need from the page
        
        /**
         * Here we obtain from the HttpSession object...
         * 1) the username of the student ex.cmc21-00001
         * 2) a Student object called student which hold information about the student object created at login
         */
        HttpSession session = request.getSession();
        String username = (String)(session.getAttribute("username"));
        Student student = (Student)session.getAttribute("student");
        
        //obtaining values from request scope
        String nav = request.getParameter("nav");
        String logout = request.getParameter("logout");
                
        //passed for particular course/module logic. i.e, loading data from a particular course/module 
        String courseid = request.getParameter("courseid");
        String moduleid = request.getParameter("moduleid");
        
        //DBOperations classes are instantiated
        DBOperationsAnnouncement dbOpsAn = new DBOperationsAnnouncement();
        DBOperationsGeneral dbOpsGen = new DBOperationsGeneral();
        DBOperationsGrade dbOpsGrade = new DBOperationsGrade();
        DBOperationsStudent dbOpsStud = new DBOperationsStudent();
        DBOperationsModule dbOpsMod = new DBOperationsModule();
        DBOperationsCourse dbOpsCor = new DBOperationsCourse();
        DBOperationsAssignments dbOpsAss = new DBOperationsAssignments();
        DBOperationsDocument dbOpsDoc = new DBOperationsDocument();
        DBOperationsCohort dbOpsCoh = new DBOperationsCohort();
        DBOperationsSchedule dbOpsSch = new DBOperationsSchedule();
        
        //LogOut Block
        if(logout!=null&&!logout.equals("")){
          session.invalidate();
          request.setAttribute("message", "User successfully logged out.");
          request.getRequestDispatcher("/WEB-INF/student/loginV2.jsp").forward(request, response); 
        }
        //Navigation Block for Nav Bar
        else if(nav!=null&&!nav.equals("")){
            if(nav.equals("home")){
                //this code is copy pasted from the final else statment. May change this
                String cohortID = student.getCohortID();
                ArrayList<Announcement> announcements = dbOpsAn.getCohortAnnouncements(cohortID);
                request.setAttribute("announcements", announcements);

                ArrayList<Course> courses = dbOpsCor.getCourses(username);
                request.setAttribute("courses", courses);
                
                request.getRequestDispatcher("/WEB-INF/student/home.jsp").forward(request, response); 
            }
            /**
             * The reportcard else if block requires one variables to dynamically load reportcard information
             * 1) the username of the student (which is obtained above from the session scope)
             *
             * This variable is used within the getStudentCourses method to obtain an arraylist of studentCourse objects that
             * is then fed via an attribute to the reportcard page
             */
            else if(nav.equals("reportcard")){
                ArrayList<StudentCourse> courses = dbOpsGrade.getStudentCourses(username);
                request.setAttribute("courses", courses);
                request.getRequestDispatcher("/WEB-INF/student/reportcard.jsp").forward(request, response); 
            }
            else if(nav.equals("schedule")){
                String cohortID = student.getCohortID();
                Schedule schedule = dbOpsSch.getSchedule(cohortID);
                if (schedule != null){
                    String scheduleID = schedule.getScheduleId();
                    String url = dbOpsSch.getUrl(scheduleID);
                    request.setAttribute("url", url);
                }
               
                
                request.getRequestDispatcher("/WEB-INF/student/schedule.jsp").forward(request, response); 
            }
            /** 
             * The coursemain else if block requires one variable to dynamically load all modules for a specific course
             * 1) the courseID (this is passed through an href redirect on the home page) is used as an argument for getCourseModules
             */
            else if(nav.equals("coursemain")){
                ArrayList<Module> modules = dbOpsMod.getCourseModules(courseid);
                request.setAttribute("modules",modules);
                String courseName = dbOpsCor.getCourseName(courseid);
                request.setAttribute("courseName",courseName);
                request.setAttribute("courseid", courseid);
                
                //Obtain the announcements for the course
                ArrayList<CourseAnnouncement> courseAnnouncements = dbOpsAn.getCourseAnnouncements(courseid); 
                request.setAttribute("courseAnnouncements",courseAnnouncements);
                
                //Obtain users grades for the course
                ArrayList<Grade> courseGrades = dbOpsGrade.getCourseGrades(username, courseid);
                request.setAttribute("courseGrades", courseGrades);
                request.getRequestDispatcher("/WEB-INF/student/coursemain.jsp").forward(request, response);
            }
            /**
             * The announcement else if block requires one variable to dynamically load announcement information
             * 1) the cohortID of the student (which is obtained above from the session scope)
             */
            else if(nav.equals("announcements")){
                ArrayList<Announcement> announcements = dbOpsAn.getCohortAnnouncements(student.getCohortID());
                request.setAttribute("announcements", announcements);
                request.getRequestDispatcher("/WEB-INF/student/announcements.jsp").forward(request, response); 
            }
            /**
             * The coursegrade else if block requires two variables to dynamically load courseGrade information
             * 1) the username of the student (which is obtained above from the session scope)
             * 2) the courseid (which is passed via an href variable in reportcard TODO as well as eventually from courseMain link)
             *
             * These two variables are used within the getCourseGrade method to obtain an arraylist of courseGrade objects that
             * is then fed via an attribute to the courseGrade page
             */
            else if(nav.equals("coursegrade")){
                ArrayList<Grade> courseGrades = dbOpsGrade.getCourseGrades(username, courseid);
                request.setAttribute("courseGrades", courseGrades);
                
                request.getRequestDispatcher("/WEB-INF/student/coursegrade.jsp").forward(request, response); 
            }
            
            else if(nav.equals("modulemain")){
                String moduleName = dbOpsMod.getModuleName(moduleid);
                request.setAttribute("moduleName", moduleName);
                String moduleDescription = dbOpsMod.getModuleDescription(moduleid);
                request.setAttribute("moduleDescription", moduleDescription);
                
                
                ArrayList<Assignment> assignments = dbOpsAss.getModuleAssignments(moduleid);
                request.setAttribute("assignments", assignments);
                
                ArrayList<Document> documents = dbOpsDoc.getModuleDocument(moduleid);
                request.setAttribute("documents", documents);
                
                request.getRequestDispatcher("/WEB-INF/student/modulemain.jsp").forward(request, response); 
            }
            
        }
        else{
        //The following setAttribute calls are done with attibutes that dynamically load upon entering the main page
        //This includes announcments as well as courses for a specfic cohort
        
        //Note: Currently only one cohort ID per student is being allowed. This is contrary to what is currently possible
        //within the ERD. The DB may have to be changed in order to mirror this requirement
        String cohortID = student.getCohortID();
        ArrayList<Announcement> announcements = dbOpsAn.getCohortAnnouncements(cohortID);
        request.setAttribute("announcements", announcements);
        
        Cohort cohort = dbOpsCoh.getCohort(cohortID);
        String cohortNameMain = cohort.getCohortName();
        session.setAttribute("cohortNameMain", cohortNameMain);
        
        ArrayList<Course> courses = dbOpsCor.getCourses(username);
        request.setAttribute("courses", courses);
        
        request.getRequestDispatcher("/WEB-INF/student/home.jsp").forward(request, response); 
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}