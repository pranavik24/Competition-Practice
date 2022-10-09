package competition_practice;

import java.util.Scanner;

public class VowelDash {

	public static void main(String[] args) {

		String string;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter string: ");
		string = s.nextLine();
		StringBuilder builder = new StringBuilder("");
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'a' || string.charAt(i) == 'e' || string.charAt(i) == 'i' || string.charAt(i) == 'o'
					|| string.charAt(i) == 'u') {
				builder.append("-");
				builder.append(string.charAt(i));
				builder.append("-");
			} 
			else if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O'
					|| string.charAt(i) == 'A') {
				builder.append("-");
				builder.append(string.charAt(i));
				builder.append("-");
			}else {
				builder.append(string.charAt(i));
			}

		}
		
		System.out.println(builder.toString());


	}

}
