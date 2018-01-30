<%-- 
    Document   : TimeLine
    Created on : Dec 1, 2017, 3:49:08 PM
    Author     : Inspiron
--%>

<%@page import="javax.mail.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = (String) session.getAttribute("name");
            if (!name.equals(null)) {
        %>
        <%@include  file="Menu.html" %> <br><br>
        <% out.print("Welcome.. " + session.getAttribute("name"));
            } else {
                response.sendRedirect("GateWay.html");
            }
        %>
    </body>
</html>
