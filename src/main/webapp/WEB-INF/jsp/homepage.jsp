<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IBDB Home Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
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
   
<div class="container" style="position: relative; padding-top: 70px; top: 200px;  width: 70%; height: 100%;">  
<h1>Books Collection </h1>  
  
<div id="myCarousel" class="carousel slide" data-ride="carousel" style="height: 600px;">  
    <!-- Indicators -->  
    <ol class="carousel-indicators">  
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>  
      <li data-target="#myCarousel" data-slide-to="1"></li>  
      <li data-target="#myCarousel" data-slide-to="2"></li>  
    </ol>  
  
    <!-- Wrapper for slides -->  
    <div class="carousel-inner" role="listbox">  
 	   <c:forEach items="${listBook}"  var="book" >
	      <div class="item active">  
	        <img src="${book.image}" alt="book image" >  
	      </div>  
      </c:forEach>
  
    </div>  
  
    <!-- Left and right controls -->  
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">  
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>  
      <span class="sr-only">Previous</span>  
    </a>  
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">  
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>  
      <span class="sr-only">Next</span>  
    </a>  
</div><!-- corousel end -->  
  
</div>  

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>