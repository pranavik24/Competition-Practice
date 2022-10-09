package competition_practice;
import java.util.*;

public class Acowdemia2 {

	public static void main(String[] args) {
		int K,N;
		//K = number of author list; N = number of members
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		N = sc.nextInt();
		
		ArrayList<String> members = new ArrayList<>(); 
		String str; 
		for(int i = 0; i < N; i++) {
			str = sc.next(); 
			members.add(str);
		}
		
		String[][] authorLists = new String[K][N];
		char[][] output = new char[N][N];		
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) {
					output[i][j] = 'B'; 
					
				}
				else {
					output[i][j] = '?'; 
				}
			}
		}
		System.out.println(members);
		
		ArrayList<String> authors = new ArrayList<>(); 
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < N; j++) {
				authors.add(sc.next()); 
			}
			System.out.println("Author List : " + authors);
			System.out.println("hello");
			
			for(int j = 0; j < N; j++) {
				
				for(int k = 0; k <  N; k ++) {
					if( j != k) {
						System.out.println("at- j =  " + j + " k = " + k );
				String personA = members.get(j);
				String personB = members.get(k); 
				System.out.println("camparing " + personA + " and " + personB);
				if(personA.compareTo(personB) < 0 && authors.indexOf(personA) > authors.indexOf(personB)) {
					System.out.println("~~~~ Greater ~~~~");
					output[j][k] = '1';
					output[k][j] = '0'; 
			
				}
				if(personA.compareTo(personB) > 0 && authors.indexOf(personA) < authors.indexOf(personB)) {
					System.out.println(personA +"'s index: " + authors.indexOf(personA));
					System.out.println(personB +"'s index: " + authors.indexOf(personB));

					System.out.println("~~~~ Less ~~~~");
					output[j][k] = '0';
					output[k][j] = '1'; 
					
				}
					}
			
				}
				
			}
			authors.clear();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(output[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
}
