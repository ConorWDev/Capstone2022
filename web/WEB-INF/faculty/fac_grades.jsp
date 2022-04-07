<%--
    Document   : grades
    Created on : Mar. 8, 2022, 8:43:15 p.m.
    Author     : massvm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="fac_style.css" rel="stylesheet"/>
        <title>Grades</title>
    </head>
    <body>
        <%@include file="fac_headerfragment.jspf" %>

        <div class="row">
            <div class="col-1"></div>
            <div class="col bg-light rounded">
                <div class="row mb-3">

                    <div class="container-fluid border-bottom border-primary" id="announcementheader">
                        <p class="h2 ms-2 mt-2">Grades</p>
                    </div>

                </div>
                <div class="row mb-3">
                    <div class="col border-end">

                        <p>A descriptor of the Search</p>
                        <form action="SiteNavigationFaculty?nav=grades" method="POST">
                            <input type="text" name="search" onkeyup="" class="form-control mb-2">

                            <div class="container d-flex justify-content-end mb-1 ">
                                <button type="submit" value="search" class="btn bg-secondary text-white d-inline-block">Search Students?
                                </button>
                            </div>
                        </form>


                    </div>
                    <c:set var="count" value="0"/>
                    <c:forEach items="${requestScope.cohorts}" var="cohort">
                        <div class="col border-end">
                            <div class="row">
                                <p class="h4 ms-3 ">${cohort.cohortName}</p>
                            </div>
                            <c:forEach items="${requestScope.studentLists.get(count)}" var="student">
                                <div class="row  m-3 rounded">
                                    <a class="text-white p-3 btn bg-primary text-capitalize" href="SiteNavigationFaculty?nav=studentgrades&studentid=${student.userID}&cohortid=${cohort.cohortID}">${student.fullName} ${student.userID}</a>
                                </div>
                            </c:forEach>

                            <c:set var="count" value="${count + 1}"/>
                        </div>
                    </c:forEach>







                </div>
            </div>
            <div class="col-1"></div>
        </div>
    </body>
</html>
