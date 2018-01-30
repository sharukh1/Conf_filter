<%-- 
    Document   : index
    Created on : Jan 28, 2018, 7:53:43 PM
    Author     : Inspiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Here!</h1>
        <s:form action="process">
            <s:textfield label="Name" name="name"></s:textfield> 
            <s:textfield label="Age" name="age"></s:textfield>  
            <s:textfield label="Username" name="username"></s:textfield> 
            <s:textfield label="Password" name="login.password"></s:textfield> 
            <s:textfield label="Place" name="address.place"></s:textfield>  
            <s:textfield label="Pin" name="address.pin"></s:textfield> 
            <s:submit label="register"></s:submit>
    </s:form>
    </body>
</html>
