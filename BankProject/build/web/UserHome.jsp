<%-- 
    Document   : UserHome
    Created on : Dec 12, 2017, 1:25:16 PM
    Author     : Inspiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String emailid = (String) session.getAttribute("emailid");
            String name = (String) session.getAttribute("name");
            if (!emailid.equals(null)) {
        %>
        <jsp:include page="Nav.html"></jsp:include>
        <h1>Hello!..<%= name%></h1>
        <%
        } else {

        %>
        <jsp:forward page="Error404.jsp"></jsp:forward>>
        <%    }
        %>
    </body>
</html>
