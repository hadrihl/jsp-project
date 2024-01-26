<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Verify</title>
</head>
<body>
	<h2>Verify Email</h2>
	<p>You account has been verified.</p>
	<p>Please login using our login page. You will be re-direct to MSDF homepage in <span id="count">5</span></p>
	
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