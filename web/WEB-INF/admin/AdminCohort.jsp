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
                            <p class="h2 mb-1 " id="contentheader">Cohort Management</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row mt-2 mb-3 d-flex">

                            <div class="col">
                                <p class="h5 ">Cohort List</p>
                                <form action="SiteNavigationAdmin?nav=cohort&op=2" method="POST" class="d-flex-inline">
                                    
                                    <div>
                                        <select multiple="multiple" class="form-select border-secondary mb-1"  id="select1" name="cohortIDs" onchange="this.form.submit()" style="height: 100px">

                                            <c:forEach items="${requestScope.cohorts}" var="cohort">
                                                <option type="checkbox" value="${cohort.cohortID}">${cohort.cohortName}</option>
                                            </c:forEach>   

                                            <!--FOR JSP add loop to build dynamic -->
                                        </select>
                                    </div>
                                </form>
                                
                            </div>
                            <div class="row">
                            <form action="SiteNavigationAdmin?nav=cohort&op=2" method="POST" class="d-flex">
                            <div class="col ms-0">
                                
                                    <p class="h5 border-bottom border-secondary">Cohort Information</p>
                                    <div id="infoblock"class="form-control border border-light">

                                        <input type="hidden" name="cohortID" value="${requestScope.cohortID}">

                                        <label for="info2" id="label2" class="form-label mb-0"><b>Module Name</b></label>
                                        <input type="text" class="form-control mb-1" id="info2" placeholder="Name" value="${requestScope.cohortName}" name="info2">

                                        <div class="row ">
                                            <div class="container-fluid d-flex justify-content-end m-0 p-0">
                                                <button type="submit" id="but4" class="btn d-inline mb-0" name="saveChanges" value="save">Save Changes</button>


                                            </div>
                                            <div class="container-fluid d-flex justify-content-end m-0 p-0">

                                                <button type="submit" id="but6" class="btn d-inline ps-3" name="deleteCohort" value="delete">Delete Cohort</button>

                                            </div>
                                        </div>
                                    </div>
                                
                            </div>
                            <div class="col ms-1">
                                <p class="h5 border-bottom border-secondary">Course List</p>
                                <div class="scrollbox border border-secondary rounded" style="overflow-x:scroll;height:300px;background-color: white">
                                    <c:set var="count" value="${0}"/>
                                    <c:forEach items="${requestScope.allCourses}" var="course">
                                        <c:set var="found" value="${0}"/>
                                        <c:forEach items="${requestScope.relCourses}" var="relCourse">
                                            <c:if test="${relCourse.courseID == course.courseID}">
                                                <input type="checkbox" value="${course.courseID}" name="courseList${count}" checked>${course.courseName}<br>
                                                <c:set var="count" value="${count + 1}"/>
                                                <c:set var="found" value="${found + 1}"/>
                                            </c:if>
                                        </c:forEach>

                                        <c:if test="${found == 0}">
                                            <input type="checkbox" value="${course.courseID}" name="courseList${count}">${course.courseName}<br>
                                            <c:set var="count" value="${count + 1}"/>
                                        </c:if>

                                    </c:forEach>
                                    <input type="hidden" name="courseCount" value="${count}">


                                </div>
                            </div>
                            <div class="col ms-2">
                                <p class="h5 border-bottom border-secondary">Faculty List</p>
                                <div class="scrollbox border border-secondary rounded" style="overflow-x:scroll;height:300px;background-color: white">
                                    <c:set var="countFac" value="${0}"/>
                                    <c:forEach items="${requestScope.allFaculty}" var="faculty">
                                        <c:set var="found" value="${0}"/>
                                        <c:forEach items="${requestScope.relFaculty}" var="relFaculty">
                                            <c:if test="${relFaculty.userID == faculty.userID}">
                                                <input type="checkbox" value="${faculty.userID}" name="facultyList${countFac}" checked>${faculty.fullName}<br>
                                                <c:set var="countFac" value="${countFac + 1}"/>
                                                <c:set var="found" value="${found + 1}"/>
                                            </c:if>
                                        </c:forEach>

                                        <c:if test="${found == 0}">
                                            <input type="checkbox" value="${faculty.userID}" name="facultyList${countFac}">${faculty.fullName}<br>
                                            <c:set var="countFac" value="${countFac + 1}"/>
                                        </c:if>


                                    </c:forEach>
                                    <input type="hidden" name="facultyCount" value="${countFac}">

                                </div>
                            </div>
                            <div class="col me-2 ms-2">

                                <p class="h5 border-bottom border-secondary">Student List</p>
                                <div class="scrollbox border border-secondary rounded" style="overflow-x:scroll;height:300px;background-color: white">
                                    <c:set var="count" value="${0}"/>
                                    <c:forEach items="${requestScope.allStudents}" var="student">
                                        <c:set var="found" value="${0}"/>
                                        <c:forEach items="${requestScope.relStudents}" var="relStudent">
                                            <c:if test="${relStudent.userID == student.userID}">
                                                <input type="checkbox" value="${student.userID}" name="studentList${count}" checked>${student.fullName}<br>
                                                <c:set var="count" value="${count + 1}"/>
                                                <c:set var="found" value="${found + 1}"/>
                                            </c:if>
                                        </c:forEach>

                                        <c:if test="${found == 0}">
                                            <input type="checkbox" value="${student.userID}" name="studentList${count}">${student.fullName}<br>
                                            <c:set var="count" value="${count + 1}"/>
                                        </c:if>


                                    </c:forEach>
                                    <input type="hidden" name="studentCount" value="${count}">
                                      
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
