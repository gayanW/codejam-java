package com.reversiblean.standingovation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StandingOvation {
	
	static Scanner in;
	static PrintWriter out;
	static String fileName = "A-large";
	
	public static void main(String[] args) throws IOException {
		setupInOut(fileName);

		// Number of test cases
		int T = in.nextInt();

		// Iterate over test cases
		for (int t = 1; t <= T; t++) {
			int maxShyness = in.nextInt();
			String countFromShyLvl = in.next();
			int numOfFriends = 0;

			// Initial stand up count
			int standUpCount = countFromShyLvl.charAt(0) - '0';

			// iterate over the each shyness level
			for (int i = 1; i <= maxShyness; i++) {
				int shynessLevel = i;

				// if the audience with shynessLevel of 'i' can't stand up
				if (shynessLevel > standUpCount) {
					// increase stand up count by adding friends
					// to match stand up count to the current shyness level
					numOfFriends += shynessLevel - standUpCount;
					standUpCount = shynessLevel;
				}

				// now the stand up count is greater than or equal to the shyness level of 'i'
				// so the audience with current shyness level could also stand up.
				int audienceWithShynessI = countFromShyLvl.charAt(i) - '0';
				standUpCount += audienceWithShynessI;

			}

			out.println("Case #" + t + ": " + numOfFriends);
		}
		
		in.close();
		out.close();
	}
	
	public static void setupInOut(String fileName) throws FileNotFoundException {
		try {
			in = new Scanner(new File(fileName + ".in"));
			out = new PrintWriter(new File(fileName + ".out"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
