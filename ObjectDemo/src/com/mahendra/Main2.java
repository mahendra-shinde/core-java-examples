package com.mahendra;

import java.util.HashSet;

public class Main2 {

	public static void main(String[] args) {
		HashSet<Book> books = new HashSet<>();
		Book b1 = new Book(101,"Let Us C++","Yashwant Kanetkar");
		Book b2 = new Book(102,"Let Us C", "Yashwant Kanetkar");
		Book b3 = new Book(101,"Let Us C++","Yashwant Kanetkar");
		Book b4 = b2;
		System.out.println("Adding b1: "+ books.add(b1));
		System.out.println("Adding b2: "+books.add(b2));
		System.out.println("Adding b3: "+books.add(b3));
		System.out.println("Adding b4: "+books.add(b4));
		
		for(Book b : books) {
			System.out.println(b.getBookId()+" \t"+ b.getTitle() +" \t"+b.getAuthor());
		}
	}

}
