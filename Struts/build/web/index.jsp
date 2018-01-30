<%-- 
    Document   : index
    Created on : Jan 15, 2018, 6:00:40 PM
    Author     : Inspiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri = "/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Here!</h1>
        <s:form action="checkin">
        <s:textfield name="name" key="Name"/>
        <s:textfield name="username" key="UserName"/>
        <s:textfield name="password" key="Password"/>
        <s:submit label="register"/>
        </s:form>
    </body>
</html>
