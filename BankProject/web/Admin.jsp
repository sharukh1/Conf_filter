<%-- 
    Document   : Admin
    Created on : Dec 13, 2017, 2:27:13 PM
    Author     : Inspiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link rel="stylesheet" href="css/temp.css">
    </head>
    <body>
       <%
            String name = (String) session.getAttribute("name");
            if (!name.equals(null)) {
        %>
        <jsp:include page="AdminNav.html"></jsp:include>
        <h1>Hello!..<%= name%></h1>
        <%
        } else {

        %>
        <jsp:forward page="Error404.jsp"></jsp:forward>>
        <%    }
        %>
    </body>
</html>
