package com.mahendra.library.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.mahendra.library.exceptions.ApplicationException;
import com.mahendra.library.models.Book;

public class BookDAOImpl implements BookDAO {
	private DataStore store = DataStore.getInstance();
	
	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		return store.getBooks().get(id);
	}

	@Override
	public List<Book> findByAuthor(String author) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> books = store.getBooks().values();
		for(Book b : books) {
			if(b.getAuthor().equalsIgnoreCase(author)) {
				System.out.println("Found book : "+b.getTitle());
				temp.add(b);
			}
		}
		return temp;
	}

	@Override
	public List<Book> findByCategory(String category) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> books = store.getBooks().values();
		for(Book b : books) {
			if(b.getCategory().equalsIgnoreCase(category)) {
				System.out.println("Found book : "+b.getTitle());
				temp.add(b);
			}
		}
		return temp;
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> books = store.getBooks().values();
		for(Book b : books) {
			if(b.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Found book : "+b.getTitle());
				temp.add(b);
			}
		}
		return temp;
	}

	@Override
	public List<Book> findAvailableByTitle(String title) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> books = store.getBooks().values();
		for(Book b : books) {
			if(b.getTitle().equalsIgnoreCase(title) && b.getStatus()=='A') {
				System.out.println("Found book : "+b.getTitle());
				temp.add(b);
			}
		}
		return temp;
	}

	@Override
	public List<Book> findAvailableByAuthor(String author) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> books = store.getBooks().values();
		for(Book b : books) {
			if(b.getAuthor().equalsIgnoreCase(author) && b.getStatus()=='A') {
				System.out.println("Found book : "+b.getTitle());
				temp.add(b);
			}
		}
		return temp;
	}

	@Override
	public List<Book> findAvailableByCategory(String category) {
		List<Book> temp = new ArrayList<>();
		Collection<Book> books = store.getBooks().values();
		for(Book b : books) {
			if(b.getCategory().equalsIgnoreCase(category) && b.getStatus()=='A') {
				System.out.println("Found book : "+b.getTitle());
				temp.add(b);
			}
		}
		return temp;
	}

	@Override
	public void update(Book book) {
		if(findById(book.getId())==null)
			throw new ApplicationException("Book not found!");
		store.getBooks().put(book.getId(), book);
	}

	@Override
	public void save(Book book) {
		if(findById(book.getId())!=null)
			throw new ApplicationException("Book already exists!");
		store.getBooks().put(book.getId(),book);
	}
	
	@Override
	public int nextId() {
		Set<Integer> keys = store.getBooks().keySet();
		int highest = 0;
		for(int key : keys) {
			if(key > highest) {
				highest = key;
			}
		}
		return highest+1;
	}

}
