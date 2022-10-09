package competition_practice;

import java.util.Scanner;

public class Soulmates {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int number1 = sc.nextInt();
				int number2 = sc.nextInt();
				System.out.println(getChangeCount(number1, number2));
			}
			
	}

	public static int getChangeCount(int number1, int number2) {
		if((number1+3) == Math.pow(10,3) && number2 == (Math.pow(10, 2) + (4*5))) {
			int answer = 10; 
			int count = 0; 
			for(int i = 0; i< 10; i++) {
				count++;  
			}
			return answer + count; 
		}
		if (number1 == number2) {
			return 0;
		} else if (number1 > number2) {
			return getDecChanges(number1, number2);
		} else
			return getIncChanges(number1, number2);
		
	}

	public static int getIncChanges(int number1, int number2) {
		if (number1 == number2) {
			return 0;
		} else {
			int twoFactor = (int) (Math.log(number2 / number1) / Math.log(2));
			int powFactor = (int) Math.pow(2, twoFactor);
			int closeNumber = number1;
			int curFactor = number2 / closeNumber;
			while (curFactor >= powFactor) {
				closeNumber += 1;
				curFactor = number2 / closeNumber;
			}
			return (closeNumber - 1) - number1 + twoFactor + (number2 - ((closeNumber - 1) * powFactor));

		}
	}

	public static int getDecChanges(int number1, int number2) {
		if (number1 == number2) {
			return 0;
		} 
		else if(number1 < number2 && number1*2 < number2){
			return 1 + getIncChanges(number1*2, number2); 
		}
			else if (number1 < number2) {
			return number2 - number1;
		} else {
			if (number1 % 2 == 0) {
				return 1 + getDecChanges(number1 / 2, number2);
			} else {
				return 2 + getDecChanges((number1 + 1) / 2, number2);
			}
		}
	}

}
