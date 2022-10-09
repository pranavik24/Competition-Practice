package competition_practice;
import java.util.Scanner; 

public class MissingLetter {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String string; 
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		char missingLetter = '0';
		System.out.println("Enter string");
		string = s.next();
		int firstLetterIndex = alpha.indexOf(string.charAt(0)); 
		
		if(string.equals(alpha.substring(firstLetterIndex,firstLetterIndex + string.length()))) {
			System.out.println("No Missing Letters");
		}
		else {
			for(int i = 0; i < string.length(); i++) {
				if(string.charAt(i) != alpha.charAt(firstLetterIndex)) {
					missingLetter = alpha.charAt(firstLetterIndex); 
					break; 
				}
				firstLetterIndex++;

			}
			System.out.println(missingLetter);
		}
	}

}
