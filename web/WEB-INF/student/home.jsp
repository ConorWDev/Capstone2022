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


            <div class="col-5 bg-white rounded p-2" >
                <p class="h3 " style="color: #0069d9">Courses</p>
                <div class="row">
                    
                <div class="col-6">
                        <div class="card border-0" >
                    <img class="card-body p-0 align-content-center" width="100%" src="tall.png" alt="tall"/>
                    
                </div>
                </div>
                
                    <div class="col-6 align-content-center">
                        <div class="card border-0 mb-4" >
                <img class="card-body p-0" width="100%" src="short.png" alt="short"/>
                </div>
                <div class="card border-0 " >
                <img class="card-body p-0 " width="100%" src="short.png" alt="short"/>
                </div>
                    </div>
                </div>
            </div> 

            


            <div class="col-1">

            </div> 
            <div class="col-3 bg-white rounded">
                <p class="h3" style=" color: #0069d9">Announcements</p>
            </div>

            <div class="col-1">

            </div> 
        </div>
        <%@include file="footerfragment.jspf" %>





    </body>
</html>
