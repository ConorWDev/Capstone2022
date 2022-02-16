<%-- 
    Document   : login
    Created on : Feb 8, 2022, 10:38:12 PM
    Author     : 816601
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <div>
        <h1>MGT Login</h1><br>
        <p>Powered by:<p>
        <p>Mass</p><br>
        </div>
        <div>
        <form action="LogonCon" method="POST">
             <c:if test="${LogOut}">
                <p>You have successfully logged out.</p>
            </c:if>
            <c:if test="${Invalid}">
                <p>Invalid login</p>
            </c:if>
            <input type="text" name="username" Placeholder="Username" value="${username}"><br><br>
            <input type="password" name="password" Placeholder="Password" value="${password}"><br>
            <a href="forgotpass">Forgot Password?</a><br>
            <input type="submit" name="submit" value="Login"><br>
            ${requestScope.message}
        </form>
        </div>
    </body>
</html>
