package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

public interface IBookService {

	public List<Book> findAllBooks();
	
	public Book findBookById(int id);
}
