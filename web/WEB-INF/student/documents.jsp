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
        <title>documents</title>
        <link href="style.css" rel="stylesheet"/>
        <title>Documents</title>
    </head>
    <body>
        <div>
             <%@include file="headerfragment.jspf" %>
        </div>
        <div>
             <table>
                <h1>${courseid} - Documents</h1>
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
        <div>
            <%@include file="footerfragment.jspf" %>
        </div>
    </body>
</html>
