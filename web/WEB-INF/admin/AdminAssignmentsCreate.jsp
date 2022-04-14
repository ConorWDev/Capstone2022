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
        <title>Assignment Creation</title>
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
                            <p class="h2 mb-3 " id="contentheader">Assignment Create</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row  ">

                            
                            
                            <div class="col-4 ps-3">
                                 
                                <form action="SiteNavigationAdmin?nav=assignments&op=1" method="POST">

                                    
                                    <div class="row">
                                        <div id="infoblock"class="form-control  ">
                                            
                                           
                                            <!-- 
                                            <label for="info1" id="label1" class="form-label mb-0 "><b>Assignment ID</b></label>
                                            <input type="text" class="form-control mb-3" id="info1" placeholder="Assignment ID will be created automatically." name="info1" disabled="true">
                                            <!-- -->
                                            <label for="info2" id="label2" class="form-label mb-0"><b>Assignment Name</b></label>
                                            <input type="text" class="form-control mb-3" id="info2" placeholder="Name" name="info2">
                                            <!-- -->
                                            <label for="info3" id="label3" class="form-label mb-0"><b>Assignment Description</b></label>
                                            <input type="text" class="form-control  mb-3" id="info3" placeholder="Description" name="info3">
                                            <!-- -->
                                            <label for="info4" id="label4" class="form-label mb-0"><b>Assignment URL (Optional)</b></label>
                                            <input type="text" class="form-control mb-3" id="info4" placeholder="Assignment URL - EX: https://mtghealthcare.com/" name="info4">
                                            <!-- weight will have to be assigned when assignments are gathered within a given course as weight
                                            is relative to the other assignments within the course
                                            <label for="info5" id="label5"  class="form-label mb-0"><b>Assignment Weight</b></label>
                                            <input type="text" class="form-control mb-5" id="info5" placeholder="Weight" name="info5">
                                             -->
                                            
                                            <div class="row mb-5">
                                                <div class="container-fluid d-flex justify-content-around ">
                                                    <button href="#" type="submit" id="but4" class="btn d-inline text-success">Create Assignment</button>
                                                    
                                                    
                                                </div>
                                            </div>
                                            
                                        </div>
                                    </div>




                                </form>
                            </div>
                            
                            <div class="col-3"></div>
                            <div class="col">
                                <img id="imagefiller" class="img m-4" src="MassLogo500px.png" alt="Mass" style="height: 250px;width: 250px"/>
                            </div> 
                            
                        </div>
                        
                        
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
