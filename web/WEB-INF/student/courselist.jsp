<%-- 
    Document   : newjsp1
    Created on : Feb. 9, 2022, 7:52:46 a.m.
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
        <title>Course Grades</title>
    </head>
    <body>
         
        <%@include file="headerfragment.jspf" %>
        <p class="h1 bg-danger">Under Construction </p>
        <form action="courseListController" style="border-style: solid">
                This form is a place holder. When app is complete the data will be fed into page dynamically. Try student: cmc21-00001<br>
                enter student username:<input type="text" name="username"><br>
                <input type="submit" value="get courses">
                
        </form>
        <!-- here we are pulling course data from the arraylist of course objects passed by courseListController.
        
             courses.description can be used to pull course descriptions however this data will be null in the 
             current database that we are running. As such, to have that functionality we will need to first populate
             the description column within the ma_course table in the database. -Ryan
        -->
        <c:forEach var="courses" items="${requestScope.courses}">                
            ${courses.courseName}  <br>   
        </c:forEach>
        
        
        <%@include file="footerfragment.jspf" %>
        
       
        
        
    </body>
</html>
