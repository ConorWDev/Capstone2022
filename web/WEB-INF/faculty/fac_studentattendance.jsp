<%-- 
    Document   : fac_studentattendance
    Created on : Mar. 16, 2022, 3:56:31 p.m.
    Author     : ryanc
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
        <title>Attendance</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        
        
        <div class="row">
        <div class="col-1"></div>
        
        <div class="col bg-white rounded" id="containerfac">
        <h1>${requestScope.studentName}'s Attendance Record</h1>
        If you wish to change the record for a particular day, click on the Present/Absent button...<br><br>
        
        <c:forEach items="${requestScope.attendanceList}" var="attendance">
            
            ${attendance.date}
           
            <c:choose>
                <c:when test="${attendance.present}">
                    <a href="SiteNavigationFaculty?nav=studentattendance&studentID=${requestScope.studentID}&date=${attendance.date}&isPresent=true&studentName=${requestScope.studentName}">Present</a>
                </c:when>
                <c:otherwise>
                    <a href="SiteNavigationFaculty?nav=studentattendance&studentID=${requestScope.studentID}&date=${attendance.date}&isPresent=false&studentName=${requestScope.studentName}">Absent</a>
                </c:otherwise>
            </c:choose>
            <br>
            
        </c:forEach>
        </div>
        <div class="col-1"></div>
        </div>
        
    </body>
</html>
