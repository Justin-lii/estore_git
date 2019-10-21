package com.briup.service.impl;

import java.util.List;
import java.util.Map;

import com.briup.bean.Category;
import com.briup.dao.CategoryDao;
import com.briup.dao.impl.CategoryDaoImpl;
import com.briup.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	private CategoryDao categoryDao = new CategoryDaoImpl();
	@Override
	public Map<Category,List<Category>> findAllCategories() {
		Map<Category, List<Category>> map = categoryDao.findAllCategories();
		return map;
	}

	@Override
	public List<Category> findAllCategoryWithBooks() {
		return null;
	}

	@Override
	public Category findCategoryWithBooksById(int id) {
		return null;
	}

}
