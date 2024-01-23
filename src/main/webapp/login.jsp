<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login here</h2>
	<form action="login" method="post">
		<div class="form-group mt-2">
			<label for="email">Email</label>
			<input type="text" id="email" name="email" placeholder="Enter your email" required />
		</div>
		
		<div class="form-group mt-2">
			<label for="password">Password</label>
			<input type="password" id="password" name="password" placeholder="Enter your password" required />
		</div>
		
		<div class="form-group mt-2">
			<button style="margin-top: 1em;" type="submit">Login</button>
		</div>
		
		<c:if test="${not empty errorMessage}">
			<p style="color: red;">${errorMessage} Forgot password? Click <a href="/jsp-project/forgot">here</a></p>
		</c:if>
	</form>
	
	<footer style="margin-top: 1em;">hadrihl &copy; 2024. Made with love in Penang.</footer>
</body>
</html> 