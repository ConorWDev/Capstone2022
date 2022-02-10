<%-- 
    Document   : newjsp
    Created on : Feb. 9, 2022, 7:52:39 a.m.
    Author     : massvm
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
        <title>JSP Page</title>
    </head>
    <body>
        <div>
         <!-- Header Fragment will be inserted here -->
        </div>
        <div>
          <!-- Assignments table will be inserted here -->
        </div>
        <div>
          <!-- Footer Fragment will be inserted here -->
        </div>
        <%@include file="headerfragment.jspf" %>
    </body>
</html>
