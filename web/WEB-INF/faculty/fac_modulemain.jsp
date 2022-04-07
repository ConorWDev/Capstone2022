<%-- 
    Document   : fac_modulemain
    Created on : Mar. 8, 2022, 8:28:56 p.m.
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
        <title>Module</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>
        <div class="row">
            <div class="col-1"></div>
            <div class="col bg-white rounded">
                <div class="row mb-3">

                    <div class="container-fluid border-bottom border-primary" id="announcementheader">    
                        <p class="h2 ms-2 mt-2">${sessionScope.moduleObject.name}</p>
                    </div>

                </div> 
                <div class="row mb-3">
                    <div class="col ">
                        <div class="row ">
                        <p class="h4 ">Assignments</p>
                        </div>
                        
                        <c:forEach items="${requestScope.assignments}" var="assignment">
                            <div class="row m-1 bg-light">
                            <p class="mb-0 text-primary"><b>${assignment.assignmentName}</b></p>
                            <p>${assignment.assignmentDescription}</p>
                            </div>  
                        </c:forEach>
                          
                    </div>


                    <div class="col ">
                        <div class="row ">
                        <p class="h4 ">Documents</p>
                        </div>
                        
                        <c:forEach items="${requestScope.documents}" var="document">
                            <div class="row bg-light m-1">
                            <p class="mb-0 text-primary"><b>${document.name}</b></p>
                            <p>${document.description}</p>
                            </div>     
                        </c:forEach>
                             
                    </div>


                    <div class="col ">
                        <div class="row ">
                        <p class="h4 ">Assignment Creation Form</p>
                        </div>
                        <div class="row">
                        <form action="SiteNavigationFaculty?nav=modulemain" method="POST">
                            
                            
                            <p class="mb-0"><b>Assignment Name</b></p>
                            <input type="text" name="assignmentName" required="true" class="form-control mb-3"> 
                            <p class="mb-0"><b>Assignment Description</b></p>
                            <input type="text" name="assignmentDescription" required="true" class="form-control mb-3"> 
                            <p class="mb-0"><b>Assignment URL (Optional)</b></p>
                            <input type="text" name="assignmentURL" class="form-control mb-3"> 
                            <input type="hidden" name="moduleid" value="${sessionScope.moduleObject.lessonId}"> 
                            
                            
                            <div class="container d-flex justify-content-end mb-1 ">
                                <button type="submit" value="submit" class="btn bg-secondary text-white d-inline-block">Submit</button>
                            </div>
                        </form>
                        ${requestScope.message}
                        </div>
                    </div>


                    <div class="col"> 
                        <div class="row ">
                        <p class="h4 ">Document Creation Form</p>
                        </div>
                        <div class="row">
                        <form action="SiteNavigationFaculty?nav=modulemain" method="POST">
                            
                            <p class="mb-0"><b>Document Name</b></p>
                            <input type="text" name="documentName" required="true" class="form-control mb-3">
                            <p class="mb-0"><b>Document Description</b></p>
                            <input type="text" name="documentDescription" required="true" class="form-control mb-3"> 
                            <p class="mb-0"><b>Document URL</b></p>
                            <input type="text" name="documentURL" required="true" class="form-control mb-3"> 
                            <input type="hidden" name="moduleid" value="${sessionScope.moduleObject.lessonId}"> 
                            
                            <div class="container d-flex justify-content-end mb-1 ">
                                <button type="submit" value="submit" class="btn bg-secondary text-white d-inline-block">Submit</button>
                            </div>
                        </form>
                        ${requestScope.message}
                        </div>
                    </div>








                </div>    
            </div>
            <div class="col-1"></div>
        </div>
    </body>
</html>
