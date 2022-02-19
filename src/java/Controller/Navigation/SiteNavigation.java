/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package Controller.Navigation;
import DBOperations.DBOperationsAnnouncement;
import DBOperations.DBOperationsGeneral;
import DBOperations.DBOperationsGrade;
import DBOperations.DBOperationsModule;
import Interface.Users.Student;
import Objects.Announcement;
import Objects.Grade;
import Objects.Module;
import Objects.StudentCourse;
import java.io.IOException;
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
 *
 * @author massvm
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
        
        /*Here we obtain from the HttpSession object...
        *  1) the username of the student ex.cmc21-00001
        *  2) a student object which contains attibutes relevant to a particular student 
        */
        HttpSession session = request.getSession();
        String username = (String)(session.getAttribute("username")); 
        Student student = (Student)(session.getAttribute("student"));
        
        //obtaining values from request scope. May be able to clean this up
        String nav = request.getParameter("nav");
        String logout = request.getParameter("logout");
                //note: these two variables seem to hold the same value
                //will come back and determine if they can be one variable
        String courseNumber = request.getParameter("courseNumber");
        String courseid = request.getParameter("courseid");
        
        //DBOperations classes are instantiated
        DBOperationsAnnouncement dbOpsAn = new DBOperationsAnnouncement();
        DBOperationsGeneral dbOpsGen = new DBOperationsGeneral();
        DBOperationsGrade dbOpsGrade = new DBOperationsGrade();
        
        //Obtain the name of the student who is logging in
        String displayname = dbOpsGen.getStudentName(username);
        request.setAttribute("displayname", displayname);
        //request.setAttribute("cohortID","1");
        
        //currently setting the cohortID statically, using within getCohortAnnouncement
        String cohortID = "1";//request.getParameter("cohortId");
        
        
        ArrayList<Announcement> announcements = dbOpsAn.getCohortAnnouncements(cohortID);
        request.setAttribute("announcements", announcements);
        
        //LogOut Block
        if(logout!=null&&!logout.equals("")){
          session.invalidate();
          request.setAttribute("message", "User successfully logged out.");
          request.getRequestDispatcher("/WEB-INF/student/loginV2.jsp").forward(request, response); 
        }
        else if(courseNumber!=null&&!courseNumber.equals("")){
            DBOperationsModule dbOpsMod = new DBOperationsModule();
            ArrayList<Module> modules = dbOpsMod.getAllModules(cohortID);
            
            request.setAttribute("modules", modules);
            request.getRequestDispatcher("/WEB-INF/student/coursemain.jsp").forward(request, response);  
        }
        //Navigation Block for Nav Bar Most of home page
        else if(nav!=null&&!nav.equals("")){
            if(nav.equals("home")){
                request.getRequestDispatcher("/WEB-INF/student/home.jsp").forward(request, response); 
            }
            else if(nav.equals("courses")){
                request.getRequestDispatcher("/WEB-INF/student/courselist.jsp").forward(request, response); 
            }
            else if(nav.equals("reportcard")){
                ArrayList<StudentCourse> courses = dbOpsGrade.getStudentCourses(username);
                request.setAttribute("courses", courses);
                request.getRequestDispatcher("/WEB-INF/student/reportcard.jsp").forward(request, response); 
            }
            else if(nav.equals("schedule")){
                request.getRequestDispatcher("/WEB-INF/student/schedule.jsp").forward(request, response); 
            }
            else if(nav.equals("courselist")){
                request.getRequestDispatcher("/WEB-INF/student/courselist.jsp").forward(request, response);
            }
            //Leaving for now - possible deprecation
            else if(nav.equals("coursemain")){
                request.getRequestDispatcher("/WEB-INF/student/coursemain.jsp").forward(request, response);
            }
            else if(nav.equals("announcements")){
                request.getRequestDispatcher("/WEB-INF/student/announcements.jsp").forward(request, response); 
            }
            /*The course grade else if statement requires two variables to dynamically load courseGrade information
            1) the username of the student (which is obtained above from the session scope)
            2) the courseid (which is passed via an href variable in reportcard TODO as well as eventually from courseMain link)
            
            These two variables are used within the getCourseGrade method to obtain an arraylist of courseGrade objects that
            is then fed via an attribute to the courseGrade page
            */
            else if(nav.equals("coursegrade")){
                ArrayList<Grade> courseGrades = dbOpsGrade.getCourseGrades(username, courseid);
                request.setAttribute("courseGrades", courseGrades);
                request.getRequestDispatcher("/WEB-INF/student/coursegrade.jsp").forward(request, response); 
            }
            else if(nav.equals("coursemodules")){
                request.getRequestDispatcher("/WEB-INF/student/coursemodules.jsp").forward(request, response); 
            }
            else if(nav.equals("assignments")){
                request.getRequestDispatcher("/WEB-INF/student/assignments.jsp").forward(request, response); 
            }
            else{
              request.getRequestDispatcher("/WEB-INF/student/home.jsp").forward(request, response);   
            }
        }
        else{
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