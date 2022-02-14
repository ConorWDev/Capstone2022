<%-- 
    Document   : newjsp1
    Created on : Feb. 9, 2022, 7:52:46 a.m.
    Author     : massvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Grades</title>
    </head>
    <body>
        <!-- Header -->
        <div class="container">
            <div class="row">
                <%@include file="headerfragment.jspf" %>
            </div>
        </div>
        
            <form action="courseGradeController" style="border-style: solid">
                This form is a place holder. Data will be fed into page dynamically<br>
                enter student id:<input type="text" name="username"><br>
                enter course id: <input type="text" name="courseID"><br>
                <input type="submit" value="get grades">
                
            </form>
            
        <!-- Main -->
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="h1">Course Grade</p>
                </div>
                <hr>
            </div>
            
            <div class="row">
                <div class="col-2">
                    <p class="h5">Module</p>
                </div>
                <div class="col-2">
                    <p class="h5">Assignment</p>
                </div>
                <div class="col-2">
                    <p class="h5">Grade</p>
                </div>
                <hr>
            </div>
            <!-- Note: This will become a JSTL Loop -->
            <c:forEach var="courseGrade" items="${requestScope.courseGrades}">
            
            <div class="row">
                <div class="col-2">
                    <p class="h5">${courseGrade.lessonName}</p>
                </div>
                <div class="col-2">
                    <p class="h5">${courseGrade.assignmentName}</p>
                </div>
                <div class="col-2">
                    <p class="h5">${courseGrade.mark}</p>
                </div>
                <hr>
            </div>
                
            </c:forEach>
            
            
            
        </div>
        
        <!-- Footer -->
        <div class="container">
            <div class="row">
                <%@include file="footerfragment.jspf" %>
            </div>
        </div>
    </body>
</html>
