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
import Interface.Users.Student;
import Objects.Announcement;
import Objects.Assignment;
import Objects.Course;
import Objects.Cohort;
import Objects.Document;
import Objects.Grade;
import Objects.Module;
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
        String moduleID = request.getParameter("moduleid");
        //the parameter cohortid and cohort name are retrieved from fac_home.jsp announcement form
        String cohortID = request.getParameter("cohortid");
        String cohortName = request.getParameter("cohortname");
        //studentid and studentname passed from fac_grades.jsp
        String studentID = request.getParameter("studentid");
        String studentName = request.getParameter("studentname");
        
        
        //TODO search functionality on grades page
        String search = request.getParameter("search");
        
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
           //navigating to course main
            if (nav.equals("coursemain")){
               //load list of modules for associated course
               ArrayList<Module> modules = dbOpsMod.getCourseModules(courseID);
               request.setAttribute("modules",modules);
               //get course name
               String courseName = dbOpsCor.getCourseName(courseID);
               request.setAttribute("courseName",courseName);
               //direct to coursemain page
               request.getRequestDispatcher("/WEB-INF/faculty/fac_coursemain.jsp").forward(request, response);
           }
            //navigating to modulemain
            else if (nav.equals("modulemain")){
                //get module name
                String moduleName = dbOpsMod.getModuleName(moduleID);
                request.setAttribute("moduleName", moduleName);
                //get module description
                String moduleDescription = dbOpsMod.getModuleDescription(moduleID);
                request.setAttribute("moduleDescription", moduleDescription);
                //get assignments for module
                ArrayList<Assignment> assignments = dbOpsAss.getModuleAssignments(moduleID);
                request.setAttribute("assignments", assignments);
                //get documents for module
                ArrayList<Document> documents = dbOpsDoc.getModuleDocument(moduleID);
                request.setAttribute("documents", documents);
                //direct to module main
                request.getRequestDispatcher("/WEB-INF/faculty/fac_modulemain.jsp").forward(request, response); 
            }
            //navigating to grades page
            else if (nav.equals("grades")){
                
                ArrayList<Cohort> cohorts = dbOpsCo.getCohorts(faculty.getUserID());
                request.setAttribute("cohorts", cohorts);
                //an array list of arraylists. In the case that a teacher teaches across multiple cohorts, we need to be able
                //to store the student list of each cohort
                ArrayList<ArrayList> studentLists = new ArrayList<>();
                for(int x =0; x < cohorts.size(); x++){
                    ArrayList<Student> students = dbOpsStud.getStudentsByCohort(cohorts.get(x).getCohortID());
                    studentLists.add(students);
                }
                request.setAttribute("studentLists", studentLists);
                
                
                request.getRequestDispatcher("/WEB-INF/faculty/fac_grades.jsp").forward(request, response);   
            }
            //navigating to student grades page
            else if (nav.equals("studentgrades")){
                //get a list of grades for all assignments of a particular student 
                ArrayList<Grade> studentGrades = dbOpsGrade.getGrades(studentID);
                request.setAttribute("studentGrades", studentGrades);
                request.setAttribute("studentName", studentName);
                
                request.getRequestDispatcher("/WEB-INF/faculty/fac_studentgrades.jsp").forward(request, response);   
            }
            //faculty has selected view all announcements on fac_home.jsp
            else if (nav.equals("cohortannouncements")){
                
                ArrayList<Announcement> announcements = dbOpsAn.getCohortAnnouncements(cohortID);
                request.setAttribute("announcements", announcements);
                request.setAttribute("cohortName", cohortName);
                
                request.getRequestDispatcher("/WEB-INF/faculty/fac_cohortannouncements.jsp").forward(request, response);
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
