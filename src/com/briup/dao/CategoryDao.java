package com.briup.dao;

import java.util.List;
import com.briup.bean.Category;

public interface CategoryDao {
	
	public List<Category> findAllCategories();
	
	/*
	 * ��ѯ���еķ����Լ�����������ͼ��
	 */
	public List<Category> findAllCategoryWithBooks();
	
	/*
	 * ͨ��id��ѯ�����Լ��÷����µ�����ͼ��
	 */
	public Category findCategoryWithBooksById(int id);

}