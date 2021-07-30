package com.mahendra;


public class Book implements Comparable<Book>{
	private Integer bookId;
	private String title;
	private String author;
	
	
	
	public Book(Integer bookId, String title, String author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
	}

	@Override
	public int hashCode() {
		// Not a correct but simplified method
		System.out.println("LOG  : HashCode is invoked");
		return bookId;
	}
	
	@Override
	public boolean equals(Object ob) {
		System.out.println("LOG  : EQUALS method invoked !");
		if (ob == null)
			return false;
		else if (ob instanceof Book) {
			Book target = (Book)ob;
			if(this.bookId == target.bookId
					&& this.title.equals(target.title)
					&& this.author.equals(target.author)) {
				return true;
		}
		}
		return false;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
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

	@Override
	public int compareTo(Book other) {
		//Lets compare the BookID
		// if same RETURN zero
		// if this.bookId > other.bookId = Positive
		// if this.bookId < other.bookId = Negative
		int result = this.bookId - other.bookId;
		System.out.println("LOG : comparison between "+this.bookId+" and "+other.bookId+" resulted in "+result);
		return result;
	}
	
}
