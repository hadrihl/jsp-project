<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  </head>
  <body>
    <div class="card mt-5" style="width: 20rem; margin: auto;">
        <div class="card-body text-center">
            <form class="mb-4" action="register" method="post">
                <span class="navbar-brand mt-1 h1">MSDF</span>
                <h1 class="mb-4">Register</h1>
                <div class="form-group mt-2">
                    <label for="username" class="visually-hidden">username</label>
                    <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
                </div>
                <div class="form-group mt-2">
                    <label for="email" class="visually-hidden">email</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="Email" required>
                </div>
                <div class="form-group mt-2">
                    <label for="password" class="visually-hidden">password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group mt-2">
                    <label for="cpassword" class="visually-hidden">Confirm password</label>
                    <input type="password" id="cpassword" name="cpassword" class="form-control" placeholder="Confirm Password">
                </div>
                <div class="form-group mt-2">
                    <label for="firstname" class="visually-hidden">Firstname</label>
                    <input type="text" id="firstname" name="firstname" class="form-control" placeholder="Enter first name" required autofocus>
                </div>
                <div class="form-group mt-2">
                    <label for="lastname" class="visually-hidden">Lastname</label>
                    <input type="text" id="lastname" name="lastname" class="form-control" placeholder="Enter last name" required autofocus>
                </div>
                <div class="form-group mt-2">
                    <label for="company" class="visually-hidden">Company</label>
                    <input type="text" id="company" name="company" class="form-control" placeholder="Enter your company's name" required>
                </div>
                <div class="form-group mt-2">
                    <label for="city" class="visually-hidden">City</label>
                    <input type="text" id="city" name="city" class="form-control" placeholder="City" required>
                </div>
                <div class="form-group mt-2 mb-3">
                    <label for="country" class="visually-hidden">Country</label>
                    <input type="text" id="country" name="country" class="form-control" placeholder="Country" required>
                </div>
                
                <c:if test="${not empty errmsg}">
                	<div class="alert alert-danger" role="alert">${errmsg}</div>
                </c:if>
                
                <div class="form-group d-grid gap-2">
                    <button class="btn btn-success w-100">Sign up with email</button>
                </div>
                
                <footer class="mt-5 text-muted">&copy; 2024. <a href="/">MSDF</a> portal.<br/>
                    Made with <i class="fa-solid fa-heart"></i> in Penang.<br/>
                    <i class="fa-brands fa-github"></i>
                    <a href="https://github.com/hadrihl/jsp-project"> jsp-project</a>
                </footer>
            </form>
        </div>
    </div>

    <script src="https://kit.fontawesome.com/e19fcdf015.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
  </body>
</html>