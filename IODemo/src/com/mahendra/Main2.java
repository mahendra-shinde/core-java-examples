package com.mahendra;

import java.io.*;

public class Main2 {

	public static void main(String[] args) {
		
		try {
			// System.in is BYTE STREAM : takes BYTES inputs
			// InputStreamReader is CHARACTER STREAM : converts EACH BYTE into CHARACTER 
			// BufferedReader is providing BUFFERRING by converting CHARS into STRINGs
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter your name: ");
			String line = br.readLine();
			
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
