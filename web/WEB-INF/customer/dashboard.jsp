<%-- 
    Document   : dashboard
    Created on : Jan 18, 2017, 9:46:25 AM
    Author     : Andrew Crayden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="haven" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard - Haven Cycles</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        <haven:header />
 
        <div id="main">
            
            <div class="container">
                <h1>Dashboard</h1>
                
                <section>
                <h2>Personal Repair History</h2>
                <table class="table">
                    <tr>
                      <th>Rental Id</th>
                      <th>Start Date</th>
                      <th>End Date</th>
                      <th>Total Cost</th>
                    </tr>
                    <tr>
                      <td><a href="personal-rental-history-detail.html">#0000010</a></td>
                      <td><a href="personal-rental-history-detail.html">Nov 20, 2016</a></td>
                      <td><a href="personal-rental-history-detail.html">Nov 20, 2016</a></td>
                      <td><a href="personal-rental-history-detail.html">$50.00</a></td>
                    </tr>
                </table>
                <a href="#" class="btn btn-success">See All</a>
                </section>
                       
                <section>
                <h2>Personal Rental History</h2>
                <table class="table">
                    <tr>
                      <th>Rental Id</th>
                      <th>Start Date</th>
                      <th>End Date</th>
                      <th>Total Cost</th>
                    </tr>
                    <tr>
                      <td><a href="personal-rental-history-detail.html">#0000010</a></td>
                      <td><a href="personal-rental-history-detail.html">Nov 20, 2016</a></td>
                      <td><a href="personal-rental-history-detail.html">Nov 20, 2016</a></td>
                      <td><a href="personal-rental-history-detail.html">$50.00</a></td>
                    </tr>
                </table>
                <a href="#" class="btn btn-success">See All</a>
                </section>
                
                <section>
                <h2>Personal Store Purchases</h2>
                <table class="table">
                    <tr>
                      <th>Rental Id</th>
                      <th>Start Date</th>
                      <th>End Date</th>
                      <th>Total Cost</th>
                    </tr>
                    <tr>
                      <td><a href="personal-rental-history-detail.html">#0000010</a></td>
                      <td><a href="personal-rental-history-detail.html">Nov 20, 2016</a></td>
                      <td><a href="personal-rental-history-detail.html">Nov 20, 2016</a></td>
                      <td><a href="personal-rental-history-detail.html">$50.00</a></td>
                    </tr>
                </table>
                <a href="#" class="btn btn-success">See All</a>
                </section>
            </div>
            
        </div>
        <haven:footer />
    </body>
</html>
