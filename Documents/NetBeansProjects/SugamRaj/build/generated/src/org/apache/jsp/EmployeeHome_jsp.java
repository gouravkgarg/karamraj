package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public final class EmployeeHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("  <head> \n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Raleway\" rel=\"stylesheet\">\n");
      out.write("   <title>Stage 1</title>\n");
      out.write("   <style>\n");
      out.write("     body {\n");
      out.write("  margin: 0 0;\n");
      out.write("  font-family: 'Raleway';\n");
      out.write("  background-color: #E0F7FA;\n");
      out.write("  color: #006064;\n");
      out.write("}\n");
      out.write("form  { \n");
      out.write("    display: table;\n");
      out.write("    /*box-shadow: 0 5px 25px 0 rgba(0, 0, 0, 0.l4);*/\n");
      out.write("    padding: 30px;\n");
      out.write("    margin: 0 auto;\n");
      out.write("    margin-bottom: 40px;\n");
      out.write("    transition: 2s ease all;\n");
      out.write("}\n");
      out.write("p     { display: table-row;  }\n");
      out.write("label, input, select, button, form p span  { display: table-cell; }\n");
      out.write("button {\n");
      out.write("  margin-left: 55%;\n");
      out.write("  width: 200px;\n");
      out.write("  height: 50px;\n");
      out.write("  font-size: 115%;\n");
      out.write("  background-color: #006064;\n");
      out.write("  border: 0px;\n");
      out.write("  border-radius: 7px;\n");
      out.write("  color: white;\n");
      out.write("  transition: 2s ease all;\n");
      out.write("}\n");
      out.write("button img {\n");
      out.write("  height: 22px; \n");
      out.write("}\n");
      out.write("form:hover, button:hover {\n");
      out.write("-webkit-transition: 2s ease all;\n");
      out.write("  transition: 2s ease all;\n");
      out.write("  box-shadow: 0 15px 35px 0 rgba(0, 0, 0, 0.7);\n");
      out.write("  -webkit-transform: translateY(-1px);\n");
      out.write("          transform: translateY(-1px);\n");
      out.write("}       \n");
      out.write("  form label {\n");
      out.write("    font-size:16px;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  input[type=\"text\"], input[type=\"number\"], input[type=\"password\"], select {\n");
      out.write("    width: 200px;\n");
      out.write("    height: 30px;\n");
      out.write("    margin-left: 20px;\n");
      out.write("    padding: 3px;\n");
      out.write("    padding-left:6px;\n");
      out.write("    border-radius: 5px;\n");
      out.write("  font-size: 14px;\n");
      out.write("  box-shadow: inset 0 1px 3px rgba(0,0,0, .455), 0px 1px 1px rgba(255,255,255,.5);\n");
      out.write("  border: 1px solid #4DD0E1;\n");
      out.write("  background-color: rgb(239,252,251);\n");
      out.write("  }\n");
      out.write("  .foot {\n");
      out.write("    position: absolute;\n");
      out.write("    bottom: 0;\n");
      out.write("  background-color: #006064;\n");
      out.write("  width: 100%;\n");
      out.write("  color: white;\n");
      out.write("  }\n");
      out.write("  .centered {\n");
      out.write("    padding: 10px;\n");
      out.write("    margin: 0 auto;\n");
      out.write("    text-align:center;\n");
      out.write("  }\n");
      out.write("  .heading {\n");
      out.write("    margin: 20px;\n");
      out.write("  }\n");
      out.write("   </style>\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>  \n");
      out.write("    \n");
      out.write("  <div>\n");
      out.write("    <img src=\"karamraj.png\" width=\"125\" style=\"padding: 10px; position: absolute; left:0; top:0;\">\n");
      out.write("  </div>\n");
      out.write("      <div class=\"container\">\n");
      out.write("  <h2 class=\"heading centered\">Old-age Pension Scheme</h2><br>\n");
      out.write("    <form  action =\"viewRequest\" method =\"POST\" name = ?order?>\n");
      out.write("        <table style=\"\">\n");
      out.write("            <tr style=\"font-weight:bold; padding: 10px;\">\n");
      out.write("            <th>Tracking ID</th>\n");
      out.write("            <th>Status</th>\n");
      out.write("            <th>Link</th>\n");
      out.write("            </tr>\n");
      out.write("        ");

//String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "sugamkaram";
String userId = "root";
String password = "";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection con=null;
Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
String empId="";
            
try{ 
    
    String username=(String)session.getAttribute("userName");
    String password1=(String)session.getAttribute("password1");
    System.out.println("username and password in EmployeeHome"+username+password1);
    connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
    con = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.prepareStatement("SELECT empId FROM performance where empName=? and Password=?");
statement.setString(1, username);
statement.setString(2,password1);

resultSet = statement.executeQuery();
ResultSet rs=null;
if(resultSet.next()){
    empId=resultSet.getString(1);
}

PreparedStatement pst=con.prepareStatement("Select * from stages where empId=?");
    pst.setInt(1,Integer.parseInt(empId));
     rs=pst.executeQuery();
    
while(rs.next()){
    String reqId=rs.getString(1);

      out.write("\n");
      out.write("<tr bgcolor=\"#DEB887\">\n");
      out.write("<td>");
      out.print(reqId );
      out.write("</td>\n");
      out.write("<td>");
      out.print(rs.getString(4) );
      out.write("</td>\n");
      out.write("<td><a href=\"updateApplication.jsp?tid=");
      out.print(reqId);
      out.write("&eid=");
      out.print(rs.getString(3));
      out.write("\">Update</a></td>\n");
      out.write("</tr>\n");
      out.write("\n");
 
}

} catch (Exception e) {
e.printStackTrace();
}

      out.write("\n");
      out.write("</table>\n");
      out.write("    </form>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"foot\"> \n");
      out.write("            <ul style=\"list-style-type:none\" class=\"centered\">\n");
      out.write("            <li>DroidiserGang @ Rajasthan Hackathon</li>\n");
      out.write("            </ul>\n");
      out.write("    </div>\n");
      out.write("  </body>\n");
      out.write("</html>");
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
