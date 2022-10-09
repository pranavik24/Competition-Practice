package competition_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KingInDanger {
	static boolean[][] board = new boolean[8][8];
	static int[] kingLoc = new int[2];


	//Sample Input: Ba1 Rd3 Rg7 Qb3 Ke6 - Check N - Knight P - Pawn
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		int arrLen = (input.length()+1)/4; 
		int index = 0; 
		ArrayList<String>[] pieces = new ArrayList[arrLen]; 
		for(int i = 0; i < pieces.length; i++) {
			pieces[i] = new ArrayList<>(); 
			pieces[i].add(Character.toString(input.charAt(index)));
			index++;
			pieces[i].add(Integer.toString((input.charAt(index) - 97)));
			index++;
			pieces[i].add(Integer.toString((int)(input.charAt(index) - 49)));
			index+=2; 
			if(pieces[i].get(0).equals("K")) {
				kingLoc[0] = Integer.parseInt(pieces[i].get(1));
				kingLoc[1] = Integer.parseInt(pieces[i].get(2));

			}
			
			
		}
		
		System.out.println(Arrays.toString(pieces));
		fillBoard(pieces); 
		
		if(kingSafeInPlace() && kingSafeToMove()) {
			System.out.println("Safe");
		}
		if(!kingSafeInPlace() && kingSafeToMove()) {
			System.out.println("Check");
		}
		if(!kingSafeInPlace() && !kingSafeToMove()) {
			System.out.println("Checkmate");
		}
		if(kingSafeInPlace() && !kingSafeToMove()) {
			System.out.println("Stalemate");
		}
		
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[0].length; c++) {
				if(r == kingLoc[0] && c == kingLoc[1]) {
					System.out.print("*");
				}
				else if(board[r][c]) {
					System.out.print(1);
				}
				else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
		
		

	}
	
	public static void fillBoard(ArrayList<String>[] pieces) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j] = true; 
			}
		}
		for(int i = 0; i < pieces.length; i++) {
			board[Integer.parseInt(pieces[i].get(1))][Integer.parseInt(pieces[i].get(2))] = false; 
			attack(pieces[i]); 
		}
	}
	public static boolean kingSafeInPlace() {
		return board[kingLoc[0]][kingLoc[1]]; 
			
	}
	
	public static boolean kingSafeToMove() {
		int r = kingLoc[0];
		int c = kingLoc[1];
		if(board[r-1][c-1]) {
			return true; 
		}
		if(board[r-1][c]) {
			return true; 
		}
		if(board[r-1][c+1]) {
			return true; 
		}
		if(board[r][c+1]) {
			return true; 
		}
		if(board[r+1][c+1]) {
			return true; 
		}
		if(board[r+1][c]) {
			return true; 
		}
		if(board[r+1][c-1]) {
			return true; 
		}
		if(board[r][c-1]) {
			return true; 
		}
		return false; 
			
	}
	public static void attack(ArrayList<String> piece) {
		int r = Integer.parseInt(piece.get(1));
		int c = Integer.parseInt(piece.get(2));

		if(piece.get(0).equals("B")) {
			diag(r,c); 
		}
		if(piece.get(0).equals("R")) {
			vertAndHor(r,c);
		}
		if(piece.get(0).equals("Q")) {
			vertAndHor(r,c);
			diag(r,c);
		}
		if(piece.get(0).equals("P")) {
			board[r-1][c-1] = false; 
			board[r-1][c+1] = false;
		}
		if(piece.get(0).equals("N")) {
			knightMove(r,c); 
		}
	}
	
	public static void diag(int rCoord, int cCoord) {
		int r = rCoord; 
		int c = cCoord; 
		
		while(r > 0 && c > 0) {
			board[r-1][c-1] = false; 
			r--;
			c--;
		}
		r = rCoord; 
		c = cCoord; 
		while(r > 0 && c < 7) {
			board[r-1][c+1] = false; 
			r--;
			c++; 
		}
		r = rCoord; 
		c = cCoord; 
		while(r < 7 && c < 7) {
			board[r+1][c+1] = false; 
			r++;
			c++;  
		}
		r = rCoord; 
		c = cCoord; 
		while(r < 7 && c > 0) {
			board[r+1][c-1] = false; 
			r++;
			c--;   
		}
	}
	public static void vertAndHor(int rCoord, int cCoord) {
		int r = rCoord; 
		int c = cCoord; 
		
		while(c > 0) {
			board[r][c-1] = false; 
			c--;    
		}
		r = rCoord; 
		c = cCoord; 
		
		while(c < 7) {
			board[r][c+1] = false; 
			c++;    
		}
		r = rCoord; 
		c = cCoord; 
		while(r > 0) {
			board[r-1][c] = false; 
			r--;   
		}
		r = rCoord; 
		c = cCoord; 
		while(r < 7) {
			board[r+1][c] = false; 
			r++;    
		}
	}
	public static void knightMove(int r, int c) {
		if(r -2 >= 0 && c -1 >= 0) {
			board[r-2][c-1] = false; 
		}
		if(r -2 >= 0 && c +1 >= 0) {
			board[r-2][c+1] = false; 
		}
		if(r -1 >= 0 && c -2 >= 0) {
			board[r-1][c-2] = false; 
		}
		if(r -1 >= 0 && c +2 >= 0) {
			board[r-1][c+2] = false; 
		}
		if(r +2 >= 0 && c -1 >= 0) {
			board[r+2][c-1] = false; 
		}
		if(r +2 >= 0 && c +1 >= 0) {
			board[r+2][c+1] = false; 
		}
		if(r +1 >= 0 && c -2 >= 0) {
			board[r+1][c-2] = false; 
		}
		if(r +1 >= 0 && c +2 >= 0) {
			board[r+1][c+2] = false; 
		}
		
	}
	

}
