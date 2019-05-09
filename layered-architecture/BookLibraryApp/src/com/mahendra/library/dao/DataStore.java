package com.mahendra.library.dao;

import java.util.*;

import com.mahendra.library.models.Book;
import com.mahendra.library.models.BookIssue;
import com.mahendra.library.models.Member;

public class DataStore {

	private Map<Integer,Book> books = new HashMap<>();
	private Map<Integer,Member> members = new HashMap<>();
	private Map<Integer,BookIssue> issues = new HashMap<>();
	
	private static DataStore instance = null;
	
	private DataStore() {
		System.out.println("Initializing Data Store...");
//		Book book1 = new Book(1001,"Java Primer","Mahendra","Study Book",'A');
//		Book book2 = new Book(1002,"Java2 Complete Reference","Mahendra","Study Book",'A');
//		books.put(1001, book1);
//		books.put(1002, book2);
	}
	
	public static DataStore getInstance() {
		if(instance == null) {
			instance = new DataStore();
		}
		return instance;
	}

	public Map<Integer,Book> getBooks() {
		return books;
	}

	public void setBooks(Map<Integer,Book> books) {
		this.books = books;
	}

	public Map<Integer,Member> getMembers() {
		return members;
	}

	public void setMembers(Map<Integer,Member> members) {
		this.members = members;
	}

	public Map<Integer,BookIssue> getIssues() {
		return issues;
	}

	public void setIssues(Map<Integer,BookIssue> issues) {
		this.issues = issues;
	}
	
	
}
