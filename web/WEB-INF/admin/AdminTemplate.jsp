<%-- 
    Document   : AdminTemplate
    Created on : Mar. 10, 2022, 12:38:44 p.m.
    Author     : Conor Welch
    You can copy and refactor then change the content section 
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                            <p class="h2 mb-1 " id="contentheader">Content Goes Here</p>
                        </div>
                        <!--Content Need Only be changed in this section-->








                    </div>

                </div>


            </div>
        </div>
    </div>
</div>

</body>
</html>
