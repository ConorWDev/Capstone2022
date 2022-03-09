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
import DBOperations.DBOperationsStudent;
import Interface.Users.Faculty;
import Objects.Announcement;
import Objects.Course;
import Objects.Cohort;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "SiteNavigationFaculty", urlPatterns = {"/SiteNavigationFaculty"})
public class SiteNavigationFaculty extends HttpServlet {

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
        
        //get session object faculty
        HttpSession session = request.getSession();
        Faculty faculty = (Faculty)session.getAttribute("faculty");
        
        //obtaining values from request scope
        String nav = request.getParameter("nav");
        String logout = request.getParameter("logout");
        
        String courseID = request.getParameter("courseid");
        
        DBOperationsCohort dbOpsCo = new DBOperationsCohort();
        DBOperationsModule dbOpsMod = new DBOperationsModule();
        DBOperationsAnnouncement dbOpsAn = new DBOperationsAnnouncement();
        DBOperationsGeneral dbOpsGen = new DBOperationsGeneral();
        DBOperationsGrade dbOpsGrade = new DBOperationsGrade();
        DBOperationsStudent dbOpsStud = new DBOperationsStudent();
        DBOperationsCourse dbOpsCor = new DBOperationsCourse();
        DBOperationsAssignments dbOpsAss = new DBOperationsAssignments();
        DBOperationsDocument dbOpsDoc = new DBOperationsDocument();
        
        if(logout!=null&&!logout.equals("")){
          session.invalidate();
          request.setAttribute("message", "User successfully logged out.");
          request.getRequestDispatcher("/WEB-INF/student/loginV2.jsp").forward(request, response); 
        }
        else if(nav!=null&&!nav.equals("")){
           if (nav.equals("coursemain")){
               ArrayList<Objects.Module> modules = dbOpsMod.getCourseModules(courseID);
                request.setAttribute("modules",modules);
                String courseName = dbOpsCor.getCourseName(courseID);
                request.setAttribute("courseName",courseName);
               
               
               request.getRequestDispatcher("/WEB-INF/faculty/fac_coursemain.jsp").forward(request, response);
           }
        }
        //if faculty is logging in for first time
        else{
            ArrayList<Cohort> cohorts = dbOpsCo.getCohorts(faculty.getUserID());
            request.setAttribute("cohorts", cohorts);
            
            //an array list of arraylists. In the case that a teacher teaches across multiple cohorts, we need to be able
            //to store the course list of each cohort
            ArrayList<ArrayList> courseLists = new ArrayList<>();
            //similarly we need to hold the list of announcements for every cohort
            ArrayList<ArrayList> announcementList = new ArrayList<>();
           //loop through the list of cohorts. For each cohort obtain the list of courses for that cohort and add that to the list of course lists
           //similarly for announcment. For each cohort, obtain the list of announcements and add that to the list of announcement lists
            for(int x =0; x < cohorts.size(); x++){
               ArrayList<Course> courses = dbOpsCor.getCoursesByCohort(cohorts.get(x).getCohortID());
               courseLists.add(courses);
               ArrayList<Announcement> announcements = dbOpsAn.getCohortAnnouncements(cohorts.get(x).getCohortID());
               announcementList.add(announcements);
           } 
           //here our list of lists is added to the request attribute for use in fac_home.jsp
           request.setAttribute("courseLists", courseLists);
           request.setAttribute("announcementLists", announcementList);
            
           request.getRequestDispatcher("/WEB-INF/faculty/fac_home.jsp").forward(request, response);
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
