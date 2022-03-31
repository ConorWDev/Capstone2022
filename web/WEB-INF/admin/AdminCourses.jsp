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
                                <form>
                                    <div class="row">
                                        <div class="container d-flex justify-content mb-1">
                                            <p class='h4'>Course List</p>
<!--                                            <button type="submit" id="but1" class="btn d-inline-block ms-2 ">Button 1</button>
                                            <button type="submit" id="but2"class="btn d-inline-block ">Button 2</button>
                                            <button type="submit" id="but3" class="btn d-inline-block dropdown-toggle me-2 " data-bs-toggle="dropdown">Button/Dropdown 3</button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="#">Item 1</a></li>
                                                <li><a class="dropdown-item" href="#">Item 2</a></li>
                                                <li><a class="dropdown-item" href="#">Item 3</a></li>
                                            </ul>-->
                                        </div>
                                    </div>
                                    <div>
                                        <select multiple="multiple" class="form-select border-0 mb-3"  id="select1">
                                            <option>This needs to be Updated with Logic So this is dynamically created</option>
                                            <!--FOR JSP add loop to build dynamic -->
                                        </select>
                                    </div>
                                </form>
                            </div>

                            <div class="col ">

                                <form action="#">

                                    <div class="row justify-content-end">
                                        <div class="container-sm
                                             d-flex justify-content ">
                                            <p class="h4  mb-0" id="headerdynamic">Course Info</p>
                                        </div>
                                    </div>
                                    <div class="row ">
                                        <div id="infoblock"class="form-control  ">
                                            <!---->
                                            <label for="info1" id="label1" class="form-label mb-0 "><b>Course ID</b></label>
                                            <input type="text" class="form-control mb-2" id="info1" placeholder="" name="info1" disabled="true">
                                            <!---->
                                            <label for="info2" id="label2" class="form-label mb-0"><b>Course Name</b></label>
                                            <input type="text" class="form-control mb-2" id="info2" placeholder="Name" name="info2">
                                            <!---->
                                            <label for="info3" id="label3" class="form-label mb-0"><b>Course Description</b></label>
                                            <input type="text" class="form-control  mb-2" id="info3" placeholder="Description" name="info3">
                                            
                                            <div class="row">
                                                <div class="container-fluid d-flex justify-content-between ">
                                                    <button type="submit" id="but4" class="btn d-inline  ">Edit Course</button>
                                                    <button type="submit" id="but6" class="btn d-inline  ">Delete Course</button>  
                                                    
                                                    
                                                </div>
                                            </div>
                                            <div class="row">
                                                <!---->
                                            <label for="info4" id="label4" class="form-label mb-0"><b>Student Username</b></label>
                                            <input type="text" class="form-control mb-3" id="info4" placeholder="Student Username" name="info4" disabled="true">
                                            
                                            <label for="info5" id="label5"  class="form-label mb-0"><b>Student First Name</b></label>
                                            <input type="text" class="form-control mb-3" id="info5" placeholder="Student First Name" name="info5" disabled="true">
                                            
                                            <label for="info6" id="label6" class="form-label mb-0"><b>Student Last Name</b></label>
                                            <input type="text" class="form-control mb-0" id="info6" placeholder="Student Last Name" name="info6" disabled="true">
                                            </div>
                                            <div class="row">
                                                <div class="container-fluid d-flex justify-content-end ">
                                                  <button type="submit" id="but4" class="btn d-inline  ">Add Student to Course</button>
                                                    
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>




                                </form>
                            </div>
                            <div class="col ">
                                <form>
                                    <div class="row">
                                        <div class="container d-flex justify-content mb-1">
                                            <p class='h4'>Student List</p>
<!--                                        <button type="submit" id="but1" class="btn d-inline-block ms-2 ">Button 1</button>
                                            <button type="submit" id="but2"class="btn d-inline-block ">Button 2</button>
                                         <button type="submit" id="but3" class="btn d-inline-block dropdown-toggle me-2 " data-bs-toggle="dropdown">Select Cohort?</button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="#">Cohort 1</a></li>
                                                <li><a class="dropdown-item" href="#">Cohort 2</a></li>
                                                <li><a class="dropdown-item" href="#">Cohort 3</a></li>
                                            </ul>-->   
                                        </div>
                                    </div>
                                    <div>
                                        <select multiple="multiple" class="form-select border-0 me-2"  id="select1">
                                            <option>This needs to be Updated with Logic So this is dynamically created</option>
                                            <!--FOR JSP add loop to build dynamic -->
                                        </select>
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
