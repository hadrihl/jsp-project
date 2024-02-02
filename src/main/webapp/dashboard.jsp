<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
        <style>
            .card {
              width: 360px;
              height: 560px;
              border-radius: 12px;
              box-shadow: 6px 6px 10px #ccc, 6px 6px 20px #ccc;
              margin-bottom: 50px;
            }
      
            .card img {
              width: 100%;
              height: 60%;
              object-fit: cover;
            }
      
            .card-title {
              font-size: 16px;
            }
        </style>
    </head>
    
    <body>
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
                <span class="navbar-brand mt-1 h1"><span class="text-primary">MSDF</span></span>

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarScroll">
                    <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="">Contact</a>
                        </li>
                    </ul>

                    <form class="d-flex" role="search">
                        <div class="input-group">
                            <input class="form-control" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success me-2" type="submit">Search</button>
                        </div>

                        <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                            <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <c:if test="${not empty username}">
                                	@${username}
                                </c:if>
                              </a>
                              <ul class="dropdown-menu dropdown-menu-lg-end">
                                <li><a class="dropdown-item" href="/jsp-project/user?id=${id}">Profile</a></li>
                                <li><hr class="dropdown-divider"></li>
                                
                                <c:if test="${not empty adm }">
                                <li><a class="dropdown-item" href="#">Manage Users</a></li>
                                <li><a class="dropdown-item" href="#">Settings</a></li>
                                </c:if>
                                
                                <li><a class="dropdown-item" href="logout">Logout</a></li>
                              </ul>
                            </li>
                        </ul>
                    </form>
                </div>
            </div>
        </nav>
        
        

        <section>
            <div class="container py-4 mb-5">
                
                <c:if test="${not empty adm}">
                <p style="color: red;">testing 123, admin: ${adm}</p>
		        </c:if>
		        
		        <c:if test="${not empty user}">
		        <p style="color: blue;">testing 456, normal user: ${user}</p>
		        </c:if>
        
                <div class="row" style="margin-top: 20px;">
        
                  
                  
                </div>
              </div>
        </section>

        <footer class="py-5 bg-light text-muted">
            <div class="container">
              <div class="row">
                <div class="col-8 d-flex justify-content-start">
                  <span>&copy; 2022. <a href="#">LinkedMeIn</a> portal.<br/>
                    Made with <i class="fa-solid fa-heart"></i> in Penang.<br/>
                    <i class="fa-brands fa-github"></i>
                    <a href="https://github.com/hadrihl/linkedmein"> linkedmein</a>
                  </span>
                </div>
      
                <div class="col-4 d-flex justify-content-end">
                  <a href="#" class="me-2">Sitemap</a>
                  <a href="#">Policy</a>
                </div>
              </div>
            </div>
        </footer>

        <script src="https://kit.fontawesome.com/e19fcdf015.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    </body>
</html>