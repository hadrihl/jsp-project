package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dao.UserDaoImpl;

public class VerifyServlet extends HttpServlet {

	private static final long serialVersionUID = -1624198724863014647L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String token = req.getParameter("token");
		UserDao myDaoImpl = new UserDaoImpl();
		
		if(myDaoImpl.verifyToken(token)) {
			resp.sendRedirect("verify-success.jsp");
		} else {
			resp.sendRedirect("verify-fail.jsp");
		}
	}
}
