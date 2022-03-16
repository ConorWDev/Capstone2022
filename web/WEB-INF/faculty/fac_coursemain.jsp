<%-- 
    Document   : fac_coursemain
    Created on : Mar. 8, 2022, 5:44:58 p.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        <h1>${sessionScope.courseObject.courseName}</h1>
        
        <c:forEach items="${requestScope.modules}" var="module">
            <a href="SiteNavigationFaculty?nav=modulemain&moduleid=${module.lessonId}">${module.name}</a><br>
        </c:forEach>
            
            <br>
            <b> COURSE ANNOUNCEMENTS </b>    
            <br>
        <%--TODO limit printout of announcemnts to three or something. View all announcements on next page --%>    
        <c:forEach items="${requestScope.announcements}" var="announcement">
            <form style="border: solid">
            <br>${announcement.text}<br>
            ${announcement.startDate}<br>
            </form>
        </c:forEach>    
        
            
        <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                <input type="submit" value="View/edit announcements">
        </form> 
            
         
        
    </body>
</html>
