package competition_practice;
import java.util.*;

public class Cowntagion {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int numFarms = sc.nextInt(); 
		int numDays = 0;
		numDays+= getNumDaysDoubled(numFarms); 
		int farm1, farm2; 
		int numAdjFarms; 
		/*for (int i = 0; i < numFarms - 1; i++) {
			farm1 = sc.nextInt();
			farm2 = sc.nextInt(); 
			
		}*/
		
		System.out.println(numDays);
	}
	
	public static int getNumDaysDoubled(int numFarms) {
		int numDaysDoubled = 0;
		int days =1; 
		
			while(days < numFarms) {
				days*=2; 
				numDaysDoubled++; 
			}
		return numDaysDoubled; 
	}

}
