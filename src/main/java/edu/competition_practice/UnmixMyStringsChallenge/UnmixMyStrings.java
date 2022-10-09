package competition_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnmixMyStrings {
	public static void main(String[] args) {

		try {
			File Myfile = new File(
					"/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenge5/UnmixMyStringsTest");
			Scanner myReader = new Scanner(Myfile);
			while (myReader.hasNextLine()) {
				String string = myReader.nextLine();
				MyString mystring = new MyString();
				mystring.UnMixStrings(string);

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static class MyString {

		public void UnMixStrings(String string) {
			StringBuilder builder = new StringBuilder();
			int stringLen = string.length();
			for (int i = 0; i < stringLen - 1; i += 2) {
				builder.append(string.charAt(i + 1));
				builder.append(string.charAt(i));

				if (i == stringLen - 3) {
					if (string.length() % 2 != 0) {
						builder.append(string.charAt(string.length() - 1));

					}
				}
			}

			System.out.println(builder.toString());
		}
	}
}
