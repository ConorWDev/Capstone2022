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
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="fac_style.css" rel="stylesheet"/>
        <title>Cohort Announcement</title>
    </head>
    <body>
        
        <div class="row">
            <div class="col"></div>
            <div class="col bg-light rounded">
        <%@include file="fac_headerfragment.jspf" %>
        <h1>Announcements for ${requestScope.cohortName} Cohort</h1>
        
        <c:forEach items="${requestScope.announcements}" var="announcement">
            ${announcement.text}
        </c:forEach>
        </div>
        <div class="col-1"></div>
        </div>
    </body>
</html>
