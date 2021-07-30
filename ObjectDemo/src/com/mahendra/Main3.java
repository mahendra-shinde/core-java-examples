package com.mahendra;

import java.util.TreeSet;

public class Main3 {

	public static void main(String[] args) {
		TreeSet<Book> books = new TreeSet<>();
		
		Book b1 = new Book(103,"Let Us C++","Yashwant Kanetkar");
		Book b2 = new Book(102,"Let Us C", "Yashwant Kanetkar");
		Book b3 = new Book(105,"Let Us C++","Yashwant Kanetkar");
		Book b4 = new Book(101,"Java Primer","Unknown!");
		
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		
		for(Book b : books) {
			System.out.println(b.getBookId()+" \t"+ b.getTitle() +" \t"+b.getAuthor());
		}
		
	}

}
