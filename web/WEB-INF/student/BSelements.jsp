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

            <!-- Copy this for the large element height will be dynamic or you'll have to set it as seen here-->
            <div class="col-5 bg-white rounded" style="height: 400px">
                <div class="row">
                    <p class="h3 mb-3 " style=" color: #0069d9">Large Card Element</p>
                    </div>

                <div class="row"> 
                    <div class="col-1"></div>
                        <div class="col-4 ">

                        
                        
                        
                        </div>
               

                <div class="col-1"></div>

                <div class="col-4 ">
                   
                    

                </div>

            
            <div class="col-1"></div>
        </div>
    </div> 



           <!-- Copy this for the thinner element height will be dynamic-->
    <div class="col-1">

    </div> 
    <div class="col-3 bg-white rounded">
        <p class="h3" style=" color: #0069d9">Thinner Element</p>
    </div>

    <div class="col-1">

    </div> 
</div>
        





</body>
</html>
