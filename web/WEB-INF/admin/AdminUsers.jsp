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
        <title>Title</title>
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
                            <p class="h2 mb-1 " id="contentheader">User Management</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row  ">

                            <div class="col ">
                                <form>
                                    <div class="row">
                                        <div class="container d-flex justify-content-around mb-1">
                                            <button type="submit" id="but1" class="btn d-inline-block ms-2 ">Select User</button>
                                            <button type="submit" id="but2"class="btn d-inline-block ">Edit User</button>
                                            <button type="submit" id="but3" class="btn d-inline-block dropdown-toggle me-2 " data-bs-toggle="dropdown">Change User Type</button>
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="SiteNavigationAdmin?nav=users&op=1">Student</a></li>
                                                <li><a class="dropdown-item" href="SiteNavigationAdmin?nav=users&op=2">Faculty</a></li>
                                                <li><a class="dropdown-item" href="SiteNavigationAdmin?nav=users&op=3">Admin</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div>
                                        <select multiple="multiple" class="form-select border-0"  id="select1">
                                            
                                            
                                            <%--Test to find which array list is not null, the list
                                            that is not null will be printed--%>
                                            <c:choose>
                                                <c:when test="${requestScope.students != null}">
                                                    <c:forEach items="${requestScope.students}" var="student">
                                                        <option>${student.fullName}</option>
                                                    </c:forEach>
                                                </c:when>
                                                <c:when test="${requestScope.faculty != null}">
                                                    <c:forEach items="${requestScope.faculty}" var="faculty">
                                                        <option>${faculty.fullName}</option>
                                                    </c:forEach>    
                                                </c:when>
                                                <c:when test="${requestScope.admins != null}">
                                                    <c:forEach items="${requestScope.admins}" var="admin">
                                                        <option>${admin.fullName}</option>
                                                        
                                                    </c:forEach>   
                                                </c:when>
                                                
                                            </c:choose>    
                                                 
                                            
                                            
                                               
                                            
                                           
                                            <!--FOR JSP add loop to build dynamic -->
                                            
                                            
                                            
                                        </select>
                                    </div>
                                </form>
                            </div>

                            <div class="col-5">

                                <form>

                                    <div class="row justify-content-end">
                                        <div class="container-sm
                                             d-flex justify-content ">
                                            <p class="h6 mt-2 " id="headerdynamic"><b>${requestScope.usertype} Info</b></p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div id="infoblock"class="form-control  ">
                                            
                                            <!-- -->
                                            <label for="info1" id="label1" class="form-label mb-0 "><b>Username</b></label>
                                            <input type="text" class="form-control mb-3" id="info1" placeholder="Username" name="info1">
                                            <!-- -->
                                            <label for="info2" id="label2" class="form-label mb-0"><b>First Name</b></label>
                                            <input type="text" class="form-control mb-3" id="info2" placeholder="First Name" name="info2">
                                            <!-- -->
                                            <label for="info3" id="label3" class="form-label mb-0"><b>Middle Name</b></label>
                                            <input type="text" class="form-control  mb-3" id="info3" placeholder="Middle Name" name="info3">
                                            <!-- -->
                                            <label for="info4" id="label4" class="form-label mb-0"><b>Last Name</b></label>
                                            <input type="text" class="form-control mb-3" id="info4" placeholder="Last Name" name="info4">
                                            <!-- -->
                                            <label for="info5" id="label5"  class="form-label mb-0"><b>Password</b></label>
                                            <input type="text" class="form-control mb-3" id="info5" placeholder="Password" name="info5">
                                            <!---->
                                            <label for="info6" id="label6" class="form-label mb-0"><b>Email</b></label>
                                            <input type="text" class="form-control mb-0" id="info6" placeholder="Email" name="info6">
                                            <div class="row">
                                                <div class="container-fluid d-flex justify-content-around ">
                                                    <a href="#" type="submit" id="but4" class="btn d-inline  ">Edit User</a>
                                                    
                                                    <a type="submit" id="but6" class="btn d-inline  ">Delete User</a>
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
