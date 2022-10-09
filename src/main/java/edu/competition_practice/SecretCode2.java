package competition_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SecretCode2 {
	static int N;
	static int L;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static ArrayList<Integer> arrSorted = new ArrayList<Integer>();

	public static void main(String[] args) {

		try {
			File Myfile = new File(
					"/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenges9/PrimeNumberTesting");
			Scanner myReader = new Scanner(Myfile);
			while (myReader.hasNextLine()) {
				int numTestCases = myReader.nextInt();
				for (int i = 1; i <= numTestCases; i++) {
					N = myReader.nextInt();
					L = myReader.nextInt();

					ArrayList<Integer> sample = new ArrayList<Integer>();
					int num;
					for (int j = 0; j < L; j++) {
						num = myReader.nextInt();
						sample.add(num);
					}

					int temp = sample.get(0);
					int origTemp = temp;
					int arrNum = findPrimeFactor(temp);
					int origArrNum = arrNum;
					arr.add(arrNum);
					arrNum = temp / arrNum;
					arr.add(arrNum);

					for (int j = 1; j < L; j++) {
						temp = sample.get(j);
						if (temp % arrNum != 0) {
							// System.out.println("fixing. orig arrNum = " + arrNum + "Temp = " + temp);
							RedoArray(origArrNum, origTemp, sample);
							break;
							// System.out.println("new arrNum = " + arrNum + "\n");
						}
						arr.add(temp / arrNum);
						arrNum = temp / arrNum;

					}

					arrSorted.addAll(arr);
					Collections.sort(arrSorted);
					Set<Integer> sortedSet = new HashSet<Integer>(arr);
					ArrayList<Integer> tempArr = new ArrayList<Integer>(sortedSet);
					tempArr.sort(null);
					arrSorted = tempArr;

					CrackTheCode();
					arr.clear();
				}

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public static int findPrimeFactor(int num) {
		if (num % 2 == 0) {
			return 2;
		}
		for (int i = 3; i < N; i += 2) {
			if (num % i == 0) {
				return i;
			}
		}

		return 0;
	}

	public static void RedoArray(int origArrNum, int origTemp, ArrayList<Integer> sample) {
		int temp = origTemp;
		int arrNum = origTemp / origArrNum;

		arr.clear();
		arr.add(arrNum);
		arr.add(temp / arrNum);
		arrNum = temp / arrNum;

		for (int j = 1; j < L; j++) {
			temp = sample.get(j);
			arr.add(temp / arrNum);
			arrNum = temp / arrNum;

		}

	}

	public static void CrackTheCode() {
		StringBuilder builder = new StringBuilder();
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char letter;
		for (int i = 0; i < L + 1; i++) {
			letter = alpha.charAt(arrSorted.indexOf(arr.get(i)));
			builder.append(letter);
		}

		System.out.println(builder.toString());

	}

}
