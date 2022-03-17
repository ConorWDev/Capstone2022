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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
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
        
        
    </body>
</html>
