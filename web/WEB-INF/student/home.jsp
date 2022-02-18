<%-- 
    Document   : HomePage
    Created on : Feb. 9, 2022, 7:28:24 a.m.
    Author     : Conor W
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
        <%@include file="headerfragment.jspf" %>
        <div class="row">
            <div class="col-1">
            </div>
            <div class="col-5 bg-white rounded " style=" width: 525px;">
                <p class="h3 " style="color: #0069d9">Courses</p>
                <div class="row " style="align-content: center">
                    <div class="col-6">
                        <div class="card border-0 stretched-link" >
                            <img class="card-body p-0 align-content-cente stretched-link" width="100%" src="tall.png" alt="tall"/>
                            
                            <div class="card-img-overlay stretched-link card-link">
                                
                                <a href="SiteNavigation?courseNumber=1" class="card-title h4 stretched-link" Style="color: white;">Course One</a>
                                <p Style="color: white;">Health Care Aide Role and Responsibility</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 align-content-center mr-5">
                        <div class="card border-0 mb-4 mr-3" >
                            <img class="card-body p-0 card-img" width="100%" src="short.png" alt="short"/>
                            <div class="card-img-overlay">
                                <a hef="SiteNavigation?nav=coursemain&courseNumber=2" class="card-title h5 stretched-link" Style="color: white;">Course Two</a>
                                <p Style="color: white;">The Human Body, Health and Chronic Illness</p>
                            </div>

                        </div>
                        <div class="card border-0 " style="align-content: center">
                            <img class="card-body p-0 bottom-0 a" width="100%" src="short.png" alt="short"/>
                            <div class="card-img-overlay">
                                <a hef="SiteNavigation?nav=coursemain&courseNumber=3" class="card-title h5 stretched-link" Style="color: white;">Course Three</a>
                                <p Style="color: white;">Communication and Documentation in the Health Care Environment </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8"></div>
                    <div class="col-4">
                        <a href="SiteNavigation?nav=courselist" class="">See full course list</a>
                    </div>
                    <div class="col-8"></div>
                    <div class="col-4">
                        <a href="SiteNavigation?nav=coursemain&courseNumber=1" class="bg-warning">To course Main</a>
                    </div>
                </div>
            </div>
            <div class="col-1">
            </div>
            <div class="col-3 bg-white rounded">
                <p class="h3" style=" color: #0069d9">Announcements</p>
                <c:forEach items="${requestScope.announcements}" var="announcements">
                    <div class="row border-bottom">
                        <!-- 7 annoucement should be the final output update file after -->
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
            <%@include file="footerfragment.jspf" %>
    </body>
</html>