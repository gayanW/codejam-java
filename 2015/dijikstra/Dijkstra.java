package com.reversiblean.dijkstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class DijkstraNew {

	static Scanner in;
	static PrintWriter out;
	static String fileName = "C-large";

	public static void main(String[] args) {
		setupInOut(fileName);

		int T = in.nextInt();

		// iterate over the test cases
		for (int t = 1; t <= T; t++) {
			long L = in.nextLong();
			long X = in.nextLong();
			String s = in.next();

			StringBuilder strBuilder = new StringBuilder();

			// repeat the given string X times
			for (int x = 0; x < X; x++) {
				strBuilder.append(s);
			}
			
			String str = strBuilder.toString();

			boolean foundI = false, foundJ = false, foundK = false;
			long strSize = L * X;

			// search for 'i'
			String resultQuartenion = Character.toString(str.charAt(0));
			int i = 0;
			for (i = 1; i < strSize; i++) {

				// if 'i' found
				if (resultQuartenion.equals("i")) {
					break;
				}

				String currentQuartenion = Character.toString(str.charAt(i));
				resultQuartenion = multipleQuartenion(resultQuartenion, currentQuartenion);
			}
			if (resultQuartenion.equals("i")) {
				str = str.substring(i);
				foundI = true;
			}

			if (foundI && !str.isEmpty()) {
				// also search for 'j' in the remaining substring
				resultQuartenion = Character.toString(str.charAt(0));
				i = 0;
				for (i = 1; i < str.length(); i++) {
					// if 'j' found
					if (resultQuartenion.equals("j")) {
						break;
					}

					String currentQuartenion = Character.toString(str.charAt(i));
					resultQuartenion = multipleQuartenion(resultQuartenion, currentQuartenion);
				}
				if (resultQuartenion.equals("j")) {
					str = str.substring(i);
					foundJ = true;
				}
			}

			
			if (foundJ && !str.isEmpty()) {
				// search for 'k' in the remaining substring
				resultQuartenion = Character.toString(str.charAt(0));
				i = 0;
				for (i = 1; i < str.length(); i++) {

					String currentQuartenion = Character.toString(str.charAt(i));
					resultQuartenion = multipleQuartenion(resultQuartenion, currentQuartenion);
				}
				if (resultQuartenion.equals("k")) {
					foundK = true;
				}

			}
			
			if (foundI && foundJ && foundK) {
				out.println("Case #" + t + ": YES");
			}
			else {
				out.println("Case #" + t + ": NO");
			}
		}
		
		closeInOut();
	}


	/**
	 * 
	 * @param firstQuartenion Result Quartenion, which can be 1, -1, i, j, k, -i, -j, -k
	 * @param secondQuartenion Can be i, j, k only.
	 * @return
	 */
	public static String multipleQuartenion(String firstQuartenion, String secondQuartenion) {

		if (firstQuartenion.equals(secondQuartenion))
			return "-1";
		else if (firstQuartenion.equals("-" + secondQuartenion)) {
			return "1";
		}
		else if (firstQuartenion.equals("1"))
			return secondQuartenion;
		else if (firstQuartenion.equals("-1")) {
			return "-" + secondQuartenion;
		}
		else if (firstQuartenion.equals("i")) {
			if (secondQuartenion.equals("j"))
				return "k";
			else //if (secondQuartenion == "k")
				return "-j";
		}
		else if (firstQuartenion.equals("-i")) {
			if (secondQuartenion.equals("j"))
				return "-k";
			else //if (secondQuartenion == "k")
				return "j";
		}
		else if (firstQuartenion.equals("j")) {
			if (secondQuartenion.equals("i"))
				return "-k";
			else //if (secondQuartenion == "k")
				return "i";
		}
		else if (firstQuartenion.equals("-j")) { 
			if (secondQuartenion.equals("i"))
				return "k";
			else // if secondQuartenion == "k"
				return "-i";
		}
		else if (firstQuartenion.equals("k")) {
			if (secondQuartenion.equals("i"))
				return "j";
			else
				return "-i";
		}
		else { // firstQuartenion == "-k"
			if (secondQuartenion.equals("i"))
				return "-j";
			else
				return "i";
			
		}
	}
	
	public static void setupInOut(String fileName) {
		try {
			in = new Scanner(new File(fileName + ".in"));
			out = new PrintWriter(new File(fileName + ".out"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeInOut() {
		in.close();
		out.close();
	}

}