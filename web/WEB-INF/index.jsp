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
        <title>Home - Haven Cycles</title>
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
                        <a href="rentals"><img src="images/rentals.jpg" class="img-responsive border" alt="Rentals" /></a>
                        <a href="rentals">Rentals</a>
                    </div>
                    <div class="col-md-4">
                        <a href="repairs"><img src="images/repairs.jpg" class="img-responsive border" alt="Repairs" /></a>
                        <a href="repairs">Repairs</a>
                    </div>
                    <div class="col-md-4">
                        <a href="store"><img src="images/store.jpg" class="img-responsive border" alt="Store" /></a>
                        <a href="store">Store</a>
                    </div>
                </div>
                
                <img src="images/map.jpg" id="map" class="img-responsive border" alt="Haven Cycles" />
                
            </div>
            
        </div>
        <haven:footer />
    </body>
</html>
