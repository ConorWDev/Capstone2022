<%-- 
    Document   : fac_cohortannouncements
    Created on : Mar. 11, 2022, 11:36:31 a.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--This page shows all of the announcements for a particular cohort and allows
for the faculty member to add/edit the cohort annoucments
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Announcements for ${requestScope.cohortName} Cohort</h1>
        
        <c:forEach items="${requestScope.announcements}" var="announcement">
            ${announcement.text}
        </c:forEach>
        
    </body>
</html>
