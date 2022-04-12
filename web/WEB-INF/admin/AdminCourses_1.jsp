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
        <title>Course Management</title>
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
                            <p class="h2 mb-1 " id="contentheader">Course Management</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row  ">

                            <div class="col ">
                                <form action="SiteNavigationAdmin?nav=courses&op=2" method="POST">
                                    <div class="row">
                                        <div class="container d-flex justify-content mb-1">
                                            <p class='h4'>Course List</p>
                                     
                                        </div>
                                    </div>
                                    <div>
                                        <select multiple="multiple" class="form-select border-0" id="select1" name="courseIDs"  onchange="this.form.submit()">
                                            <c:forEach items="${requestScope.courses}" var="course">
                                                        <option value="${course.courseID}">${course.courseName}</option>
                                            </c:forEach>
                                            
                                        </select>
                                    </div>
                                </form>
                            </div>
                            
                            
                            <div class="col ">

                                
                                <form action="SiteNavigationAdmin?nav=courses&op=2" method="POST">
                                    <div class="row justify-content-end">
                                        <div class="container-sm
                                             d-flex justify-content ">
                                            <p class="h4  mb-0" id="headerdynamic">Course Info</p>
                                        </div>
                                    </div>
                                    <div class="row ">
                                        <div id="infoblock"class="form-control  ">
                                            <input type="hidden" name="courseID" value="${requestScope.courseID}">
                                            <!--
                                            <label for="info1" id="label1" class="form-label mb-0 "><b>Course ID</b></label>
                                            <input type="text" class="form-control mb-2" id="info1" placeholder="" name="info1" disabled="true">
                                            <!---->
                                            <label for="info2" id="label2" class="form-label mb-0"><b>Course Name</b></label>
                                            <input type="text" class="form-control mb-2" id="info2" placeholder="Name"  value="${requestScope.courseName}" name="info2" required>
                                            <!---->
                                            <label for="info3" id="label3" class="form-label mb-0"><b>Course Description</b></label>
                                            <input type="text" class="form-control  mb-2" id="info3" placeholder="Description" value="${requestScope.courseDescription}" name="info3">
                                            
                                            </div>
                                            
                                            <div class="row">
                                                <div class="container-fluid d-flex justify-content-around ">
                                                    <button type="submit" id="but4" class="btn d-inline" name="saveChanges" value="save">Save Changes</button>
                                                    <button type="submit" id="but6" class="btn d-inline" name="deleteCourse" value="delete">Delete</button> 
                                                </div>
                                            </div>
                                            
                                    </div>




                                
                            </div>
                            <div class="col ">
                                
                                    <div class="row">
                                        <div class="container d-flex justify-content mb-1">
                                            <p class='h4'>Module List</p>
                                         
                                        </div>
                                    </div>
                                    <div>
                                        <div class="scrollbox" style="overflow-x:scroll;height:400px;background-color: white">
                                            
                                            <c:set var="count" value="${0}"/>
                                            <c:forEach items="${requestScope.allModules}" var="module">
                                                <c:set var="found" value="${0}"/>
                                                <c:forEach items="${requestScope.relModules}" var="relModule">
                                                    <c:if test="${relModule.lessonId == module.lessonId}">
                                                         <input type="checkbox" value="${module.lessonId}" name="moduleList${count}" checked>${module.name}<br>
                                                         <c:set var="count" value="${count + 1}"/>
                                                         <c:set var="found" value="${found + 1}"/>
                                                    </c:if>
                                                </c:forEach>
                                                         
                                                <c:if test="${found == 0}">
                                                   <input type="checkbox" value="${module.lessonId}" name="moduleList${count}">${module.name}<br>
                                                   <c:set var="count" value="${count + 1}"/>
                                                </c:if>
                                                
                                            </c:forEach>
                                                   <input type="hidden" name="count" value="${count}">
                                        </div>
                                    </div>
                                
                            </div>
                        </form>
                        </div>


                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
