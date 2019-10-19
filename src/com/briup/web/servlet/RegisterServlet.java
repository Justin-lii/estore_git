package com.briup.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebServlet("/servlet/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Customer customer;
	private ICustomerService customerService = new CustomerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RegisterServlet.....");
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String zip = request.getParameter("zipCode");
		String phone = request.getParameter("telephone");
		String email = request.getParameter("email");
		System.out.println("注册的用户信息："+username+" "+password+" "+zip+" "+phone+" "+email);
		customer = new Customer(username, password, zip, phone, email);
		try {
			customerService.insertCustomer(customer);
			request.setAttribute("info", "注册成功，请登录！");
//			response.sendRedirect("../register.jsp");
//			request.getRequestDispatcher("/login.html").forward(request, response);
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("异常信息："+message);
			request.setAttribute("info", message);
//			response.sendRedirect("../register.jsp");
		}finally {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
//		request.getRequestDispatcher("/login.html").forward(request, response);
		//response.sendRedirect("../login.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
