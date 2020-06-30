<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%@page language="java" import="java.util.*" %>
<%@page language="java" import="java.sql.*" %>

<%@page language="java" import="javax.servlet.*" %>

<%@page language="java" import="javax.servlet.annotation.WebServlet" %>

<%@page language="java" import="javax.servlet.http.*" %>

<%@page language="java" import="java.util.*" %>


<html>
<head>
<title>All Users</title>
<h5 align="center"> All Registered Users</h5>
</head>
<body> 
<table border="1" width="303"  align="center">
<tr>
<td><b>ID</b></td>
<td><b>Name</b></td>
<td ><b>Mail id</b></td>
<td><b>Phone No</b></td>
<td><b>Select</b></td>


</tr>
<%
String connectionURL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
Connection connection= null;
ResultSet rs;
Class.forName("com.mysql.jdbc.Driver");
connection = DriverManager.getConnection(connectionURL, "root", "redhat"); 
String sql = "select * from users";
Statement s = connection.createStatement();
s.executeQuery (sql);
rs = s.getResultSet();
while (rs.next ()){
	%>
<tr>
<td>
<%=rs.getString("id") %> </td>
<td>
<%=rs.getString("fullName")%> </td>
<td>
<%=rs.getString("mail")%> </td>
<td>
<%=rs.getString("mobile")%> </td>
<td>
<a href = "userSpecificData.jsp">

Edit </a>
 </td>

</tr>

</tr>
<%  } %>

</table>


</html>