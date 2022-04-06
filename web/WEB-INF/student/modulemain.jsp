<%-- 
    Document   : modulemain
    Created on : Feb. 20, 2022, 12:39:29 a.m.
    Author     : Ryan Checora

    modulemain will give information about a specific module.
    This will hold modulename, description, as well as assignments (TODO) and documents (TODO)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        
        <div class="container bg-white rounded p-3"> 
            <!-- Module Overview -->
            <div class="row">
                <div class="col">
                    <p class="h1">${requestScope.moduleName}</p> 
                </div>
            </div>
            <div class="row">
                <p>${requestScope.moduleDescription}</p>
                
            </div>
            <hr>       
            
            <!-- Assignments Section -->
            <div class="row">
                <p class="h3">Assignments</p>
            </div>
            
            <!-- 
                JSTL Assignment loop notes:
                Summary:
                    Loads every assignment from the module into rows
                List Name: assignments
                What Will it Call:
                    - An ArrayList containing all the assignments the module has
                Attributes List:
                    assignmentUrl: the URL that will download the assignment file
                    assignmentName: name of assignment
                    assignmentDescription: description of assignment
            --> 
            <c:forEach items="${requestScope.assignments}" var="assignment">
                <div class="card m-3">
                    <div class="card-header">
                        <p class="h5">${assignment.assignmentName}</p>
                    </div>
                    <div class="card-body">
                        <p>${assignment.assignmentDescription}</p>
                    </div>
                </div>
            </c:forEach>
            <hr>
            <!-- 
                JSTL document loop notes:
                Summary:
                    Loads every document from the module into rows
                List Name: documents
                    What Will it Call:
                        - An ArrayList containing all the documents the module has
                    Attributes List:
                        name     : name of document
                        description: description of document
                        url: url of document
            -->
            
            <!-- Documents Section -->
            <div class="row">
                <p class="h3">Documents</p> 
            </div>    
            <c:forEach items="${requestScope.documents}" var="document">
                <div class="card m-3">
                    <div class="card-header">
                        <p class="h3">${document.name}</p>
                    </div>
                    <div class="card-body">
                        <p>${document.description}</p>
                        <button type="button" class="btn btn-primary" href="${document.url}">View</button>
                        <button type="button" class="btn btn-primary" href="${document.url}">Download</button>
                        <!-- Might need download link in the future -->
                    </div>
                </div>
            </c:forEach>



                   <div class="col-6 align-content-center mr-5">
                        <div class="card border-0 mb-4 mr-3" >

                        </div>
                  </div>
         </div>
         
         
         <!--  
         
         
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="h1"> </p> 
                </div>
                <hr>
            </div>
            
            <div class="row">
                <div class="col-4"><p class="h5">Assignment</p></div>
                <div class="col-2"><p class="h5">Status</p></div>
                <div class="col-3"><p class="h5">Grade</p></div>
                <div class="col-3"><p class="h5">Due Date</p></div>
                <hr>
            </div>
        </div>
         
        -->    
          
                 
                 
            
        
         
         <%@include file="footerfragment.jspf" %>
    </body>
</html>
