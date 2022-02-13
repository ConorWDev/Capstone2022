<%-- 
    Document   : newjsp1
    Created on : Feb. 9, 2022, 7:52:46 a.m.
    Author     : massvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Grades</title>
    </head>
    <body>
        <div>
            <!-- Header Fragment will be inserted here -->
            <%@include file="headerfragment.jspf" %>
        </div>
        <div>
            <table>
                <h1>${courseid} - Grades</h1>
                <c:forEach items="${assignments}" var="assignment">
                    <tr>
                        <td>Assignment # ${Assignmentid}</td>
                    </tr>
                    <tr>
                        <td>${assignment.grade}</td>
                        <td>${assignment.lettergrade}</td>
                    </tr>
                </c:forEach>
                </table>
        </div>
        <div>
            <!-- Footer Fragment will be inserted here -->
            <%@include file="footerfragment.jspf" %>
        </div>
    </body>
</html>
