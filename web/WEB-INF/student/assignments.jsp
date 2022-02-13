<%-- 
    Document   : Assignment JSP Page
    Created on : Feb. 12, 2022, 6:04:00 p.m.
    Author     : Cadence Briand - 000832343
    
    Note: This version currently serves as a mockup, I will go back and add
    JSTL and database connectivity when applicable.
    -Cadence B.
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
        <title>146 - Assignments - MTG</title>
    </head>
    <body>
        <!-- Header -->
        <div class="container">
            <div class="row">
                <%@include file="headerfragment.jspf" %>
            </div>
        </div>
            
        <!-- Main -->
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="h1">146 - Assignments</p> 
                </div>
                <hr>
            </div>
            <!-- Note: This will eventually become a JSTL loop that will load in each assignment entry from the DB -->
            <div class="row">
                <div class="col-8">
                    <a class="h5 col" href="">Assignment #</a>
                </div>
                <div class="col-2">
                    <p class="h5">100%</p>
                </div>
                <div class="col-2">
                    <p class="h5">A+</p>
                </div>
                <hr>
            </div>
            <div class="row">
                <div class="col-8">
                    <a class="h5 col" href="">Assignment #</a>
                </div>
                <div class="col-2">
                    <p class="h5">100%</p>
                </div>
                <div class="col-2">
                    <p class="h5">A+</p>
                </div>
                <hr>
            </div>
            <div class="row">
                <div class="col-8">
                    <a class="h5 col" href="">Assignment #</a>
                </div>
                <div class="col-2">
                    <p class="h5">100%</p>
                </div>
                <div class="col-2">
                    <p class="h5">A+</p>
                </div>
                <hr>
            </div>
            <div class="row">
                <div class="col-8">
                    <a class="h5 col" href="">Assignment #</a>
                </div>
                <div class="col-2">
                    <p class="h5">100%</p>
                </div>
                <div class="col-2">
                    <p class="h5">A+</p>
                </div>
                <hr>
            </div>
            <div class="row">
                <div class="col-8">
                    <a class="h5 col" href="">Assignment #</a>
                </div>
                <div class="col-2">
                    <p class="h5">100%</p>
                </div>
                <div class="col-2">
                    <p class="h5">A+</p>
                </div>
                <hr>
            </div>
        </div>
            
        <!-- Footer -->
        <div class="container">
            <div class="row">
                <%@include file="footerfragment.jspf" %>
            </div>
        </div>
        
    </body>
</html>
