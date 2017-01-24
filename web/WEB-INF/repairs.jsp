<%-- 
    Document   : repairs
    Created on : Jan 23, 2017, 4:29:19 PM
    Author     : 545410
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="haven" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Repairs - Haven Cycles</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        <haven:header />
        
        <div id="main">
            
            <div class="container">
                
                <h1>Repairs</h1>
                
                <c:if test="${role eq 'customer'}">
                <form class="form">
                    <div class="row">
                      <div class="form-group col-md-6">
                        <label>First name</label>
                        <input type="text" class="form-control">
                      </div>
                      <div class="form-group col-md-6">
                        <label>Last name</label>
                        <input type="text" class="form-control">
                      </div>
                      <div class="form-group col-md-6">
                        <label>Email</label>
                        <input type="email" class="form-control">
                      </div>
                      <div class="form-group col-md-6">
                        <label>Phone number</label>
                        <input type="tel" class="form-control">
                      </div>
                      <div class="form-group col-md-6">
                        <label>Date of birth</label>
                        <input type="date" class="form-control">
                      </div>
                      <div class="form-group col-md-6">
                        <label>Bike Type</label>
                        <select class="form-control">
                          <option>BMX</option>
                          <option>Cruiser</option>
                          <option>Cyclocross</option>
                          <option>Hybrid</option>
                          <option>Mountain</option>
                          <option>Road</option>
                          <option>Touring</option>
                          <option>Track/Fixed-Gear</option>
                        </select>
                      </div>
                      <div class="form-group col-md-6">
                        <label>Comments</label>
                        <textarea class="form-control" rows="10"></textarea>
                      </div>
                    </div>
                    <div class="row">
                      <div class="form-group col-md-6">
                        <label>Security deposit</label>
                        <input type="number" step="0.01" class="form-control" readonly>
                      </div>
                      <div class="form-group col-md-6">
                        <label>Total rental amount</label>
                        <input type="number" step="0.01" class="form-control">
                      </div>
                    </div>
                      <input type="submit" class="btn btn-success" value="Submit">
                  </form>
                </c:if>
                
                <h2>Bike repair information goes here for unauthenticated users.</h2>
                <c:if test="${role eq 'anonymous'}">
                    <a href="login">Login to create a bike repair request order.</a>
                </c:if>
                
            </div>
            
        </div>
        <haven:footer />
    </body>
</html>
