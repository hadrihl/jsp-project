package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -154176561953216931L;
	
	UserDao myUserDaoImpl = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		// store info into user object
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
	
		// validate user
		int rowAffected = myUserDaoImpl.login(user);
		
		// if success, redirect user to dashboard page
		// otherwise, show wrong email/password
		if(rowAffected == 1) {
			resp.sendRedirect("/jsp-project/dashboard");
		} else {
			resp.sendRedirect("/login");
		}
	}

}
