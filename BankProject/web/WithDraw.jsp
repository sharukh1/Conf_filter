<%-- 
    Document   : WithDraw
    Created on : Dec 13, 2017, 8:44:40 PM
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
        <form action="WithDraw">
            <h2> <label>Amount:  </label><input type="text" name="cash"> <br>

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="submit">
            </h2>
        </form>

    </body>
</html>
