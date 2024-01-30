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

public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = -384554213505312705L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");
		UserDao myDaoImpl = new UserDaoImpl();
		User user = myDaoImpl.getUserById(uid);
		
		req.setAttribute("user", user);
		RequestDispatcher dispatcher = req.getRequestDispatcher("user.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String company = req.getParameter("company");
		String city = req.getParameter("city");
		String country = req.getParameter("country");
		String uid = req.getParameter("id");
		
		UserDao myDaoImpl = new UserDaoImpl();
		boolean update = myDaoImpl.updateUserProfile(firstname, lastname, company, city, country, uid);
		System.err.println("boolean update: " + update);
		if(update) {
			User user = myDaoImpl.getUserById(uid);
			req.setAttribute("user", user);
			RequestDispatcher dispatcher = req.getRequestDispatcher("user.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
