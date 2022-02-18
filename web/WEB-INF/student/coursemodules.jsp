<%-- 
    Document   : coursemodules
    Created on : Feb. 9, 2022, 7:58:18 a.m.
    Author     : massvm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="style.css" rel="stylesheet"/>
        <title>Modules</title>
    </head>
    <body>
       <div>
            <!-- Header Fragment will be inserted here -->
            <%@include file="headerfragment.jspf" %>
        </div>
        
        <form action="courseModulesController" style="border-style: solid">
                enter course:<input type="text" name="courseNum"><br>
                <input type="submit" value="get modules">
        </form>
        
        <form action="modules" method="POST">
            <div class="row">
            <div class="col-1">

            </div> 
                 

        <div id="modules" class="col-5 bg-white rounded" style="height: 425px; width: 350px;">
                <p class="h3 " style="color: #0069d9">${courseid} - Modules</p>
                <div class="row " style="align-content: center">
             
                <c:forEach items="${requestScope.modules}" var="modules">
                    <div class="row">
                  <div class="col-10">
                      <a class="h5 col" href="courseModulesController?link=yes">${modules.name}</a>
                  </div>
                    </div>
                </c:forEach>
        </div>
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