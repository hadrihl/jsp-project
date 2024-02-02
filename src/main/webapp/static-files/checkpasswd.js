var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/;

document.getElementById('register').addEventListener('submit', function(event) {
	var password = document.getElementById('password').value;
	var cpassword = document.getElementById('cpassword').value;
	var errmsg = document.getElementById('errormsg').value;
	
	if(!passwordRegex.test(password)) {
		errmsg.textContent = "Password does not meet the requirement.";
		event.preventDefault();
		return;
	}
	
	if(password !== cpassword) {
		alert("Password does not match.");
		event.preventDefault();
	}
});