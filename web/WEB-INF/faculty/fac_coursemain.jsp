<%-- 
    Document   : fac_coursemain
    Created on : Mar. 8, 2022, 5:44:58 p.m.
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
        <h1>${requestScope.courseName}</h1>
        
        <c:forEach items="${requestScope.modules}" var="module">
            <a href="SiteNavigationFaculty?nav=modulemain&moduleid=${module.lessonId}">${module.name}</a><br>
        </c:forEach>
        
    </body>
</html>
