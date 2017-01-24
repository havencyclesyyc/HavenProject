<%-- 
    Document   : header
    Created on : Jan 16, 2017, 1:07:02 PM
    Author     : 545410
--%>

<%@tag description="Header" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<header>
            <div class="container">
              <!-- Static navbar -->
              <nav class="navbar main-nav">
                <div class="container-fluid">
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="home">HAVEN CYCLES</a>
                  </div>
                  <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                      <li><a href="store">STORE</a></li>
                      <li><a href="about">ABOUT</a></li>
                      <li><a href="rentals">RENTALS</a></li>
                      <li><a href="repairs">REPAIRS</a></li>
                      <li><a href="#">CONTACT</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <c:if test="${role eq 'anonymous'}">
                            <li><a href="login?action=login">LOGIN</a></li>
                        </c:if>
                        <c:if test="${role eq 'customer'}">
                            <li><a href="profile?action=profile">PROFILE</a></li>
                            <li><a href="login?action=logout">LOGOUT</a></li>
                        </c:if>
                        <c:if test="${role eq 'admin'}">
                            <li><a href="login?action=login">LOGIN</a></li>
                        </c:if>
                        <c:if test="${role eq 'employee'}">
                            <li><a href="login?action=login">LOGIN</a></li>
                        </c:if>
                    </ul>
                  </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
              </nav>
            </div> <!-- /container -->
        </header>