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
        <title>Announcement Management</title>
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
                            <p class="h2 mb-1 " id="contentheader">Announcement Management</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row  ">

                            <div class="col ">
                                <form action="SiteNavigationAdmin?nav=announcements&op=2" method="POST">
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
                                        <select multiple="multiple" class="form-select border-0"  id="select1" name="cohortIDs"  onchange="this.form.submit()">
                                            <c:forEach items="${requestScope.cohorts}" var="cohort">
                                                <option value="${cohort.cohortID}">${cohort.cohortName}</option>
                                            </c:forEach>
                                                 
                                            
                                           
                                        </select>
                                        
                                    </div>
                                </form>
                            </div>

                            <div class="col ">

                                <form action="SiteNavigationAdmin?nav=announcements&op=2" method="POST">

                                    <div class="row justify-content-end">
                                        <div class="container-sm
                                             d-flex justify-content ">
                                            <p class="h4 mt-2 " id="headerdynamic"><b>Cohort Announcements</b></p>
                                        </div>
                                    </div>
                                    <c:set var="count" value="${0}"/>
                                    <c:forEach items="${requestScope.announcements}" var="cohortAnnouncement">
                                        
                                        <div class="row">
                                            <div id="infoblock"class="form-control  ">
                                                <input type="hidden" name="id${count}" value="${cohortAnnouncement.announcementID}">
                                                <label for="info2" id="label2" class="form-label mb-0"><b>Announcement Text</b></label>
                                                <textarea rows="4" cols="50" type="text" style="resize:none" class="form-control mb-3" id="info2" name="cohortText${count}">${cohortAnnouncement.text} </textarea>
                                                <div class="row mb-3">
                                                    <div class="container-fluid d-flex justify-content-around ">
                                                        <button type="submit" id="but4" class="btn d-inline" name="saveChanges" value="save">Save Changes</button>
                                                        <button type="submit" id="but6" class="btn d-inline" name="deleteAnn${count}" value="delete">Delete</button>
                                                        <c:set var="count" value="${count + 1}"/>
                                                    </div>
                                                       
                                                </div>
                                                        
                                            </div>
                                                        
                                        </div>
                                        
                                    </c:forEach>
                                    <input type="hidden" name="count" value="${count}"> 



                                </form>
                            </div>

                        </div>


                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
