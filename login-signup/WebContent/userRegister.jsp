<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Employee Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Full Name</td>
     <td><input type="text" name="fullName" /></td>
    </tr>
    <tr>
     <td>Age</td>
     <td><input type="text" name="age" /></td>
    </tr>
   <tr>
     <td>Mobile number</td>
     <td><input type="text" name="mobile" /></td>
    </tr>
   <tr>
     <td>Email id</td>
     <td><input type="text" name="mail" /></td>
    </tr>
    <tr>
   <td> Date of birth : <input type="text" id="datepicker"></td>
	
	<td> <h4 id="selectedDtaeVal"></h4>
	<script>
$( function() {
    $.datepicker.setDefaults({
        onClose:function(date, inst){
            $("#selectedDtaeVal").html(date);
        }
    });

    $( "#datepicker" ).datepicker();
}); 
</script> </td>
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