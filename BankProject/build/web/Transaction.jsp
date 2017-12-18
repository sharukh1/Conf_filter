<%-- 
    Document   : Transaction
    Created on : Dec 13, 2017, 12:42:53 PM
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
        <h2>Hello!..<%= name%></h2>
        <%
        }

        %>
        <a href="AddBalance.jsp">Deposit</a> <br>  <br> 
        <a href="WithDraw.jsp">Withdraw</a>  <br>  <br> 
        <a href="Transfer.jsp">Transfer</a>  <br>  <br> 
    </body>
</html>
