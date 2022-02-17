/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.UserServices;

import DBOperations.DBOperationsGeneral;
import Interface.Users.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Altamish Lalani
 *
 *
 * To use LogonService class, a user must enter credentials from the following
 * prerequisites. 1) webUsername from login.jsp 2) webPassword from login.jsp
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

        boolean login = false;

        if (webUsername == null && webPassword == null) {
            //TESTING********************************************************************
            request.setAttribute("message", "TestPASSED!");

            request.getRequestDispatcher("WEB-INF/student/login.jsp").forward(request, response);

        } else if (webUsername.equals("") || webPassword.equals("")) {
            request.setAttribute("message", "Both values are required!");
            request.getRequestDispatcher("WEB-INF/student/login.jsp").forward(request, response);
        } //Check a valid entry
        else {

            DBOperationsGeneral dbOps = new DBOperationsGeneral();

            HttpSession session = request.getSession();

            String result = dbOps.login(webUsername, webPassword);

            if (result.equals("1")) {
                login = true;
            }
//PASSED
            if (login) {

                ServletContext application = getServletContext();

                if (application.getAttribute("usercount") == null) {
                    application.setAttribute("usercount", 0);
                }

                int userCount = (Integer) application.getAttribute("usercount");
                userCount++;
                application.setAttribute("usercount", userCount);

                session.setAttribute("username", webUsername);
                session.setAttribute("student", new Student(webUsername));

                request.getRequestDispatcher("/NavCon").forward(request, response);
            } else {
                request.setAttribute("message", "Invalid username or password!");
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
