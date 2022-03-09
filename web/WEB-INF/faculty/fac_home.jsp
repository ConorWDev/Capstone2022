<%-- 
    Document   : faculty_home
    Created on : Mar. 8, 2022, 2:48:03 p.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        <h1>Faculty home</h1>
        
        <!-- 
        The following code dynamically loads all cohort information that is associated with a faculty member. As a faculty
        member may be assigned to one or more cohort it is the case that we need "lists of lists". What I mean by this is
        that for every cohort, there is a list of courses and list of announcements. To pass a dynamic number of course lists and announcement lists
        it was required to make two ArrayLists that themselves hold ArrayLists. These two "inception" lists are called courseLists and announcementLists.
        The following loop gets somewhat complex. it is comprised of an outer loop that loops through the list of cohorts. And two inner loops.
        The first inner loop accessess the courseList inception list at index (count) and loops through the ArrayList held at that index, printing each
        course within. A similar funciton is done for the second inner loop that prints out cohort specific announcements 
        
        -->
        
        <c:set var="count" value="0"/>
        <c:forEach items="${requestScope.cohorts}" var="cohort">
            <b>${cohort.cohortName}</b><br>
           
            <c:forEach items="${requestScope.courseLists.get(count)}" var="course">
                <a href="SiteNavigationFaculty?nav=coursemain&courseid=${course.courseID}">${course.courseName}</a><br>
            </c:forEach>
                
                <b>COHORT SPECIFIC ANNOUNCEMENTS --></b>
            <c:forEach items="${requestScope.announcementLists.get(count)}" var="announcement">
                ${announcement.text}  <br>
            </c:forEach>
                
           
               <c:set var="count" value="${count + 1}"/>
               
        </c:forEach>
        
    </body>
</html>
