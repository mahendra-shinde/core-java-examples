package com.mahendra;

import java.util.*;

public class BookData {
	private List<Book> books = new LinkedList<>();
	
	
	public void add(int bookId, String title, String author) {
		Book book = new Book(bookId, title, author);
		books.add(book);
	}
	
	public Book[] getAll() {
		//Convert list to an array and return it
		return books.toArray(new Book[books.size()]);
	}
	
	
	
}
