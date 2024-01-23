package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnnection;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class RegisterServlet extends HttpServlet {
	
	UserDao myDao = new UserDaoImpl();

	private static final long serialVersionUID = 4651920540358014074L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		String city = req.getParameter("city");
		
		System.err.println("firstname: " + firstname);
		System.err.println("lastname: " + lastname);
		System.err.println("email: " + email);
		System.err.println("password: " + password);
		System.err.println("city: " + city);
		
		// catch data and store it into user object
		// in industry practice, you should VALIDATE IT!!
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(cpassword);
		user.setCity(city);
		
		// pass to UserDaoImpl to insert the data
		myDao.insert(user);
		
		resp.sendRedirect("/jsp-project");
	}

}
