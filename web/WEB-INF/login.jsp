<%-- 
    Document   : login
    Created on : Jan 16, 2017, 12:33:22 PM
    Author     : 545410
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="haven" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Haven Cycles - Login</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        
        <haven:header />
 
        <div id="main">
            
            <div class="container">
                <h1>Login</h1>
                <form class="form" id="login-form">
                    <div class="row">
                    <div class="form-group col-md-6">
                      <label class="control-label" for="">Username:</label>
                      <input type="text" class="form-control" id="">
                    </div>
                    <div class="form-group col-md-6">
                      <label class="control-label" for="">Password:</label>
                      <input type="text" class="form-control" id="" >
                    </div>
                    </div>
                      <input class="btn btn-success" type="submit" value="Login" />
                  </form>
            </div>
            
        </div>
        <haven:footer />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>
