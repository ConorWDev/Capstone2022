<%-- 
    Document   : AdminTemplate
    Created on : Mar. 10, 2022, 12:38:44 p.m.
    Author     : Conor Welch
    You can copy and refactor then change the content section 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="adminstyle.css" rel="stylesheet"/>
        <title>Cohort Management</title>
    </head>
    <body>
        <!--Header Fragment-->
        <!--Top of the admin bar-->
        <%@include file="AdminHeaderFragment.jspf" %>


        <div class="row">
            <!--SideBar Fragment-->   
            <%@include file="AdminSideBarFragment.jspf" %>
            <!--End of Fragment-->


            <!--CONTENT SECTION-->
            <div class="col p-5 pt-3" id="contentpage">
                <div class="row">
                    <div class="container pe-2" id="contentcontainer" >
                        <div class="row-cols-1 mt-3" id="contentheaderrow">
                            <p class="h2 mb-1 " id="contentheader">Reports</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row mt-2 mb-3 d-flex">

                            <div class="col">
                                <p class="h5 ">Attendance Records</p>
                                <form action="SiteNavigationAdmin?nav=adminreport&op=1" method="POST" class="d-flex-inline">
                                     
                                    <div>
                                        
                                        <div class="scrollbox border border-secondary rounded" style="overflow-x:scroll;height:300px;background-color: white">
                                            <c:forEach items="${requestScope.attendanceLists}" var="attendanceList">
                                                <c:set var="count" value="${0}"/>
                                                <c:forEach items="${attendanceList}" var="attendance">
                                                    
                                                    <c:if test="${count == 0}">
                                                        <b>Student ID: ${attendance.student_username}</b><br>
                                                    </c:if>
                                                    <c:set var="count" value="${count + 1}"/>    
                                                    ${attendance.date}
                                                    <c:choose>
                                                        <c:when test="${attendance.present}">
                                                           Present 
                                                        </c:when>
                                                        <c:otherwise>
                                                            Absent
                                                        </c:otherwise>
                                                    </c:choose>
                                                    
                                                     <br>
                                                </c:forEach>

                                            </c:forEach>
                                        </div>
                                        
                                        
                                    </div>
                                </form>
                                <p class="h5 ">All Grades</p>
                                 <form action="SiteNavigationAdmin?nav=adminreport&op=1" method="POST" class="d-flex-inline">
                                     
                                    <div>
                                        
                                        <div class="scrollbox border border-secondary rounded" style="overflow-x:scroll;height:300px;background-color: white">
                                            <c:forEach items="${requestScope.gradeLists}" var="gradeList">
                                                <c:set var="count" value="${0}"/>
                                                <c:forEach items="${gradeList}" var="grade">
                                                    
                                                    <c:if test="${count == 0}">
                                                        <b>Student Name: ${grade.studentName}</b><br>
                                                    </c:if>
                                                    <c:set var="count" value="${count + 1}"/>    
                                                    ${grade.assignmentName}
                                                    ${grade.mark}
                                                     <br>
                                                </c:forEach>

                                            </c:forEach>
                                        </div>
                                        
                                        
                                        
                                    </div>
                                </form>
                                
                            </div>
                                  
                                  
                        </div>


                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
<div>
