package competition_practice;

public class BinarySearchPractice {

	public static void main(String[] args) {
		
		int[] arr = {2,5,6,7,10,13}; 
		System.out.println("Recursion: " + binarySearch(arr, 10, 0, arr.length -1));
		System.out.println("Non- Recursive: " + binarySearch(arr, 10));

		
	}
	
	public static int binarySearch(int arr[], int value, int left, int right) {
		int mid = (left + right)/2;
		
		if(arr[mid] == value) {
			return mid; 
		}
		else if(arr[mid] < value) {
			return binarySearch(arr, value, mid+1, right);
		}
		else if(arr[mid] > value) {
			return binarySearch(arr, value, left, mid-1); 
		}
		else {
			return -1; 
		}
	}
	
	public static int binarySearch(int arr[], int key) {
		int left = 0; 
		int right = arr.length -1; 
		
		while(left <= right) {
			int mid = (left + right)/2;
			
			if(arr[mid] == key) {
				return mid; 
			}
			else if(arr[mid] < key) {
				left = mid + 1; 
			}
			else if(arr[mid] > key) {
				right = mid - 1; 
			}

			
		}
		return -1; 
		
	}

}
