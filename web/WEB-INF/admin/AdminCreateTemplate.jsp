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
                            <p class="h2 mb-3 " id="contentheader">Header 1</p>
                        </div>
                        <!--Content Need Only be changed in this section-->
                        <div class="row  ">

                            
                            
                            <div class="col-4 ps-3">
                                 
                                 <form action="action">

                                    <div class="row justify-content-end">
                                        <div class="container-sm
                                             d-flex justify-content mt-1">
                                            <p class="h6 me-3 mt-2 d-inline" id="headerdynamic">Header 2</p>
                                            
                                            <select class="form-control-sm  d-inline" id="usercreatetype" name="sellist1">
                                                <option value="1">X</option>
                                                <option value="2">Y</option>
                                                <option value="3">Z</option>
                                                                
                                            </select>
                                            
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div id="infoblock"class="form-control  ">
                                            
                                           
                                            <!-- -->
                                            <label for="info1" id="label1" class="form-label mb-0 "><b>info1</b></label>
                                            <input type="text" class="form-control mb-3" id="info1" placeholder="info1" name="info1">
                                            <!-- -->
                                            <label for="info2" id="label2" class="form-label mb-0"><b>info2</b></label>
                                            <input type="text" class="form-control mb-3" id="info2" placeholder="info" name="info2">
                                            <!-- -->
                                            <label for="info3" id="label3" class="form-label mb-0"><b>info3</b></label>
                                            <input type="text" class="form-control  mb-3" id="info3" placeholder="info" name="info3">
                                            <!-- -->
                                            <label for="info4" id="label4" class="form-label mb-0"><b>info4</b></label>
                                            <input type="text" class="form-control mb-3" id="info4" placeholder="info" name="info4">
                                            <!-- -->
                                            <label for="info5" id="label5"  class="form-label mb-0"><b>info5</b></label>
                                            <input type="text" class="form-control mb-3" id="info5" placeholder="info" name="info5">
                                            <!-- -->
                                            <label for="info6" id="label6" class="form-label mb-0"><b>info6</b></label>
                                            <input type="text" class="form-control mb-0" id="info6" placeholder="info" name="info6">
                                            <div class="row">
                                                <div class="container-fluid d-flex justify-content-around ">
                                                    <button href="#" type="submit" id="but4" class="btn d-inline text-success">Create XXXX</button>
                                                    
                                                    
                                                </div>
                                            </div>
                                            </form>
                                        </div>
                                    </div>




                                </form>
                            </div>
                            
                            <div class="col me-3">
                                
                                <div class="row mt-2 " >
                                     <select multiple="multiple" class="form-select border-0"  id="select2" style="height: 500px;">
                                     
                                     
                                     
                                     </select>
                                </div>
                            </div> 
                            
                        </div>
                        
                        
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
