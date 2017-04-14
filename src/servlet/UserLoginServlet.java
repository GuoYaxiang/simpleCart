package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

import bean.User;

public class UserLoginServlet extends HttpServlet{

	private static final long serialVersionUID = -2612798932458375213L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new UserDAO().getUser(name, password);
		if(null != user){
			request.getSession().setAttribute("user", user);
			response.sendRedirect("listProduct");
		}else{
			response.sendRedirect("login.jsp");
		}
	}

}
