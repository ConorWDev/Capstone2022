/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Navigation;

import Interface.Users.Admin;
import Interface.Users.Faculty;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ryanc
 */
@WebServlet(name = "SiteNavigationAdmin", urlPatterns = {"/SiteNavigationAdmin"})
public class SiteNavigationAdmin extends HttpServlet {

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
        //get session object admin
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        
        //obtaining values from request scope
        String nav = request.getParameter("nav");
        String logout = request.getParameter("logout");
        
        
         if(logout!=null&&!logout.equals("")){
          session.invalidate();
          request.setAttribute("message", "User successfully logged out.");
          request.getRequestDispatcher("/WEB-INF/student/loginV2.jsp").forward(request, response); 
        }
        else if(nav!=null&&!nav.equals("")){
            
            if(nav.equals("users")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            }
            
            else if(nav.equals("assignments")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            }
            
            else if(nav.equals("modules")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            }
            
            else if(nav.equals("courses")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            }
            
            else if(nav.equals("cohorts")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            }
            
            else if(nav.equals("annoucements")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            
            }
            else if(nav.equals("adminreport")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            
            }
            
            else if(nav.equals("adminarchive")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            }
            
            else if(nav.equals("adminbr")){
                request.getRequestDispatcher("/WEB-INF/admin/XXX.jsp").forward(request, response);
            }
            
            else{
                request.getRequestDispatcher("/WEB-INF/admin/AdminLanding.jsp").forward(request, response);
            }
            
        }
        //first time the admin is logging in
        else{
            
            request.getRequestDispatcher("/WEB-INF/admin/AdminLanding.jsp").forward(request, response);
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
