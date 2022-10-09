package competition_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;


public class SocialDistancingII {
	public static void main(String[] args) {
		try {
			File Myfile = new File(
					"/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/usaco/SocialDistancingIITesting");
			Scanner myReader = new Scanner(Myfile);
			while (myReader.hasNextLine()) {
				int numCows = myReader.nextInt();
				HashMap <Integer, Integer> cows = new HashMap<>(); 
				ArrayList <Integer> cowPositions = new ArrayList<>(numCows);
				int cowPos, isInfected;
				for(int i = 0; i < numCows; i++) {
					cowPos = myReader.nextInt();
					isInfected = myReader.nextInt();
					cows.put(cowPos, isInfected); 
					cowPositions.add(cowPos);  
				}
				cowPositions.sort(null);
				int distance = distanceFromNonInfected(cows,cowPositions);
				System.out.println( "Distance = " + distance);

				removeNonInfected(cows,cowPositions);
				System.out.println(cowPositions);
				int result = determineInitialInfectedCows(distance, cowPositions);
				System.out.println("Result = " + result);
				
				
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public static int distanceFromNonInfected(HashMap<Integer, Integer> cows,ArrayList<Integer> cowPositions ) {
		
		int distance = 1000000; 
		for(int x : cowPositions) {
			if(cows.get(x) == 0) {
				for(int i: cowPositions) {
					
					if(i == x) {
						continue; 
					}
					if(Math.abs(x - i) < distance && cows.get(i) != 0) {
					distance = Math.abs(x - i);
					}

				}
			}
			
		}
		return distance; 
	}
	
	public static void removeNonInfected(HashMap<Integer, Integer> cows, ArrayList<Integer> cowPositions) {
		List<Integer> positionsCopy  = new ArrayList<>(cowPositions);
		for(int i: positionsCopy) {
			if(cows.get(i) == 0) {
				cowPositions.remove((Integer)i);
			}
		}
	}
	public static int determineInitialInfectedCows(int distance,ArrayList<Integer> cowPositions  ) {
		int numInfected= 1; 
		for(int i = 1; i < cowPositions.size(); i++) {
			if(Math.abs(cowPositions.get(i) - cowPositions.get(i -1)) >= distance) {
				numInfected++; 
			}
		}
		return numInfected; 
	}

}
