<%-- 
    Document   : fac_cohortannouncements
    Created on : Mar. 11, 2022, 11:36:31 a.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--This page shows all of the announcements for a particular cohort and allows
for the faculty member to add/edit the cohort annoucments
--%>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="fac_style.css" rel="stylesheet"/>
        <title>Cohort Announcement</title>
    </head>
    <body>


        <%@include file="fac_headerfragment.jspf" %>
        <div class="row">
            <div class="col-1"></div>    
            <div class="col bg-white rounded">
                <div class="row mb-3">

                    <div class="container-fluid border-bottom border-primary" id="announcementheader">    
                        <p class="h2 ms-2 mt-2">Announcements for ${sessionScope.cohort.cohortName} Cohort</p>
                    </div>

                </div> 
                <div class="row">
                    <div class="col">
                        <table class="table border-dark">
                        <c:forEach items="${requestScope.announcements}" var="announcement">
                            
                            <tr class="table-light border-dark border-end-1 ">   
                            <form action="SiteNavigationFaculty?nav=cohortannouncements&cohortid=${sessionScope.cohort.cohortID}" method="POST">
                                
                                <td><p><b>${announcement.startDate}</b></p>
                                    <p>${announcement.text}</p>
                                </td><!-- comment -->
                                <td>
                                <input type="hidden" name="announcementID" value="${announcement.announcementID}">
                                <button class="btn rounded text-secondary bg-transparent" type="submit" name="editMenu" value="edit">Edit</button>
                                </td><!-- comment -->
                                <td>
                                <button class="btn rounded text-danger bg-transparent" type="submit" name="deleteButton" value="delete">Delete</button>
                                </td>
                                
                                
                            </form>
                            </tr>     
                        </c:forEach>
                        </table>    
                    </div>


                    <div class="col">
                        <div class="row ">
                        <p class="h3 border-bottom-1">Announcement Creation Form</p> 
                        </div>
                        <div class="row">
                        <form action="SiteNavigationFaculty?nav=cohortannouncements&cohortid=${sessionScope.cohort.cohortID}" method="POST">
                            <p>Enter Announcement Below:</p>
                            <textarea rows="5" name="textSubmission" class="form-control mb-3"></textarea>
                            <button type="submit" value="add" class="btn bg-secondary text-white">
                                Publish Announcement
                            </button>
                        </form>    
                        <p>${requestScope.message}</p>
                        </div>
                        
                        
                        
                        
                        <div class="row">
                        <c:if test="${requestScope.editMenu}">
                            <p class="h3">Announcement Edit Form</p>  
                            <form action="SiteNavigationFaculty?nav=cohortannouncements&cohortid=${sessionScope.cohort.cohortID}" method="POST">
                                <p><b>Original Text:</b></p><p> ${sessionScope.cohortAnnouncement.text}</p>
                                <p><b>New Text:</b></p> 
                                <input type="text" name="newText" class="form-control mb-3" placeholder="${sessionScope.cohortAnnouncement.text}">
                                <button type="submit" value="update"class="btn bg-secondary text-white mb-3">
                                    Update Post
                                </button>
                            </form>
                        </c:if>
                        ${requestScope.editMessage}
                        </div>
                </div>
                    </div>        
                </div>         
            



            <div class="col-1"></div>        
        </div><!-- comment -->           
    </body>
</html>
