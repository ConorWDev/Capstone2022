<%-- 
    Document   : fac_courseannouncements
    Created on : Mar. 11, 2022, 2:46:52 p.m.
    Author     : massvm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Announcements for ${sessionScope.courseObject.courseName}</h1>
        
        <c:forEach items="${requestScope.announcements}" var="announcement">
            ${announcement.text} <br>
        </c:forEach>
            
            
            <br>
            <b>ANNOUNCEMENT CREATION FORM</b>  
            
            <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                    Text:<input type="text" name="textSubmission"> 
                    <input type="submit" value="add">
                    
            </form>
                     
            ${requestScope.message}
                
          
        
            
        
        
        
        
    </body>
</html>
