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
        <title>User Management</title>
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
                                <form action="SiteNavigationAdmin?nav=users" method="POST">
                                    
                                    <c:choose>
                                        <c:when test="${requestScope.students != null}">
                                            <input type="hidden" name="op" value="1">
                                        </c:when>
                                        <c:when test="${requestScope.faculty != null}">
                                            <input type="hidden" name="op" value="2">
                                        </c:when>
                                        <c:when test="${requestScope.admins != null}">
                                            <input type="hidden" name="op" value="3">
                                        </c:when>
                                    </c:choose>
                                    
                                    <div class="row">
                                        <div class="container d-flex justify-content-end mb-0 ">
                                            
                                            
                                            <button type="submit" id="but3" class="btn d-inline-block dropdown-toggle me-4 mb-1 mt-1 p-1" data-bs-toggle="dropdown">Switch User Types</button> 
                                            <ul class="dropdown-menu">
                                                <li><a class="dropdown-item" href="SiteNavigationAdmin?nav=users&op=1">Student</a></li>
                                                <li><a class="dropdown-item" href="SiteNavigationAdmin?nav=users&op=2">Faculty</a></li>
                                                <li><a class="dropdown-item" href="SiteNavigationAdmin?nav=users&op=3">Admin</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div>
                                        <select multiple="multiple" class="form-select border border-secondary"  id="select1" name="userIDs" onchange="this.form.submit()">
                                            
                                            
                                            <%--Test to find which array list is not null, the list
                                            that is not null will be printed--%>
                                            <c:choose>
                                                <c:when test="${requestScope.students != null}">
                                                    <c:forEach items="${requestScope.students}" var="student">
                                                        <option class="text-capitalize" value="${student.userID}">${student.fullName}</option>
                                                    </c:forEach>
                                                </c:when>
                                                <c:when test="${requestScope.faculty != null}">
                                                    <c:forEach items="${requestScope.faculty}" var="faculty">
                                                        <option class="text-capitalize" value="${faculty.userID}">${faculty.fullName}</option>
                                                    </c:forEach>    
                                                </c:when>
                                                <c:when test="${requestScope.admins != null}">
                                                    <c:forEach items="${requestScope.admins}" var="admin">
                                                        <option class="text-capitalize" value="${admin.userID}">${admin.fullName}</option>
                                                    </c:forEach>   
                                                </c:when>
                                                
                                            </c:choose>    
                                                 
                                        </select>
                                    </div>
                                </form>
                            </div>

                            <div class="col-5">

                                <form action="SiteNavigationAdmin?nav=users&editUser=yes" method="POST">
                                     <c:choose>
                                        <c:when test="${requestScope.students != null}">
                                            <input type="hidden" name="op" value="1">
                                        </c:when>
                                        <c:when test="${requestScope.faculty != null}">
                                            <input type="hidden" name="op" value="2">
                                        </c:when>
                                        <c:when test="${requestScope.admins != null}">
                                            <input type="hidden" name="op" value="3">
                                        </c:when>
                                    </c:choose>
                                    <div class="row justify-content-end">
                                        <div class="container-sm
                                             d-flex justify-content ">
                                            <p class="h4 mt-2 mb-0" id="headerdynamic">${requestScope.usertype} Info</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div id="infoblock"class="form-control  ">
                                            
                                            <!-- -->
                                            <label for="info1" id="label1" class="form-label mb-0 "><b>Username</b></label>
                                            <input type="text" class="form-control mb-3" id="info1" value="${requestScope.username}" name="infoUser"> 
                                            <!-- -->
                                            <label for="info2" id="label2" class="form-label mb-0"><b>First Name</b></label>
                                            <input type="text" class="form-control mb-3" id="info2" value="${requestScope.firstname}" name="infoFirst">
                                            <!-- -->
                                            <label for="info3" id="label3" class="form-label mb-0"><b>Middle Name</b></label>
                                            <input type="text" class="form-control  mb-3" id="info3" value="${requestScope.middlename}" name="infoMiddle">
                                            <!-- -->
                                            <label for="info4" id="label4" class="form-label mb-0"><b>Last Name</b></label>
                                            <input type="text" class="form-control mb-3" id="info4" value="${requestScope.lastname}" name="infoLast">
                                            <!-- -->
                                            <label for="info5" id="label5"  class="form-label mb-0"><b>Password</b></label>
                                            <input type="text" class="form-control mb-3" id="info5" value="${requestScope.pass}" name="infoPass">
                                            <!---->
                                            <label for="info6" id="label6" class="form-label mb-0"><b>Email</b></label>
                                            <input type="text" class="form-control mb-0" id="info6" value="${requestScope.email}" name="infoEmail">
                                            <div class="row">
                                                <div class="container-fluid d-flex justify-content-around ">
                                                    <button type="submit" id="but1" class="btn d-inline-block ms-2" name="saveChanges" value="save">Save Changes</button>
                                                    <button type="submit" id="but6" class="btn d-inline-block ms-2" name="deleteUser" value="delete">Delete User</button>
                                                    <%--<a href="SiteNavigationAdmin?nav=users&editUser=yes" type="submit" id="but4" class="btn d-inline">Edit User</a>--%>
                                                    
                                                    <%-- <a type="submit" id="but6" class="btn d-inline  ">Delete User</a> --%>
                                                </div>
                                            </div>
                                        </div>
                                                    ${requestScope.message}
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
