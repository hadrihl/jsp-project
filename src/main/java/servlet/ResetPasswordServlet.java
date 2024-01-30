package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

public class ResetPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = -46207241144598667L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String token = req.getParameter("token");
		UserDao myDaoImpl = new UserDaoImpl();
		
		if(myDaoImpl.verifyToken(token)) {
			String email = myDaoImpl.getEmailByToken(token);
			
			req.setAttribute("email", email);
			RequestDispatcher dispatcher = req.getRequestDispatcher("reset-success.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		String email = req.getParameter("email");
		
		if(password.matches(cpassword)) {
			UserDao myDaoImpl = new UserDaoImpl();
			myDaoImpl.resetPassword(email, password);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);

		} else {
			req.setAttribute("errormsg", "Password not match! Please try again.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("reset-success.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
