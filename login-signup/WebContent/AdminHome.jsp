<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
<h5  align="center"> Admin Home !! </h5>
<form action="<%= request.getContextPath() %>/ViewUsers" method="get">
  <button type="submit" formaction="<%= request.getContextPath() %>/ViewUsers">View Users</button>
</form>
 <br> 
<form action="<%= request.getContextPath() %>/ViewProfile" method="get">

  <button type="submit" formaction="<%= request.getContextPath() %>/ViewProfile">Profile</button>
</form>
<br>

<form action="<%= request.getContextPath() %>/LogoutServlet" method = "get">

  <button type="submit" formaction="<%= request.getContextPath() %>/LogoutServlet">Logout</button>
</form>

</body>
</html>