package competition_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SecretCode {
	static ArrayList<Integer> ListNums = new ArrayList<Integer>();

	public static void main(String[] args) {
		try {
			File Myfile = new File(
					"/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenges9/PrimeNumberTesting");
			Scanner myReader = new Scanner(Myfile);
			while (myReader.hasNextLine()) {
				int numTestCases = myReader.nextInt();
				for (int i = 1; i <= numTestCases; i++) {
					int N = myReader.nextInt();
					System.out.println("N = " + N);

					int L = myReader.nextInt();
					System.out.println("L = " + L);
					CrackTheCode myCode = new CrackTheCode();
					myCode.FillHashmap(N);
					for (int x = 0; x < L; x++) {
						int num = myReader.nextInt();
						ListNums.add(num);
					}
					myCode.SeparateNums(L, i);

				}

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static class CrackTheCode {
		private HashMap<Character, Integer> ListPrimeNums2 = new HashMap<Character, Integer>();
		private HashMap<Integer, Character> ListPrimeNums = new HashMap<Integer, Character>();

		private String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		public void FillHashmap(int N) {

			int charCount = 25;
			boolean IsPrime = true;
			;

			if (N % 2 == 0) {
				while (N % 2 == 0) {
					N--;
				}
			}
			for (int i = N; i >= 2; i -= 2) {
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						IsPrime = false;
						break;
					}
				}
				if (IsPrime) {
					ListPrimeNums2.put(alpha.charAt(charCount), i);
					System.out.println(alpha.charAt(charCount));
					System.out.println(i);

					ListPrimeNums.put(i, alpha.charAt(charCount));

					charCount--;

				}
				IsPrime = true;
				if (charCount < 0) {
					break;
				}
			}

		}

		public void SeparateNums(int L, int c) {
			StringBuilder builder = new StringBuilder();
			int prevNum = -1;
			boolean leave = false;
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {

					if (ListNums.get(0) % ListPrimeNums2.get(alpha.charAt(i)) == 0) {
						System.out.println("found");
						builder.append(alpha.charAt(i));
						System.out.println(ListNums.get(0));
						System.out.println(ListPrimeNums2.get(alpha.charAt(i)));
						prevNum = ListNums.get(0) / ListPrimeNums2.get(alpha.charAt(i));
						builder.append(ListPrimeNums.get(prevNum));
						leave = true;
						break;
					}
				}
				if (leave) {
					break;
				}

			}

			int temp;
			for (int i = 1; i < L; i++) {

				System.out.println("list nums: " + ListNums.get(i));
				System.out.println("prev num" + prevNum);
				temp = ListNums.get(i) / prevNum;
				builder.append(ListPrimeNums.get(temp));
				prevNum = temp;

			}
			System.out.println("Case #" + c + ": " + builder);
			ListNums.clear();
			ListPrimeNums2.clear();
			ListPrimeNums.clear();
		}
	}
}
