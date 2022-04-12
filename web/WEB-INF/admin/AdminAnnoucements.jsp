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
        <title>Create Announcement</title>
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
                            <p class="h2 mb-3 " id="contentheader">Create Announcement</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row  ">
                            <div class="col">
                                <form action="SiteNavigationAdmin?nav=announcements&op=1" method="POST">
                                    <div id="infoblock"class="form-control  ">


                                        <p class="h5 mb-3">Create Cohort Announcement</p>
                                        <label for="cohorts" id="label2" class="form-label mb-0 h6 ">Select Cohort:</label>
                                        <select name="cohorts" class="form-select mb-2 text-primary ">
                                            <c:forEach items="${requestScope.cohorts}" var="cohort">
                                                <option value="${cohort.cohortID}">${cohort.cohortName}</option>
                                            </c:forEach>
                                        </select>

                                        <label for="info2" id="label2" class="form-label mb-0 h6 ">Cohort Annoucement Text</label>
                                        <textarea rows="4" cols="50" type="text" style="resize:none" class="form-control mb-0 border-secondary" id="info2" placeholder="Announcement" name="cohortText"> </textarea>

                                        <div class="row">
                                            <div class="container-fluid d-flex justify-content-end mb-0">
                                                <button type="submit" id="but4" class="btn d-inline text-white bg-secondary" name="createCohortAnn" value="yes">Create Cohort Announcement</button>

                                            </div>
                                        </div>

                                    </div>
                                </form>
                            </div>
                            <div class="col">
                                <form action="SiteNavigationAdmin?nav=announcements&op=1" method="POST">


                                    <div id="infoblock"class="form-control  ">



                                        <p class="h5 mb-3">Create Course Announcement</p>
                                        <label for="courses" id="label2" class="form-label mb-0 h6 ">Select Course:</label>
                                        <select name="courses" class="form-select mb-2 text-primary ">
                                            <c:forEach items="${requestScope.courses}" var="course">
                                                <option value="${course.courseID}">${course.courseName}</option>
                                            </c:forEach>
                                        </select>

                                        <label for="info2" id="label2" class="form-label mb-0 h6">Course Name</label>
                                        <textarea rows="4" cols="50" type="text" style="resize:none" class="form-control mb-0 border border-secondary" id="info2" placeholder="Announcement" name="courseText"> </textarea>

                                        <div class="row">
                                            <div class="container-fluid d-flex justify-content-end mt-0">
                                                <button type="submit" id="but4" class="btn d-inline text-white bg-secondary" name="createCourseAnn" value="yes">Create Course Announcement</button>

                                            </div>
                                        </div>

                                    </div>

                                </form>

                            </div>




                        </div>

                    </div> 

                </div>


            </div>
        </div>
    </div>
</div>

</body>
</html>
