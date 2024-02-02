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
import utility.TokenGenerator;

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
		String username = req.getParameter("username");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		String company = req.getParameter("company");
		String city = req.getParameter("city");
		String country = req.getParameter("country");
		
		//validate password
		if(!password.matches(cpassword)) {
			req.setAttribute("errmsg", "Password not match! Please try again.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
			dispatcher.forward(req, resp);
			
		} else {
			User user = new User();
			user.setUsername(username);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setEmail(email);
			user.setPassword(cpassword);
			user.setCompany(company);
			user.setCity(city);
			user.setCountry(country);
			
			// pass to UserDaoImpl to insert the data
			boolean rowAffected = myDao.insert(user);
			
			if(rowAffected) {
				resp.sendRedirect("/jsp-project/confirm");
				
			} else {
				req.setAttribute("errorMessage", "user/email already exists!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}

}
