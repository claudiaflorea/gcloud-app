<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Greetings</title>
</head>
<body>

	<div class="navbar" style="overflow: hidden;  background-color: cornflowerblue; position: fixed; top: 0;  width: 100%;">
		<div class="container" style="margin-right: 10px;">
		  <a href="books" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;">Books</a>
	   	  <a href="signup" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;">Sign Up</a>
	      <a href="login" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;" >Login</a>
	      <a href="/" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;">Home</a>
	     
		</div>
   </div>
   
	<h1 style="text-align: center"> Welcome ${sessionScope.username } </h1>
	<br>
	<a href="${pageContext.request.contextPath }/logout">Logout</a>
</body>
</html>