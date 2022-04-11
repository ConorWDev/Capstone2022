/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Navigation;

import DBOperations.DBOperationsAdmin;
import DBOperations.DBOperationsAnnouncement;
import DBOperations.DBOperationsAssignments;
import DBOperations.DBOperationsCohort;
import DBOperations.DBOperationsCourse;
import DBOperations.DBOperationsDocument;
import DBOperations.DBOperationsFaculty;
import DBOperations.DBOperationsModule;
import DBOperations.DBOperationsStudent;
import Interface.Users.Admin;
import Interface.Users.Faculty;
import Interface.Users.Student;
import Objects.Announcement;
import Objects.Assignment;
import Objects.Cohort;
import Objects.Course;
import Objects.Document;
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
        
        DBOperationsDocument dbOpsDoc = new DBOperationsDocument();
        DBOperationsAssignments dbOpsAss = new DBOperationsAssignments();
        DBOperationsModule dbOpsMod = new DBOperationsModule();
        DBOperationsCourse dbOpsCou = new DBOperationsCourse();
        DBOperationsCohort dbOpsCoh = new DBOperationsCohort();
        DBOperationsAnnouncement dbOpsAnn = new DBOperationsAnnouncement();
        
        
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
                
                 String userType = request.getParameter("userType");
                if (userType != null && !userType.equals("")){
                    
                    
                    String username = request.getParameter("info1");
                    String first = request.getParameter("info2");
                    
                    String middle = request.getParameter("info3");
                    if (middle == null){
                        middle = "";
                    }
                    
                    String last = request.getParameter("info4");
                    String pass = request.getParameter("info5");
                    String email = request.getParameter("info6");
                    
                    
                    switch(userType){
                        case "student": boolean resultStud = dbOpsAd.createStudent(username,first,middle,last,pass,email);
                                        if (resultStud){
                                            request.setAttribute("message", "Student " + first + " " + middle + " " + last + " Created");
                                        }
                                        break;
                        case "faculty": boolean resultFac = dbOpsAd.createFaculty (username,first,middle,last,pass,email);
                                        if (resultFac){
                                            request.setAttribute("message", "Faculty " + first + " " + middle + " " + last + " Created");
                                        }
                                        break;
                        case "admin": boolean resultAd = dbOpsAd.createAdmin (username,first,middle,last,pass,email);
                                        if (resultAd){
                                            request.setAttribute("message", "Admin " + first + " " + middle + " " + last + " Created");
                                        }
                                        break;
                    }
                        
                    
                }
                
                
                request.getRequestDispatcher("/WEB-INF/admin/AdminUserCreate.jsp").forward(request, response);
            }
            else if(nav.equals("documents")){
                if (op.equals("1")){
                    
                    String name = request.getParameter("info1");
                    String description = request.getParameter("info2");
                    String url = request.getParameter("info3");
                    
                    if (name != null && !name.equals("")){
                        //boolean result = dbOpsDoc.createDocument(name, description, url);
                         Document doc = new Document(name,description,url);
                    
                         //trying altamishes code
                         request.setAttribute("message", dbOpsDoc.submitDocument(doc)); 
                    }
                    
                    
                    
                    request.getRequestDispatcher("/WEB-INF/admin/AdminDocumentCreate.jsp").forward(request, response);
                }
                else{
                    
                   
                    
                    
                    String documentID = request.getParameter("documentIDs");
                    if (documentID != null && !documentID.equals("")){
                        
                        Document document = dbOpsDoc.getDocumentByID(documentID);
                        request.setAttribute("docID",document.getDocumentID());
                        request.setAttribute("docName", document.getName());
                        request.setAttribute("docDescription", document.getDescription());
                        request.setAttribute("docUrl", document.getUrl());
                    }
                    
                    String saveChanges = request.getParameter("saveChanges");
                    if (saveChanges != null && !saveChanges.equals("")){
                        
                        String id = request.getParameter("id");
                        String name = request.getParameter("info1");
                        String description = request.getParameter("info2");
                        String url = request.getParameter("info3");
                        //boolean result = dbOpsDoc.updateDoc(id,name,description,url);
                        
                        Document doc = new Document(id,name,description,url);
                        request.setAttribute("message", dbOpsDoc.editDocument(doc));   
                        
                        /*
                        if (result){
                            request.setAttribute("message", "saved succesfully");
                        }
                        else{
                            request.setAttribute("message", "something went wrong");
                        }*/
                           
                    }
                    
                    String deleteDoc = request.getParameter("deleteDoc");
                    if (deleteDoc != null && !deleteDoc.equals("")){
                        
                        String id = request.getParameter("id");
                        boolean result = dbOpsDoc.deleteDoc(id);
                        
                        if (result){
                            request.setAttribute("message", "deleted");
                        }
                        else{
                            request.setAttribute("message", "something went wrong when deleting");
                        }
                        
                    }
                    
                    
                    ArrayList<Document> documents = dbOpsDoc.getAllDocuments();
                    request.setAttribute("documents", documents);
                    
                    request.getRequestDispatcher("/WEB-INF/admin/AdminDocumentManagement.jsp").forward(request, response);
                }
            }
            
            else if (nav.equals("assignments")) {
                
                if(op.equals("1")){
                    
                    
                    String name = request.getParameter("info2");
                    String description = request.getParameter("info3");
                    String url = request.getParameter("info4");
                    //if url is not entered assign it to ""
                    if (url == null || url.equals("")){
                        url = "";
                    }
                    
                    
                    if (name != null && !name.equals("")){
                        
                        Assignment assignment = new Assignment (name,description,url);
                        request.setAttribute("message",dbOpsAss.submitAssignment(assignment));
                    }
                    
                    
                    request.getRequestDispatcher("/WEB-INF/admin/AdminAssignmentsCreate.jsp").forward(request, response);
                }
                
                else{
                    
                    String assignmentID = request.getParameter("assignmentIDs");
                    if (assignmentID != null && !assignmentID.equals("")){
                        Assignment assignment = dbOpsAss.getAssignmentByID(assignmentID);
                        request.setAttribute("assID", assignmentID);
                        request.setAttribute("assName", assignment.getassignmentName());
                        request.setAttribute("assDescription", assignment.getassignmentDescription());
                        request.setAttribute("assURL", assignment.getassignmentUrl());
                    }
                    
                   
                    String save = request.getParameter("saveChanges");
                    
                    if (save != null && !save.equals("")){
                        
                        String id = request.getParameter("id");
                        String name = request.getParameter("info2");
                        String description = request.getParameter("info3");
                        String url = request.getParameter("info4");
                        
                        Assignment assignment = new Assignment(id,name,description,url, 1);
                        
                        request.setAttribute("message",dbOpsAss.editAssignment(assignment));
                    }
                    
                     String delete = request.getParameter("deleteAss");
                     
                     if (delete != null && !delete.equals("")){
                         
                         String id = request.getParameter("id");
                         boolean result = dbOpsAss.deleteAssignmentByID(id);
                         
                         if (result){
                             request.setAttribute("message", "successfully deleted");
                         }
                         else{
                             request.setAttribute("message", "something went wrong when deleting");
                         }
                     }
                    
                    
                    
                    ArrayList<Assignment> assignments = dbOpsAss.getAllAssignments();
                    request.setAttribute("assignments", assignments);
                    
                    request.getRequestDispatcher("/WEB-INF/admin/AdminAssignments.jsp").forward(request, response);
                
                }
            } 
            
            else if (nav.equals("modules")) {
                
                if(op.equals("1")){
                    
                   String name = request.getParameter("info2");
                   String description = request.getParameter("info3");
                   
                   if (name != null && !name.equals("")){
                       boolean result = dbOpsMod.createModule(name, description);
                       
                       if (result){
                           request.setAttribute("message", "successfully added module");
                       }
                       else{
                           request.setAttribute("message", "something went wrong when adding module");
                       }
                   }
                    
                    
                   request.getRequestDispatcher("/WEB-INF/admin/AdminModulesCreate.jsp").forward(request, response); 
                }
                else{
                    
                   
                   
                   String moduleID = request.getParameter("moduleIDs");
                   if (moduleID != null && !moduleID.equals("")){
                       Module module = dbOpsMod.getModule(moduleID);
                       request.setAttribute("modName", module.getName());
                       request.setAttribute("modDescription", module.getDescription());
                       request.setAttribute("modID", module.getLessonId());
                       
                       
                       ArrayList<Assignment> allAssignments = dbOpsAss.getAllAssignments();
                       ArrayList<Document> allDocuments = dbOpsDoc.getAllDocuments();
                       
                       request.setAttribute("allAssignments", allAssignments);
                       request.setAttribute("allDocuments", allDocuments);
                       
                       ArrayList<Assignment> relevantAssignments = dbOpsAss.getModuleAssignments(moduleID);
                       ArrayList<Document> relevantDocuments = dbOpsDoc.getModuleDocument(moduleID);
                       
                       request.setAttribute("relAssignments", relevantAssignments);
                       request.setAttribute("relDocuments", relevantDocuments);
                   }
                   
                   String save = request.getParameter("saveChanges");
                   if (save != null && !save.equals("")){
                       
                       /*
                       in the following code, obtain two lists. One list is of all assignments currently connected to the
                       given module. The second is a list of all assignments that have been checked off within the "assignments" form
                       using these two lists we will update the database appropriatly, either adding or deleteing the connections of assignments from
                       a given module
                       */
                       
                       //obtain a list of all assignments currently held in the module and stor it in array list previouslyCheckedAssignmentIDs
                       moduleID = request.getParameter("modID"); 
                       ArrayList<Assignment> relevantAssignments = dbOpsAss.getModuleAssignments(moduleID);
                       ArrayList<String> previouslyCheckedAssignmentIDs = new ArrayList<>();
                       for (int x = 0; x < relevantAssignments.size(); x++){
                           previouslyCheckedAssignmentIDs.add(relevantAssignments.get(x).getassignmentId());
                       }
                       
                       //obtain list of all assignments that are checked off in the assignments form and store it in array list checkedAssignmentIDs
                       String count = request.getParameter("count");
                       int countInt = Integer.parseInt(count);
                       ArrayList<String> checkedAssignmentIDs = new ArrayList<>();
                       for (int x = 0; x < countInt; x++){
                           String check = request.getParameter("assignmentList" + x);
                           if (check != null && !check.equals("")){
                               checkedAssignmentIDs.add(check);
                           }
                       }
                       
                       //if a value in the old list is not contained in the new list, sever the connection between the lesson and assignment table
                       for (int x = 0; x < previouslyCheckedAssignmentIDs.size(); x++){
                           if (!checkedAssignmentIDs.contains(previouslyCheckedAssignmentIDs.get(x))){
                               dbOpsAss.severConnection(moduleID, previouslyCheckedAssignmentIDs.get(x));
                           }
                       }
                       
                       //if a value is the new list is not in the old list, add the new bridge connection to the DB
                       for (int x = 0; x < checkedAssignmentIDs.size(); x++){
                           if (!previouslyCheckedAssignmentIDs.contains(checkedAssignmentIDs.get(x))){
                               //add checkedAssignmentIDs.get(x) id
                               dbOpsAss.brigeAssignmentModule(moduleID, checkedAssignmentIDs.get(x));
                           }
                       }
                       
                       //drop all entries in ma_less_document table where module_id = x. then add in as necessary
                       
                       
                       /*
                       in the following code, obtain one lists. A list of all documents that have been checked off within the "documents" form
                       using this list we will update the database appropriatly, first delete all previous instances in ma_lesson_document
                       table where module_id = x. then add all new occurences in
                       */
                       
                       //obtain list of all documents that are checked off in the document form and store it in array list checkedDocumentIDs
                       String docCount = request.getParameter("docCount");
                       int countDocInt = Integer.parseInt(docCount);
                       ArrayList<String> checkedDocumentIDs = new ArrayList<>();
                       for (int x = 0; x < countInt; x++){
                           String check = request.getParameter("documentList" + x);
                           if (check != null && !check.equals("")){
                               checkedDocumentIDs.add(check);
                           }
                       }
                       
                       //sever all previous connections between module and documents
                       dbOpsDoc.clearBridge(moduleID);
                       
                       //add new connections
                       for (int x = 0; x < checkedDocumentIDs.size(); x++){
                           dbOpsDoc.bridgeDocumentModule(moduleID, checkedDocumentIDs.get(x));
                       }
                       
                       
                       
                       //editing name/ description
                       String name = request.getParameter("info2");
                       String description = request.getParameter("info3");
                       
                       if (name != null && !name.equals("")){
                           boolean result = dbOpsMod.updateModule(moduleID, name, description);
                       }
                   }
                    
                   String delete = request.getParameter("deleteModule");
                   if (delete != null && !delete.equals("")){
                       moduleID = request.getParameter("modID"); 
                       dbOpsMod.deleteModuleByID(moduleID);
                   }
                   
                   ArrayList<Module> modules = dbOpsMod.getAllModules();
                   request.setAttribute("modules", modules);
                   
                   request.getRequestDispatcher("/WEB-INF/admin/AdminModules.jsp").forward(request, response); 
                }
                
            } 
            
            
            else if (nav.equals("courses")) {
                
                if(op.equals("1")){
                    
                    String courseName = request.getParameter("info2");
                    String courseDescription = request.getParameter("info3");
                    if (courseName != null && !courseName.equals("")){
                       boolean result = dbOpsCou.createCourse(courseName, courseDescription);
                        if (result){
                            request.setAttribute("message", "course added sucessfully");
                        }
                        else{
                            request.setAttribute("message", "something went wrong...");
                        }
                    }
                    
                    
                   request.getRequestDispatcher("/WEB-INF/admin/AdminCourseCreate.jsp").forward(request, response); 
                }
                else{
                    
                    
                    String courseID = request.getParameter("courseIDs");
                    if (courseID != null && !courseID.equals("")){
                        Course course = dbOpsCou.getCourse(courseID);
                        request.setAttribute("courseID", course.getCourseID());
                        request.setAttribute("courseName", course.getCourseName());
                        request.setAttribute("courseDescription", course.getCourseDescription());
                        
                        
                        ArrayList<Module> allModules = dbOpsMod.getAllModules();
                        ArrayList<Module> relModules = dbOpsMod.getCourseModules(courseID);
                        
                        request.setAttribute("allModules", allModules);
                        request.setAttribute("relModules", relModules);
                    }
                    
                    
                    String save = request.getParameter("saveChanges");
                    if (save != null && !save.equals("")){
                        
                        
                       String ID = request.getParameter("courseID");
                        
                       //obtain list of all modules that are checked off in the document form and store it in array list checkedModuleIDs
                       String count = request.getParameter("count");
                       int countInt = Integer.parseInt(count);
                       ArrayList<String> checkedModuleIDs = new ArrayList<>();
                       for (int x = 0; x < countInt; x++){
                           String check = request.getParameter("moduleList" + x);
                           if (check != null && !check.equals("")){
                               checkedModuleIDs.add(check);
                           }
                       }
                       
                       //sever all previous connections between course and lessons
                       dbOpsCou.clearBridge(ID);
                       
                       //add new connections
                       for (int x = 0; x < checkedModuleIDs.size(); x++){
                           dbOpsCou.bridgeCourseModule(ID, checkedModuleIDs.get(x));
                       }
                        
                        
                        String courseName = request.getParameter("info2");
                        String courseDescription = request.getParameter("info3");
                        
                        if (courseName != null && !courseName.equals("")){
                            dbOpsCou.updateCourse(ID, courseName, courseDescription);
                        }
                        
                    }
                    
                    String delete = request.getParameter("deleteCourse");
                    if (delete != null && !delete.equals("")){
                         String ID = request.getParameter("courseID");
                        dbOpsCou.deleteCourseByID(ID);
                    }
                    
                    
                    
                    
                    
                    ArrayList<Course> courses = dbOpsCou.getAllCourses();
                    request.setAttribute("courses", courses);
                    
                    request.getRequestDispatcher("/WEB-INF/admin/AdminCourses.jsp").forward(request, response);
                }
                
            } 
            
            
            else if (nav.equals("cohort")) {
                
                if (op.equals("1")){
                    
                    String cohortName = request.getParameter("info2");
                    if (cohortName != null && !cohortName.equals("")){
                        boolean result = dbOpsCoh.createCohort(cohortName);
                        if (result){
                            request.setAttribute("message", "cohort added");
                        }
                        else{
                            request.setAttribute("message", "something went wrong when adding cohort");
                        }
                    }
                    
                    
                    
                request.getRequestDispatcher("/WEB-INF/admin/AdminCohortCreate.jsp").forward(request, response); 
                }
                else {
                    
                
                String cohortID = request.getParameter("cohortIDs");
                if (cohortID != null && !cohortID.equals("")){
                    Cohort cohort = dbOpsCoh.getCohort(cohortID);
                    request.setAttribute("cohortName", cohort.getCohortName());
                    request.setAttribute("cohortID", cohort.getCohortID());
                    
                    
                    ArrayList<Course> allCourses = dbOpsCou.getAllCourses();
                    ArrayList<Faculty> allFaculty = dbOpsFac.getAllFaculty();
                    ArrayList<Student> allStudents = dbOpsStud.getAllStudents();
                    
                    ArrayList<Course> relCourses = dbOpsCou.getCoursesByCohort(cohortID);
                    ArrayList<Faculty> relFaculty = dbOpsFac.getFacultyByCohort(cohortID);
                    ArrayList<Student> relStudents = dbOpsStud.getStudentsByCohort(cohortID);
                    
                    request.setAttribute("allCourses", allCourses);
                    request.setAttribute("allFaculty", allFaculty);
                    request.setAttribute("allStudents", allStudents);
                    
                    request.setAttribute("relCourses", relCourses);
                    request.setAttribute("relFaculty", relFaculty);
                    request.setAttribute("relStudents", relStudents);
                }
                
                String save = request.getParameter("saveChanges");
                if (save != null && !save.equals("")){
                    
                    
                      /*
                       in the following code, obtain one lists. A list of all courses that have been checked off within the "courses" form
                       using this list we will update the database appropriatly, first delete all previous instances in ma_cohort_course
                       table where cohort_id = x. then add all new occurences in
                       */
                        
                      String ID = request.getParameter("cohortID");
                      
                       //obtain list of all documents that are checked off in the document form and store it in array list checkedDocumentIDs
                       String courseCount = request.getParameter("courseCount");
                       int countInt = Integer.parseInt(courseCount);
                       ArrayList<String> checkedCourseIDs = new ArrayList<>();
                       for (int x = 0; x < countInt; x++){
                           String check = request.getParameter("courseList" + x);
                           if (check != null && !check.equals("")){
                               checkedCourseIDs.add(check);
                           }
                       }
                       
                       //sever all previous connections between module and documents
                       dbOpsCoh.clearCohortCourseBridge(ID);
                       
                       //add new connections
                       for (int x = 0; x < checkedCourseIDs.size(); x++){
                           dbOpsCoh.bridgeCohortCourse(ID, checkedCourseIDs.get(x));
                       }
                       
                       
                       
                       /*
                       in the following code, obtain one list. A list of all faculty that have been checked off within the "faculty" form
                       using this list we will update the database appropriatly, first delete all previous instances in ma_cohort_faculty
                       table where cohort_id = x. then add all new occurences in
                       */
                       
                       //obtain list of all faculty that are checked off in the document form and store it in array list checkedDocumentIDs
                       String facultyCount = request.getParameter("facultyCount");
                       int countIntFac = Integer.parseInt(facultyCount);
                       ArrayList<String> checkedFacultyIDs = new ArrayList<>();
                       for (int x = 0; x < countIntFac; x++){
                           String check = request.getParameter("facultyList" + x);
                           if (check != null && !check.equals("")){
                               checkedFacultyIDs.add(check);
                           }
                       }
                       
                       //sever all previous connections
                       dbOpsCoh.clearCohortFacultyBridge(ID);
                       
                       //add new connections
                       for (int x = 0; x < checkedFacultyIDs.size(); x++){
                           dbOpsCoh.bridgeCohortFaculty(ID, checkedFacultyIDs.get(x));
                       }
                       
                       
                       /*
                       in the following code, obtain two lists. A list of all students that have been checked off within the "student" form
                       using this list we will update the database appropriatly, first delete all previous instances in ma_student_cohort
                       table where cohort_id = x. then add all new occurences in
                       */
                       
                       //obtain a list of all students currently held in the module and store it in array list previouslyCheckedStudentIDs
                       ArrayList<Student> relevantStudents = dbOpsStud.getStudentsByCohort(ID);
                       ArrayList<String> previouslyCheckedStudentIDs = new ArrayList<>();
                       for (int x = 0; x < relevantStudents.size(); x++){
                           previouslyCheckedStudentIDs.add(relevantStudents.get(x).getUserID());
                       }
                       
                       //obtain list of all students that are checked off in the document form and store it in array list checkedDocumentIDs
                       String studentCount = request.getParameter("studentCount");
                       int countIntStud = Integer.parseInt(studentCount);
                       ArrayList<String> checkedStudentIDs = new ArrayList<>();
                       for (int x = 0; x < countIntStud; x++){
                           String check = request.getParameter("studentList" + x);
                           if (check != null && !check.equals("")){
                               checkedStudentIDs.add(check);
                           }
                       }
                       
                       
                       
                       //if a value in the old list is not contained in the new list, delete grade records of that student as they have been removed
                       //from the cohort
                       for (int x = 0; x < previouslyCheckedStudentIDs.size(); x++){
                           if (!checkedStudentIDs.contains(previouslyCheckedStudentIDs.get(x))){
                               dbOpsStud.deleteGrades(previouslyCheckedStudentIDs.get(x));
                           }
                       }
                       //TODO ABOVE. delete grades may not be working??? bridging table?
                       
                       
                       //sever all previous connections
                       dbOpsCoh.clearCohortStudentBridge(ID);
                       
                       //add new connections
                       for (int x = 0; x < checkedStudentIDs.size(); x++){
                           dbOpsCoh.bridgeCohortStudents(ID, checkedStudentIDs.get(x));
                       }
                       
                       
                       
                    
                }
                
                String delete = request.getParameter("deleteCohort");
                if (delete != null && !delete.equals("")){
                    
                    String ID = request.getParameter("cohortID");
                    dbOpsCoh.deleteCohortByID(ID);
                    
                }
                    
                    
                    
                    
                    
                ArrayList<Cohort> cohorts = dbOpsCoh.getAllCohorts();  
                request.setAttribute("cohorts", cohorts);
                
                
                    
                    
                request.getRequestDispatcher("/WEB-INF/admin/AdminCohort.jsp").forward(request, response);
                }
            } 
            
            
            else if (nav.equals("announcements")) {
                
                if (op.equals("1")){
                    
                    String createCohortAnn = request.getParameter("createCohortAnn");
                    String cohortText = request.getParameter("cohortText");
                    if (createCohortAnn != null && !createCohortAnn.equals("") && cohortText != null && !cohortText.equals("")){
                        String cohortID = request.getParameter("cohorts");
                        boolean result = dbOpsAnn.createCohortAnnouncement(cohortID, cohortText);
                        
                        if (result){
                            request.setAttribute("message", "success");
                        }
                        else{
                            request.setAttribute("message", "failure");
                        }
                    }
                    
                    String createCourseAnn = request.getParameter("createCourseAnn");
                    String courseText = request.getParameter("courseText");
                    if (createCourseAnn != null && !createCourseAnn.equals("") && courseText != null && !courseText.equals("")){
                        String courseID = request.getParameter("courses");
                        boolean result = dbOpsAnn.createCourseAnnouncement(courseID, courseText);
                        
                        if (result){
                            request.setAttribute("message", "success");
                        }
                        else{
                            request.setAttribute("message", "failure");
                        }
                    }
                    
                    
                    
                    //get all cohorts and all courses for selection
                     ArrayList<Cohort> cohorts = dbOpsCoh.getAllCohorts();
                     ArrayList<Course> courses = dbOpsCou.getAllCourses();
                
                    request.setAttribute("cohorts", cohorts);
                    request.setAttribute("courses", courses);
                
                    request.getRequestDispatcher("/WEB-INF/admin/AdminAnnoucements.jsp").forward(request, response);
                }
                //navigating to cohort announcement mgmt
                else if(op.equals("2")){
                    
                    String save = request.getParameter("saveChanges");
                    if (save != null && !save.equals("")){
                        
                        String count = request.getParameter("count");
                        int countInt = Integer.parseInt(count);
                            
                        for(int x = 0; x < countInt; x++){
                            String cohortText = request.getParameter("cohortText" + x);
                            String announcementID = request.getParameter("id" + x);
                            if (cohortText != null && !cohortText.equals("")){
                                dbOpsAnn.editCohortAnnouncement(announcementID, cohortText);
                            }
                            
                        }
                    }
                    
                    //Delete functionality TODO
                    String count = request.getParameter("count");
                    if (count != null && !count.equals("")){
                        int countInt = Integer.parseInt(count);
                        for (int x = 0; x < countInt; x++){
                            String ID = request.getParameter("deleteAnn" + x);
                            if (ID != null && !ID.equals("")){
                                dbOpsAnn.deleteCohortAnnouncement(ID);
                            }
                        }
                    }
                    
                    
                    
                    String cohortID = request.getParameter("cohortIDs");
                    if (cohortID != null && !cohortID.equals("")){
                        ArrayList<Announcement> announcements = dbOpsAnn.getAnnouncementsByCohort(cohortID);
                        request.setAttribute("announcements", announcements);
                        
                        
                    }
                    
                    //get all cohorts and all courses for selection
                    ArrayList<Cohort> cohorts = dbOpsCoh.getAllCohorts();
                    ArrayList<Course> courses = dbOpsCou.getAllCourses();
                
                    request.setAttribute("cohorts", cohorts);
                    request.setAttribute("courses", courses);
                    
                    
                    request.getRequestDispatcher("/WEB-INF/admin/AdminAnnouncementManagement.jsp").forward(request, response);
                }
                
                

            } else if (nav.equals("adminreport")) {
                request.getRequestDispatcher("/WEB-INF/admin/AdminReports.jsp").forward(request, response);

            } else if (nav.equals("adminarchive")) {
                request.getRequestDispatcher("/WEB-INF/admin/AdminArchive.jsp").forward(request, response);
            } else if (nav.equals("adminbr")) {
                request.getRequestDispatcher("/WEB-INF/admin/AdminRecovery.jsp").forward(request, response);
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
