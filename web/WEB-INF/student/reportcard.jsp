<%-- 
    Document   : reportcard
    Created on : Feb. 9, 2022, 8:05:14 a.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="style.css" rel="stylesheet"/>
        <title>Report Card</title>
    </head>
    <body>
        <!-- Header -->
        <div class="container">
            <div class="row">
                <%@include file="headerfragment.jspf" %>
            </div>
        </div>
        
             <form action="reportcardController" style="border-style: solid">
                This form is a place holder. When app is complete the data will be fed into page dynamically. Try student_id: cmc21-00001<br>
                enter student username:<input type="text" name="username"><br>
                <input type="submit" value="get report">
                
            </form>
            
        <!-- Main -->
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="h1">Report Card</p>
                </div>
                <hr>
            </div>
            
            <div class="row">
                <div class="col-8">
                    <p class="h5">Course</p>
                </div>
                <div class="col-2">
                    <p class="h5">Grade</p>
                </div>
                <hr>
            </div>
            <c:forEach var="courses" items="${requestScope.courses}">
            <div class="row">
                <div class="col-8">
                    <a class="h5 col" href="reportcardController?link=yes">${courses.courseName}</a>
                </div>
                <div class="col-2">
                    <p class="h5">${courses.courseAvg}</p>
                </div>
                <hr>
            </div>
            </c:forEach>
        
        <!-- Footer -->
        <div class="container">
            <div class="row">
                <%@include file="footerfragment.jspf" %>
            </div>
        </div>
    </body>
</html>
