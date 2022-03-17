<%-- 
    Document   : AdminTemplate
    Created on : Mar. 10, 2022, 12:38:44 p.m.
    Author     : Conor Welch
    You can copy and refactor then change the content section 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="adminstyle.css" rel="stylesheet"/>
    <title>Administrator Landing</title>
</head>
<body>

<!--Header Fragment-->
<%@include file="AdminHeaderFragment.jspf" %>

<!--SideBar Fragment-->
<%@include file="AdminSideBarFragment.jspf" %>    
<!--End of Fragments-->
<div class="row">

    <div class="col p-5 pt-3" id="contentpage">
        <div class="row">
            <div class="container bg-light" id="contentcontainer">
                <div class="row-cols-1 " id="contentheaderrow">
                <p class="h3 ms-3 mt-3 " id="contentheader">Section Header</p>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
