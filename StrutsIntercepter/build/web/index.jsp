<%-- 
    Document   : index
    Created on : Jan 16, 2018, 12:48:05 PM
    Author     : Inspiron
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Biodata</h1>
        <s:form action="checkin">
            <s:textfield name="name" label="Name"/>
            <s:textfield name="age" label="Age"/>
            <s:textfield name="mark" label="Mark"/>
            <s:submit value="save"/>
        </s:form>
    </body>
</html>
