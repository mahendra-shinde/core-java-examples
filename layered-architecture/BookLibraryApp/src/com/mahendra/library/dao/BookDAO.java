package com.mahendra.library.dao;

import java.util.List;

import com.mahendra.library.models.Book;

public interface BookDAO {

	Book findById(Integer id);

	List<Book> findByAuthor(String author);
	List<Book> findByCategory(String category);
	List<Book> findByTitle(String title);

	List<Book> findAvailableByTitle(String title);
	List<Book> findAvailableByAuthor(String author);
	List<Book> findAvailableByCategory(String category);
	
	void update(Book book);
	void save(Book book);
	public int nextId();
}
