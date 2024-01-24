<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
</head>
<body>
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