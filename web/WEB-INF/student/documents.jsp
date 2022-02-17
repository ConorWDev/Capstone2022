<%-- 
    Document   : documents
    Created on : Feb. 9, 2022, 8:02:50 a.m.
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
        <title>documents</title>
    </head>
    <body>
        <div>
             <%@include file="headerfragment.jspf" %>
        </div>
        <form action="docs" method="POST">
            <div class="row">
            <div class="col-1">

            </div> 
        <div class="col-5 bg-white rounded" style="height: 425px; width: 350px;">
                <p class="h3 " style="color: #0069d9">${courseid} - Documents</p>
                <div class="row " style="align-content: center">
             <table>
                <c:forEach items="${document}" var="document">
                    <tr>
                        <td>${document.name}</td>
                    </tr>
                    <tr>
                        <td>
                            <label for="documentdownload">Download</label>
                            <input type="button" name="documentdownload">
                        </td>
                    </tr>
                </c:forEach>
             </table>
        </div>
        </div>
        </form>
        <div>
            <%@include file="footerfragment.jspf" %>
        </div>
    </body>
</html>