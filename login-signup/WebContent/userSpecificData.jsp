
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<%@page language="java" import="java.sql.*" %>

<%@page language="java" import="javax.servlet.*" %>

<%@page language="java" import="javax.servlet.annotation.WebServlet" %>

<%@page language="java" import="javax.servlet.http.*" %>

<%@page language="java" import="java.util.*" %>

<!DOCTYPE html>
<html>
<% String connectionURL = "jdbc:mysql://localhost:3306/sys?useSSL=false";
Connection connection= null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver").newInstance();
connection = DriverManager.getConnection(connectionURL, "root", "redhat"); 
%>

	
<head>
<meta charset="UTF-8">
<title>user data </title>
</head>
<body>

<form action="" method="post">
<% 
String u = request.getParameter("id");
int id = parseInt(u);
String sql = "select * from users where id='"+id+"'";
Statement s = connection.createStatement();
s.executeQuery(sql);
rs = s.getResultSet();
while (rs.next ()){
%>
<input type="hidden" name="id" value='<%=rs.getString("id") %>'/>
<div>
<label>
 Name 
</label>
<input type="text" name="fullName"  value='<%=rs.getString("fullName") %>'/>
</div>
<div>
<label>
Mail
</label>
<input type="text" name="mail"  value='<%=rs.getString("mail") %>'/>
</div>
<% } %>
<button type="submit"> Update</button>
</form>



</body>
</html>
<%
String temp=request.getParameter("id");
int userId= parseInt(temp);
String name=request.getParameter("fullName");
String mail=request.getParameter("mail");
if(userId!=null && name!=null  && mail!=null )
{
	
	String query="update crud set name=?,mail=? where id='"+userId+"'";
	s = connection.prepareStatement(query);
	s.setString(1,name);
	s.setString(2,mail);
	s.executeUpdate();
	resposne.sendRedirect("ViewUsers.jsp");

}

%>
