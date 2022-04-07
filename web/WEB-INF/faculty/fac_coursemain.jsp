<%-- 
    Document   : fac_coursemain
    Created on : Mar. 8, 2022, 5:44:58 p.m.
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
        <title>Course</title>
    </head>
    <body>


        <%@include file="fac_headerfragment.jspf" %>
        <div class="row">
            <div class="col-1"></div>
            <div class="col bg-white rounded">
                
                <div class="row mb-3">

                    <div class="container-fluid border-bottom border-primary" id="announcementheader">    
                        <p class="h2 ms-2 mt-2">${sessionScope.courseObject.courseName}</p>
                    </div>

                </div> 
                <div class="row">
                    <div class="col-4">
                        <div class="row">
                            <p class="h4 ms-3">Course Announcements</p> 
                        </div>    
                <c:forEach items="${requestScope.modules}" var="module">
                    <div class="row ms-3 p-1">
                    <a class="d-flex btn border-bottom-primary bg-white text-primary" href="SiteNavigationFaculty?nav=modulemain&moduleid=${module.lessonId}">${module.name}</a>
                    </div>
                    </c:forEach>
                </div> 
                <div class="col-8">
                    <div class="row  ms-3 me-5">   
                <p class="h4 ">Course Announcements</p>    
                    </div> 
                <%--TODO limit printout of announcemnts to three or something. View all announcements on next page --%>    
                <div class="row ms-3 me-5">
                <select multiple="multiple"class=" form-select mb-3" id="annselect" style="height: 300px">    
                    
                <c:forEach items="${requestScope.announcements}" var="announcement">
                    
                    
                    <option> 
<!--                        <p class="h6"></p>-->
                        <p class="h6">${announcement.startDate}:  ${announcement.text}</p>
                    </option>   
                        
                           
                        
<!--                    private String cohortId;
                private String text;
                private String startDate;
                private String endDate;
                private boolean isVisible;-->
                </c:forEach>
                </select>    
                </div>
                <div class="row ms-3 me-5 justify-content-end">
                
                    <a type="submit" href="SiteNavigationFaculty?nav=courseannouncements" class="btn-block  text-primary justify-content-end mb-5" value="View/Edit Announcements">
                    View/Edit Announcements</a>
                
                </div>    
                </div>
                
                </div>

                
            </div>
            <div class="col-1"></div>
        </div>


    </body>
</html>
