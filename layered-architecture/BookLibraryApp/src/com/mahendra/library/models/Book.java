package com.mahendra.library.models;

import java.io.Serializable;

public class Book implements Serializable{
	private Integer id;
	private String title;
	private String author;
	private String category;
	private char status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Book(Integer id, String title, String author, String category, char status) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.status = status;
	}
	public Book() {
		super();
	}
	
}
