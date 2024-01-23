<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login here</h2>
	<form action="/login" method="post">
		<label for="email">Email</label>
		<input type="text" id="email" name="email" placeholder="Enter your email" required />
		
		<label for="password">Password</label>
		<input type="password" id="password" name="password" placeholder="Enter your password" required />
		
		<button style="margin-top: 1em;" type="submit">Login</button>
	</form>
	
	<footer style="margin-top: 1em;">hadrihl &copy; 2024. Made with love in Penang.</footer>
</body>
</html> 