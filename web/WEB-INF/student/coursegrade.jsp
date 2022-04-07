<%-- 
    Document   : newjsp1
    Created on : Feb. 9, 2022, 7:52:46 a.m.
    Author     : massvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet"/>
        <title>Course Grades</title>
    </head>
    <body>
        <!-- Header -->
        <div>
                <%@include file="headerfragment.jspf" %>
        </div>
        
            <!-- Taking out this form. dynamic loading will occur within SiteNavigation, not courseGradeController 
            <form action="courseGradeController" style="border-style: solid">
                This form is a place holder. When app is complete the data will be fed into page dynamically. Try student: cmc21-00001 course_id: 1<br>
                enter student username:<input type="text" name="username"><br>
                enter course id: <input type="text" name="courseID"><br>
                <input type="submit" value="get grades">
                
            </form>
            -->
            
        <!-- Main -->
        <div class="container bg-white rounded p-5">
            <div class="row">
                <div class="col-10">
                    <p class="h3">Course Grade</p>
                </div>
                <hr>
            </div>
            
            <div class="row bg-light rounded">
                <div class="col-4">
                    <p class="h5"><b>Module</b></p>
                </div>
                <div class="col-4">
                    <p class="h5"><b>Assignment</b></p>
                </div>
                <!--
                <div class="col-2">
                    <p class="h5">Weight</p>
                </div>
                -->
                <div class="col-2">
                    <p class="h5"><b>Grade</b></p>
                </div>
            </div>
            <c:set var="gradeXweights" value="0"/>
            <c:set var="weightTotal" value ="0"/>
            <c:forEach var="courseGrade" items="${requestScope.courseGrades}">
                
            <div class="row">
                <div class="col-4">
                    <p class="h5">${courseGrade.lessonName}</p>
                </div>
                <div class="col-4">
                    <p class="h5">${courseGrade.assignmentName}</p>
                </div>
                <!--
                <div class="col-2">
                    <p class="h5">${courseGrade.weight}</p>
                </div>
                 -->
                <div class="col-2">
                    <p class="h5">
                        <c:if test="${courseGrade.isVisible}">
                        ${courseGrade.mark}
                        <c:set var= "weightInDecimal" value="${courseGrade.weight / 100}"/>
                        <c:set var = "gradeXweight" value="${courseGrade.mark * courseGrade.weight}"/>
                        <c:set var="gradeXweights" value="${gradeXweights + gradeXweight}"/>
                        <c:set var ="weightTotal" value = "${weightTotal + courseGrade.weight}"/>
                        </c:if>
                    </p>
                </div>
            </div>
            </c:forEach>
            <div class="row">
                <div class="col-8">
                    <br>
                    <p class="h5">Total Weighted Avg:</p>
                </div>
                <div class="col-2">
                    <p class="h5">
                        <br>
                        <c:set var="result" value="${gradeXweights / weightTotal}"/>
                        <c:choose>
                            <c:when test="${result != null && result != 'NaN'}">
                                ${fn:substring(result,0,5)}
                            </c:when>
                            <c:otherwise>
                                <br>
                                <b>...Looks like you haven't been assigned any grades yet for this course! <br>Check back later</b>
                            </c:otherwise>
                        </c:choose>
                        
                        
                    </p>
                </div>
                <hr>
            </div>
             
            
            
            
        </div>
        
        <!-- Footer -->
        <div>
                
        </div>
        </div>
    </body>
</html>
