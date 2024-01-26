package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class SearchServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1643958525044428352L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		UserDao myDaoImpl = new UserDaoImpl();
		
		List<User> users = myDaoImpl.getUsersByKeyword(keyword);
		
		req.setAttribute("users", users);
		RequestDispatcher dispatcher = req.getRequestDispatcher("search.jsp");
		dispatcher.forward(req, resp);
	}

}
