<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
 <div align="center">
  <h1>login</h1>
  <form action="<%= request.getContextPath() %>/login" method="post">
   <table style="with: 80%">
    <tr>
     <td>Email id</td>
     <td><input type="text" name="id" /></td>
    </tr>
 
  
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
 
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>