package com.mahendra;

public class Main1 {

	public static void main(String[] args) {
		Book b1 = new Book(101,"Let Us C++","Yashwant Kanetkar");
		Book b2 = new Book(102,"Let Us C", "Yashwant Kanetkar");
		Book b3 = b2; //Both b3 and b2 refers to same objects!
		Book b4 = new Book(101,"Let Us C++","Yashwant Kanetkar");
		
		System.out.println("b1 and b4 are SAME object [Using ==]? "+ (b1==b4));
		System.out.println("b1 and b4 are IDENTICAL object [Using equals ]? "+ (b1.equals(b4)));
		
		System.out.println("b2 and b3 are SAME object [Using ==]? "+ (b2==b3));
		System.out.println("b2 and b3 are IDENTICAL object [Using equals ]? "+ (b2.equals(b3)));
	}

}
