<%-- 
    Document   : BankRequest
    Created on : Dec 14, 2017, 3:10:47 PM
    Author     : Inspiron
--%>
<%@page import="java.sql.*"%>
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
       <h2 align="center"><i>Banks Requests</i></h2>
           <%
            int id;
            String bname;
            String key;
            Connection con = DbConnect.DbConnect.con();
            Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from bankdb where status=0 ");
        

        %>  
          <TABLE BORDER="5" width="400" align="center">
            <TR>
                <TH width="25%">ID</TH>
                <TH width="25%">Name</TH>
                <TH width="25%">KEY</TH>
                <TH>PERMIT</TH>
            </TR>  
             <%        
                 while (rs.next()) {

                    id = rs.getInt(1);
                    bname = rs.getString(2);
                    key = rs.getString(3);
            %>
            
            <TR>
                <TD align="center"> <%= id%> </TD>
                <TD align="center"> <%= bname%> </TD>
                <TD align="center"> <%= key%> </TD>
                <TD align="center"> <a href="Approve?id=<%= id%>">approve</a>
                      
    </TD>
            </TR>
            <%    }


            %>

        </TABLE>

        <%                        }
        %>
            
            
            
            
            
            
            
            
            
        
        
        
       
            
            
           


            




    </body>
</html>
