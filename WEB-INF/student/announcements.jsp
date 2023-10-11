<%-- 
    Document   : annoucements
    Created on : Feb. 12, 2022, 6:15:00 p.m.
    Author     : Cadence Briand - 000832343
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
        <title>Announcements - MTG</title>
    </head>
    <body>
        <!-- Header -->
        
                <%@include file="headerfragment.jspf" %>
                <div class="row">
                    <div class="col"></div>
                    <div class="col-6 bg-white rounded p-3">
                      <!-- Main -->
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="h3">Announcements</p>                    
                </div>
                <hr>
            </div>
        </div>
        
        
        
        <div class="container">
            <div class="row">
                <!-- Note: This will eventually need an "on Select" function that'll reload the cards in the order specified -->
                <div class="col-3">
                    <p>Sort By:
                        <select name="sortby" id="sortby" >
                            <option value="dateNewOld">Date (New to Old)</option>
                            <option value="dateOldNew">Date (Old to New)</option>
                            <option value="course">Course</option>
                        </select>
                    </p>
                </div>
                <div class="col-3">
                    <p>Filter:
                        <select name="sortby" id="sortby" >
                            <option value="all">All</option>
                            <!-- JSTL Filter Loop Notes:
                                
                                Summary: 
                                    Adds new elements to the select dropdown in accordance to the students available courses.
                                
                                What Will it Call:
                                    An Arraylist containing each course the student is enrolled in
                                
                                Attributes:
                                    courseID    : The ID of the course to choose from.
                                    courseName  : The Human Language name of the course.
                            
                                Potential Changes:
                                    - CourseID and courseName might be the same item, so it may not be necessary to separate them.
                            -->
                            <%--
                            <c:forEach items="courses" var="course">
                                <option value="${course.courseID}">${course.courseName}</option>
                            </c:forEach>
                            <--%>
                        </select>
                    </p>
                </div>
            </div>
            <!-- 
                Announcement Page JSTL Loop Notes:
                
                Summary: 
                    Calls the announcements given the order and filters from above.
                
                List Name: announcement
            
                What Will it Call:
                    - An ArrayList Containing all the announcements pulled from DB
            
                The Attributes of each announcement:
                    - title     : The title of the announcement.
                    - courseID  : The ID of the course it came from (if blank, will be considered as "all").
                    - date      : The date the Announcement was published.
                    - body      : The body text of the announcement, clipped to a specific character length -OR- Line number.
                    - url       : A URL leading to the announcement in full.
            
                Potential Changes:
                    - Could also do a maximum word count, could be weird to shorten the body.
                    - Instead of leading to a URL of just a single announcement, we could have announcements in their full on this page.
            -->
            
            <c:forEach items="${requestScope.announcements}" var="announcements">
                <div class="card">
                    <div class="card-header">
                        <p class="h4" style="float:left;">${announcements.startDate}</p>
                        <span style="float:right;">
                            <p class="h5">${announcements.startDate} - ${announcements.endDate}</p>
                        </span>
                    </div>
                    <div class="card-body">
                        <p>${announcements.text}</p>
                        <span style="float:right">
                            <%-- <a href="${announcement.url}" class="btn btn-primary">Read More...</a><--%>
                        </span>
                    </div>
                </div>
            </c:forEach>
            
        </div>
        
        <!-- Footer -->
        
                
              
                        
                    </div>
                        <div class="col"></div>
                    
                </div>

        
        
        
    </body>
</html>
