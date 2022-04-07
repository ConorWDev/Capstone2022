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

                <div class="row mb-3">
                    <div class="container-fluid border-bottom border-primary" id="announcementheader">    
                        <p class="h2 ms-2 mt-2">${sessionScope.courseObject.courseName}</p>
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col border-end">
                        <div class="row">
                        <p class="h4">Course Announcements</p>
                        </div>
                        
                        <table class="table">
                        <c:forEach items="${requestScope.announcements}" var="announcement">
                            <tr>
                            <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                                <td>
                                <p class="d-inline-block">${announcement.text}</p>
                                <input type="hidden" name="announcementID" value="${announcement.announcementID}">
                                </td>
                                <td>
                                    <button class="btn bg-transparent text-secondary" type="submit" name="editMenu" value="edit">Edit</button>
                                </td>
                                
                                <td>
                                
                                <button class ="btn bg-transparent text-danger" type="submit" name="deleteMenu" value="delete">Delete</button>
                               </td>
                            </form>
                            </tr>
                        </c:forEach>
                        </table>
                    </div>
                    
                    <div class="col">
                        <div class="row">
                            <p class="h4">Announcement Creation Form</p>
                        </div>
                        <div class="row">
                            <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST">
                                <p>Enter Announcement Below</p>
                                <input type="text" name="textSubmission" class="form-control mb-2">
                                </div>
                        <div class="row">
                                <div class="container d-flex justify-content-end mb-1 ">
                                <button type="submit" value="add" class="btn bg-secondary text-white d-inline-block">Add Announcement</button>
                                </div>
                        </div>
                        </form>
                        
                        
                    </div>
                    
                    <div class="col border-start">
                        
                        
                    
                        <c:if test="${requestScope.editMenu}">
                            <div class="row">  
                            <p class="h4">Announcement Edit Form</p>
                            </div>
                            <div class="row">    
                            <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST" disabled="true">
                                <p><b>Original Text:</b></p> 
                                <p>${sessionScope.courseAnnouncement.text}</p>
                                <p><b>New Text:</b></p> 
                                <input type="text" name="newText" class="form-control mb-2">
                                <div class="container d-flex justify-content-end mb-1 ">
                                <button type="submit" value="update" class="btn bg-secondary text-white d-inline-block">Update</button>
                                </div>
                            </form>
                            </div>
                        </c:if>
                        <c:if test="${!requestScope.editMenu}">
                            <div class="row">  
                            <p class="h4">Announcement Edit Form</p>
                            </div>
                            <div class="row">    
                            <form action="SiteNavigationFaculty?nav=courseannouncements" method="POST" disabled="true">
                                <p class="text-primary">Press the Edit Button next to Announcement to Activate</p>
                                <input type="text" name="newText" class="form-control mb-2">
                                <div class="container d-flex justify-content-end mb-1 ">
                                <button type="submit" value="update" disabled="true" class="btn bg-secondary text-white d-inline-block">Update</button>
                                </div>
                            </form>
                            </div>
                        </c:if>
                            
                    </div>
                </div>

            </div>    
            <div class="col-1"></div>    

        </div>




    </body>
</html>
