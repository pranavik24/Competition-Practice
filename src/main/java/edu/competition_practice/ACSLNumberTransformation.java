package competition_practice;
import java.util.*; 

public class ACSLNumberTransformation {
	
	public static String changeLeftSide(String leftSide, int pthDigit) {
		StringBuilder newLeftSide = new StringBuilder(); 
		int digitValue; 
		for(int i = 0; i < leftSide.length(); i++) {
			digitValue = Integer.parseInt(String.valueOf(leftSide.charAt(i))); 
			digitValue += pthDigit; 
			newLeftSide.append(digitValue); 
		}

		return newLeftSide.toString(); 
	}
	
	public static String changeRightSide(String rightSide, int pthDigit) {
		StringBuilder newRightSide = new StringBuilder(); 
		int digitValue, newDigitValue; 
		for(int i = 0; i < rightSide.length(); i++) {
			digitValue = Integer.parseInt(String.valueOf(rightSide.charAt(i))); 
			newDigitValue = Math.abs(digitValue- pthDigit); 
			newRightSide.append(newDigitValue); 
		}
		
		return newRightSide.toString(); 
	}
	
	
	
	public static String transformNumber(long number, String numberStr, int indexOfP) {
		int pthDigit = Integer.parseInt(numberStr.substring(indexOfP, indexOfP+1)); 
		String leftSide = changeLeftSide(numberStr.substring(0, indexOfP), pthDigit); 
		String rightSide = changeRightSide(numberStr.substring(indexOfP+1, numberStr.length()), pthDigit); 
		String pString = Integer.toString(numPrimeFactors(number)); 
		return leftSide+pString+rightSide; 
	}
	
	public static int numPrimeFactors(long n) {

		Set<Long> primefactors = new HashSet<Long>(); 
		
		if(n%2==0) {
			primefactors.add(n);
			 while (n%2==0)
		        {
		            n /= 2;
		        	
		        }
			
		}

        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
        	if(n%i == 0) {
        		primefactors.add(n);
	            while (n%i == 0)
	            {
	                n /= i;
	            }
        	}
        	if(n == 1) {
        		break; 
        	}
        }
 
        if (n > 2) {
        	primefactors.add(n);
        }  
        return primefactors.size(); 
	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long number = sc.nextLong(); 
		int p = sc.nextInt(); 
		sc.close();
		
		String numberStr = Long.toString(number); 
		int indexOfP = numberStr.length() - p; 
		System.out.println(transformNumber(number, numberStr, indexOfP));

	}

}
