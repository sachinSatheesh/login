<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"                                                    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@page import="java.sql.*;"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<h5 align="center"> WELCOME   </h5>
<body>

</body>
<form method="post">

<table border="2" align ="center">
<tr>
<td>ID</td>
<td>NAME</td>
<td>AGE</td>
<td>Email </td>
<td>Mobile Number </td>

</tr>
<%
try
{
Class.forName("com.mysql.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/sys?useSSL=false";
String username="root";
String password="redhat";
String query="select * from users";
Connection conn=DriverManager.getConnection(url,username,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery(query);
while(rs.next())
{

%>
    <tr>
    <td><%=rs.getInt("id") %></td>
    <td><%=rs.getString("fullName") %></td>
        <td><%=rs.getString("age") %></td>
                <td><%=rs.getString("mail") %></td>
                <td><%=rs.getString("mobile") %></td>
        
    
</tr><%

}
%>
    </table>
    <%
    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }




%>

</form>

<form action = "<%= request.getContextPath() %>/LogoutServlet" method = "get" >
<input type ="submit" value = "Logout" align="center">
</form>
</html> >