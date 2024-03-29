package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

public class ForgotServlet extends HttpServlet {

	private static final long serialVersionUID = -5101876182623474886L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("forgot.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		
		UserDao myDaoImpl = new UserDaoImpl();
		boolean status = myDaoImpl.forgotPassword(email);
		System.err.println("status: " + status);

		if(status) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("confirm-forgot.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("errormsg", "Email not exists! Please try again or register new account.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("forgot.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
