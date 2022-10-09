package competition_practice;

import java.util.*;

public class CowFrisbee {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numCows = sc.nextInt();

		int[] heights = new int[numCows];

		for (int i = 0; i < numCows; i++) {

			heights[i] = sc.nextInt();

		}

		int innerMax = 0;

		int totalDistance = 0;

		int currIndexHeights = 0;
		for (int startingIndex = 0; startingIndex < numCows - 1; startingIndex++) {
			int startingVal = heights[startingIndex];

			for (int currIndex = startingIndex + 1; currIndex < numCows; currIndex++) {
				currIndexHeights = heights[currIndex];
				if (currIndex == (startingIndex + 1)) {
					innerMax = currIndexHeights;
					totalDistance += currIndex - startingIndex + 1;
					if (innerMax >= startingVal) {
						break;
					}
				} else if (innerMax < currIndexHeights) {
					innerMax = currIndexHeights;
					if (innerMax >= startingVal) {
						totalDistance += currIndex - startingIndex + 1;
						break;
					} else {
						totalDistance += currIndex - startingIndex + 1;
					}
				}
			}

		}
		System.out.println(totalDistance);

	}

}
