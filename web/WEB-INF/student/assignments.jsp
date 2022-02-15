<%-- 
    Document   : Assignment JSP Page
    Created on : Feb. 12, 2022, 6:04:00 p.m.
    Author     : Cadence Briand - 000832343
    
    Note: This version currently serves as a mockup, I will go back and add
    JSTL and database connectivity when applicable.
    -Cadence B.
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
        
        <title>146 - Assignments - MTG</title>
    </head>
    <body>
        <!-- Header -->
        <div class="container">
            <div class="row">
                <%@include file="headerfragment.jspf" %>
            </div>
        </div>
            
        <!-- Main -->
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="h1">146 - Assignments</p> 
                </div>
                <hr>
            </div>
            
            <div class="row">
                <div class="col-4"><p class="h5">Assignment</p></div>
                <div class="col-2"><p class="h5">Status</p></div>
                <div class="col-3"><p class="h5">Grade</p></div>
                <div class="col-3"><p class="h5">Due Date</p></div>
                <hr>
            </div>
            
            <!-- 
                JSTL Assignment loop notes:
                
                Summary:
                    Loads every assignment from the course into rows
            
                List Name: assignments
                
                What Will it Call:
                    - An ArrayList containing all the assignments the student has in the course
            
                Attributes List:
                    url     : the URL that will download the assignment file
                    status  : The current status of the assignment (incomplete, complete, marked, etc.)
                    grade   : Shows the grade recieved and/or it's marks worth (format: a/b - ##%)
                    dueDate : The Date and time the assignment must be handed in prior to (format: Month-Day-Year | HH:MM am/pm)
            
                Potential Changes:
                    <TBD>
            -->
            <c:forEach items="${assignments}" var="assignment">
                <div class="row">
                    <div class="col-4"><a class="h5" href="${assignment.url}">${assignment.name}</p></div>
                    <div class="col-2"><p class="h5">${assignment.status}</p></div>
                    <div class="col-3"><p class="h5">${assignment.grade}</p></div>
                    <div class="col-3"><p class="h5">${assignment.dueDate}</p></div>
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
