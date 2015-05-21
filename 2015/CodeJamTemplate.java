package com.reversiblean.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CodeJamTemplate {

	private static Scanner in;
	private static PrintWriter out;
	private static String fileName = "A-small-attempt2";
	
	public static void main(String[] args) {
		setupInOut(fileName);
		
		
		
		closeInOut();

	}
	
	private static void setupInOut(String fileName) {
		try {
			in = new Scanner(new File(fileName + ".in"));
			out = new PrintWriter(new File(fileName + ".out"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void closeInOut() {
		in.close();
		out.close();
	}

}
