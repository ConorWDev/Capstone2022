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
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="fac_style.css" rel="stylesheet"/>
        <title>Course Announcements</title>
    </head>
    <body>
        
        <%@include file="fac_headerfragment.jspf" %>
        
        <div class="row">
            <div class="col"></div>
            <div class="col bg-light rounded">
        
        <p class="h3">Announcements for ${sessionScope.courseObject.courseName}</p>
        
        <c:forEach items="${requestScope.announcements}" var="announcement">
            <form style="border: solid" action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                ${announcement.text}
            <input type="hidden" name="announcementID" value="${announcement.announcementID}">
                <input type="submit" name="editMenu" value="edit">
            </form>
        </c:forEach>
            
            
            <br>
            <b>ANNOUNCEMENT CREATION FORM</b>  
            
            <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                    Text:<input type="text" name="textSubmission"> 
                    <input type="submit" value="add">
            </form>
                     
            ${requestScope.message}
                
            <br>
            <c:if test="${requestScope.editMenu}">
                <b>ANNOUNCEMENT EDIT FORM</b>  
                <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                    Original Text: ${sessionScope.courseAnnouncement.text}<br>
                    New Text: <input type="text" name="newText">
                    <input type="submit" value="update">
                </form>
            </c:if>
            </div>
            <div class="col-1"></div>
            </div>
        
        
        
        
    </body>
</html>
