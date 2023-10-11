<%-- 
    Document   : loginV2
    
    Author     : Altamish Lalani
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mass Login - MTG Healthcare</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="css/style.css">

    </head>
    <body class="img js-fullheight" style="background-image: url(images/bg.jpg);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 text-center mb-5">
                        <div class="css-3d-text" style="font-size: 69px;color: #ffffff; line-height: 1.6;font-family: 'Lato', Arial, sans-serif;text-shadow: 0px 0px 0 rgb(150,150,150),
                             1px 1px 0 rgb(113,113,113),
                             2px 2px 0 rgb(77,77,77),
                             3px 3px 0 rgb(40,40,40),
                             4px 4px 0 rgb(4,4,4),
                             5px 5px 0 rgb(-33,-33,0),
                             6px 6px 0 rgb(-69,-69,0),
                             7px 7px  0 rgb(-105,-105,0),
                             8px 8px 7px rgba(0,0,0,1),
                             8px 8px 1px rgba(0,0,0,0.5),
                             0px 0px 7px rgba(0,0,0,.2);">MASS</div>
                        <h4 class="header-section" style ="color: white;line-height: 1; font-family: 'Lato', Arial, sans-serif;">MTG Healthcare Academy</h4>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <h3 class="mb-4 text-center">Have an account?</h3>

                            <!--CHANGE THE # in "action='#'" HERE TO THE CORRECT SERVLET ADDRESS WHICH IS ACCEPTING THE FORM-->

                            <form action="LogonCon" method="Post" class="signin-form">
                                <div class="form-group">
                                    <input name="username" type="text" class="form-control" placeholder="Username">
                                </div>
                                <div class="form-group">
                                    <input id="password" name="password" type="password" class="form-control" placeholder="Password">
                                    <span toggle="#password" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <div class="form-group">
                                    <button type="submit" name="submit" value="Sign In" class="form-control btn btn-primary submit px-3">Sign In</button>
                                </div>
                                <div class="form-group d-md-flex">
                                    <div class="w-50">
                                        <!--Add id for Remember Me and Track in Servlet either as a cookie, or let the session live infinitely like FB does it.-->
                                        <label class="checkbox-wrap checkbox-primary">Remember Me
                                            <input type="checkbox" checked>
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                    <div class="w-50 text-md-right">
                                        <!-- Change Href to point to Forgot Password Page -->
                                        <a href="#" onClick="MyWindow = window.open('https://mtghealthcare.com/contact-us/', 'MyWindow', 'width=600,height=300'); return false;" style="color: #fff"><u>Forgot Password</u> </a>
                                    </div>
                                </div>
                            </form>
                            <div class="alert alert-error" role="alert">
                                <button type="button" class="close" data-dismiss="alert">&times;</button>
                                <p class ="text-lg-left">
                                    ${requestScope.message} </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/jquery.min.js"></script>
        <script src="js/popper.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>

    </body>
</html>
