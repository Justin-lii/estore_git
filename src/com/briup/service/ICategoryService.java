package com.briup.service;

import java.util.List;
import java.util.Map;

import com.briup.bean.Category;

public interface ICategoryService {
//	public List<Category> findAllCategories();
	public Map<Category,List<Category>> findAllCategories();
	
	public List<Category> findAllCategoryWithBooks();
	
	public Category findCategoryWithBooksById(int id);
	
}
