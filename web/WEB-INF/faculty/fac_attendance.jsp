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
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="fac_style.css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-10 bg-light rounded">
        
                <div class="row">   
                <p class="h3 d-inline">Attendance</p>
                <p class="h5 ">${requestScope.attendanceMessage}</p><!-- comment -->
                </div>
                <div class="row">
                <div class="col-3">
                   
                <button  class="btn d-inline justify-content-end"data-bs-toggle="collapse" data-bs-target="#instruct">View Less</button>
             
                <div id="instruct" class=" collapse-show">
                <p>To take attendance....</p>
                 <ul class="list-group bg-transparent">
                    <li class="list-group-item bg-transparent">1. Select the date</li>
                    <li class="list-group-item bg-transparent">2. Check off the students who were present on that day  </li>
                    <li class="list-group-item bg-transparent">3. Select save</li>
                </ul> 
                <p>Note: if you are teaching more than one cohort you will need to track attendance separately.</p>
                </div> 
                </div>
        <c:set var="count" value="0"/>
        
        <c:forEach items="${requestScope.cohorts}" var="cohort">
            <c:set var="countStudent" value="0"/>
            <div class="col-2 ">
                <div class="container border-right">    
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
            </div>
            </div>
        </c:forEach>
            </div>
            
            </div>
            <div class="col-1"></div>
            </div>
            
    </body>
</html>
