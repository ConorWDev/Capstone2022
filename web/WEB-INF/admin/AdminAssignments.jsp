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
        <title>Assignment Management</title>
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
                <div class="row">
                    <div class="container pe-2" id="contentcontainer" >
                        <div class="row-cols-1 mt-3" id="contentheaderrow">
                            <p class="h2 mb-1 " id="contentheader">Assignment Management</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row  ">

                            <div class="col ">
                                <form action="SiteNavigationAdmin?nav=assignments&op=2" method="POST">
                                    <div class="row">
                                        <div class="container d-flex justify-content-end mb-1">
                                            <p> </p>
<!--                                            <button type="submit" id="but3" class="btn d-inline-block dropdown-toggle me-2 " data-bs-toggle="dropdown"></button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="#">X</a></li>
                                                <li><a class="dropdown-item" href="#">Y</a></li>
                                                <li><a class="dropdown-item" href="#">Z</a></li>
                                            </ul>-->
                                        </div>
                                    </div>
                                    <div>
                                        <select multiple="multiple" class="form-select border-0"  id="select1" name="assignmentIDs"  onchange="this.form.submit()">
                                            <c:forEach items="${requestScope.assignments}" var="assignment">
                                                <option value="${assignment.assignmentId}">${assignment.assignmentName}</option>
                                            </c:forEach>
                                                 
                                            
                                           
                                        </select>
                                        
                                    </div>
                                </form>
                            </div>

                            <div class="col ">

                                <form action="SiteNavigationAdmin?nav=assignments&op=2" method="POST">

                                    <div class="row justify-content-end">
                                        <div class="container-sm
                                             d-flex justify-content ">
                                            <p class="h4 mt-2 " id="headerdynamic"><b>Assignment Info</b></p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div id="infoblock"class="form-control  ">
                                            
                                            <input type="hidden" name="id" value="${requestScope.assID}">
                                            <!--
                                            <label for="info1" id="label1" class="form-label mb-0 "><b>Assignment ID</b></label>
                                            <input type="text" class="form-control mb-3" id="info1" placeholder="Assignment ID" name="info1" disabled="true">
                                            <!---->
                                            <label for="info2" id="label2" class="form-label mb-0"><b>Assignment Name</b></label>
                                            <input type="text" class="form-control mb-3" id="info2" placeholder="Name" value="${requestScope.assName}" name="info2">
                                            <!---->
                                            <label for="info3" id="label3" class="form-label mb-0"><b>Assignment Description</b></label>
                                            <input type="text" class="form-control  mb-3" id="info3" placeholder="Description" value="${requestScope.assDescription}" name="info3">
                                            <!---->
                                            <label for="info4" id="label4" class="form-label mb-0"><b>Assignment URL</b></label>
                                            <input type="text" class="form-control mb-3" id="info4" placeholder="URL" value="${requestScope.assURL}" name="info4">
                                            <!--
                                            <label for="info5" id="label5"  class="form-label mb-0"><b>Assignment Weight</b></label>
                                            <input type="text" class="form-control mb-3" id="info5" placeholder="Weight" name="info5">
                                            <!---->
                                            
                                            <div class="row mb-3">
                                                <div class="container-fluid d-flex justify-content-around ">
                                                    <button type="submit" id="but4" class="btn d-inline" name="saveChanges" value="save">Save Changes</button>
                                                    <button type="submit" id="but6" class="btn d-inline" name="deleteAss" value="delete">Delete</button>
                                                    
                                                    test ${requestScope.message}
                                                </div>
                                            </div>
                                        </div>
                                    </div>




                                </form>
                            </div>

                        </div>


                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
