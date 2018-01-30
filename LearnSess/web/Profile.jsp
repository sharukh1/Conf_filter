<%-- 
    Document   : Profile
    Created on : Dec 1, 2017, 4:36:19 PM
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

        <% String name = (String) session.getAttribute("name");
            if (!name.equals(null)) {
        %>
        <%@include file="Menu.html" %>
        <%        out.print("This is " + name + "'s profile");
                out.println();
                Cookie[] allcook = request.getCookies();
                for (int i = 0; i < allcook.length; i++) {
                    if (allcook[i].getName().equals("lang")) {
                        out.println("language " + allcook[i].getValue());
                    }

                }
            } else {
                response.sendRedirect("index.html");
            }
        %>


    </body>
</html>
