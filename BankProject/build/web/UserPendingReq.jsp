<%-- 
    Document   : UserPendingReq
    Created on : Dec 14, 2017, 8:29:21 PM
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
            String name = (String) session.getAttribute("name");
            if (!name.equals(null)) {
        %>
        <jsp:include page="BankNav.html"></jsp:include>
        <h1>Hello!..<%= name%></h1>
       <h2 align="center"><i>Users Pending Requests</i></h2>
           <%
           
            String emailid;
           int id;
            Connection con = DbConnect.DbConnect.con();
            Statement st = con.createStatement();
                 ResultSet rs1= st.executeQuery("select idbank from bankdb where name='"+name+"'");
                 while(rs1.next()){
                     id=rs1.getInt(1);
                 }
           ResultSet rs = st.executeQuery("select emailid from jointable where bankname='"+name+"' AND idbank=0");
        

        %>  
          <TABLE BORDER="5" width="400" align="center">
            <TR>
                <TH width="25%">USERS</TH>
                <TH>PERMIT</TH>
            </TR>  
             <%        
                 while (rs.next()) {

                    
                    emailid = rs.getString(1);
                    
            %>
            
            <TR>
                
                <TD align="center"> <%= emailid %> </TD>
                <TD align="center"> <a href="UserApproval?emailid=<%= emailid %>">approve</a>
                      
    </TD>
            </TR>
            <%    }


            %>

        </TABLE>

        <%                        }
        %>
            
            
            
            
            
            
            
            
            
        
        
        
       
            
            
           


            



    </body>
</html>
