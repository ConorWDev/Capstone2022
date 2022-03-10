<%-- 
    Document   : fac_studentgrades
    Created on : Mar. 10, 2022, 11:07:23 a.m.
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
        <h1>${requestScope.studentName}'s Grades</h1>
        
        <c:forEach items="${requestScope.studentGrades}" var="grades">
            ${grades.assignmentName} ${grades.mark} <br>
        </c:forEach>
        
        
    </body>
</html>
