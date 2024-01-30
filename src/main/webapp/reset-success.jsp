<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Verify</title>
</head>
<body>
	<h2>Verify Reset password successful!</h2>
	<p>Your token has been verified.</p>
	<p>Please enter new password.</p>
	
	<form action="resetpassword" method="post">
		<input type="hidden" id="email" name="email" value="${email}" />
		
		<label for="password">New password</label>
		<input type="password" id="password" name="password" required />
		
		<label for="cpassword">Confirm password</label>
		<input type="password" id="cpassword" name="cpassword" required />
		
		<button type="submit">Submit</button>
		
		<c:if test="${not empty errormsg}">
			<p style="color: red;">${errormsg}</p>
		</c:if>
	</form>
</body>
</html>