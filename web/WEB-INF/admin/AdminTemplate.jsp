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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link href="adminstyle.css" rel="stylesheet"/>
    <title>Administrator Landing</title>
</head>
<body>

<!--Header Fragment-->
<%@include file="AdminHeaderFragment.jspf" %>

<!--SideBar Fragment-->
<%@include file="AdminSideBarFragment.jspf" %>    
<!--End of Fragments-->
<    <div class="col p-5 pt-3" id="contentpage">
        <div class="row">
            <div class="container pe-2" id="contentcontainer" >
                <div class="row-cols-1 mt-3" id="contentheaderrow">
                    <p class="h2 mb-1 " id="contentheader">User Management</p>
                </div>
                <!--Content Need Only be changed in this section-->
                <div class="row">

                    <div class="col">
                        <form>
                            <div class="row">
                                <div class="container d-flex justify-content-around mb-1">
                                    <button type="submit" id="but1" class="btn d-inline-block ms-2 ">Button 1</button>
                                    <button type="submit" id="but2"class="btn d-inline-block ">Button 2</button>
                                    <button type="submit" id="but3" class="btn d-inline-block dropdown-toggle me-2 " data-bs-toggle="dropdown">Button/Dropdown 3</button>
                                    <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="#">Item 1</a></li>
                                        <li><a class="dropdown-item" href="#">Item 2</a></li>
                                        <li><a class="dropdown-item" href="#">Item 3</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div>
                                <select multiple="multiple" class="form-select border-0"  id="select1">
                                    <option>This needs to be Updated with Logic So this is dynamically created</option>
                                    <!--FOR JSP add loop to build dynamic -->
                                </select>
                            </div>
                        </form>
                    </div>

                    <div class="col ">

                        <form action="#">

                            <div class="row">
                                <div class="container-sm
                                     d-flex justify-content ">
                                    <p class="h6 mt-2 " id="headerdynamic">*User Type* Info</p>
                                </div>
                            </div>
                            <div class="row">
                                <div id="infoblock"class="form-control  ">
                                    <!---->
                                    <label for="info1" id="label1" class="form-label "><b>Info 1</b></label>
                                    <input type="text" class="form-control " id="info1" placeholder="info1" name="info1">
                                    <!---->
                                    <label for="info2" id="label2" class="form-label "><b>Info 2</b></label>
                                    <input type="text" class="form-control " id="info2" placeholder="info2" name="info2">
                                    <!---->
                                    <label for="info3" id="label3" class="form-label "><b>Info 3</b></label>
                                    <input type="text" class="form-control  " id="info3" placeholder="info3" name="info3">
                                    <!---->
                                    <label for="info4" id="label4" class="form-label "><b>Info 4</b></label>
                                    <input type="text" class="form-control " id="info4" placeholder="info4" name="info4">
                                    <!---->
                                    <label for="info5" id="label5"  class="form-label "><b>Info 5</b></label>
                                    <input type="text" class="form-control" id="info5" placeholder="info5" name="info5">
                                    <!---->
                                    <label for="info6" id="label6" class="form-label "><b>Info 6</b></label>
                                    <input type="text" class="form-control " id="info6" placeholder="info6" name="info6">
                                    <div class="row">
                                        <div class="container-fluid d-flex justify-content-around ">
                                            <button type="submit" id="but4" class="btn d-inline  ">Edit $$$$</button>
                                            <button type="submit" id="but5" class="btn d-inline  ">Create $$$$</button>
                                            <button type="submit" id="but6" class="btn d-inline  ">Delete $$$$</button>
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
