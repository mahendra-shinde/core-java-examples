package com.mahendra.library.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.mahendra.library.dao.DataStore;
import com.mahendra.library.models.Book;
import com.mahendra.library.models.BookIssue;
import com.mahendra.library.models.Member;

public class DataWriter {
	private static String FILENAME = "data.sv";
	private DataStore store = DataStore.getInstance();
	
	public void loadData() {
		Map<Integer,Book> books = null;
		Map<Integer,Member> members = null;
		Map<Integer,BookIssue> issues = null;
		
		File file = new File(FILENAME);
		if(file.exists()) {
			System.out.println("File path: "+file.getAbsolutePath());
			try(ObjectInputStream obj = new ObjectInputStream(new FileInputStream(file))) {
				Object data1 = obj.readObject();
				if(data1 instanceof Map) {
					books = (Map)data1;
				}
				Object data2 = obj.readObject();
				if(data2 instanceof Map) {
					members = (Map)data2;
				}
				Object data3 = obj.readObject();
				if(data1 instanceof Map) {
					issues = (Map)data3;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			store.setBooks(books);
			store.setMembers(members);
			store.setIssues(issues);
		}
		
		
	}
	
	public void writeData() {
		File file = new File(FILENAME);
		if(file.exists()) {
			file.delete();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
			out.writeObject(store.getBooks());
			out.flush();
			out.writeObject(store.getMembers());
			out.flush();
			out.writeObject(store.getIssues());
			out.flush();
		}catch(IOException ex) {
			System.out.println("Cannot write changes to file "+ex.getMessage());
		}
	}
}
