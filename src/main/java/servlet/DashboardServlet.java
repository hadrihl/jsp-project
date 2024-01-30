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

public class DashboardServlet extends HttpServlet {

	private static final long serialVersionUID = -963094406558960533L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("user") == null) {
			resp.sendRedirect("login.jsp");
		} else {
			String email = session.getAttribute("user").toString();
			UserDao myDaoImpl = new UserDaoImpl();
			User user = myDaoImpl.getUserByEmail(email);
			
			req.setAttribute("uid", user.getId());
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("dashboard.jsp");
		dispatcher.forward(req, resp);
	}

}
