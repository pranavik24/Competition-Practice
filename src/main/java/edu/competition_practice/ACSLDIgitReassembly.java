package competition_practice;
import java.util.*; 

public class ACSLDIgitReassembly {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		int nDigit = sc.nextInt(); 
		System.out.println("num = " + num);
		System.out.println("N = " + nDigit);

		
		int sum = 0; 
		int endIndex; 
		for(int startIndex = 0; startIndex < num.length(); startIndex+=nDigit) {
			endIndex = startIndex + nDigit; 
			if(endIndex > num.length()) {
				int lastNum = Integer.parseInt(num.substring(startIndex)); 
				lastNum *= Math.pow(10, endIndex - num.length() ); 
				sum += lastNum; 
				System.out.println(lastNum);
				
			}
			else {
			int number  =Integer.parseInt(num.substring(startIndex, endIndex));
			System.out.println(number);
			sum+= number;
			
			}
			
		}
		System.out.println(sum);
		
	}

}
