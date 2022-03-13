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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
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
            
        
    </body>
</html>
