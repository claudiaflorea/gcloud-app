<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books</title>
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
       
	<div class="container"
	style="display: flex; text-align: left;  left: 35%; right: 35%; width: 70%;   top: 20%;   position: absolute;   height: 500px;  font-size: xxx-large;">
		<div style="text-align: center; border-radius: 10%; border-color: cornflowerblue;  border-width: 5px;">
		<legend style="margin-bottom: 10%;"> List of Books</legend>
		<div align="center">
		<form:form method="GET" action="/book/all" modelAttribute="listBook">
          
	        <table border="1" cellpadding="7" style="font-size: x-large;">
	            <tr>
	                <th>Title</th>
	                <th>ISBN</th>
	                <th>Author</th>
	                <th>Publisher</th>
	                <th>Publish Date</th>
	                <th>Category</th>
	                <th>Rating</th>
	            </tr>
	       
                <tr>
                     <c:forEach items="${listBook}"  var="book" >
	                    <td><c:out value="${book.title}" /></td>
	                    <td><c:out value="${book.isbn}" /></td>
	                    <td><c:out value="${book.author}" /></td>
	                    <td><c:out value="${book.publisher}" /></td>
	                    <td><c:out value="${book.publishDate}" /></td>
	                    <td><c:out value="${book.category}" /></td>
	                    <td><c:out value="${book.rating}" /></td>
                    </c:forEach>
                </tr>

	        </table>
         </form:form>
    </div> 
		</div>
	</div>

</body>
</html>