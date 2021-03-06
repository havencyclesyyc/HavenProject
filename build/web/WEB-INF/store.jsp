<%-- 
    Document   : store
    Created on : Jan 16, 2017, 2:32:27 PM
    Author     : Andrew Crayden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="haven" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store - Haven Cycles</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        <haven:header />
 
        <div id="main">
            
            <div class="container">
                <h1>Store</h1>
                <div class="row" id="store-products-grid">
                    <div class="col-md-4 product-preview">
                        <a href="#"><img src="images/bike.jpg" class="img-responsive border" alt="Bike" /></a>
                        <a href="#">Product 1</a>
                        <span class="price">$100</span>
                    </div>
                    <div class="col-md-4 product-preview">
                        <a href="#"><img src="images/bike.jpg" class="img-responsive border" alt="Bike" /></a>
                        <a href="#">Product 1</a>
                        <span class="price">$100</span>
                    </div>
                    <div class="col-md-4 product-preview">
                        <a href="#"><img src="images/bike.jpg" class="img-responsive border" alt="Bike" /></a>
                        <a href="#">Product 1</a>
                        <span class="price">$100</span>
                    </div>
                </div>
            </div>
            
        </div>
        <haven:footer />
    </body>
</html>
