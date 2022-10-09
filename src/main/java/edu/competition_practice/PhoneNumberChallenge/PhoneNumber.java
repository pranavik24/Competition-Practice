package competition_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PhoneNumber {
	public static void main(String[] args) {

		try {
			File Myfile = new File(
					"/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenge3/PhoneNumber_Test");
			Scanner myReader = new Scanner(Myfile);
			while (myReader.hasNextLine()) {
				String number = myReader.next();
				TextToNum num1 = new TextToNum(number);
				num1.convertTextToNum(number);
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static class TextToNum {
		private String number;
		private HashMap<String, String> converter = new HashMap<String, String>();

		public TextToNum(String num) {
			number = num;
			converter.put("0", "0");
			converter.put("1", "1");
			converter.put("2", "2");
			converter.put("3", "3");
			converter.put("4", "4");
			converter.put("5", "5");
			converter.put("6", "6");
			converter.put("7", "7");
			converter.put("8", "8");
			converter.put("9", "9");
			converter.put("A", "2");
			converter.put("B", "2");
			converter.put("C", "2");
			converter.put("D", "3");
			converter.put("E", "3");
			converter.put("F", "3");
			converter.put("G", "4");
			converter.put("H", "4");
			converter.put("I", "4");
			converter.put("J", "5");
			converter.put("K", "5");
			converter.put("L", "5");
			converter.put("M", "6");
			converter.put("N", "6");
			converter.put("O", "6");
			converter.put("P", "7");
			converter.put("Q", "7");
			converter.put("R", "7");
			converter.put("S", "7");
			converter.put("T", "8");
			converter.put("U", "8");
			converter.put("V", "8");
			converter.put("W", "9");
			converter.put("X", "9");
			converter.put("Y", "9");
			converter.put("Z", "9");
		}

		public void convertTextToNum(String number) {
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < number.length(); i++) {
				builder.append(converter.get(number.substring(i, i + 1)));
			}

			System.out.println(builder.toString());
		}
	}

}
