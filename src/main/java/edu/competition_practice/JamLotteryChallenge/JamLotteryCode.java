package jam_lottery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class JamLotteryCode{
	  public static void main(String[] args) {
		    try {
		      File Myfile = new File("/Users/rajithak/eclipse-workspace/JamLottery/src/main/java/jam_lottery/JamLotteryTest");
		      Scanner myReader = new Scanner(Myfile);
		      while (myReader.hasNextLine()) {
		    	  int num = myReader.nextInt();  
		    	  Num number = new Num(num);
		    	  number.PrintAandB();
		      }
		      myReader.close();
		    
		   }
		    catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		 }
	  
	
	  public static class Num{
		  int number;
		  int A;
		  int B;
		  public Num(int num) {
			  number = num;
			  A = getA(number);
			  B = number -A;

		  }
		  
		  public int getA(int num) {
			  
			  String number = Integer.toString(num); 
			  String newNumber = number.replace('4','3');
			
			  num = Integer.parseInt(newNumber);
			  
			  return num;
		  }
		  public void PrintAandB() {
		      System.out.println(A + " " + B);
		  }
		  
	  }
}
