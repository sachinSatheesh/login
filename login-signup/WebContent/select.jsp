<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Select an option !

<button id="register" class="float-left submit-button" >Register</button>

<script type="text/javascript">
    document.getElementById("register").onclick = function () {
        location.href = "userRegister.jsp";
    };
    
    </script>
    
    <button id="login" class="float-right submit-button" >Login</button>

    <script type="text/javascript">
        document.getElementById("login").onclick = function () {
            location.href = "login.jsp";
        };    </script>
</body>
</html>