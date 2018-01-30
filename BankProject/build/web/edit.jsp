<%-- 
    Document   : edit
    Created on : Dec 14, 2017, 3:57:46 PM
    Author     : Inspiron
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javascript">
function editRecord(id){
<% System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    %>
    var f=document.form;
    f.method="post";
    f.action='edit.jsp?id='+id;
    f.submit();
}
</script>

    </head>
    <body>
        
        
        

        <%
           int id;
           String bname;
           String key;
           Connection con = DbConnect.DbConnect.con();
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery("select * from bankdb where status=0 ");
           
           %>
           
           <form method="post" name="form">
               <Table>
                   
              <%
            while(rs.next()){
                id=rs.getInt(1);
bname=rs.getString(2);
key=rs.getString(3);
%>
<TR>
                    <TD align="center"> <%= id %> </TD>
                    <TD align="center"> <%= bname  %> </TD>
                    <TD align="center"> <%= key%> </TD>
                       <td><input type="submit" onclick="editRecord(id)" value="Approve" />
    <input type="hidden" id="editRecord"  value="<%=id%>" />
    </td>
                </TR>
<%
}
%>
 </Table>
        </form>
    </body>
</html>
