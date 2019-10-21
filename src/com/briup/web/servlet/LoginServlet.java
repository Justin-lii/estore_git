package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Customer customer = new Customer();
	private ICustomerService customerService = new CustomerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("用户名："+username+" 密码："+password);
		customer.setUsername(username);
		customer.setPassword(password);
		try {
			customerService.selectCustomerByUsername(customer);
			HttpSession session = request.getSession();
			session.setAttribute("user", customer);
			System.out.println("登录成功");
			request.getRequestDispatcher("/servlet/CategoryServlet").forward(request, response);
//			response.sendRedirect("../index.jsp");
//			request.getRequestDispatcher("../index.jsp").forward(request, response);
		} catch (Exception e) {
//			response.sendRedirect("../login.jsp");
			String message = e.getMessage();
			request.setAttribute("info", message);
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
