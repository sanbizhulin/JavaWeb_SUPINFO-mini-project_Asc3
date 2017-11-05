package com.supinfo.supcommerce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.sun.net.httpserver.HttpExchange;

@WebFilter(urlPatterns="/auth/*")
public class AuthenticateFilter implements Filter {
	
	@SuppressWarnings("unused")
	private FilterConfig fc;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String username  = (String) ((HttpServletRequest)req).getSession().getAttribute("username");
		
		if(username!=null)
			chain.doFilter(req, resp);//jump to next webpage.
		else// if username == null, then you have to input username in login.html again
			((HttpServletResponse)resp).sendRedirect(((HttpServletRequest)req).getContextPath()+"/login.html");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.fc = filterConfig;
	}

}
