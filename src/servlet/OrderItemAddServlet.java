package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;

import bean.OrderItem;
import bean.Product;

public class OrderItemAddServlet extends HttpServlet{

	private static final long serialVersionUID = 7185163470222728700L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int num = Integer.parseInt(request.getParameter("num"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		System.out.println("添加商品" + pid + ",共" + num + "件");
		
		Product product = new ProductDAO().getProduct(pid);
		
		OrderItem oi = new OrderItem();
		oi.setNum(num);
		oi.setProduct(product);
		
		List<OrderItem> ois = (List<OrderItem>) request.getSession().getAttribute("ois");
		
		if(null == ois){
			ois = new ArrayList<OrderItem>();
			request.getSession().setAttribute("ois", ois);
		}
		
		//如果商品已经在订单中，则只需要改变数量即可
		boolean found = false;
		for(OrderItem item : ois){
			if(item.getProduct().getId() == oi.getProduct().getId()){
				item.setNum(item.getNum() + oi.getNum());
				found = true;
				break;
			}
		}
		
		if(!found)  ois.add(oi);
		
//		response.sendRedirect("listOrderItem");
	}

}
