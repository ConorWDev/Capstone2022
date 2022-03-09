/*
 *
 */
package Controller.UserServices;

/**
 *
 * @author Altamish Lalani
 * 
 * Instructions.
 * 
 * Launch LoginService class with two input prerequisites.
 * 1) webUsername from login.jsp
 * 2) webPassword from login.jsp
 * 
 * then user LoginService.getResult(); to return boolean for further MVC processing.
 * 
 * 
 * 
 * Directions for MVC may be viewed in this code --- It has been commented.
 * 
 * MVC uses $$$$ as markers.
 * DBOps uses &&&& as markers.
 * 
 */
/*
public class LoginService {
    
    public String message = "";
    boolean result = false;
        
    LoginService(String webUsername, String webPassword){
    isValid(webUsername,webPassword);
    }
    
    public void isValid(String webUsername, String webPassword){
        
        
//  $$$$$$$$$ Initial Page MVC Code
//        if (webUsername==null && webPassword==null) {
//            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
//        }
//        else if (webUsername.equals("") || password.equals("")) {
//            request.setAttribute("message", "Both values are required!");
//            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
//        }
//  //Check a valid entry
//        else{ HttpSession session = request.getSession();
//           



//   &&&&&& 
//   &&&&&& Valid - DbOPs functions go here!

           //  result = dbOps.validateUser(webUsername,webPassword);
           
           /*
           To validate a user for the method above. The following query would work
           for a Valid Student:
           _______________________________
           SELECT COUNT(username)
           FROM ma_student ms 
           WHERE username = 'cmc21-00001' 
           AND password = 'PASS';
           _______________________________
           
           
    if(query_result == 1){return true;}
           
           Security ISSUE - IT FAILS TO CHECK CASE SENSITIVITY with password.

----------RYAN stated
           Every usertype belongs to it's own table.
           For now this function can check ma_student.
    Decision needed:  Later, we need to expand to ma_faculty as a secondary check.
           
     &&&&&&&&&&&&&&      */

           
           
           
// if Valid ->    if (result) {
//                
//                ServletContext application = getServletContext();
//                
//                if (application.getAttribute("usercount")==null) {
//                    application.setAttribute("usercount", 0);
//                }
//                
//                int userCount = (Integer) application.getAttribute("usercount");
//                userCount++;
//                application.setAttribute("usercount", userCount);
//
//                session.setAttribute("username", username);
//                session.setAttribute("words", new ArrayList<String>());

//     ****GO TO LANDING PAGE******            

//                request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
//            }
//            //Invalid
//            else {
//                request.setAttribute("message", "Invalid username or password!");
//                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
//            }
//        }   
    
//    }
    
 /*   
    
    //Simple getter for result.
    public boolean getResult(){
    return result;
    }
    
}
*/