<%-- 
    Document   : annoucements
    Created on : Feb. 12, 2022, 6:15:00 p.m.
    Author     : Cadence Briand - 000832343
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
        <title>Announcements - MTG</title>
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
                    <p class="h3">Announcements</p>                    
                </div>
                <hr>
            </div>
        </div>
        
        <div class="container">
            <div class="row">
                <div class="col-3">
                    <p>Sort By:
                        <select name="sortby" id="sortby" >
                            <option value="dateNewOld">Date (New to Old)</option>
                            <option value="dateOldNew">Date (Old to New)</option>
                            <option value="course">Course</option>
                        </select>
                    </p>
                </div>
                <div class="col-3">
                    <p>Filter:
                        <select name="sortby" id="sortby" >
                            <option value="all">All</option>
                            <option value="courseA">Course A</option>
                            <option value="courseB">Course B</option>
                            <option value="courseC">Course C</option>
                        </select>
                    </p>
                </div>
            </div>

            <div class="card">
                <div class="card-header">
                    <p class="h4" style="float:left">New Assignment - Course A</p>
                    <span style="float:right;">
                        <p class="h5">2022-02-12 | 11:19 pm</p>
                    </span>
                </div>
                <div class="card-body">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam imperdiet lacus sed justo finibus, vitae dapibus felis efficitur. Ut id mollis justo, in tincidunt enim. Aenean ornare, urna ac rhoncus aliquam, mi enim fringilla mauris, in accumsan arcu augue ut orci. Praesent ullamcorper viverra sapien in blandit. Donec consectetur, mi in rhoncus imperdiet, augue urna dictum nisi, sed lobortis nulla est laoreet tellus. Cras aliquam, lacus non dictum suscipit, dolor eros congue nunc, a pretium urna turpis ac sapien. Duis nibh nunc, pellentesque id ultricies quis, posuere sollicitudin risus. Praesent nec erat id quam bibendum accumsan. Suspendisse id convallis justo.
                    </p>
                    <span style="float:right">
                        <a href="#" class="btn btn-primary">Read More...</a>
                    </span>
                </div>
            </div>
            
            <br>
            
            <div class="card">
                <div class="card-header">
                    <p class="h4" style="float:left">New Test - Course B</p>
                    <span style="float:right;">
                        <p class="h5">2022-01-27 | 2:24 pm</p>
                    </span>
                </div>
                <div class="card-body">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam imperdiet lacus sed justo finibus, vitae dapibus felis efficitur. Ut id mollis justo, in tincidunt enim. Aenean ornare, urna ac rhoncus aliquam, mi enim fringilla mauris, in accumsan arcu augue ut orci. Praesent ullamcorper viverra sapien in blandit. Donec consectetur, mi in rhoncus imperdiet, augue urna dictum nisi, sed lobortis nulla est laoreet tellus. Cras aliquam, lacus non dictum suscipit, dolor eros congue nunc, a pretium urna turpis ac sapien. Duis nibh nunc, pellentesque id ultricies quis, posuere sollicitudin risus. Praesent nec erat id quam bibendum accumsan. Suspendisse id convallis justo.
                    </p>
                    <span style="float:right">
                        <a href="#" class="btn btn-primary">Read More...</a>
                    </span>
                </div>
            </div>
            
            <br>
            
            <div class="card">
                <div class="card-header">
                    <p class="h4" style="float:left">Closed for New Years Day</p>
                    <span style="float:right;">
                        <p class="h5">2021-12-18 | 8:00 am</p>
                    </span>
                </div>
                <div class="card-body">
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam imperdiet lacus sed justo finibus, vitae dapibus felis efficitur. Ut id mollis justo, in tincidunt enim. Aenean ornare, urna ac rhoncus aliquam, mi enim fringilla mauris, in accumsan arcu augue ut orci. Praesent ullamcorper viverra sapien in blandit. Donec consectetur, mi in rhoncus imperdiet, augue urna dictum nisi, sed lobortis nulla est laoreet tellus. Cras aliquam, lacus non dictum suscipit, dolor eros congue nunc, a pretium urna turpis ac sapien. Duis nibh nunc, pellentesque id ultricies quis, posuere sollicitudin risus. Praesent nec erat id quam bibendum accumsan. Suspendisse id convallis justo.
                    </p>
                    <span style="float:right">
                        <a href="#" class="btn btn-primary">Read More...</a>
                    </span>
                </div>
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
