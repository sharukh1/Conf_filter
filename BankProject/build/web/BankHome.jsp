<%-- 
    Document   : BankHome
    Created on : Dec 14, 2017, 6:14:36 PM
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
            
            String name =(String)session.getAttribute("name");
            if (!name.equals(null)) {
        %>
        <jsp:include page="BankNav.html"></jsp:include>
        <h1>Hello!..<%= name%></h1>
        <%
        } else {

        %>
        <jsp:forward page="Error404.jsp"></jsp:forward>>
        <%    }
        %>
    </body>
</html>
