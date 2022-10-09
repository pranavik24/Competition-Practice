package competition_practice;
import java.util.*; 

public class AcowdemiaI {

	public static void main(String[] args) {
 
		Scanner scanner = new Scanner(System.in);
		
		int numPapers = scanner.nextInt();
		int L = scanner.nextInt();
		
		if(L > numPapers) {
			L = numPapers; 
		}
		
		ArrayList<Integer> papers = new ArrayList<>(numPapers);		
		for(int i = 0; i < numPapers; i++) {
			papers.add(scanner.nextInt());
		}
		
		scanner.close();
		
	
		papers.sort(null); 
		//reverse papers
		ArrayList<Integer> papersRev = new ArrayList<>(numPapers); 
		for(int i = numPapers-1; i >= 0; i--) {
			papersRev.add(papers.get(i)); 
		}
		
		
	
		ArrayList<Integer> papersCopy =  new ArrayList<>();
		papersCopy = new ArrayList<>(papersRev); 
		
		
		int hIndex = 1; 
		for(int i = 0; i < numPapers; i++) {
			if(papersRev.get(0) == 0) {
				hIndex = 0; 
				break; 
			}
			if(hIndex > papersRev.get(i)) {
				if(L > 0) {
					papersCopy.set(i, papersRev.get(i) + 1);
					L--; 
					
					for(int a = 0; a < numPapers; a++) {
						if(papersCopy.get(a) == papersRev.get(i) && L > 0) {
							papersCopy.set(a, papersRev.get(i) + 1); 
							L--; 
						}
					}
					papersCopy.sort(null);
					Collections.reverse(papersCopy);
					
					
					if(hIndex > papersCopy.get(i)) {
						hIndex--; 
						break;
					}
					else if(i == numPapers-1) {
						
					}
					else {
						hIndex++; 
					}
			

				}
				else {

					hIndex--; 
					break;
				}
				
				 
			}
			else {

				hIndex++; 
			}
		}
		
		System.out.println(hIndex);
		
	}

}
