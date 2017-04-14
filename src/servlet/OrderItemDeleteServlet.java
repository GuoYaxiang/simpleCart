package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.OrderItem;

public class OrderItemDeleteServlet extends HttpServlet{

	private static final long serialVersionUID = 913237771976750148L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		int pid = Integer.parseInt(request.getParameter("pid"));
		List<OrderItem> ois = (List<OrderItem>)request.getSession().getAttribute("ois");
		
		for(Iterator<OrderItem> iter = ois.iterator();iter.hasNext();){
			OrderItem oi = iter.next();
			if(oi.getProduct().getId() == pid){
				iter.remove();
				break;
			}
		}
		response.sendRedirect("listOrderItem");
	}

}
