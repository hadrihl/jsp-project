<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Malaysian Software Developer Portal</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <nav>
            <div class="logo">MSDP</div>
            <ul class="nav-links">
                <li><a href="/">Home</a></li>
                <li><a href="/about">About</a></li>
                <li><a href="#discussions">Discussions</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><a href="/register">Register</a></li>
                <li><a href="/login">Login</a></li>
                <li><a href="/search">Search</a></li>
            </ul>
        </nav>
        <section class="hero" id="home">
            <h1>Welcome to the Malaysian Software Developer Portal</h1>
            <p>A community hub for Malaysian developers to discuss and share about software development and IT.</p>
            <button>Join Us</button>
        </section>
    </header>
    
    <main>
        <section class="discussion" id="discussions">
            <h2>Latest Discussions</h2>
            <!-- Discussion topics will be listed here -->
        </section>
    </main>

    <footer id="contact">
        <p>Contact us at: <a href="mailto:contact@msdp.com">contact@msdp.com</a></p>
        <p>Follow us on <a href="#">social media</a></p>
        <p>hadrihl &copy; 2024. Made with &#10084; in Penang.</p>
    </footer>
</body>
</html>