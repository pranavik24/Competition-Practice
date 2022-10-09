package competition_practice;

import java.util.*;

public class AcowdemiaIII {
	static int numFriends; 

	public static void main(String[] args) {

		HashMap<Integer, Space> pasture = new HashMap<>(); 
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int width = scanner.nextInt();
		int numSpaces = length*width; 
		int colSize = (int)Math.ceil((width +11) /10)  * 10;
		
		
		char type; 
		String string; 
		ArrayList<Integer> coords = new ArrayList<>(); 
		int coord = 11; 
		for(int i = 0; i < length; i++) {
			string = scanner.next();
			for(int j = 0; j < string.length(); j++) {
				type = string.charAt(j);
				pasture.put(coord, new Space(type, coord)); 
				coords.add(coord); 
				coord++;
			}
			coord-=string.length();
			coord+=10; 
		}
		
		scanner.close();
		

		for(int a : coords) {
			if(pasture.get(a).getType() == 'C') {
				if(pasture.containsKey(a+2) && pasture.get(a+2).getType() == 'C') {
					if(pasture.get(a+1).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a+2), pasture.get(a+1));
					}
				}
				if(pasture.containsKey(a-2) && pasture.get(a-2).getType() == 'C') {
					if(pasture.get(a-1).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a-2), pasture.get(a-1));
					}
				}
				if(pasture.containsKey(a+(2*colSize)) && pasture.get(a+(2*colSize)).getType() == 'C') {
					if(pasture.get(a+colSize).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a+(2*colSize)), pasture.get(a+colSize));
					}
				}
				if(pasture.containsKey(a-(2*colSize)) && pasture.get(a-(2*colSize)).getType() == 'C') {
					if(pasture.get(a-colSize).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a-(2*colSize)), pasture.get(a-colSize));
					}
				}
				if(pasture.containsKey(a+colSize+1) && pasture.get(a+colSize+1).getType() == 'C') {
					if(pasture.get(a+1).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a+colSize+1), pasture.get(a+1));
					}
					else if(pasture.get(a+colSize).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a+colSize+1), pasture.get(a+colSize));
					}
				}
				if(pasture.containsKey(a-colSize-1) && pasture.get(a-colSize-1).getType() == 'C') {
					if(pasture.get(a-1).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a-colSize-1), pasture.get(a-1));
					}
					else if(pasture.get(a-colSize).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a-colSize-1), pasture.get(a-colSize));
					}
				}
				if(pasture.containsKey(a+colSize-1) && pasture.get(a+colSize-1).getType() == 'C') {
					if(pasture.get(a-1).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a+colSize-1), pasture.get(a-1));
					}
					else if(pasture.get(a+colSize).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a+colSize-1), pasture.get(a+colSize));
					}
				}
				if(pasture.containsKey(a-colSize+1) && pasture.get(a-colSize+1).getType() == 'C') {
					if(pasture.get(a+1).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a-colSize+1), pasture.get(a+1));
					}
					else if(pasture.get(a-colSize).getType() == 'G') {
						meet(pasture.get(a) , pasture.get(a-colSize+1), pasture.get(a-colSize));
					}
				}
			}
		}
		
		System.out.println(numFriends);
	}
	
	public static void meet(Space cow1, Space cow2, Space grassSpace) {
		grassSpace.changeType('.');
		if(!cow1.ifFriend(cow2)) {
			cow1.becomeFriends(cow2);
			numFriends++; 
		}
	}
    static class Space{
		char type; 
		int coord; 
		ArrayList<Integer> cowFriends = new ArrayList<>(); 
		public Space (char type, int coord) {
			this.type = type;  
			this.coord = coord; 
		}
		public char getType() {
			return type; 
		}
		public int getCoord() {
			return coord; 
		}
		public ArrayList<Integer> getCowFriends(){
			return cowFriends; 
		}
		public void changeType(char newType) {
			this.type = newType; 
		}
		public void becomeFriends(Space cow) {
			this.cowFriends.add(cow.getCoord());
			cow.updateFriendsArr(this.coord);
		}
		public void updateFriendsArr(int coordinate) {
			this.cowFriends.add(coordinate); 
		}
		public boolean ifFriend(Space cow) {
			boolean friends = false; 
			for(int a: this.cowFriends) {
				if(a == cow.getCoord()) {
					friends = true; 
					break; 
				}
			}
			return friends; 
		}
		public String toString() {
			String result = ""; 
			result += "Type: " + type + "\tCoordinate: " +coord; 
			return result;
		}
	}

}
