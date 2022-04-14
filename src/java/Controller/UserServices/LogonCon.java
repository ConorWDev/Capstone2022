/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.UserServices;

import DBOperations.DBOperationsLogin;
import Interface.Users.Admin;
import Interface.Users.Faculty;
import Interface.Users.Student;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * To use LogonService class, a user must enter credentials with the following prerequisites in mind. 
 * 1) webUsername from login.jsp 2) webPassword from login.jsp
 * The class will transact with the database and point the user in the right direction.
 * @author Altamish Lalani
 * 
 */
@WebServlet(name = "LogonCon", urlPatterns = {"/LogonCon"})
public class LogonCon extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String webUsername = request.getParameter("username");
        String webPassword = request.getParameter("password");

        //initial catch for first time entering the site. Send user to the login screen
        if (webUsername == null && webPassword == null) {
            request.getRequestDispatcher("WEB-INF/student/loginV2.jsp").forward(request, response);

        } 
        //if username or password fields are left empty redirect to login page with error message
        else if (webUsername.equals("") || webPassword.equals("")) {
            request.setAttribute("message", "Sorry, please enter both<br>Username and Password to sign in.");
            request.getRequestDispatcher("WEB-INF/student/loginV2.jsp").forward(request, response);
        } 
        //Username and password entered. We now must check that the entry was valid, as well as what usertype is
        //logging on
        else {

            //session object for storring values within the session scope. As of Feb.19 we are only holding info relevant
            //to student users (studentid and a student object that holds general info for a given student--see Student.java)
            HttpSession session = request.getSession();
            
            //Here we are creating an instance of DBOperations login. This class contains methods for
            //determining of the user who is loggin in is a student, faculty, or admin type user.
            DBOperationsLogin dbOps = new DBOperationsLogin();
            Boolean isStudent = dbOps.isStudent(webUsername, webPassword);
            Boolean isFaculty = dbOps.isFaculty(webUsername, webPassword);
            Boolean isAdmin = dbOps.isAdmin(webUsername, webPassword);
            
            //a valid student is logging in
            if (isStudent) {

                ServletContext application = getServletContext();

                if (application.getAttribute("usercount") == null) {
                    application.setAttribute("usercount", 0);
                }

                int userCount = (Integer) application.getAttribute("usercount");
                userCount++;
                application.setAttribute("usercount", userCount);

                session.setAttribute("username", webUsername);
                session.setAttribute("student", new Student(webUsername));

                request.getRequestDispatcher("/SiteNavigation").forward(request, response);
            }
            else if (isFaculty){
                ServletContext application = getServletContext();

                if (application.getAttribute("usercount") == null) {
                    application.setAttribute("usercount", 0);
                }

                int userCount = (Integer) application.getAttribute("usercount");
                userCount++;
                application.setAttribute("usercount", userCount);

                session.setAttribute("username", webUsername);
                session.setAttribute("faculty", new Faculty(webUsername));

                request.getRequestDispatcher("/SiteNavigationFaculty").forward(request, response);
            }
            else if (isAdmin){
                
                ServletContext application = getServletContext();

                if (application.getAttribute("usercount") == null) {
                    application.setAttribute("usercount", 0);
                }

                int userCount = (Integer) application.getAttribute("usercount");
                userCount++;
                application.setAttribute("usercount", userCount);
                
                session.setAttribute("username", webUsername);
                session.setAttribute("admin", new Admin(webUsername));

                request.getRequestDispatcher("/SiteNavigationAdmin").forward(request, response);
            }
            //Username and password do not match in ma_student, ma_faculty, or ma_admin tables
            else {
                request.setAttribute("message", "Hmmm, I don't recognize that username or password. Try again &#128512;");
                request.getRequestDispatcher("WEB-INF/student/loginV2.jsp").forward(request, response);
            }
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
