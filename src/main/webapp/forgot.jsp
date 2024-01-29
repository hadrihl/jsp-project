<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
</head>
<body>
	<h2>Reset Your Password</h2>
	<p>Enter your email address</p>
	
	<form action="forgot" method="post">
		<input type="text" id="email" name="email" required />
		
		<button type="submit">Submit</button>
		
		<c:if test="${not empty errormsg}">
			<p style="color: red;">${errormsg}</p>
		</c:if>
	</form>
	
	<footer style="margin-top:2em;">hadrihl &copy; 2024. Made with &#10084; in Penang.</footer>
</body>
</html>