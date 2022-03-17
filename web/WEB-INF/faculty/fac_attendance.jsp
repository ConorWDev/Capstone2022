<%-- 
    Document   : fac_attendance
    Created on : Mar. 16, 2022, 11:26:39 a.m.
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
        <h1>Attendance</h1>
        
        To take attendance.... <br> 1) Select the date <br> 2) Check off the students who were present on that day <br> 3) Select save
        <br> Note: if you are teaching more than one cohort you will need to track attendance separately
        <br><br>
      
        
        <c:set var="count" value="0"/>
        
        <c:forEach items="${requestScope.cohorts}" var="cohort">
            <c:set var="countStudent" value="0"/>
            <b>${cohort.cohortName}</b><br>
            
            <form action="SiteNavigationFaculty?nav=attendance" method="POST">
                <%--print out calendar --%>
                <input type="date" name="date" required=""> <br><br>
            
                <%--print out list of students with a checkbox for present vs absent.
                each checkbox is given a unique name attendance{count} so that each
                individual student checkbox data can be obtained and then persisted
                later on into the database
                --%>
                <c:forEach items="${requestScope.studentLists.get(count)}" var="student">
                    <a href="SiteNavigationFaculty?nav=studentattendance&studentName=${student.fullName}&studentID=${student.userID}">${student.fullName}</a> ${student.userID}<input type="checkbox" name="attendanceCheck${countStudent}" value="${student.userID}">
                    <br>
                    <%--This hidden field is used to capture every student ID within the cohort. this is needed as only the checked
                    boxes above will return a student ID. With this in mind we will have two lists. A list of student ids that are marked
                    present for a given day. And a list of all ids in the ochort. These two lists will be used to determine who is and isnt
                    present for a given day, and that info will be persisted to the DB--%>
                    <input type="hidden" name="attendanceHidden${countStudent}" value="${student.userID}">
                    
                    <%--increase countStudent for each student. This value is used for creating unique attendanceCheck{count} names
                    for each checkbox as well as a fincal studentCount parameter within the hidden input below--%>
                    <c:set var="countStudent" value="${countStudent + 1}"/>
                </c:forEach>
                <%--hidden form that passes the count --%> 
                <input type="hidden" name="studentCount" value="${countStudent}">
                <%--submit button--%> 
                <input type="submit" value="Save ${cohort.cohortName} Attendance">
                
            </form>   
            <br> 
            <c:set var="count" value="${count + 1}"/> 

        </c:forEach>
        
            ${requestScope.attendanceMessage}
    </body>
</html>
