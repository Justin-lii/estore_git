package com.briup.service;

import java.util.List;

import com.briup.bean.Category;

public interface ICategotyService {
	public List<Category> findAllCategories();
	
	public List<Category> findAllCategoryWithBooks();
	
	public Category findCategoryWithBooksById(int id);
	
}
