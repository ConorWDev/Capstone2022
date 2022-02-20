<%-- 
    Document   : coursemain
    Created on : Feb. 9, 2022, 7:57:47 a.m.
    Author     : massvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet"/>
        <title>Course</title>
    </head>
    <body>
        <div>
            <!-- Header Fragment will be inserted here -->
            <%@include file="headerfragment.jspf" %>
        </div>
        
        
        <form action="course" method="POST">
                <div class="row">
            <div class="col-1">

            </div> 


            <div class="col-5 bg-white rounded p-2">
                <p class="h3 " style="color: #0069d9">${requestScope.courseName}</p>
                <div class="row " style="align-content: center">
                    
                <div class="col-6">
                        <div class="card border-0" >
                            <a href="SiteNavigation?nav=coursegrade&courseid=${requestScope.courseid}"><img class="card-body p-0 align-content-center" width="100%" src="tall.png" alt="tall"/>
                        <span class="h5">Grades</span></a>
                    
                </div>
                </div>
                
                    <div class="col-6 align-content-center mr-5">
                        <div class="card border-0 mb-4 mr-3" >
                <!-- changing href to send directly to SiteNavigation with no additional variable. This is for testing purposes. 
                Will have to add the dynamic data passing later          
                <a href="SiteNavigation?nav=assignments?assignment=#"><img class="card-body p-0" width="100%" src="short.png" alt="short"/> -->
                
                <!-- Commenting out assignments. Assignments will be found within the yet to be created modulemain.jsp TODO Feb19
                
                <a href="SiteNavigation?nav=assignments"><img class="card-body p-0" width="100%" src="short.png" alt="short"/>
                <span id ="assignments" class="h5">Assignments</span></a></div> -->
                
                
                
                 
                <div class="card border-0" style="align-content: center">    
                    <a href=""><img class="card-body p-0" width="100%" src="short.png" alt="short"/> 
                <span id="modules" class="h5">${module.name}</span></a>
                </div> 
             
                
                
                <!--Here is the newly added loop for dynamic modules of each course. Some visual changes from front end are required here
                clicking these bubbles will take you to the modulemain.jsp page-->
                
                
                <c:forEach items="${requestScope.modules}" var="module">
                    <a href="SiteNavigation?nav=modulemain&moduleid=${module.lessonId}">${module.name}</a>
                </c:forEach>
                
                
                    </div>
                </div>
                <div class="row">
                    <div class="col-8"></div>
                    <div class="col-4">    
                </div>
                </div>
            </div> 
            <div class="col-1">
            </div> 
            
            <!--   Announcement functionality on coursemain has been removed. This more closely resembles
                    the logic within the database, as announcements will be cohort specific. This code may
                    be deleted
            
            <div class="col-3 bg-white rounded">
                <p class="h3" style=" color: #0069d9">Announcements</p>
                
                    <div class="row border-bottom">
                        <!-- 7 annoucement should be the final output update file after 
                            <%--> <p class="h4" style="float:left;">${announcement.title} - ${announcement.courseID}</p> <--%>            
                            <p class=" d-inline">{announcements.startDate} <b>-</b> {announcements.text}</p>
                    </div>
                  
                    <div class="row mt-0 pt-0 pb-3">
                        <div class="col-5 align-content-end">
                            <a href="SiteNavigation?nav=announcements" class="h6" style=" color: #0069d9; float: right">See All Announcements</a>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-5">
                        <a href="SiteNavigation?nav=announcements" class="h6" style=" color: #0069d9">See All Announcements</a>
                    </div>
                </div>
                    -->
            </div>
            <div class="col-1">
            </div>
        </div>
                                

        </form>
    
        <div>
            <!-- Footer Fragment will be inserted here -->
            <%@include file="footerfragment.jspf" %>
        </div>
    </body>
</html>