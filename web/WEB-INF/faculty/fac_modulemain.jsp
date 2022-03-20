<%-- 
    Document   : fac_modulemain
    Created on : Mar. 8, 2022, 8:28:56 p.m.
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
        <title>Module</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        
        <div class="row">
        <div class="col-1"></div>
        
        <div class="col bg-light rounded" >
        
        <h1>${sessionScope.moduleObject.name}</h1>
        ${sessionScope.moduleObject.description}<br>
        
        <b> ASSIGNMENTS </b><br>
        <c:forEach items="${requestScope.assignments}" var="assignment">
            ${assignment.assignmentName}<br>
            ${assignment.assignmentDescription}<br>
        </c:forEach>
            
        <br><b> DOCUMENTS </b><br>
        <c:forEach items="${requestScope.documents}" var="document">
            ${document.name}<br>
            ${document.description}<br>
        </c:forEach>
        </div>
        <div class="col-1"></div>
        </div>    
        
    </body>
</html>
