/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Navigation;

import DBOperations.DBOperationsAdmin;
import DBOperations.DBOperationsFaculty;
import DBOperations.DBOperationsStudent;
import Interface.Users.Admin;
import Interface.Users.Faculty;
import Interface.Users.Student;
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
        Admin admin = (Admin) session.getAttribute("admin");

        //obtaining values from request scope
        String nav = request.getParameter("nav");
        String logout = request.getParameter("logout");
        String op = request.getParameter("op");
        
        
        DBOperationsStudent dbOpsStud = new DBOperationsStudent();
        DBOperationsFaculty dbOpsFac = new DBOperationsFaculty();
        DBOperationsAdmin dbOpsAd = new DBOperationsAdmin();
        
        
        if(logout!=null&&!logout.equals("")){
          session.invalidate();
          request.setAttribute("message", "User successfully logged out.");
          request.getRequestDispatcher("/WEB-INF/student/loginV2.jsp").forward(request, response); 
        }
        else if(nav!=null&&!nav.equals("")){
            
            if(nav.equals("users")){
                
                //obtain userID from requestScope. use this to populate edit menu
                //this code excecutes when a name is clicked in the main window
                String userID = request.getParameter("userIDs");
                if (userID != null && !userID.equals("")){
                    switch(op){
                    case "1": Student student = new Student(userID);
                              request.setAttribute("username", student.getUserID());
                              request.setAttribute("firstname", student.getFirstName());
                              request.setAttribute("middlename", student.getMiddleName());
                              request.setAttribute("lastname", student.getLastName());
                              request.setAttribute("email", student.getEmail());
                              
                              //obtain password separately
                              String passStudent = dbOpsAd.getStudentPass(userID);
                              request.setAttribute("pass", passStudent);
                              break;
                    case "2": Faculty facultyMember = new Faculty(userID);
                              request.setAttribute("username", facultyMember.getUserID());
                              request.setAttribute("firstname", facultyMember.getFirstName());
                              request.setAttribute("middlename", facultyMember.getMiddleName());
                              request.setAttribute("lastname", facultyMember.getLastName());
                              request.setAttribute("email", facultyMember.getEmail());
                              
                              //obtain password separately
                              String passFaculty = dbOpsAd.getFacultyPass(userID);
                              request.setAttribute("pass", passFaculty);
                             break;
                    case "3": Admin adminMember = new Admin(userID);
                              request.setAttribute("username", adminMember.getUserID());
                              request.setAttribute("firstname", adminMember.getFirstName());
                              request.setAttribute("middlename", adminMember.getMiddleName());
                              request.setAttribute("lastname", adminMember.getLastName());
                              request.setAttribute("email", adminMember.getEmail());
                              
                              //obtain password separately
                              String passAdmin = dbOpsAd.getAdminPass(userID);
                               request.setAttribute("pass", passAdmin);  
                             break;
                    }  
                }
                
                //user is being edited from edit menu
                String editUser = request.getParameter("editUser");
                if(editUser != null && !editUser.equals("")){
                    //obtain menu option selected from form
                    String save = request.getParameter("saveChanges");
                    String delete = request.getParameter("deleteUser");
                    
                    //user has selected to save changes
                    if (save != null && !save.equals("")){
                        String user = request.getParameter("infoUser");
                        String first = request.getParameter("infoFirst");
                        String middle = request.getParameter("infoMiddle");
                        String last = request.getParameter("infoLast");
                        String email = request.getParameter("infoEmail");
                        String pass = request.getParameter("infoPass");
                        
                        switch(op){
                            case "1": boolean resultStud = dbOpsAd.editStudent(user, first, middle, last, email, pass);break;
                            case "2": boolean resultFac = dbOpsAd.editFaculty(user, first, middle, last, email, pass);break;
                            case "3": boolean resultAdmin = dbOpsAd.editAdmin(user, first, middle, last, email, pass);break;
                        }
                    }
                    //user has selected to delete users
                    else if (delete != null && !delete.equals("")){
                        String user = request.getParameter("infoUser");
                         switch(op){
                            case "1": boolean resultStud = dbOpsAd.deleteStudent(user);break;
                            case "2": boolean resultFac = dbOpsAd.deleteFaculty(user);break;
                            case "3": boolean resultAdmin = dbOpsAd.deleteAdmin(user);break;
                        }
                    }
                }
                
                //arraylist for holding whatever type of user is selected
                ArrayList<Student> students = null;
                ArrayList<Faculty> faculty = null;
                ArrayList<Admin> admins = null;
                
                //depending on the option selected, the arraylist will be populated
                //the rest will stay null
                //TODO
                String usertype=null;
                switch(op){
                    case "1": students = dbOpsStud.getAllStudents();usertype= "Student";break;
                    case "2": faculty = dbOpsFac.getAllFaculty();usertype= "Faculty"; break;
                    case "3": admins = dbOpsAd.getAllAdmins();usertype= "Admin"; break;
                }
                
                //assign user type as determined by the above switch statement
                request.setAttribute("usertype", usertype);
             
                //assign arraylists to the session scope
                request.setAttribute("students", students);
                request.setAttribute("faculty", faculty);
                request.setAttribute("admins", admins);
                
                
                request.getRequestDispatcher("/WEB-INF/admin/AdminUsers.jsp").forward(request, response);
            }
            else if(nav.equals("create")){
                
                request.getRequestDispatcher("/WEB-INF/admin/AdminUserCreate.jsp").forward(request, response);
            }
            else if(nav.equals("documents")){
                if (op.equals("1")){
                    request.getRequestDispatcher("/WEB-INF/admin/AdminDocumentCreate.jsp").forward(request, response);
                }
                else{
                    request.getRequestDispatcher("/WEB-INF/admin/AdminDocumentManagement.jsp").forward(request, response);
                }
            }
            
            else if (nav.equals("assignments")) {
                
                if(op.equals("1")){
                    request.getRequestDispatcher("/WEB-INF/admin/AdminAssignmentsCreate.jsp").forward(request, response);
                }
                
                else{
                request.getRequestDispatcher("/WEB-INF/admin/AdminAssignments.jsp").forward(request, response);
                        }
            } 
            
            else if (nav.equals("modules")) {
                
                
                
                if(op.equals("1")){
                   request.getRequestDispatcher("/WEB-INF/admin/AdminModulesCreate.jsp").forward(request, response); 
                }
                else{
                   request.getRequestDispatcher("/WEB-INF/admin/AdminModules.jsp").forward(request, response); 
                }
                
            } 
            
            
            else if (nav.equals("courses")) {
                
                if(op.equals("1")){
                   request.getRequestDispatcher("/WEB-INF/admin/AdminCourseCreate.jsp").forward(request, response); 
                }
                else{
                    request.getRequestDispatcher("/WEB-INF/admin/AdminCourses.jsp").forward(request, response);
                }
                
            } 
            
            
            else if (nav.equals("cohort")) {
                
                if (op.equals("1")){
                request.getRequestDispatcher("/WEB-INF/admin/AdminCohortCreate.jsp").forward(request, response); 
                }
                else {    
                request.getRequestDispatcher("/WEB-INF/admin/AdminCohort.jsp").forward(request, response);
                }
            } 
            
            
            else if (nav.equals("announcements")) {
                request.getRequestDispatcher("/WEB-INF/admin/AdminAnnoucements.jsp").forward(request, response);

            } else if (nav.equals("adminreport")) {
                request.getRequestDispatcher("/WEB-INF/admin/AdminReports.jsp").forward(request, response);

            } else if (nav.equals("adminarchive")) {
                request.getRequestDispatcher("/WEB-INF/admin/AdminArchive.jsp").forward(request, response);
            } else if (nav.equals("adminbr")) {
                request.getRequestDispatcher("/WEB-INF/admin/AdminRecover.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/admin/AdminLanding.jsp").forward(request, response);
            }

        } //first time the admin is logging in
        else {

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
