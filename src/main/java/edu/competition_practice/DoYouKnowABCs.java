package competition_practice;

import java.util.*;

public class DoYouKnowABCs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numList = new ArrayList<>(7);
		String input;
		for (int i = 0; i < 7; i++) {
			input = sc.next();
			numList.add(Integer.parseInt(input));
		}
		sc.close();
		numList.sort(null);
		int A, B, C;
		A = numList.get(0);
		B = numList.get(1);
		C = numList.get(6) - A - B;
		System.out.println(A + " " + B + " " + C);
	}
}
