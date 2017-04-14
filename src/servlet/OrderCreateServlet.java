package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.OrderItemDAO;

import bean.Order;
import bean.OrderItem;
import bean.User;

public class OrderCreateServlet extends HttpServlet{

	private static final long serialVersionUID = 6248721498330353091L;

	/**
	 *    创建订单的Servlet：
	 * 1. 首选判断用户是否登陆，如果没有登陆跳转到登陆页面
	 * 2. 创建一个订单对象，并设置其所属用户
	 * 3. 把该订单对象保存到数据库中
	 * 4. 遍历session中所有的订单项，设置他们的Order。 然后保存到数据库中
	 * 5. 清空session中的订单项
	 * 6. 最后打印订单创建成功
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		User user = (User)request.getSession().getAttribute("user");
		if(null == user){
			response.sendRedirect("login.jsp");
			return;
		}
		
		Order order = new Order();
		order.setUser(user);
		
		new OrderDAO().insert(order);
		
		List<OrderItem> ois = (List<OrderItem>)request.getSession().getAttribute("ois");
		
		for(OrderItem oi:ois){
			oi.setOrder(order);
			new OrderItemDAO().insert(oi);
		}
		
		ois.clear();
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("订单创建成功！！！");
	}

}
