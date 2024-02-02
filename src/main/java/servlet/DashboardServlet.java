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
		
		HttpSession session = req.getSession();
		
		System.err.println("session.username: " + session.getAttribute("username"));
		
		if(session == null || session.getAttribute("username") == null) {
			resp.sendRedirect("/jsp-project/login");
		
		} else {
			User user = new User();
			UserDao myDaoImpl = new UserDaoImpl();
			user = myDaoImpl.getUserByUsername(session.getAttribute("username").toString());
			
			if(user.getUserType().equals("1")) {
				req.setAttribute("adm", user.getUsername());
			} else {
				req.setAttribute("user", user.getUsername());
			}
			
			
			req.setAttribute("id", user.getId());
			req.setAttribute("username", user.getUsername());
			RequestDispatcher dispatcher = req.getRequestDispatcher("dashboard.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
