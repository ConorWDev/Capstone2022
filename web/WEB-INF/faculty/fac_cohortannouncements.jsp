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
                <div class="row">

                    <div class="container-fluid border-bottom border-primary" id="coanheader">    
                        <p class="h2 ms-2 mt-2">Announcements for ${sessionScope.cohort.cohortName} Cohort</p>
                    </div>

                </div> 
                <div class="row">
                    <div class="col">
                        <table class="table">
                        <c:forEach items="${requestScope.announcements}" var="announcement">
                            
                            <tr>   
                            <form action="SiteNavigationFaculty?nav=cohortannouncements&cohortid=${sessionScope.cohort.cohortID}" method="POST">
                                
                                <td><p>${announcement.startDate}</p>
                                    <p>${announcement.text}</p>
                                </td><!-- comment -->
                                <td>
                                <input type="hidden" name="announcementID" value="${announcement.announcementID}">
                                <button class="btn rounded text-success bg-transparent" type="submit" name="editMenu" value="edit">Edit</button>
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
                        <b>ANNOUNCEMENT CREATION FORM</b>  
                        <form action="SiteNavigationFaculty?nav=cohortannouncements&cohortid=${sessionScope.cohort.cohortID}" method="POST">
                            Text:
                            <input type="text" name="textSubmission" class=""> 
                            <input type="submit" value="add">
                        </form>
                        ${requestScope.message}

                        <br>
                        <c:if test="${requestScope.editMenu}">
                            <b>ANNOUNCEMENT EDIT FORM</b>  
                            <form action="SiteNavigationFaculty?nav=cohortannouncements&cohortid=${sessionScope.cohort.cohortID}" method="POST">
                                Original Text: ${sessionScope.cohortAnnouncement.text}<br>
                                New Text: <input type="text" name="newText">
                                <input type="submit" value="update">
                            </form>
                        </c:if>
                        ${requestScope.editMessage}
                    </div>        
                </div>         
            </div>



                    <div class="col-1"></div>        
        </div><!-- comment -->           
    </body>
</html>
