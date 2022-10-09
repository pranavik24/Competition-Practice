package competition_practice;

import java.util.*;

public class DaisyChains {

	public static int getNumAvgFlower(ArrayList<Integer> list, int N) {
		int total = 0;
		int P;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				P = getP(list, i, j);
				if (P > 0) {
					if (photoHasAvgFlower(list, i, j, P)) {
						total++;
					}
				}
			}
		}
		return total;
	}

	public static int getP(ArrayList<Integer> list, int i, int j) {

		int sum = 0, numFlowers;
		numFlowers = j - i + 1;
		for (int x = i; x <= j; x++) {
			sum += list.get(x);
		}
		if (sum % numFlowers == 0) {
			return sum / numFlowers;
		} else {
			return -1;
		}
	}

	public static boolean photoHasAvgFlower(ArrayList<Integer> list, int i, int j, int P) {
		for (int x = i; x <= j; x++) {
			if (list.get(x) == P) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		int input;
		for (int i = 0; i < N; i++) {
			input = sc.nextInt();
			list.add(input);
		}
		sc.close();
		int totalAvg = N;
		totalAvg += getNumAvgFlower(list, N);
		System.out.println(totalAvg);

	}

}
