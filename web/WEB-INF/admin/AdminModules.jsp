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
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="adminstyle.css" rel="stylesheet"/>
        <title>Module Management</title>
    </head>
    <body>
        <!--Header Fragment-->
        <!--Top of the admin bar-->
        <%@include file="AdminHeaderFragment.jspf" %>


        <div class="row">
            <!--SideBar Fragment-->   
            <%@include file="AdminSideBarFragment.jspf" %>
            <!--End of Fragment-->
            <!--CONTENT SECTION-->
            <div class="col p-5 pt-3" id="contentpage">
                <div class="container pe-2" id="contentcontainer" >
                    <div class="row-cols-1 mt-3" id="contentheaderrow">
                        <p class="h2 mb-1 " id="contentheader">Modules Management</p>
                    </div>
                    <div class="row">
                        <div class="col">
                            <form action="SiteNavigationAdmin?nav=modules&op=2" method="POST">
                            <select multiple="multiple" class="form-select border-0 mb-5"  style="overflow-x:scroll" id="select1" name="moduleIDs" onchange="this.form.submit()">

                                <c:forEach items="${requestScope.modules}" var="module" >
                                    <option type="checkbox" value="${module.lessonId}">${module.name}</option>
                                </c:forEach>   

                                <!--FOR JSP add loop to build dynamic -->
                            </select>
                            </form>
                        </div>
                        <div class="col">
                            <form action="SiteNavigationAdmin?nav=modules&op=2" method="POST">
                                <div class="row justify-content-end">
                                    <div class="container-sm
                                         d-flex justify-content ">
                                        <p class="h4 mt-2 mb-3" id="headerdynamic"><b>Module Management</b></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div id="infoblock"class="form-control  ">

                                        <input type="hidden" name="modID" value="${requestScope.modID}">
                                        <!--
                                        <label for="info1" id="label1" class="form-label mb-0 "><b>Modules ID</b></label>
                                        <input type="text" class="form-control mb-3" id="info1" placeholder="ID" name="info1" disabled="true">
                                        <!---->
                                        <label for="info2" id="label2" class="form-label mb-0"><b>Module Name</b></label>
                                        <input type="text" class="form-control mb-3" id="info2" placeholder="Name" value="${requestScope.modName}" name="info2">
                                        <!---->
                                        <label for="info3" id="label3" class="form-label mb-0"><b>Module Description</b></label>
                                        <input type="text" class="form-control  mb-3" id="info3" placeholder="Description" value="${requestScope.modDescription}" name="info3">
                                        <!---->
                                        <!--                                            <label for="info4" id="label4" class="form-label mb-0"><b>Info 4</b></label>
                                                                                    <input type="text" class="form-control mb-3" id="info4" placeholder="info4" name="info4">
                                                                                    
                                                                                    <label for="info5" id="label5"  class="form-label mb-0"><b>Info 5</b></label>
                                                                                    <input type="text" class="form-control mb-3" id="info5" placeholder="info5" name="info5">
                                                                                    
                                                                                    <label for="info6" id="label6" class="form-label mb-0"><b>Info 6</b></label>
                                                                                    <input type="text" class="form-control mb-0" id="info6" placeholder="info6" name="info6">-->
                                        <div class="row pe-4">
                                            
                                                <button type="submit" id="but4" class="btn " name="saveChanges" value="save">Save Changes</button>
                                                <button type="submit" id="but6" class="btn " name="deleteModule" value="delete">Delete</button>

                                            
                                        </div>
                                    </div>
                                </div>
                        </div>      
                                        <div class="col">
                                        
                                            <p class="h4 mt-2">Assignments<p>
                                        <div class="scrollbox" style="overflow-x:scroll;height:400px;background-color: white">
                                            <c:set var="count" value="${0}"/>
                                            <c:forEach items="${requestScope.allAssignments}" var="assignment">
                                                <c:set var="found" value="${0}"/>
                                                <c:forEach items="${requestScope.relAssignments}" var="relAssignment">
                                                    <c:if test="${relAssignment.assignmentId == assignment.assignmentId}">
                                                         <input type="checkbox" value="${assignment.assignmentId}" name="assignmentList${count}" checked>${assignment.assignmentName}<br>
                                                         <c:set var="count" value="${count + 1}"/>
                                                         <c:set var="found" value="${found + 1}"/>
                                                    </c:if>
                                                </c:forEach>
                                                         
                                                <c:if test="${found == 0}">
                                                   <input type="checkbox" value="${assignment.assignmentId}" name="assignmentList${count}">${assignment.assignmentName}<br>
                                                   <c:set var="count" value="${count + 1}"/>
                                                </c:if>
                                                
                                            </c:forEach>
                                                   <input type="hidden" name="count" value="${count}">
                                            
                                            
                                        
                                        </div>
                                        </div>           
                                        <div class="col">
                                                       <p class="h4 mt-2">Documents<p>
                                        <div class="scrollbox" style="overflow-x:scroll;height:400px;background-color: white">
                                            <c:set var="count" value="${0}"/>
                                            <c:forEach items="${requestScope.allDocuments}" var="document">
                                                <c:set var="found" value="${0}"/>
                                                <c:forEach items="${requestScope.relDocuments}" var="relDocument">
                                                    <c:if test="${relDocument.documentID == document.documentID}">
                                                         <input type="checkbox" value="${document.documentID}" name="documentList${count}" checked>${document.name}<br>
                                                         <c:set var="count" value="${count + 1}"/>
                                                         <c:set var="found" value="${found + 1}"/>
                                                    </c:if>
                                                </c:forEach>
                                                         
                                                <c:if test="${found == 0}">
                                                   <input type="checkbox" value="${document.documentID}" name="documentList${count}">${document.name}<br>
                                                   <c:set var="count" value="${count + 1}"/>
                                                </c:if>
                                                   <input type="hidden" name="docCount" value="${count}">
                                                
                                            </c:forEach>
                                            
                                        </div>
                                                   </div>
                    </div>    

                </div>    
                </body>
                </html>
