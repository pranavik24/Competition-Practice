package home.projects.challenge6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AlmostPallindrome {

	public static void main(String[] args) {

		try {
			File Myfile = new File(
					"/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenge6/AlmostPallindromeTest");
			Scanner myReader = new Scanner(Myfile);
			while (myReader.hasNextLine()) {
				String string = myReader.next();
				Pallindrome myString = new Pallindrome(string);
				myString.IfAlmostPallindrome();

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static class Pallindrome {
		String palinString;
		int stringLen;

		public Pallindrome(String string) {
			palinString = string;
			stringLen = palinString.length();
		}

		public boolean IfAlmostPallindrome() {

			int numFlaggedChar = 0;
			int x = stringLen - 1;
			for (int i = 0; i < stringLen / 2; i++) {
				if (palinString.charAt(i) != palinString.charAt(x)) {
					numFlaggedChar++;
				}
				x--;

			}
			if (numFlaggedChar != 1) {
				System.out.println("false");
				return true;
			} else {
				System.out.println("true");
				return false;
			}
		}

	}

}
