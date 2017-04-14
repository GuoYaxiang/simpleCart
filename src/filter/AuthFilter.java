package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;

public class AuthFilter implements Filter{

	@Override
	public void destroy(){
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
		throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		String uri = request.getRequestURI();
		if(uri.endsWith("login.jsp") || uri.endsWith("login")){
			chain.doFilter(request, response);
			return;
		}
		
		User user = (User)request.getSession().getAttribute("user");
		if(null == user){
			response.sendRedirect("login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException{
		
	}

}
