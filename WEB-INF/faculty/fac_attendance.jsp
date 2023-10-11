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
            <div class="col bg-white rounded">
                <div class="row mb-3">

                    <div class="container-fluid border-bottom border-primary" id="announcementheader">    
                        <p class="h2 ms-2 mt-2">Attendance</p>
                        <p class="text-success text-capitalize">${requestScope.attendanceMessage}<p>
                    </div>

                </div> 
                <div class="row">
                    <div class="col border-end">
                        <p><b>To take attendance:</b></p>

                        <p>1. Select the date.</p>
                        <p>2. Check off the students who were present on that day.</p>
                        <p>3. Select save.</p>

                        <p><b class="text-primary">Note:</b> If you are teaching more than one cohort you will need to track attendance separately.</p>

                    </div>
                    <c:set var="count" value="0"/>

                    <c:forEach items="${requestScope.cohorts}" var="cohort">
                        <c:set var="countStudent" value="0"/>
                        <div class="col border-end mb-3">

                            <p class="mb-2"><b>${cohort.cohortName}</b></p>

                            <form action="SiteNavigationFaculty?nav=attendance" method="POST">
                                <%--print out calendar --%>
                                <input type="date" name="date" required="" class="form-control text-primary text-center">

                                <%--print out list of students with a checkbox for present vs absent.
                                each checkbox is given a unique name attendance{count} so that each
                                individual student checkbox data can be obtained and then persisted
                                later on into the database
                                --%>
                                <table class="table p-2 mb-2">
                                <c:forEach items="${requestScope.studentLists.get(count)}" var="student">
                                    <tr class="pt-2">
                                        <td>    
                                    <a class="text-primary text-decoration-none text-capitalize mt-2" href="SiteNavigationFaculty?nav=studentattendance&studentName=${student.fullName}&studentID=${student.userID}">${student.fullName}</a> 
                                        </td>
                                        <td>
                                            <p>${student.userID}<p>
                                    </td>
                                    <td><input type="checkbox" name="attendanceCheck${countStudent}" value="${student.userID}"></td>

                                    <%--This hidden field is used to capture every student ID within the cohort. this is needed as only the checked
                                    boxes above will return a student ID. With this in mind we will have two lists. A list of student ids that are marked
                                    present for a given day. And a list of all ids in the ochort. These two lists will be used to determine who is and isnt
                                    present for a given day, and that info will be persisted to the DB--%>
                                    <input type="hidden" name="attendanceHidden${countStudent}" value="${student.userID}">

                                    <%--increase countStudent for each student. This value is used for creating unique attendanceCheck{count} names
                                    for each checkbox as well as a fincal studentCount parameter within the hidden input below--%>
                                    <c:set var="countStudent" value="${countStudent + 1}"/>
                                    </tr>
                                </c:forEach>
                                </table>    
                                <%--hidden form that passes the count --%> 
                                <input type="hidden" name="studentCount" value="${countStudent}">
                                <%--submit button--%> 
                                
                                
                                <button type="submit" value="Save ${cohort.cohortName} Attendance"class="btn bg-secondary text-white mb-2">
                                    Save ${cohort.cohortName} Attendance
                                </button>
                            </form>   

                            <c:set var="count" value="${count + 1}"/> 
                        </div>
                    </c:forEach>    


                </div>
            </div>













            <div class="col-1"></div>
        </div>
    </div>
</body>
</html>
