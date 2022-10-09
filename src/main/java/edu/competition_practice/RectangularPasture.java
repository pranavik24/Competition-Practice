package competition_practice;

import java.util.*;

public class RectangularPasture {

	/*public static void main(String[] args) {
        int n = 10; 
        int[] xs = {11,17,92,46,82,38,74,38,72,20};
		//Integer[] cows = new Integer[n];
		Integer[] cows = {0,1,2,3,4,5,6,7,8,9};


        Arrays.sort(cows, Comparator.comparingInt(j -> xs[j]));
        for(int i = 0; i <  10; i ++) {
        	System.out.print(cows[i] + " ");
        }
        System.out.println();
        for(int i = 0; i <  10; i ++) {
        	System.out.print(xs[i] + " ");
        }

	}*/
	
	//Not my code. Got from USACO website
    static int[][] sums;
    
    static int getSum(int fromX, int toX, int fromY, int toY) {
        return sums[toX][toY] - sums[fromX - 1][toY] - sums[toX][fromY - 1] + sums[fromX - 1][fromY - 1];
    }
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        Integer[] cows = new Integer[n];
        for (int j = 0; j < n; j++) {
            xs[j] = in.nextInt();
            ys[j] = in.nextInt();
            cows[j] = j;
        }
        
        Arrays.sort(cows, Comparator.comparingInt(j -> xs[j]));
        for (int x = 1; x <= n; x++) {
            xs[cows[x - 1]] = x;
        }
        
        for(int i = 0; i < n ; i++) {
        	System.out.println(xs[i] + " ");
        }
        Arrays.sort(cows, Comparator.comparingInt(j -> ys[j]));
        for (int y = 1; y <= n; y++) {
            ys[cows[y - 1]] = y;
        }
        for(int i = 0; i < n ; i++) {
        	System.out.println(ys[i] + " ");
        }
        sums = new int[n + 1][n + 1];
        for (int j = 0; j < n; j++) {
            sums[xs[j]][ys[j]]++;
        }
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (x > 0) {
                    sums[x][y] += sums[x - 1][y];
                }
                if (y > 0) {
                    sums[x][y] += sums[x][y - 1];
                }
                if (x > 0 && y > 0) {
                    sums[x][y] -= sums[x - 1][y - 1];
                }
            }
        }
        long answer = n + 1;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                answer += getSum(Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), 1, Math.min(ys[j], ys[k]))
                        * getSum(Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), Math.max(ys[j], ys[k]), n);
            }
        }
        System.out.println(answer);
    }
	

}
