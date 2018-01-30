package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.InitialContext;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            static Connection c;
        

            public static Connection dbConnect() {
                Connection con = null;
                try {

                    InitialContext context = new InitialContext();
                    Object ob = context.lookup("jdbc/myDatasource");
                    DataSource ds = (DataSource) ob;
                    con = ds.getConnection();
                    System.out.println("connection setup....");
                } catch (Exception e) {
                    System.out.println(">" + e);
                }
                return con;

            }

            public int insert(String n, int p) {
                int i = 0;
                try {
                    String str = "insert into student (name,phno) values ('" + n + "','" + p + "')";
                    Statement stmt = c.createStatement();
                    System.out.println("connection got");
                    i = stmt.executeUpdate(str);
                    if (i > 0) {
                        System.out.println("inserted");
                    } else {
                        System.out.println("didnt inserted");
                    }
                } catch (Exception e) {
                    System.out.println(">" + e);
                }
                return i;
            }
        
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            String name = request.getParameter("name");
            int phno = Integer.parseInt(request.getParameter("phno"));
            c = dbConnect();
            int i = insert(name, phno);
            if (i > 0) {
                response.sendRedirect("TimeLine.jsp");
            } else {
                response.sendRedirect("Login.jsp");
            }


        
      out.write("\n");
      out.write("        ");
      out.write("\n");
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
