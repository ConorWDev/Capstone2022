<%-- 
    Document   : coursemain
    Created on : Feb. 9, 2022, 7:57:47 a.m.
    Author     : massvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet"/>
        <title>Course</title>
    </head>
    <body>
        <div>
            <!-- Header Fragment will be inserted here -->
            <%@include file="headerfragment.jspf" %>
        </div>
        
        <form action="course" method="POST">
                <div class="row">
            <div class="col-1">

            </div> 


            <div class="col-5 bg-white rounded p-2">
                <p class="h3 " style="color: #0069d9">${courseid} - Current Course</p>
                <div class="row " style="align-content: center">
                    
                <div class="col-6">
                        <div class="card border-0" >
                    <img class="card-body p-0 align-content-center" width="100%" src="tall.png" alt="tall"/>
                    <p class="h3" style="color:white">Grades</p>
                    
                </div>
                </div>
                
                    <div class="col-6 align-content-center mr-5">
                        <div class="card border-0 mb-4 mr-3" >
                <img class="card-body p-0" width="100%" src="short.png" alt="short"/>
                </div>
                <div class="card border-0" style="align-content: center">
                <img class="card-body p-0" width="100%" src="short.png" alt="short"/>
                
                
                </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-8"></div>
                    <div class="col-4">    
                    <a href="#" class="">See full course list</a>
                </div>
                </div>
            </div> 



            <div class="col-1">

            </div> 
            <div class="col-3 bg-white rounded shadow">
                <p class="h3" style=" color: #0069d9">${courseid} - Announcements</p>
            </div>
            <div>
                <table>
                <c:forEach items="${announcements}" var="announcements">
                    <tr>
                        <td>${announcements.title}</td>
                        <td>${announcements.date}</td>
                        <td>${announcement}<td>
                    </tr>
                </c:forEach>
                </table>
            </div>

            <div class="col-1">

            </div> 
        </div>
                                 

        </form>
    
        <div>
            <!-- Footer Fragment will be inserted here -->
            <%@include file="footerfragment.jspf" %>
        </div>
    </body>
</html>