package com.mahendra;

import java.io.IOException;

public class Main1 {

	public static void main(String[] args) {
		System.out.println("Hello World !");
		System.err.println("Hello Errors !");
		
		byte[] buffer=new byte[20];
		
		int len;
		try {
			System.out.println("Enter your name: ");
			len = System.in.read(buffer);
			System.out.println("Number of bytes read : "+len);
			
			String line = new String(buffer,0,len);
			// User input captures ENTER key as well, which takes 2 Bytes on Windows and 1 Byte on Unix/Linux/Mac
			System.out.println("New String: "+line+" which has "+line.length()+" characters");
			
			//Removes all WHITESPACES (Invisible characters like space or line-break (enter) )
			line = line.trim();
			System.out.println("New String: "+line+" which has "+line.length()+" characters");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
