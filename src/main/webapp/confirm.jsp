<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation</title>
</head>
<body>
	<h2>Registration Confirmation</h2>
	<p>Registration Almost complete!</p>
	<p>Please check your email mailbox for a confirmation link to complete your registration.</p>
	<p>If you don't see the email, check your spam or junk email folder.</p>
	
	<p>You will be redirect to homepage in <span id="count">5</span></p>
	
	<footer style="margin-top: 1em;">hadrihl &copy; 2024. Made with love in Penang.</footer>
	
	<script>
		let counter = +document.getElementById('count').innerText;
		let count = counter - 1;
		
		setInterval(() => {
			document.getElementById('count').textContent = count;
			count--;
			if(count < 1) location.replace('http://localhost:8080/jsp-project/');
		}, 1000);
	</script>
</body>
</html>