package competition_practice;
import java.util.*;

public class NotShading {
	
	static int numRows;
	static int numCol; 

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		int numTests = sc.nextInt(); 
		for(int i = 0; i < numTests; i++) {
			 numRows = sc.nextInt(); 
			 numCol = sc.nextInt(); 
			char[][] graph = new char[numRows][numCol]; 
			int rowVal = sc.nextInt() - 1;
			int colVal = sc.nextInt() - 1; 
			
			boolean containsBlack = false; 
			for(int j = 0; j < numRows; j++) {
				String input = sc.next(); 
				if(input.contains("B")) {
					containsBlack = true; 
				}
				graph[j] = input.toCharArray(); 
				
			}
			int answer = getNumOperations(graph, rowVal, colVal, containsBlack); 
			System.out.println(answer);
			
			
		}
		
		
		
	}
	
	public static int getNumOperations(char[][] graph, int rVal, int cVal, boolean containsBlack) {
		if(graph[rVal][cVal] == 'B') {
			return 0; 
		}
		if(rowOrColContainsBlack(graph, rVal, cVal)) {
			return 1; 
		}
		if(containsBlack) {
			return 2; 
		}
		return -1; 
	}
	
	public static boolean rowOrColContainsBlack(char[][] graph, int rVal, int cVal) {
		for(int i = 0; i <= numRows - 1; i++) {
			if(graph[i][cVal] == 'B') {
				return true; 
			}
		}
		for(int i = 0; i <= numCol - 1; i++) {
			if(graph[rVal][i] == 'B') {
				return true; 
			}
		}
		return false; 
		
	}

}
