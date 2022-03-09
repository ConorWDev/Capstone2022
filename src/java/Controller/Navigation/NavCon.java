/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Navigation;

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
 * @author Conor
 */
@WebServlet(name = "NavCon", urlPatterns = {"/NavCon"})
public class NavCon extends HttpServlet {

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
        /*
        
        DEPRICATED. TODO DELETE
        
        String nav = request.getParameter("nav");
        String logout = request.getParameter("logout");
        HttpSession session = request.getSession();
        
        
        if(logout!=null&&!logout.equals("")){
          session.invalidate();
          request.getRequestDispatcher("/WEB-INF/student/loginV2.jsp").forward(request, response); 
        }
        else if(nav!=null&&!nav.equals("")){
            
            if(nav.equals("home")){
                request.getRequestDispatcher("/WEB-INF/student/home.jsp").forward(request, response); 
            }
            else if(nav.equals("course")){
                request.getRequestDispatcher("/WEB-INF/student/course.jsp").forward(request, response); 
            }
            else if(nav.equals("reportcard")){
                request.getRequestDispatcher("/WEB-INF/student/reportcard.jsp").forward(request, response); 
            }
            else if(nav.equals("schedule")){
                request.getRequestDispatcher("/WEB-INF/student/schedule.jsp").forward(request, response); 
            }
            else{
              request.getRequestDispatcher("/WEB-INF/student/home.jsp").forward(request, response);   
            }
        }
        else{
        
         
          request.getRequestDispatcher("/WEB-INF/student/home.jsp").forward(request, response); 
        }
        
        
        */
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
