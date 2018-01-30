<%-- 
    Document   : Home
    Created on : Dec 1, 2017, 12:05:07 PM
    Author     : Inspiron
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            static Connection c;
        %>
        <%
            String name = request.getParameter("name");
            int phno = Integer.parseInt(request.getParameter("phno"));
            c = dbConnect();
            int i = insert(name, phno);
            if (i > 0) {
                response.sendRedirect("TimeLine.jsp");
            } else {
                response.sendRedirect("Login.jsp");
            }


        %>
        <%!
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
        %>
    </body>
</html>
