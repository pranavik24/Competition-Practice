package competition_practice;
import java.util.*; 

public class AdjListPractice {
	
	static int components[] = new int[10000]; 
	static int numFarms,numRoads, numFriends; 
	static boolean[] visited;;
	static ArrayList<Integer>[] adj; 
	static int num = 0; 
	static String cows; 


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		numFarms = sc.nextInt(); 
		numFriends = sc.nextInt(); 
		cows = sc.next(); 
		numRoads = numFarms-1; 
		adj = new ArrayList[numFarms];  
		visited = new boolean[numFarms]; 
		for(int i = 0; i < numFarms; i++){
			adj[i] = new ArrayList<Integer>(); 
			}
		
		int a, b; 
		for(int i = 0; i < numRoads; i++) {
			a = sc.nextInt()-1;
			b = sc.nextInt()-1;
			
			adj[a].add(b); 
			adj[b].add(a); 

		}
		
		
		System.out.println(Arrays.toString(adj));
		
		for(int i = numFarms-1; i >= 0; i--) {
			num++;
			dfs(i); 
		}
		
		System.out.println(Arrays.toString(components));
		int startingPoint, endingPoint; 
		char friendCow; 
		for(int i = 0; i < numFriends; i++) {
			startingPoint = sc.nextInt()-1;
			endingPoint = sc.nextInt()-1;
			friendCow = sc.next().charAt(0);
			if(cows.charAt(startingPoint) == friendCow || components[startingPoint] != components[endingPoint]) {
				System.out.print(0);
			}
			else {
				System.out.print(1);
			}
			
		}
		
		
		
	}
	
	public static void dfs(int node) {
		visited[node] = true; 
		
		components[node] = num; 
		for(int next: adj[node]) {
			if(cows.charAt(node) == cows.charAt(next) && !visited[next]) {
				dfs(next); 
			}
		}
	}
	

}

/*
Input: 
5 5
HHGHG
1 2
2 3
2 4
1 5
1 4 H
1 4 G
1 3 G
1 3 H
5 5 H
*/
