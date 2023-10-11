<%-- 
    Document   : reportcard
    Created on : Feb. 9, 2022, 8:05:14 a.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="style.css" rel="stylesheet"/>
        <title>Report Card</title>
    </head>
    <body>
        <!-- Header -->
        <div>
           <%@include file="headerfragment.jspf" %>         
        </div>
        
        <!-- Main -->
        <div class="container rounded bg-light my-2">
            
            <div class="row">
                <div class="col border-0">
                    <p class="h1" style="font-weight: bold; color:#0069d9; text-decoration: none">Report Card</p>
                </div>
                <hr>
            </div>
            <div class="row">

                <div class="col-10">
                    <p class="h5" style="font-weight: bold; color:  slategrey " >Course</p>
                </div>
                <div class="col-2">
                    <p class="h5" style="font-weight: bold; color: slategrey ">Grade</p>
                </div>
                  <c:set var="courseTotal" value="0"/>
                    <c:set var="count" value="0"/>
                    
                    <c:forEach var="courses" items="${requestScope.courses}">
                        <div class="row">
                            <div class="col-10">
                                <!--The link generated will pass two variable back to SiteNavigation
                                1) nav, which will determine the more general if/else structure within SiteNavigation
                                2) courseid, this will allow for the dynamic loading of particular course assignments into the courseGrade page-->
                                <a class=""  href="SiteNavigation?nav=coursegrade&courseid=${courses.courseID}">${courses.courseName}</a>
                            </div>
                            <div class="col-2" style='align-content: center'>
                                <p>${courses.courseAvg!="NaN"?courses.courseAvg:"-"}</p>
                            </div>
                        </div>
                            
                        <c:if test="${courses.courseAvg>=0 && courses.courseAvg<=100}">
                            <c:set var="courseTotal" value="${courseTotal + courses.courseAvg}"/> 
                            <c:set var="count" value="${count + 1}"/>
                        </c:if>
                    </c:forEach>
                    
                           
                    <div class="row ">
                        <div class="col-10">
                            <p class="h5" style="font-weight: bold; color:  slategrey " >Total Course Avg.</p>
                        </div>
                        <div class="col-2">
                            <c:set var="courseAvg" value="${courseTotal / count}"/>
                                
                            <c:choose>
                            <c:when test="${result != null || result != 'NaN'}">
                                <b>${fn:substring(courseAvg,0,5)} </b>
                            </c:when>
                        </c:choose>
                        </div>
                       
                    </div>
            </div>                
                           

                    <!-- 
                        JSTL Report Card loop notes:
                        Summary:
                            Loads the grades from each course into separate rows in a container.
                        List Name: courseReport
                        What Will it Call:
                            - An ArrayList containing both the course name and it's average.
                        Attributes List:
                            courseName       : The name of the course.
                            courseAvg        : The average calculated grade from the course.
                        Potential Changes:
                            - Variables can be adjusted to fit a common ground.
                            - Potentially could be adding a URL that will take you to the Courses grade page.
                    -->          
        </div>
        <div>
            <!-- Footer -->
            
        </div>

    </body>
</html>