/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Navigation;

import DBOperations.DBOperationsAnnouncement;
import DBOperations.DBOperationsAssignments;
import DBOperations.DBOperationsAttendance;
import DBOperations.DBOperationsCohort;
import DBOperations.DBOperationsCourse;
import DBOperations.DBOperationsDocument;
import DBOperations.DBOperationsGeneral;
import DBOperations.DBOperationsGrade;
import DBOperations.DBOperationsModule;
import DBOperations.DBOperationsSchedule;
import DBOperations.DBOperationsStudent;
import Interface.Users.Faculty;
import Interface.Users.Student;
import Objects.Announcement;
import Objects.Assignment;
import Objects.Attendance;
import Objects.Course;
import Objects.Cohort;
import Objects.CourseAnnouncement;
import Objects.Document;
import Objects.Grade;
import Objects.Module;
import Objects.Schedule;
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
        
        
        //course ID is passed into SiteNavigationFaculty from the users selection of the particular course
        //that they are navigating to. this will then be used to create a course ibject. That course object will be attached to the session.
        String courseID = request.getParameter("courseid");
        //module ID is passed into SiteNavigationFaculty from the users selection of the particular module
        //that they are navigating to. this will then be used to create a module object. that module object will be attached to the session.
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
        DBOperationsAttendance dbOpsAtt = new DBOperationsAttendance();
        DBOperationsSchedule dbOpsSch = new DBOperationsSchedule();
        
        if(logout!=null&&!logout.equals("")){
          session.invalidate();
          request.setAttribute("message", "User successfully logged out.");
          request.getRequestDispatcher("/WEB-INF/student/loginV2.jsp").forward(request, response); 
        }
        else if(nav!=null&&!nav.equals("")){
           //navigating to course main
            if (nav.equals("coursemain")){
                
               //ADDING GIVEN COURSE TO SESSION SCOPE "courseObject" 
               
               //create a course object from the given course ID and then set it within the session scope for use later.
               //this is a new model. Prior to this, no course was held in session scope. Rather, the required values (name, id description)
               //were all passed individually. This was ineffective. Because all navigation "deeper" into the app (i.e, navigating to further pages
               //from this point onward) will be only relevant to this particular course, the course is set as "course" on the session scope.
               //if a different course is navigated to on fac_home.jsp, that particular course will be assigned to the session scope as "course".
               Course course = dbOpsCor.getCourse(courseID);
               session.setAttribute("courseObject", course);
               
               //obtain course announcements 
               ArrayList<CourseAnnouncement> announcements = dbOpsAn.getCourseAnnouncements(courseID);
               request.setAttribute("announcements",announcements);
               
               //load list of modules for associated course
               ArrayList<Module> modules = dbOpsMod.getCourseModules(courseID);
               request.setAttribute("modules",modules);
               
               //direct to coursemain page
               request.getRequestDispatcher("/WEB-INF/faculty/fac_coursemain.jsp").forward(request, response);
           }
            //navigating to modulemain
            else if (nav.equals("modulemain")){
                
                //ADDING GIVEN MODULE TO SESSION SCOPE "moduleObject"
                
                
                 //create a module object from the given module ID and then set it within the session scope for use later.
               //this is a new model. Prior to this, no module was held in session scope. Rather, the required values (name, id description)
               //were all passed individually. This was ineffective. Because all navigation "deeper" into the app (i.e, navigating to further pages
               //from this point in the app onward) will be only relevant to this particular module, the module is set as "module" on the session scope.
               //if a different module is navigated to on fac_coursemain.jsp, that particular module will be assigned to the session scope as "module".

                Module module = dbOpsMod.getModule(moduleID);
                session.setAttribute("moduleObject", module);
               
                
                String assName = request.getParameter("assignmentName");
                String assDescription = request.getParameter("assignmentDescription");
                String assURL = request.getParameter("assignmentURL");
                if (assName != null && !assName.equals("")){
                    module = (Module)session.getAttribute("moduleObject");
                    Assignment assignment = new Assignment(assName,assDescription,assURL);
                    
                    //COME BACK TO HERE work on facultys ability to add assignments
                    dbOpsAss.createAssignmentFac(module.getLessonId(),assignment);
                    
                    String id = dbOpsAss.getAssignmentID(assignment);
                    
                    if (id != null && !id.equals("")){
                        request.setAttribute("message", id);
                    }
                    else{
                           request.setAttribute("message", "something went wrong");
                    }
                    
                    dbOpsAss.brigeAssignmentModule(module.getLessonId(), id);
                    
                    
                }
                
                String docName = request.getParameter("documentName");
                String docDescription = request.getParameter("documentDescription");
                String docURL = request.getParameter("documentURL");
                if (docName != null && !docName.equals("")){
                    Document doc = new Document(docName,docDescription,docURL);
                    dbOpsDoc.submitDocument(doc);
                    String id = dbOpsDoc.getDocumentID(doc);
                    dbOpsDoc.bridgeDocumentModule(moduleID, id);
                }
                
                
                //get list of assignments for particular module
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
                
                //a faculty member may have multiple cohorts under their influence. return a list of these cohorts
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
                //set student to session scope for further use later
                Student student = new Student(studentID);
                session.setAttribute("student", student);
                
                //obtain cohortID from grades page (related to particular student) and get a list of the courses.
                String cohortid = request.getParameter("cohortid");
                request.setAttribute("cohortid", cohortid);
                ArrayList<Course> courses = dbOpsCor.getCoursesByCohort(cohortid);
                
                //create an arraylist to hold all assignments in a given cohort
                ArrayList<Assignment> allAssignments = new ArrayList<>();
                
                //loop through all courses within a cohort. Obtain all assignments for a given course
                //and place them within "hold". Add each assignment within hold to allAssignments
                //at the end allAssignments will hold every assignment within every course within a given cohort
                for (int x = 0; x < courses.size(); x++){
                    ArrayList<Assignment> hold = dbOpsAss.getCourseAssignments(courses.get(x).getCourseID());
                    
                    for (int y =0; y < hold.size(); y++){
                        allAssignments.add(hold.get(y));
                    }
                } 
                
                /*
                If grades are being saved...
                get the variable count from form on studengrades page. this is the number of assignments, it will be used
                for the for loop.
                Obtain the unique grade value and assignment_id from the form on studentgrades page.
                Feed these two values along with the student ID obtained from session scope into the DBoperation update grades
                */
                String count = request.getParameter("count");
                String saveGrade = request.getParameter("saveGrade");
                if (saveGrade != null && !saveGrade.equals("")){
                    int countInt = Integer.parseInt(count);
                    String grade="";
                    String assignmentID = "";
                    for (int x = 0; x < countInt; x++){
                         grade = request.getParameter("newGrade" + x);
                         assignmentID = request.getParameter("assignment" + x);
                         Student stud = (Student)session.getAttribute("student");
                         boolean result = dbOpsGrade.updateGrade(assignmentID, stud.getUserID(), grade);
                         
                         if (result){
                             request.setAttribute("message", "success");
                         }
                         else{
                             request.setAttribute("message", "something went wrong. grade not updated");
                         }
                    } 
                }
                
                 //set allAssignments within the requestscope
                request.setAttribute("allAssignments", allAssignments);
                
                //get a list of grades for all assignments of a particular student 
                ArrayList<Grade> studentGrades = dbOpsGrade.getGrades(student.getUserID());
                request.setAttribute("studentGrades", studentGrades);
                
                request.getRequestDispatcher("/WEB-INF/faculty/fac_studentgrades.jsp").forward(request, response);   
            }
        
            //faculty has selected view all announcements on fac_home.jsp
            else if (nav.equals("cohortannouncements")){
                
                 //set the cohort in the session scope for the cohort currently being added to
                
                Cohort cohort = dbOpsCo.getCohort(cohortID);
                session.setAttribute("cohort",cohort);
                
                //obtain text from add announcement form on fac_cohortannouncements.jsp and carry out sql command to add it to the DB
                String textSubmission = request.getParameter("textSubmission");
                if (textSubmission != null && !textSubmission.equals("")){
                   
                   boolean result = dbOpsAn.createCohortAnnouncement(cohortID, textSubmission);
                   
                   String message = "";
                   if (result){
                       message = "The announcement has been created";
                   }
                   else{
                       message = "There was an error when creating the announcement";
                   }
                   request.setAttribute("message", message);
                }
               
                //user has selected edit. Pull up edit menu
                String announcementID = request.getParameter("announcementID");
                if(announcementID != null && !announcementID.equals("")){
                    request.setAttribute("editMenu", true);
                    //saving announcement that we are editing to the session scope.
                   //to do this we obtain the given announcements ID from the form on fac_courseannouncements.jsp
                   //create a new annonucement object with the dbOp. And then save that created announcement object to session scope
                   String cohortAnnouncementID = request.getParameter("announcementID");
                   Announcement announcement = dbOpsAn.getCohortAnnouncement(cohortAnnouncementID);
                   session.setAttribute("cohortAnnouncement", announcement);
                }
                
                //User as entered new text within the edit menu
                String newText = request.getParameter("newText");
                if (newText != null && !newText.equals("")){
                     
                   //get cohort announcement from sesssion scope assigned previously. And then get its ID
                   Announcement announcement = (Announcement)session.getAttribute("cohortAnnouncement");
                   String cohortAnnouncementID = announcement.getAnnouncementID();
                   
                   //call dbOp to editcourse announcement with courseannouncementID and newText as parameter
                   boolean result = dbOpsAn.editCohortAnnouncement(cohortAnnouncementID, newText);
                   
                   if (result){
                       request.setAttribute("editMenu", false);
                   }
                   else{
                       request.setAttribute("editMessage", "An error ocurred during editing. Limit 1000 characters");
                   }
                }
                
                 String deleteButton = request.getParameter("deleteButton");
                 if (deleteButton != null && deleteButton.equals("delete")){
                     
                     DBOperationsAnnouncement da = new DBOperationsAnnouncement();
                     da.deleteCohortAnnouncement(announcementID);
                     
                     request.setAttribute("editMenu", false);
               }
               
                ArrayList<Announcement> announcements = dbOpsAn.getCohortAnnouncements(cohortID);
                request.setAttribute("announcements", announcements);
                
                request.getRequestDispatcher("/WEB-INF/faculty/fac_cohortannouncements.jsp").forward(request, response);
            }
            //faculty has select view all announcements on fac_coursemain.jsp
            else if (nav.equals("courseannouncements")){
                
               //obtain the course object that is storred within the session scope (again, this is done above when navigating to coursemain.jsp)
               Course course = (Course)session.getAttribute("courseObject"); 
                 
               /*
                NOTE, at this point in the application, the course object "course" within the session scope has been set (occurs when selecting couse
                (on fac_home.jsp). As such, course related datafields that are required on courseannouncement.jsp can be passed via the "course" session
                scope variable
                */
               
               //obtain text from add announcement form on fac_courseannouncements.jsp and carry out sql command to add it to the DB
               String textSubmission = request.getParameter("textSubmission");
               if (textSubmission != null && !textSubmission.equals("")){
                   
                   boolean result = dbOpsAn.createCourseAnnouncement(course.getCourseID(), textSubmission);
                   
                   String message = "";
                   if (result){
                       message = "The announcement has been created";
                   }
                   else{
                       message = "There was an error when creating the announcement";
                   }
                   request.setAttribute("message", message);
               }
               
               //editing the course announcement, pull up edit menu. Add selected announcement
               //to session scope for further work
               String editMenu = request.getParameter("editMenu");
              
               if (editMenu != null && !editMenu.equals("")){
                   request.setAttribute("editMenu", true);
                   //saving announcement that we are editing to the session scope.
                   //to do this we obtain the given announcements ID from the form on fac_courseannouncements.jsp
                   //create a new annonucement object with the dbOp. And then save that created announcement object to session scope
                   String courseAnnouncementID = request.getParameter("announcementID");
                   CourseAnnouncement announcement = dbOpsAn.getCourseAnnouncement(courseAnnouncementID);
                   session.setAttribute("courseAnnouncement", announcement);
                   
               }
               
               
               
               //edit menu form submitted, call dbOp to update database
               String newText = request.getParameter("newText");
               if (newText != null && !newText.equals("")){
                   
                   //get course announcement from sesssion scope assigned previously. And then get its ID
                   CourseAnnouncement announcement = (CourseAnnouncement)session.getAttribute("courseAnnouncement");
                   String announcementID = announcement.getAnnouncementID();
                   
                   //call dbOp to edit course announcement with courseannouncementID and newText as parameter
                   boolean result = dbOpsAn.editCourseAnnouncement(announcementID, newText);
                   
                   if (result){
                       request.setAttribute("editMenu", false);
                   }
                   else{
                       request.setAttribute("editMessage", "An error ocurred during editing. Limit 1000 characters");
                   }
               }

               
               //delete course announcement, get delete menu
               String deleteMenu = request.getParameter("deleteMenu");
               
               if (deleteMenu != null && !deleteMenu.equals("")){
                   
                   //obtain announcementID from get announcement form on fac_courseannouncements.jsp and carry out sql command to delete it from the DB
                   String announcementID = request.getParameter("announcementID");
                   
                   //call dbOp to delete course announcement with announcemnetID
                   boolean result = dbOpsAn.deleteCourseAnnouncement(announcementID);
                   
                   String message = "";
                   if (result){
                       message = "The announcement has been deleted";
                   }
                  
         
                   request.setAttribute("message", message);
               }
               

               
               //obtain course announcements for display on fac_courseannouncments page 
               ArrayList<CourseAnnouncement> announcements = dbOpsAn.getCourseAnnouncements(course.getCourseID());
               request.setAttribute("announcements",announcements);
               
               //direct to fac_courseannouncement.jsp page
               request.getRequestDispatcher("/WEB-INF/faculty/fac_courseannouncements.jsp").forward(request, response);
            }
            //faculty is entering into the attendance page from the headerfragment
            else if (nav.equals("attendance")){
                
                //obtain number of students in the given cohort. Will be null unless attendance is saved on attendenca page.
                String studentCountString = request.getParameter("studentCount");
               
                //In the following code section we obtain all studentIDs that are present as well as all studentIDs for a given
                //cohort. These two lists of IDs will be used to determine who is and is not present for a given day. once this
                //is determined we persist the needed information to the database to track attendance

                String attendanceMessage = "";
                
                //create an array list to hold the IDs of all studnts who are present
                ArrayList<String> presentIDs = new ArrayList<>();
                //create an array list to hold the IDs of all students in the given cohort
                ArrayList<String> allIDs = new ArrayList<>();
                
                //if the studentCountString isnt null, ie we are saving attendance
                if (studentCountString != null){
                    int studentCount = Integer.parseInt(studentCountString);
                        //get each attendanceCheck{count} parameter from the form. If it isnt null that student
                        //has been checked and therefore is present.
                        for (int x = 0; x < studentCount; x++){
                            String presentID = request.getParameter("attendanceCheck" + x);
                            if (presentID != null){
                                presentIDs.add(presentID);
                            }   
                        }
                        //get all IDs for each student within the given cohort and add it to allIDs arraylist
                        //this will allow for comparison between the present students (whose ids are held in the
                        //presentIDs arraylist
                        for (int x = 0; x < studentCount; x++){
                            String ID = request.getParameter("attendanceHidden" + x);
                            allIDs.add(ID);
                        }
                    //parse through all StudentIDs
                    for (int x = 0; x < allIDs.size(); x++){
                        String date = request.getParameter("date");
                        //if the studentID is present
                        if (presentIDs.contains(allIDs.get(x))){
                            Boolean result = dbOpsAtt.addAttendancePresent(allIDs.get(x),date);
                            
                            if (result){
                                attendanceMessage = "Attendance Successfully updated";
                            }
                            else{
                                attendanceMessage = "Something went wrong when updating attendance";
                            }
                        }
                        //if student is marked not present
                        else{
                             Boolean result = dbOpsAtt.addAttendanceNotPresent(allIDs.get(x),date);
                             
                             if (result){
                                attendanceMessage = "Attendance Successfully updated";
                            }
                            else{
                                attendanceMessage = "Something went wrong when updating attendance";
                            }
                        }
                    }
                }
                
                request.setAttribute("attendanceMessage",attendanceMessage);
                request.setAttribute("presentIDs",presentIDs);
                request.setAttribute("allIDs",allIDs);
                
                
                //similar to logic when navigating to grade page...
                //a faculty member may have multiple cohorts under their influence. return a list of these cohorts
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
                
                request.getRequestDispatcher("/WEB-INF/faculty/fac_attendance.jsp").forward(request, response);
            }
            else if (nav.equals("studentattendance")){
                //session scope not used here. requestScope hands values back and forth. A bit lazy but it works. See large <a> in jsp to see
                //partly whats going on
                
                //date and isPresent is particular are derived solely from the <a> href within studentattendance.jsp
                String date = request.getParameter("date");
                String isPresent = request.getParameter("isPresent");
                
                //name and ID are obtained both from attendance and studentattendance depending on which page user is on
                request.setAttribute("studentName",request.getParameter("studentName"));
                request.setAttribute("studentID", request.getParameter("studentID"));
                String studentIDAttendance = request.getParameter("studentID");

                //if isPresent is not null that means the user is attempting to switch a particular student from present to
                //absent or vise versa on the studentattendance page
                if (isPresent != null && !isPresent.equals("")){
                    //student is currently present, change to absent
                    if (isPresent.equals("true")){
                        Boolean result = dbOpsAtt.addAttendanceNotPresent(studentIDAttendance, date);
                    }
                    //else the opposite
                    else{
                         Boolean result = dbOpsAtt.addAttendancePresent(studentIDAttendance, date);
                    }
                }

                
                ArrayList<Attendance> attendanceList = dbOpsAtt.getAttendanceRecords(studentIDAttendance);
                request.setAttribute("attendanceList",attendanceList);
                
                request.getRequestDispatcher("/WEB-INF/faculty/fac_studentattendance.jsp").forward(request, response);
            }
            else if (nav.equals("schedule")){
                ArrayList<Cohort> cohorts = dbOpsCo.getCohorts(faculty.getUserID());
                request.setAttribute("cohorts", cohorts);
                
                Schedule schedule = dbOpsSch.getSchedule(cohorts.get(0).getCohortID());
                if (schedule != null){
                    String scheduleID = schedule.getScheduleId();
                    String url = dbOpsSch.getUrl(scheduleID);
                    request.setAttribute("url", url);
                }
                
                
                
                request.getRequestDispatcher("/WEB-INF/faculty/fac_schedule.jsp").forward(request, response);
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
