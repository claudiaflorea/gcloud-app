<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a new Account</title>
</head>
<body>
	<div class="navbar" style="overflow: hidden;  background-color: cornflowerblue; position: fixed; top: 0;  width: 100%;">
		<div class="container" style="margin-right: 10px;">
		  <a href="books" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;">Books</a>
	   	  <a href="signup" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;">Sign Up</a>
	      <a href="login" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;" >Login</a>
	      <a href="${pageContext.request.contextPath }/logout" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;">Logout</a>
	      <a href="greet" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;" >My Account</a>
	      <a href="/" style=" float: right;  display: block;  color: #f2f2f2;  text-align: center;  padding: 14px 16px;  text-decoration: none; font-size: x-large;">Home</a>
		</div>
   </div>
   
<form method="POST" modelAttribute="registerForm"  action="/register" 
style="display: flex; text-align: left;  left: 35%; right: 35%; width: 70%;   top: 20%;   position: absolute;   height: 500px;  font-size: xxx-large;">
	<fieldset style="text-align: center; border-radius: 10%; border-color: cornflowerblue;  border-width: 5px;">
	<legend>Sign Up</legend>
	${error }
			<table style="with: 50%;  display: flex;  font-size: xx-large; justify-content: center;  margin: 10%;" cellpadding="2" cellspacing="2">
			 <spring:bind path="firstName">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" style="font-size: x-large" /></td>
				</tr>
			</spring:bind>
			<spring:bind path="lastName">
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" style="font-size: x-large"/></td>
				</tr>
			</spring:bind>
			<spring:bind path="username">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" style="font-size: x-large"/></td>
				</tr>
			</spring:bind>
			<spring:bind path="password">
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" style="font-size: x-large"/></td>
				</tr>
			</spring:bind>
			</table>
			
			<input type="submit" value="Submit" style="width: 50%; justify-content: center;  font-size: x-large;" />
		</fieldset>	
</form>
</body>
</html>