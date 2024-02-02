package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		boolean isValidUser = myUserDaoImpl.login(user);
		
		// if success, redirect user to dashboard page
		// otherwise, show wrong email/password
		if(isValidUser) {
			User uid = new User();
			uid = myUserDaoImpl.getUserByEmail(user.getEmail());
			
			//set user session
			HttpSession session = req.getSession();
			session.setAttribute("username", uid.getUsername());

			if(uid.getUserType().equals("1")) {
				req.setAttribute("adm", uid.getUsername());
			} else {
				req.setAttribute("user", uid.getUsername());
			}
			
			req.setAttribute("id", uid.getId());
			req.setAttribute("username", uid.getUsername());
			session.setMaxInactiveInterval(30 * 60); // 30 minutes timeout
			RequestDispatcher dispatcher = req.getRequestDispatcher("dashboard.jsp");
			dispatcher.forward(req, resp);
			
		} else {
			req.setAttribute("errorMessage", "Email/Password are incorect! Please try again.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
