package competition_practice;
import java.util.*;

public class Acowdemia1 {

	public static void main(String[] args) {
		int N, L; 
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		L = sc.nextInt(); 
		
 		int[] citationsInput = new int[N]; 
 		//Integer[] citations = new Integer[N]; 
 		int[]citations = new int[N]; 
 		
 		int num; 
 		for(int i = 0; i < N; i++) {
 			num = sc.nextInt();
 			citationsInput[i] = num; 
 			//citations[i] = num;
 			citations[i] = num;
 		}
 		
 		//reversing array 
 		//Arrays.sort(citations, Collections.reverseOrder());
 		
 		citations = sortArrayDescending(citations); 
 		
 		int hIndex = 0; 
 		hIndex = findHIndex(citations, hIndex); 
 		//System.out.println(Arrays.toString(citations));
 		//System.out.println(Arrays.toString(citationsInput));

 		if(L > 0) {
 			citations = addExtraCitations(citations, hIndex, L); 
 	 		citations = sortArrayDescending(citations); 
 	 		/*System.out.println("L: " + L);
 	 		System.out.println("hIndex = " + hIndex);
 	 		System.out.println("Array after L sort: " + Arrays.toString(citations));*/
 	 		hIndex = findHIndex(citations, hIndex); 

 		}
 		
 		System.out.println(hIndex);
		
	}
	public static int findHIndex(int[] citations, int hIndex) {
		for(int i = hIndex; i < citations.length; i++) {
			if(i+1 <= citations[i]) {
				hIndex = i+1; 
			}
			if(i+1 > citations[i]) {
				break; 
			}
		}
		
		return hIndex; 
		
	}
	
	public static int[] addExtraCitations(int[] citations, int hIndex, int L) {
		int startingIndex = getFirstOccurance(citations, hIndex);
		
		for(int i = 0; i < L; i++) {
			if(startingIndex >= citations.length) {
				break; 
			}
			citations[startingIndex] = citations[startingIndex] + 1; 
			startingIndex++; 
			
		}
		return citations; 
	}
	
	public static int getFirstOccurance(int[] citations, int hIndex) {
		int searchingNum = citations[hIndex];
		for(int i = 0; i < citations.length; i++) {
			if(citations[i] == searchingNum) {
				return i; 
			}
		}
		return -1; 
	}
	
	public static int[] sortArrayDescending(int[] array) {
 		int[] temp = new int[array.length]; 
		Arrays.sort(array);
 		
 		int x = 0; 
 		for(int i = temp.length-1; i >= 0; i--) {
 			temp[x] = array[i];
 			x++; 
 		}
 		return temp; 
	}


}
