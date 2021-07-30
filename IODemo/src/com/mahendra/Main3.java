package com.mahendra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main3 {
	static Scanner sc = new Scanner(System.in);
	static BookData data = new BookData();

	public static void main(String[] args) {
		
		//Infinite loop
		while(true) {
			
		System.out.println("+------------ Menu ---------------+");
		System.out.println("| List all Books       [ L ]      |");
		System.out.println("| Add new book         [ A ]      |");
		System.out.println("| Save to file         [ F ]      |");
		System.out.println("| Load from file       [ O ]      |");
		System.out.println("| Quit                 [ Q ]      | ");
		System.out.println("+---------------------------------+");
		
		String choice = sc.nextLine();
		
		switch(choice.toUpperCase()) {
		case "L":
			listAll();
			break;
		case "A":
			addBook();
			break;
		case "F":
			writeToFile();
			break;
		case "O":
			readFromFile();
			break;
		case "Q":
			//Quit the method
			return;
		}
		
		}

	}

	private static void readFromFile() {
		FileReader reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("data.csv");
			br = new BufferedReader(reader);
			String line = br.readLine();
			while(line!=null) {
				String[] fields = line.split(",");
				int id = Integer.parseInt(fields[0]);
				String title = fields[1].trim();
				String author = fields[2].trim();
				
				data.add(id, title, author);
				line = br.readLine();
			}
			
		}catch(IOException ex) {
			System.out.println("Unable to read data file! ");
			System.out.println(ex.getMessage());
		}finally {
			
			try {
				reader.close();
			}catch(IOException ex) {
				System.out.println("Unable to close the file!");
			}
		}
	}

	private static void writeToFile() {
		FileWriter writer = null;
		BufferedWriter bw = null;
		try {
			writer = new FileWriter("data.csv");
			bw = new BufferedWriter(writer);
			Book[] books = data.getAll();
			for(Book b : books) {
				bw.write(b.getBookId()+", "+b.getTitle()+", "+b.getAuthor());
				bw.newLine();
			}
			bw.flush(); // Ensures that data is written to the file
		}catch(IOException ex) {
			System.out.println("Unable to write changes to file !");
			System.out.println(ex.getMessage());
		}finally {
			try {
				// No matter whether app crashes with exception or run normally
				// All file streams MUST BE closed either ways!
				writer.close();
				bw.close();
			}catch(IOException ex) {
				System.out.println("Unable to close the file!");
			}
		}
	}

	private static void addBook() {
		System.out.println("Enter book id: ");
		int bookId = Integer.parseInt(sc.nextLine());
		System.out.println("Enter title: ");
		String title = sc.nextLine();
		System.out.println("Enter author: ");
		String author = sc.nextLine();
		data.add(bookId, title, author);
		System.out.println("Record saved !");
	}

	private static void listAll() {
		Book[] books = data.getAll();
		System.out.println("Books found : "+ books.length);
		for(Book b : books) {
			System.out.println(b);
		}
	}

}
