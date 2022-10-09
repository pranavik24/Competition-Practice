package competition_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {

	public static void main(String[] args) {

		List<Integer> factorization = new ArrayList<>(); 
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt(); 
		int n = number; 
		int numberIterations = 0; 
		for(int i = 2; i < Math.sqrt(n); i++) {
			numberIterations++; 
			System.out.println("Num Iter = " + numberIterations);
			while(n% i == 0) {
				n/=i; 
				factorization.add(i); 
			}
		}
		
		factorization.add(n); 
		
		System.out.println(factorization);
	}
	
	public boolean isPrime(int number) {
		if(number % 2 == 0) {
			return false; 
		}
		for(int i = 3; i < Math.sqrt(number); i+=2) {
			if(number % i == 0) {
				return false; 
			}
		}
		return true; 
	}

}
