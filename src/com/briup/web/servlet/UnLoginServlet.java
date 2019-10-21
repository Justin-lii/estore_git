package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
/*
 * 功能：index.jsp页面，登录、退出功能
 */
@WebServlet("/servlet/UnLoginServlet")
public class UnLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("user");
		String isLogin = (String) session.getAttribute("login");
		System.out.println("登录的用户"+customer);
		System.out.println("登录/退出："+isLogin);
		if("退出".equals(isLogin)) {
			System.out.println("登录的用户"+customer);
			session.setAttribute("user", null);
			System.out.println(session.getAttribute("user"));
//			response.sendRedirect("../index.jsp");
			request.getRequestDispatcher("/servlet/CategoryServlet").forward(request, response);
		}else{
			response.sendRedirect("../login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
