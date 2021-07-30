package com.mahendra;

import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {

	@Override
	public int compare(Book book1, Book book2) {
		// Need GETTER method to access properties
		System.out.println("LOG : Comparing "+book1.getTitle()+" with "+book2.getTitle());
		return book1.getTitle().compareTo(book2.getTitle());
	}

}
