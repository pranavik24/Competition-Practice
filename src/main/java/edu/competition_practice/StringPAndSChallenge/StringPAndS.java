package competition_practice;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class StringPandS {
	public static void main(String[] args) {
		
	    try {
	      File Myfile = new File("/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenge2/StringPandS_Test");
	      Scanner myReader = new Scanner(Myfile);
	      while (myReader.hasNextLine()) {
	    	  String pattern = myReader.next();  
	    	  String s = myReader.next();
	    	  PatternCheck tbd = new PatternCheck(s, pattern);
	    	  tbd.PatternMatching(s, pattern);
	      }
	      myReader.close();
	    
	   }
	    catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	 }
	
	
	
	public static class PatternCheck {
		String s;
		String pattern; 
		public PatternCheck(String string, String num){
			s = string;
			pattern = num; 
	

		}
		public void PatternMatching(String s, String pattern) {
			String newString = convertStringBin(s);
			String newPattern = pattern;

			int maxVal = newString.length()-newPattern.length();
			


			int numMatches = 0; 
			for(int i = 0; i < maxVal+1; i++) {
				int endVal = i+newPattern.length();
				String substr = newString.substring(i,endVal);
				if(newPattern.equals(substr)) {
					numMatches++; 
				}
				
			}
			System.out.println(numMatches);
		}
		public String convertStringBin(String s) {
			String newString = "";
			for(int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'u':
				case 'o':
				case 'y':
					newString = newString+"0";
					break;
				default:
					newString = newString+"1";
					
				}
			}
			
			return newString; 
		}
	}
}
