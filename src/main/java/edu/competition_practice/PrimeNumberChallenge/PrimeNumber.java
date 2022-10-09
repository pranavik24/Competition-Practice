package competition_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		try {
			File Myfile = new File(
					"/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenges9/PrimeNumberTesting");
			Scanner myReader = new Scanner(Myfile);
			while (myReader.hasNextLine()) {
				int number = myReader.nextInt();
				PrimeNumbers myNumber = new PrimeNumbers();
				System.out.println(myNumber.numPrimes(number));

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static class PrimeNumbers {

		public int numPrimes(int number) {
			int numPrime;
			boolean IsPrime = true; 


			if(number < 2) {
				numPrime = 0; 
			}
			else {
				numPrime = 1;
				for(int i = 3; i < number; i+=2) {
					for(int j = 2; j <= Math.sqrt(i); j++) {
						if(i%j==0) {
							IsPrime = false; 
							break;
						}
					}
					if(IsPrime) {
						numPrime++; 
						
					}
					IsPrime = true; 
}
			}
			return numPrime; 
		}
	}

}
