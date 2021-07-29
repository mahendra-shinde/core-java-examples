package com.mahendra.library.services;

import java.util.List;

import com.mahendra.library.dao.BookDAO;
import com.mahendra.library.exceptions.ApplicationException;
import com.mahendra.library.models.Book;

public class BookServiceImpl implements BookService {
	private BookDAO dao;

	public BookServiceImpl(BookDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public Book findById(Integer id) {
		Book temp = dao.findById(id);
		if (temp == null)
			throw new ApplicationException("Book not found!");
		return temp;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		List<Book> temp = dao.findByAuthor(author);
		return temp;
	}

	@Override
	public List<Book> findByCategory(String category) {
		List<Book> temp = dao.findByCategory(category);
		return temp;
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<Book> temp = dao.findByCategory(title);
		return temp;
	}

	@Override
	public List<Book> findAvailableByTitle(String title) {
		List<Book> temp = dao.findAvailableByCategory(title);
		return temp;
	}

	@Override
	public List<Book> findAvailableByAuthor(String author) {
		List<Book> temp = dao.findAvailableByAuthor(author);
		return temp;
	}

	@Override
	public List<Book> findAvailableByCategory(String category) {
		List<Book> temp = dao.findAvailableByCategory(category);
		return temp;
	}

	@Override
	public Book create(Book b) {
		int newId = dao.nextId();
		b.setId(newId);
		dao.save(b);
		return b;
	}

}
