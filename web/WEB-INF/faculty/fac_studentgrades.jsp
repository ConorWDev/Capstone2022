<%-- 
    Document   : fac_studentgrades
    Created on : Mar. 10, 2022, 11:07:23 a.m.
    Author     : massvm
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
        <title>Student Grades</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>

        <div class="row">
            <div class="col-1"></div>

            <div class="col bg-white rounded" >
                <div class="row mb-3">

                    <!-- big ol form with lots of stuff
                    1.obtain list of the grades that the student has been assigned from the request scope
                    2. obtain list of all assignments from the whole cohort from the request scope
                    forEach loop through all assignments, if the student has a grade for it print the current grade,
                    if the student does not have a grade for it, print a 0.
                    Each grade text box has a unique identifier that is made unique by the variable count. This way we can
                    parse thorugh each individual grade within the controller upon submission of the form. similarly
                    this is done with a hidden input assignment{count}.
                    
                    after this form is submitted, all grades, even if previously unassigned will be populated within the database
                    with whatever the textbox fields are.
                    -->
                    <div class="container-fluid border-bottom border-primary" id="announcementheader">    
                        <p class="h2 ms-2 mt-2 text-capitalize">${sessionScope.student.fullName}'s Grades</p>
                    </div>

                </div> 
                <div class="row">

                    
                <form action ="SiteNavigationFaculty?nav=studentgrades&studentid=${sessionScope.student.userID}&saveGrade=yes&cohortid=${requestScope.cohortid}" method ="POST">
                    <c:set var="count" value="0"/>
                    <c:set var="grades" value="${requestScope.studentGrades}"/>
                    <c:forEach items="${requestScope.allAssignments}" var="assignment">

                        <p class="mb-0 text-black-50 text-capitalize">${assignment.assignmentName}</p>
                        <c:choose>
                            <%--student has grade for this assignment --%>
                            <c:when test="${grades.size() > count}">
                                <input type ="number" name="newGrade${count}" step="0.1" max="100" min="0" value="${grades.get(count).mark}">
                                <input type="hidden" name="assignment${count}" value="${assignment.assignmentId}">
                            </c:when>
                            <%--student does not have grade for this assignment fill input field with 0.0--%>    
                            <c:otherwise>
                                <input type="number" name="newGrade${count}" step="0.1" max="100" min="0" value="0.0">
                                <input type ="hidden" name="assignment${count}" value="${assignment.assignmentId}">
                            </c:otherwise>
                        </c:choose>
                        <br>
                        <%--Increment one for each assignment --%>
                        <c:set var="count" value="${count + 1}"/>
                    </c:forEach>    
                    <%--pass count to controller for a loop that is used--%>
                    <input type ="hidden" name="count" value="${count}">
                    <input type ="submit" value="Save"> 
                </form>

                ${requestScope.message}
                ${requestScope.count}
                </div>
            </div>
            <div class="col"></div>
        </div>








    </body>
</html>
