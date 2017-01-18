<%-- 
    Document   : index
    Created on : Jan 12, 2017, 9:01:20 AM
    Author     : Andrew Crayden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="haven" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Haven Cycles - Home</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        
        <haven:header />
        
        <div id="main">
            
            <div class="container">
                <img src="images/banner.jpg" id="banner" class="img-responsive border" alt="Haven Cycles" />
            
                <div id="services-row" class="row">
                    <div class="col-md-4">
                        <img src="images/rentals.jpg" class="img-responsive border" alt="Haven Cycles" />
                        <a href="#">Rentals</a>
                    </div>
                    <div class="col-md-4">
                        <img src="images/repairs.jpg" class="img-responsive border" alt="Haven Cycles" />
                        <a href="#">Repairs</a>
                    </div>
                    <div class="col-md-4">
                        <img src="images/store.jpg" class="img-responsive border" alt="Haven Cycles" />
                        <a href="#">Store</a>
                    </div>
                </div>
                
                <img src="images/map.jpg" id="map" class="img-responsive border" alt="Haven Cycles" />
                
            </div>
            
        </div>
        <haven:footer />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
    </body>
</html>
