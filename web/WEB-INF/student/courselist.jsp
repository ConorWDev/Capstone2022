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
                <input type="submit" value="get grades">
        </form>
        <%@include file="footerfragment.jspf" %>
        
       
        
        
    </body>
</html>
