<%-- 
    Document   : rentals
    Created on : Jan 16, 2017, 3:35:49 PM
    Author     : 545410
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="haven" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        <haven:header />
        
         <div id="main">
            
            <div class="container">
                <h1>Rent Bike</h1>
                
                <form class="form">
                    <div class="row">
                      <div class="form-group col-md-6">
                        <label for="">First name</label>
                        <input type="text" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">Last name</label>
                        <input type="text" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">Email</label>
                        <input type="email" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">Phone number</label>
                        <input type="tel" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">Date of birth</label>
                        <input type="date" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">Bike Type</label>
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
                        <label for="">Start time</label>
                        <input type="datetime-local" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">End time</label>
                        <input type="datetime-local" class="form-control" id="" placeholder="">
                      </div>
                      <div class="form-group col-md-6">
                        <label for=""><input type="checkbox" id="">
                          Lock</label>
                      </div>
                      <div class="form-group col-md-6">
                        <label for=""><input type="checkbox" id="">
                          Helmet</label>
                      </div>
                    </div>
                    <div class="row">
                      <div class="form-group col-md-6">
                        <label for="">Security deposit</label>
                        <input type="number" step="0.01" class="form-control" id="" placeholder="" readonly>
                      </div>
                      <div class="form-group col-md-6">
                        <label for="">Total rental amount</label>
                        <input type="number" step="0.01" class="form-control" id="" placeholder="">
                      </div>
                    </div>
                      <input type="submit" class="btn btn-success" id="" value="Submit">
                  </form>
            </div>
             
         </div>
        
        <haven:footer />
    </body>
</html>
