
<%--
Document : HomePage
Created on : Feb. 9, 2022, 7:28:24 a.m.
Author : Conor W
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="style.css" rel="stylesheet"/>
        <title>Home</title>
    </head>
    <body>
        <!--Header Fragment-->
        <%@include file="headerfragment.jspf" %>


        
        <!-- Main Section -->
        <div class="container justify-content-around">
            <div class="row"> 
                <div class="col-6 bg-white rounded m-1">
                    <div class="row">
                        <p class="h3 m-3" id="cohort-card-header">${sessionScope.cohortNameMain}</p>
                    </div>
                    <hr>
                    <div class="row m-auto">
                        <c:set var="index" value="0"/>
                        
                        <c:forEach items="${requestScope.courses}" var="course">
                            <c:if test="${index%5==0&&index!=0}">
                                </div>
                                <div class="row m-auto">
                            </c:if>
                            <a href="SiteNavigation?nav=coursemain&courseid=${course.courseID}">
                                <div class="card m-1" >
                                    <div class="card-body">
                                        <h6>${course.courseName}</h6>
                                    </div>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-5 bg-white rounded m-1">
                    <div class="row">
                        <p class="h3" id="cohort-card-header">Announcements</p>
                    </div>
                    <hr>
                    <c:forEach items="${requestScope.announcements}" var="announcement">
                        <div class="card">
                            <div class="card-header">
                                <p class="h5">${announcement.startDate}</p>
                            </div>
                            <div class="card-body">
                                <p>${announcement.text}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!--        
                <div class="col-3 bg-white rounded">
                    <p class="h3" style=" color: #0069d9">Announcements</p>
                    <c:forEach items="${requestScope.announcements}" var="announcements">
                        <div class="row border-bottom">
                             7 annoucement should be the final output update file after 
                            <%--> <p class="h4" style="float:left;">${announcement.title} - ${announcement.courseID}</p> <--%>

                            <p class=" d-inline">${announcements.startDate} <b>-</b> ${announcements.text}</p>

                        </div>
                    </c:forEach>
                    <div class="row mt-0 pt-0 pb-3">
                        <div class="col-5 align-content-end">
                            <a href="SiteNavigation?nav=announcements" class="h6" style=" color: #0069d9; float: right">See All Announcements</a>
                        </div>
                    </div>
                </div>
                <div class="col-1">
                </div>
            </div>
        -->
        <!-- Footer Fragment -->
        
    </body>
</html>