<%-- 
    Document   : fac_schedule
    Created on : Apr. 11, 2022, 4:12:39 p.m.
    Author     : ryanc
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
        <title>Schedule</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        <div class="row">
            <div class="col-1">
            </div>
            <div class="col-10 bg-white rounded " >
                <div class="row mb-3">

                    <div class="container-fluid border-bottom border-primary" id="announcementheader">    
                        <p class="h2 ms-2 mt-2">Schedule</p>
                    </div>

                </div> 
                <div class="row p-5" style="align-content: center">
                    
                    <iframe src="${requestScope.url}" height="500"/>
                </div>
                </div>
            </div>
            <div class="col-1">
            </div>
        </div>
        
    </body>
</html>