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
            <div class="col-1"></div>    
            <div class="col bg-white rounded" id="containerfac">
                <div class="row mb-5">
                    <p class="h4">${sessionScope.courseObject.courseName}</p>
                </div>
                <div class="row mb-5">
                <div class="col">
                    <div class="row">
                        <p class="h4">Announcements</p>
                    </div>

                    <c:forEach items="${requestScope.announcements}" var="announcement">
                        <div class="row">
                            <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                                <p class="d-inline-block">${announcement.text}</p>
                                <input type="hidden" name="announcementID" value="${announcement.announcementID}">
                                <input class="btn-block d-inline-block" type="submit" name="editMenu" value="edit">
                                <input class ="btn-blck d-inline-block" type="submit" name="deleteMenu" value="delete">
                            </form>
                        </div>    
                    </c:forEach>
                </div>
                <div class="col">
                    <div class="row">
                <p class="h4">Announcement Creation Form</p>  

                <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                    Text:<input type="text" name="textSubmission"> 
                    <input type="submit" value="add">
                </form>
                </div>
                ${requestScope.message}
                </div>
                <div class="col">
                    <div class="row">
                <c:if test="${requestScope.editMenu}">
                    <p class="h4">ANNOUNCEMENT EDIT FORM</b>  
                    <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                        Original Text: ${sessionScope.courseAnnouncement.text}<br>
                        New Text: <input type="text" name="newText">
                        <input type="submit" value="update">
                    </form>
                </c:if>
                </div>    
            </div> 
                </div>
                </div>    
            <div class="col-1"></div>    

        </div>




    </body>
</html>
