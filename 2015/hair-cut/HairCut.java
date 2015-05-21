package com.reversiblean.haircut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HairCut {

	private static Scanner in;
	private static PrintWriter out;
	private static String fileName = "B-small-attempt0";
	
	public static void main(String[] args) {
		setupInOut(fileName);
		
		int T = in.nextInt();
		
		// test cases
		for (int t = 1; t <= T; t++) {
			
			int numOfBarbers = in.nextInt();
			long placeInLine = in.nextLong();
			int[][] BT = new int[numOfBarbers][1];
			int ans = -1;
			
			for (int j = 0; j < numOfBarbers; j++) {
				BT[j][0] = in.nextInt();
			}
			
			// Iterate over time
			boolean barberAvailable = false ;
			for (int time = 0; !barberAvailable; time+=1 ) {

				// check availability
				for (int b = 0; b < numOfBarbers; b++) {
					if ((time % BT[b][0] == 0 && time >= BT[b][0]) || time == 0) {
						// barber 'b' is available or working
						if (placeInLine == 1) {
							barberAvailable = true;
							ans = b + 1;
							break;
						}

						placeInLine--;
					}
				}
			}
			
			out.println("Case #" + t + ": " + ans);
			
		}
		
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
