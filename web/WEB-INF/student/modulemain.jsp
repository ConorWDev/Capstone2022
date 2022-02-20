<%-- 
    Document   : modulemain
    Created on : Feb. 20, 2022, 12:39:29 a.m.
    Author     : Ryan Checora

    modulemain will give information about a specific module.
    This will hold modulename, description, as well as assignments (TODO) and documents (TODO)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="style.css" rel="stylesheet"/>
        <title>Module - MTG</title>
    </head>
    <body>
        
        
         <%@include file="headerfragment.jspf" %>
         
         
         ${requestScope.moduleName} <br>
         ${requestScope.moduleDescription}
         
         
         
         
         <%@include file="footerfragment.jspf" %>
    </body>
</html>
