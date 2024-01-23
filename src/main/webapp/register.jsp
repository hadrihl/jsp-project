<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h2>Register Here</h2>
	<form action="register" method="post">
		<div class="form-group mt-2">
			<label for="firstname">Firstname</label>
			<input type="text" id="firstname" name="firstname" placeholder="Enter first name" />
		</div>
		
		<div class="form-group mt-2">
			<label for="lastname">Lastname</label>
			<input type="text" id="lastname" name="lastname" placeholder="Enter last name" />
		</div>
		
		<div class="form-group mt-2">
			<label for="email">Email</label>
			<input type="email" id="email" name="email" placeholder="Enter email address" />
		</div>
		
		<div class="form-group mt-2">
			<label for="password">Password</label>
			<input type="password" id="password" name="password" placeholder="Enter password" />
		</div>
		
		<div class="form-group mt-2">
			<label for="cpassword">Confirmed password</label>
			<input type="password" id="cpassword" name="cpassword" placeholder="Confirm password" />
		</div>
		
		<div class="form-group mt-2">
			<label for="city">City</label>
			<input type="text" id="city" name="city" placeholder="Enter City" />
		</div>
		
		<div class="form-group mt-2">
			<button type="submit">Submit</button>
		</div>
	</form>
	
	<footer style="margin-top: 1em;">hadrihl &copy; 2024. Made with love in Penang.</footer>
</body>
</html>