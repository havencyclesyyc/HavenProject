<%-- 
    Document   : header
    Created on : Jan 16, 2017, 1:07:02 PM
    Author     : 545410
--%>

<%@tag description="Header" pageEncoding="UTF-8"%>

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
                    <a class="navbar-brand" href="home">Haven Cycles</a>
                  </div>
                  <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                      <li><a href="store">Store</a></li>
                      <li><a href="#">About</a></li>
                      <li><a href="rentals">Rentals</a></li>
                      <li><a href="#">Repairs</a></li>
                      <li><a href="#">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                      <li><a href="login">Login</a></li>
                    </ul>
                  </div><!--/.nav-collapse -->
                </div><!--/.container-fluid -->
              </nav>
            </div> <!-- /container -->
        </header>