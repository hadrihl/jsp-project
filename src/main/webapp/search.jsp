<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Malaysian Software Developer Portal</title>
<link rel="stylesheet" href="style.css">
<title>Search</title>
</head>
<body>
	<header>
        <nav>
            <div class="logo">MSDP</div>
            <ul class="nav-links">
                <li><a href="/">Home</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="#discussions">Discussions</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="/register">Register</a></li>
                <li><a href="/login">Login</a></li>
                <li><a href="/search">Search</a></li>
            </ul>
        </nav>
    </header>
    
	<h1>Search User Profile</h1>
	<form action="search" method="post">
		<input type="text" id="keyword" name="keyword" />
		<button type="submit">Search</button>
	</form>
	
	<c:if test="${not empty users}">
	<table style="margin-top: 2em">
		<tr>
			<th>#id</th>
			<th>#email</th>
			<th>#firstname</th>
			<th>#lastname</th>
			<th>#city</th>
		</tr>
		
		<c:forEach var="user" items="${users}" varStatus="row">
		<tr>
			<td>${row.index+1}</td>
			<td>${user.email}</td>
			<td>${user.firstname}</td>
			<td>${user.lastname}</td>
			<td>${user.city}</td>
		</tr>
		</c:forEach>
		
	</table>
	</c:if>
	
	<c:if test="${empty users}">
	<p>User(s) not found.</p>
	</c:if>
	
	<footer style="margin-top:2em;">hadrihl &copy; 2024. Made with &#10084; in Penang.</footer>
</body>
</html>