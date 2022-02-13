<%-- 
    Document   : HomePage
    Created on : Feb. 9, 2022, 7:28:24 a.m.
    Author     : Conor W
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="style.css" rel="stylesheet"/>
        <title>Home</title>
    </head>

    <body>


        <%@include file="headerfragment.jspf" %>








        <div class="row">
            <div class="col-1">

            </div> 


            <div class="col-5 bg-white rounded" style="height: 400px">
                <div class="row">
                    <p class="h3 mb-3 " style=" color: #0069d9">Courses</p>
                </div>

                <div class="row"> 
                    <div class="col-1"></div>
                    <div class="col-4 ">

                        <div class="card border-0 rounded pl-1" style="background-color: #0069d9;height: 300px">
                            <p class="h4 " style=" color: white">Card 1</p>


                        </div>


                    </div>


                    <div class="col-1"></div>

                    <div class="col-4 ">
                        <div class="row">
                            <div class="card border-0 rounded text-white mb-3" style="background-color: #58aaff;height: 142px">
                                <p class="h4" style=" color: white">Card 2</p>

                            </div> 
                        </div>
                        <div class="row">
                            <div class="card border-0 rounded" style="background-color: #58aaff; height: 142px">
                                <p class="h4" style=" color: white">Card 3</p>

                            </div> 
                        </div>

                    </div>


                    <div class="col-1"></div>
                </div>
            </div> 




            <div class="col-1">

            </div> 
            <div class="col-3 bg-white rounded">
                <p class="h3" style=" color: #0069d9">Announcements</p>
            </div>

            <div class="col-1">

            </div> 
        </div>
        <%@include file="footerfragment.jspf" %>





    </body>
</html>
