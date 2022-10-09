package competition_practice;

import java.util.*;

public class Acowdemia3 {

	static int numFriends = 0; 
	static 	HashMap<Integer, ArrayList<Integer>> cowList = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numRows = sc.nextInt();
		int numColumns = sc.nextInt();
		char[][] pasture = new char[numRows][numColumns];
		HashMap<Integer, ArrayList<Integer>> cowList = new HashMap<>();
		
		
		
		//populating array
		String temp; 
		char space; 
		for (int i = 0; i < numRows; i++) {
			temp = sc.next();
			for(int j = 0; j < numColumns; j++) {
				space = temp.charAt(j);
				pasture[i][j] = space;
				if(space == 'C') {
					cowList.put(i*10+j,new ArrayList<Integer>() );
				}
			}
		}
		
		//checking horizontal and vertical cows
		for (int i = 0; i < numRows; i++) {
			for(int j = 0; j < numColumns; j++) {
				if(pasture[i][j] =='C') {
					if(i + 2 >= 0 && i +2 < numRows) {
						if(pasture[i+2][j] == 'C') {
							if(pasture[i+1][j] == 'G') {
								System.out.println("1");
								if(!(cowList.get(i*10+j).contains((i+2)*10 + j))){
									cowList.get(i*10+j).add((i+2)*10 + j);
									becomeFriends(pasture, i+1, j);
								}
							
							}
						}
					}
					if(j + 2 >= 0 && j +2 < numColumns) {
						if(pasture[i][j+2] == 'C') {
							if(pasture[i][j+1] == 'G') {
								System.out.println("2");
								if(!(cowList.get(i*10+j).contains((i)*10 + j+2))){
									cowList.get(i*10+j).add((i)*10 + j+2);
									becomeFriends(pasture, i, j+1);
								}
							}
						}
					}
					if(i - 2 >= 0 && i -2 < numRows) {
						if(pasture[i-2][j] == 'C') {
							if(pasture[i-1][j] == 'G') {
								System.out.println("3");
								if(!(cowList.get(i*10+j).contains((i-2)*10 + j))){
									cowList.get(i*10+j).add((i-2)*10 + j);
									becomeFriends(pasture,i-1,j);
								}
							}
						}
					}
					if(j - 2 >= 0 && j -2 < numColumns) {
						if(pasture[i][j-2] == 'C') {
							if(pasture[i][j-1] == 'G') {
								System.out.println("4");
								if(!(cowList.get(i*10+j).contains((i)*10 + j-2))){
									cowList.get(i*10+j).add((i)*10 + j-2);
									becomeFriends(pasture,i,j-1);
								}
							}						
						}
					}
					if(i - 1 >= 0 && j -1 >= 0) {
						if(pasture[i-1][j-1] == 'C')
							if(pasture[i-1][j] == 'G') {
								System.out.println("5a");
								if(!(cowList.get(i*10+j).contains((i-1)*10 + j-1))){
								cowList.get(i*10+j).add((i-1)*10 + j-1);
								becomeFriends(pasture,i-1,j);
								}
							}
							else if(pasture[i][j-1] == 'G') {
								System.out.println("5b");
								if(!(cowList.get(i*10+j).contains((i-1)*10 + j-1))){
								cowList.get(i*10+j).add((i-1)*10 + j-1);
								becomeFriends(pasture,i,j-1);
								}
							}
					}
					if(i - 1 >= 0 && j + 1 < numColumns) {
						if(pasture[i-1][j+1] == 'C')
							if(pasture[i-1][j] == 'G') {
								System.out.println("6a");
								if(!(cowList.get(i*10+j).contains((i-1)*10 + j+1))){
									cowList.get(i*10+j).add((i-1)*10 + j+1);
									becomeFriends(pasture,i-1,j);
								}
							}
							else if(pasture[i][j+1] == 'G') {
								System.out.println("6b");
								if(!(cowList.get(i*10+j).contains((i-1)*10 + j+1))){
									cowList.get(i*10+j).add((i-1)*10 + j+1);
									becomeFriends(pasture,i,j+1);
								}
							}
					}
					if(i + 1 < numRows && j + 1 < numColumns) {
						if(pasture[i+1][j+1] == 'C') {
							if(pasture[i+1][j] == 'G') {
								System.out.println("7a");
								if(!(cowList.get(i*10+j).contains((i+1)*10 + j+1))){
									cowList.get(i*10+j).add((i+1)*10 + j+1);
									becomeFriends(pasture,i+1,j);
								}
							}
							else if(pasture[i][j+1] == 'G') {
								System.out.println("7b");
								if(!(cowList.get(i*10+j).contains((i+1)*10 + j+1))){
									cowList.get(i*10+j).add((i+1)*10 + j+1);
									becomeFriends(pasture,i,j+1);
								}
							}
						}
					}
					if(i + 1 < numRows && j -1 >= 0) {
						if(pasture[i+1][j-1] == 'C') {
							if(pasture[i+1][j] == 'G') {
								System.out.println("7a");
								if(!(cowList.get(i*10+j).contains((i+1)*10 + j-1))){
									System.out.println(cowList.get((i+1)*10 + j-1));
									System.out.println((i+1)*10 + j-1);

									cowList.get(i*10+j).add((i+1)*10 + j-1);
									becomeFriends(pasture,i+1,j);
								}
							}
							else if(pasture[i][j-1] == 'G') {
								System.out.println("7b");
								if(!(cowList.get(i*10+j).contains((i+1)*10 + j-1))){
									cowList.get(i*10+j).add((i+1)*10 + j-1);
									becomeFriends(pasture,i,j-1);
								}
							}
						}
					}
						
				}
			}
		}
		

		//printing array
		for (int i = 0; i < numRows; i++) {
			for(int j = 0; j < numColumns; j++) {

				System.out.print(pasture[i][j]);

			}
			System.out.println();
			
		}
		
		System.out.println("\nAnswer = " + numFriends);
		
	}
	
	public static void becomeFriends(char[][] pasture, int grassPosRow, int grassPosCol) {
		//System.out.println("Friends!");

		pasture[grassPosRow][grassPosCol] = '.';
		numFriends++; 
	}
	
}
