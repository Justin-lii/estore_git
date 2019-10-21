package com.briup.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Category;
import com.briup.service.ICategoryService;
import com.briup.service.impl.CategoryServiceImpl;

/*
 * 找到全部的图书分类
 */
@WebServlet("/servlet/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Category category = new Category();
	private ICategoryService categoryService = new CategoryServiceImpl();
	List<Category> list = new ArrayList<Category>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
			if(session.getAttribute("user")!=null) { 
				session.setAttribute("login", "退出");
			}else { 
				session.setAttribute("login", "登录");
			}
		
		System.out.println("开始执行：servlet/CategoryServlet");
		Map<Category, List<Category>> map = categoryService.findAllCategories();
		request.setAttribute("map", map);
//		request.getAttribute("list");
		/*List<Category> list2 = (List<Category>) request.getAttribute("list");
		System.out.println("获得数据："+list2);
		System.out.println("集合的长度："+list2.size());*/
		request.getRequestDispatcher("../index.jsp").forward(request, response);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
