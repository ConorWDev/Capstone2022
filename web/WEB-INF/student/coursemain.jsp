<%-- 
    Document   : coursemain
    Created on : Feb. 9, 2022, 7:57:47 a.m.
    Author     : massvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="style.css" rel="stylesheet"/>
        <title>Course</title>
    </head>
    <body>
        <%@include file="headerfragment.jspf" %>
        <%@include file="footerfragment.jspf" %>
        <div>
            <!-- Header Fragment will be inserted here -->
            <%@include file="headerfragment.jspf" %>
        </div>
        <div>
             <h1>${courseid} - Current Course</h1>
             <div>
             <label for="grades">Grades</label>
             <input type="button" name="grades">
             </div>
             <div>
             <label for="assignments">Assignments</label>
             <input type="button" name="assignments">
             </div>
             <div>
             <label for="modules">Modules</label>
             <input type="button" name="modules">
             <div>
             <label for="courses">Courses</label>
             <input type="button" name="courses">
             </div>
        </div>
        <div>
             <table>
                <h1>${courseid} - Announcements</h1>
                <c:forEach items="${announcements}" var="announcements">
                    <tr>
                        <td>${announcements.title}</td>
                        <td>${announcements.date}</td>
                        <td>${announcement}<td>
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
