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
        <title>Reports</title>
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
                            <p class="h2 mb-1 " id="contentheader">Reports</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row  ">

                            

                            <div class="col ">

                                <form action="#">

                                    <div class="row justify-content-end">
                                        <div class="container-sm
                                             d-flex justify-content ">
                                            <p class="h3 mt-2 " id="headerdynamic">Generate Report</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div id="infoblock"class="form-control  ">
                                            <!---->
                                            <label for="sel1" id="label1" class="form-label mb-0 "><b>Report Type</b></label>
                                            <select  class="form-select mb-3" id="sel1">
                                                <option value="1">Report Type 1</option>
                                                <option value="2">Report Type 2</option>
                                                <option value="3">Report Type 3</option><!-- comment -->
                                            </select>
                                            <!---->
                                            <label for="sel2" id="label2" class="form-label mb-0 "><b>Filter by?</b></label>
                                            <select  class="form-select mb-3" id="sel2">
                                                <option value="1">Filter Type 1</option>
                                                <option value="2">Filter Type 2</option>
                                                <option value="3">Filter Type 3</option><!-- comment -->
                                            </select>
                                            
                                            <label for="sel3" id="label3" class="form-label mb-0 "><b>Sort By</b></label>
                                            <select  class="form-select mb-3" id="sel3">
                                                <option value="1">Ascending</option>
                                                <option value="2">Descending</option>
                                                
                                            </select>
                                            <label for="info4" id="label4" class="form-label mb-0"><b>Export Location</b></label>
                                            <input type="text" class="form-control mb-3" id="info4" placeholder="File Path" name="info4">
                                            
                                            
                                            <div class="row">
                                                <div class="container-fluid d-flex justify-content-around ">
                                                    <button type="submit" id="but4" class="btn d-inline  ">Generate Report</button>
                                                    
                                                </div>
                                            </div>
                                        </div>
                                    </div>




                                </form>
                            </div>
                            <div class="col ">
                                
                                
                                <img id="imagefiller" class="img m-4" src="MassLogo500px.png" alt="Mass" style="height: 350px;width: 350px"/>
                             
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
