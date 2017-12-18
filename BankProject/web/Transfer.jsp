<%-- 
    Document   : Transfer
    Created on : Dec 13, 2017, 9:25:48 PM
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
        <form action="Transfer">
            <h2>
            <label>From Account:  </label><input type="text" name="cashfrom"> <br> 
            <label>To Account:  &nbsp; &nbsp;</label><input type="text" name="cashto"> <br>
             <label>Amount:  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;</label><input type="text" name="cash"><br><br>
           &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; <input type="submit" value="Transfer">
            </h2>>
           </form>
    </body>
</html>
