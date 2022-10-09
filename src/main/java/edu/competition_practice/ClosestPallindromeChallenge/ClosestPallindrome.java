package competition_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ClosestPallindrome {
public static void main(String[] args) {
		
	    try {
	      File Myfile = new File("/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenge4/ClosestPallindromeTest");
	      Scanner myReader = new Scanner(Myfile);
	      while (myReader.hasNextLine()) {
	    	  int num = myReader.nextInt(); 
	    	  Number number = new Number(num);
	    	  number.FindClosestPallindrome();
	    	  
	      }
	      myReader.close();
	    
	   }
	    catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	 }

public static class Number{
String numString; 
int num; 
	public Number(int num){
	numString = Integer.toString(num);
	this.num = num; 
	}
	
	public void FindClosestPallindrome(){
		int numLen = numString.length();
		int lowPalin, highPalin; 
		StringBuilder builderLowPal = new StringBuilder();
		StringBuilder builderHighPal = new StringBuilder();

		if(num%10 == 0) {
			System.out.println(num-1);
		}
		else if(numLen ==2){
			
		}
		else {
		

			
			int max;
			if(numLen%2==0) {
				max= numLen/2;
			}
			else {
				max = numLen/2+1; 
			}
		
			for(int i = 0; i<max; i++) {
				builderLowPal.append(numString.charAt(i));
				if(i == 1) {
					int temp = Integer.parseInt(String.valueOf((numString.charAt(i))));
					temp++;
					builderHighPal.append(temp);
				}
				else {
					builderHighPal.append(numString.charAt(i));
				}
			}
			

			
			if(numLen%2!=0) {
				max--;
			}
			for(int i= max-1; i >= 0; i--) {
				builderHighPal.append(builderHighPal.charAt(i));
				builderLowPal.append(builderLowPal.charAt(i));

			}
	

			 lowPalin = Integer.parseInt(builderLowPal.toString());
			 highPalin = Integer.parseInt(builderHighPal.toString());
			 
			 int highPalFar = Math.abs(highPalin-num); 
			 int lowPalFar = Math.abs(num-lowPalin);
			 
			 int finalPal = 0;
			 if(lowPalFar<=highPalFar) {
				 finalPal = lowPalin;
			 }
			 if(lowPalFar>highPalFar) {
				 finalPal = highPalin; 
			 }

			 	System.out.println(finalPal);
			}
		}
	}
}


