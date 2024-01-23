<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	</form>
	
	<footer style="margin-top: 1em;">hadrihl &copy; 2024. Made with love in Penang.</footer>
</body>
</html>