package competition_practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddandMultiplyDigits {

	public static void main(String[] args) {
	    try {
	      File Myfile = new File("/Users/rajithak/eclipse-workspace/HomeChallenge/src/main/java/home/projects/challenge1/AddandMultiplyTest");
	      Scanner myReader = new Scanner(Myfile);
	      while (myReader.hasNextLine()) {
	    	  int num = myReader.nextInt();  
	    	  Number number = new Number(num);
	    	  number.printProdMinusSum();
	      }
	      myReader.close();
	    
	   }
	    catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	 }
	
}
