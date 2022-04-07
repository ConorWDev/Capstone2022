<%-- 
    Document   : coursemain
    Created on : Feb. 9, 2022, 7:57:47 a.m.
    Author     : massvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
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
                <p class="h3" id="coursemain-card-header">${requestScope.courseName}</p>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <!-- Grades Row -->
                    <div class="row">
                        <div class="col-6">
                            <p class="h5">Grades</p>
                        </div>
                        <div class="col-6 text-end">
                            <a class="btn btn-primary" href="SiteNavigation?nav=coursegrade&courseid=${requestScope.courseid}">
                                View All
                            </a>                        
                        </div>
                    </div>
                    <hr>
                    <div class="row">
                        <c:forEach items="${requestScope.courseGrades}" var="courseGrade">
                            <div class="row rounded bg-light my-2">
                                <div class="col-4"><p>${courseGrade.assignmentName}</p></div>
                                <div class="col-4"><p>${courseGrade.weight}</p></div>
                                <div class="col-4">
                                    <p>
                                        ${courseGrade.mark} % - 
                                        <fmt:parseNumber var="gradeLetter" type="number" value="${courseGrade.mark}" />
                                        <c:choose>
                                            <c:when test="${gradeLetter > 90}">
                                                A+
                                            </c:when>
                                            <c:when test="${gradeLetter > 85}">
                                                A
                                            </c:when>
                                            <c:when test="${gradeLetter > 80}">
                                                A-
                                            </c:when>
                                            <c:when test="${gradeLetter > 77}">
                                                B+
                                            </c:when>
                                            <c:when test="${gradeLetter > 73}">
                                                B
                                            </c:when>
                                            <c:when test="${gradeLetter > 70}">
                                                B-
                                            </c:when>
                                            <c:when test="${gradeLetter > 67}">
                                                C+
                                            </c:when>
                                            <c:when test="${gradeLetter > 63}">
                                                C
                                            </c:when>
                                            <c:when test="${gradeLetter > 60}">
                                                C-
                                            </c:when>
                                            <c:when test="${gradeLetter > 55}">
                                                D+
                                            </c:when>
                                            <c:when test="${gradeLetter > 50}">
                                                D
                                            </c:when>
                                            <c:otherwise>
                                                F
                                            </c:otherwise>
                                        </c:choose>
                                    </p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-5">
                    <!-- Announcements Row -->
                    <div class="row">
                        <div class="col-6">
                            <p class="h5">Announcements</p>
                        </div>
                        <div class="col-6 text-end">
                            <a class="btn btn-primary" href="SiteNavigation?nav=announcements">
                                View All
                            </a>                        
                        </div>
                    </div>
                    <hr>
                        <c:forEach items="${requestScope.courseAnnouncements}" var="announcement">
                            <div class="card mb-2">
                                <div class="card-header">
                                        <p class="h5">${announcement.startDate}</p>
                                        
                                </div>
                                <div class="card-body">
                                    <p>${announcement.text}</p>
                                </div>
                            </div>
                        </c:forEach>
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
            
        </div>
    </body>
</html>