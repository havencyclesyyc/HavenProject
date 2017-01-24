<%-- 
    Document   : login
    Created on : Jan 16, 2017, 12:33:22 PM
    Author     : Andrew Crayden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="haven" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - Haven Cycles</title>
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        
        <haven:header />
 
        <div id="main">
            
            <div class="container">
                <h1>Login</h1>
                <c:if test="${not empty helpText}">
                    <span id="helpBlock" class="help-block error">${helpText}</span>
                </c:if>
                <form method="post" action="login" class="form" id="login-form">
                    <c:if test="${empty correct}">
                        <div class="row">
                            <div class="form-group col-md-6">
                              <label class="control-label">Email:</label>
                              <input type="text" name="email-input" class="form-control" required />
                            </div>
                            <div class="form-group col-md-6">
                              <label class="control-label">Password:</label>
                              <input type="text" name="password-input" class="form-control" required />
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${correct eq 'false'}">
                        <div class="row">
                            <div class="form-group has-error col-md-6">
                                <label class="control-label">Email:</label>
                                <input type="text" name="email-input" class="form-control" required />
                            </div>
                            <div class="form-group  has-error col-md-6">
                                <label class="control-label">Password:</label>
                                <input type="text" name="password-input" class="form-control" required />
                            </div>
                        </div>
                    </c:if>
                      <input type="hidden" name="action" value="login" />
                      <input class="btn btn-success" type="submit" value="login" />
                  </form>
                        <a href="login?action=forgotPassword">Forgot password?</a>
                    
                    
                
                <h2>Register</h2>
                <form class="form" method="post" action="login">
                    <div class="row">
                        <div class="form-group col-md-6">
                            <label>First name</label>
                            <input type="text" name="first-name-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>Last name</label>
                            <input type="text" name="last-name-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>Email</label>
                            <input type="email" name="email-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>Password</label>
                            <input type="password" name="password-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>Phone number</label>
                            <input type="tel" name="phone-number-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>Zip Code</label>
                            <input type="text" name="zip-code-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>Street Address</label>
                            <input type="text" name="street-address-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>City</label>
                            <input type="text" name="city-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>State</label>
                            <input type="text" name="state-input" class="form-control" required />
                        </div>
                        <div class="form-group col-md-6">
                            <label>Country</label>
                            <input type="text" name="country-input" class="form-control" required />
                        </div>
                    </div>
                    <input type="hidden" name="action" value="register" />
                    <input class="btn btn-success" type="submit" value="login" />
                </form>
            </div>
            
        </div>
        <haven:footer />
    </body>
</html>
