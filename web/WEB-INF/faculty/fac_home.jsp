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
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="fac_style.css" rel="stylesheet"/>
        <title>Faculty Home</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        <div class="row">
        <div class="col-1"></div>
        
        <div class="col bg-light rounded" >
            
        
        <p class="h1">Faculty home</p>
        
        <!-- 
        The following code dynamically loads all cohort information that is associated with a faculty member. As a faculty
        member may be assigned to one or more cohort it is the case that we need "lists of lists". What I mean by this is
        that for every cohort, there is a list of courses and list of announcements. To pass a dynamic number of course lists and announcement lists
        it was required to make two ArrayLists that themselves hold ArrayLists. These two lists are called courseLists and announcementLists.
        The following loop gets somewhat complex. it is comprised of an outer loop that loops through the list of cohorts. And two inner loops.
        The first inner loop accessess the courseList list at index (count) and loops through the ArrayList held at that index, printing each
        course within. A similar function is done for the second inner loop that prints out cohort specific announcements 
        
        -->
        <div class="row justify-content-around">
        <!-- For each cohort in the list -->
        <c:set var="count" value="0"/>
        <c:forEach items="${requestScope.cohorts}" var="cohort">
            <div class="col-3">
            <b>${cohort.cohortName}</b><br>
           <!-- Print list of courses for that cohort-->
            <c:forEach items="${requestScope.courseLists.get(count)}" var="course">
                <a href="SiteNavigationFaculty?nav=coursemain&courseid=${course.courseID}">${course.courseName}</a><br>
            </c:forEach>
                
            <b>COHORT SPECIFIC ANNOUNCEMENTS --></b>
             <!-- Print list of announcements for that cohort-->
            <c:forEach items="${requestScope.announcementLists.get(count)}" var="announcement">
                    ${announcement.text}  <br>
            </c:forEach>
             <!-- Provide form for navigation to full cohort announcement list-->
            <form action="SiteNavigationFaculty?nav=cohortannouncements&cohortid=${cohort.cohortID}&cohortname=${cohort.cohortName}" method="POST">
                <input type="submit" value="See all announcements">
            </form>
                
           
               <c:set var="count" value="${count + 1}"/>
               </div>
              </c:forEach>
             
            </div>
        </div>
            <div class="col-1"></div> 
            </div>
    </body>
</html>
