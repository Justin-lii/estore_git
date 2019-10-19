package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
	
		String urlString = request.getRequestURI();
		System.out.println("请求路径："+urlString);
		HttpSession session = request.getSession();
		//对登录注册页面放行
		if(urlString.endsWith("login.jsp")||urlString.endsWith("servlet/LoginServlet")||urlString.endsWith("register.jsp")) {
			chain.doFilter(request, response);
			return;
		}else if(urlString.endsWith("index.jsp")) {//放行首页
			if(session.getAttribute("user")!=null) { 
//				request.setAttribute("login", "退出");
				session.setAttribute("login", "退出");
			}else { 
//				request.setAttribute("login", "登录");
				session.setAttribute("login", "登录");
			}
			chain.doFilter(request, response);
			return;
		}
		if(session.getAttribute("user")!=null) {
			chain.doFilter(request, response);
		}else {
			response.sendRedirect("/estore_git/login.jsp");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
