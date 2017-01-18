package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Haven Cycles | Home</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"bootstrap/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/styles.css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("              <!-- Static navbar -->\n");
      out.write("              <nav class=\"navbar main-nav\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                  <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                      <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                      <span class=\"icon-bar\"></span>\n");
      out.write("                      <span class=\"icon-bar\"></span>\n");
      out.write("                      <span class=\"icon-bar\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Haven Cycles</a>\n");
      out.write("                  </div>\n");
      out.write("                  <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                      <li class=\"active\"><a href=\"#\">Home</a></li>\n");
      out.write("                      <li><a href=\"#\">Store</a></li>\n");
      out.write("                      <li><a href=\"#\">About</a></li>\n");
      out.write("                      <li><a href=\"#\">Rentals</a></li>\n");
      out.write("                      <li><a href=\"#\">Repairs</a></li>\n");
      out.write("                      <li><a href=\"#\">Contact</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                      <li><a href=\"../navbar-static-top/\">Login</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                  </div><!--/.nav-collapse -->\n");
      out.write("                </div><!--/.container-fluid -->\n");
      out.write("              </nav>\n");
      out.write("            </div> <!-- /container -->\n");
      out.write("        </header>\n");
      out.write("        <div id=\"main\">\n");
      out.write("            \n");
      out.write("            <div class=\"container\">\n");
      out.write("                <img src=\"images/banner.jpg\" id=\"banner\" class=\"img-responsive border\" alt=\"Haven Cycles\" />\n");
      out.write("            \n");
      out.write("                <div id=\"services-row\" class=\"row\">\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <img src=\"images/rentals.jpg\" id=\"banner\" class=\"img-responsive border\" alt=\"Haven Cycles\" />\n");
      out.write("                        <a href=\"#\">Rentals</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <img src=\"images/repairs.jpg\" id=\"banner\" class=\"img-responsive border\" alt=\"Haven Cycles\" />\n");
      out.write("                        <a href=\"#\">Repairs</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <img src=\"images/store.jpg\" id=\"banner\" class=\"img-responsive border\" alt=\"Haven Cycles\" />\n");
      out.write("                        <a href=\"#\">Store</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <footer>\n");
      out.write("            <p>Open 11-8 every day</p>\n");
      out.write("            <p>121 Knickerbocker Ave (at Flushing). Brooklyn, NY 11237\n");
      out.write("            <p>havencyclesnyc@gmail.com - 347 529 4621\n");
      out.write("        </footer>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"bootstrap/js/bootstrap.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
