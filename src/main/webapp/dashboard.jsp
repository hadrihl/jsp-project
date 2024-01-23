<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<c:if test="${not empty email}">
	<h2>Welcome, ${email}!</h2>
	</c:if>
	<p>This is a dashboard page.</p>
	
	<footer style="margin-top: 1em;">hadrihl &copy; 2024. Made with love in Penang.</footer>
</body>
</html>