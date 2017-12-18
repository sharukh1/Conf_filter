<%-- 
    Document   : Join
    Created on : Dec 14, 2017, 6:52:32 PM
    Author     : Inspiron
--%>
<%@page import="java.sql.*"%>
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
            if (!name.equals(null) && !emailid.equals(null)) {
        %>
        <jsp:include page="Nav.html"></jsp:include>
        <h2>Hello!..<%= name%></h2>
       <h2 align="center"><i>Banks Available...join here for transactions</i></h2>
       
           <%
            String bankname;
            Connection con = DbConnect.DbConnect.con();
            Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select name from bankdb where status=1");
  //ResultSet rs = st.executeQuery("SELECT * FROM   bankdb p WHERE  NOT EXISTS (SELECT * FROM   [jointable] od WHERE  p.name = od.name) ");
   

           %>  
           
          <TABLE BORDER="5" width="400" align="center">
            <TR>
                <TH width="25%">BANK NAME</TH>
                 <TH width="25%">REQUEST</TH>
            </TR>  
             <%        
                 while (rs.next()) {

                    bankname = rs.getString(1);
                    
            %>
            
            <TR>
                <TD align="center"> <%= bankname %> </TD>
                
                <TD align="center"> <a href="Join?bankname=<%= bankname %>&emailid=<%= emailid %>">join</a>
                      
    </TD>
            </TR>
            <%    }


            %>

        </TABLE>

        <%                        }
        %>
            
           
    </body>
</html>
