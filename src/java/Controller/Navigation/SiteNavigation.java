/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package Controller.Navigation;
import DBOperations.DBOperationsAnnouncement;
import DBOperations.DBOperationsGrade;
import Interface.Users.Student;
import Objects.Announcement;
import Objects.Grade;
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
        String nav = request.getParameter("nav");
        String logout = request.getParameter("logout");
        HttpSession session = request.getSession();
        String course = request.getParameter("course#");
        //Needs to change to get this from 
        session.setAttribute("studentname", "Adam Ascot");
        session.setAttribute("username", "cmc21-00001");
        Student student = new Student("cmc21-00001");
        DBOperationsAnnouncement dbOpsAn = new DBOperationsAnnouncement();
       /*
        try {
            ArrayList<Announcement> homeAnnoucements=dbOpsAn.getCohortAnnouncements("1");
            request.setAttribute("Announcements", homeAnnoucements);
        } catch (Exception ex) {
            Logger.getLogger(SiteNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        if(logout!=null&&!logout.equals("")){
          session.invalidate();
          request.setAttribute("message", "User successfully logged out.");
          request.getRequestDispatcher("/WEB-INF/student/loginV2.jsp").forward(request, response); 
        }
        else if(nav!=null&&!nav.equals("")){
            if(nav.equals("home")){
                request.getRequestDispatcher("/WEB-INF/student/home.jsp").forward(request, response); 
            }
            else if(nav.equals("courses")){
                
                request.getRequestDispatcher("/WEB-INF/student/courselist.jsp").forward(request, response); 
            }
            else if(nav.equals("reportcard")){
                String username = (String)(session.getAttribute("username"));
                
                DBOperationsGrade dbOps = new DBOperationsGrade();
                ArrayList<StudentCourse> courses = dbOps.getStudentCourses(username);
                request.setAttribute("courses", courses);
                request.getRequestDispatcher("/WEB-INF/student/reportcard.jsp").forward(request, response); 
            }
            else if(nav.equals("schedule")){
                request.getRequestDispatcher("/WEB-INF/student/schedule.jsp").forward(request, response); 
            }
            else if(nav.equals("courselist")){
                request.getRequestDispatcher("/WEB-INF/student/courselist.jsp").forward(request, response); 
            }
            else if(nav.equals("coursemain")){
                request.getRequestDispatcher("/WEB-INF/student/coursemain.jsp").forward(request, response); 
            }
            else if(nav.equals("announcements")){
                request.getRequestDispatcher("/WEB-INF/student/announcements.jsp").forward(request, response); 
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