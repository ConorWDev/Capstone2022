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
        <!-- Header Fragment -->
        <div>
            <%@include file="headerfragment.jspf" %>
        </div>
        
        <!-- Main Container -->
        <div class="container bg-white rounded p-5">
            <!-- Course Title -->
            <div class="row">
                <p class="h3" id="coursemain-card-header">${requestScope.courseName} - ${requestScope.courseid}</p>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="row">
                        <p class="h5">Grades</p>
                    </div>
                    <hr>
                    <div class="row">
                        <!-- Calling Grades will Go here (TBD) -->
                    </div>
                </div>
                <div class="col-5">
                    <!-- Announcements Row -->
                    <div class="row">
                        <p class="h5">Announcements</p>
                    </div>
                    <hr>
                    <div class="row">
                        <c:forEach items="${requestScope.announcements}" var="announcement">
                            <div class="card">
                                <div class="card-header">
                                    <p class="h5">${announcement.cohortId}</p>
                                </div>
                                <div class="card-body">
                                    <p class="h6">${announcement.startDate} - ${announcement.endDate}</p>
                                    <p>${announcement.text}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Modules Row -->
                    <div class="row">
                        <p class="h5">Modules</p>
                    </div>
                    <hr>
                    <div class="row">
                        <c:forEach items="${requestScope.modules}" var="module">
                            <a href="SiteNavigation?nav=modulemain&moduleid=${module.lessonId}">
                                <div class="card mt-1">
                                    <div class="card-body">
                                        <p class="h5">${module.name}</p>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Fragment -->
        <div>
            <%@include file="footerfragment.jspf" %>
        </div>
    </body>
</html>