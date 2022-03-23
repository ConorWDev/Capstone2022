<%-- 
    Document   : grades
    Created on : Mar. 8, 2022, 8:43:15 p.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="fac_style.css" rel="stylesheet"/>
        <title>Grades</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        
        <div class="row">
        <div class="col"></div>
        <div class="col bg-light rounded">
        <h1>Grades</h1>
         
        <form action="SiteNavigationFaculty?nav=grades" method="POST">
            <input type="text" name="search" onkeyup="">
            <input type="submit" value="search">
        </form>
          
        
        <br>
        <c:set var="count" value="0"/>
        <c:forEach items="${requestScope.cohorts}" var="cohort">
            <b>${cohort.cohortName}</b><br>
            
            <c:forEach items="${requestScope.studentLists.get(count)}" var="student">
                <a href="SiteNavigationFaculty?nav=studentgrades&studentid=${student.userID}&cohortid=${cohort.cohortID}">${student.fullName} ${student.userID}</a> <br>
            </c:forEach>
            
            <c:set var="count" value="${count + 1}"/>  

        </c:forEach>
        </div>
        <div class="col-1"></div>
        </div>
    </body>
</html>
