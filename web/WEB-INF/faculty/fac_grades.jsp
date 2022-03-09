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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                ${student.fullName} ${student.userID} <br>
            </c:forEach>
            
            <c:set var="count" value="${count + 1}"/>  

        </c:forEach>
        
    </body>
</html>
