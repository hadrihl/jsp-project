<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<h3>Email Verification failed. Register again. You will be re-direct to MSDF homepage in <span id="count">5</span></h3>
	
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