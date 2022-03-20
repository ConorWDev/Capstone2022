<%-- 
    Document   : fac_studentgrades
    Created on : Mar. 10, 2022, 11:07:23 a.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="fac_style.css" rel="stylesheet"/>
        <title>Student Grades</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        
        <div class="row">
        <div class="col-1"></div>
        
        <div class="col bg-light rounded" >
        
        <p class="h3">${requestScope.studentName}'s Grades</p>
        
       <c:forEach items="${requestScope.studentGrades}" var="grades">
            ${grades.assignmentName}
            <input type ="text" name="newGrade" size ="5" value="<c:out value ='${grades.mark}'/>">
            <br>
        </c:forEach>     
            
            <form action ="SiteNavigationFaculty?nav=studentgrades" method ="POST">
            <input type ="submit" value="Save"> 
            </form>
        </div>
        <div class="col-1"></div>
        </div>
        
            
            
                
              
            
        
        
    </body>
</html>
