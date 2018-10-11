// Tasks 7 map is mapping the variables 1-n to name that represent by digit from 1 to n^3 . 

public class Task7Map {
	//set the name of the variables
	public static int varName(int i, int j, int k, int n) {
		return (n*n*i + n*j + k + 1) ; 
	}
	//locking for the right i j n k to the reletive x
	public static int[] nameToIndex(int x, int n) {  
			int [] triple = new int [3];
		boolean isname = false;
		for (int i = 0 ;i < n & !isname ; i=i+1) {
			for (int j = 0 ;j < n & !isname ; j=j+1) {
				for (int k = 0 ;k < n & !isname ; k=k+1) {
					if (x == varName( i, j, k , n)) {
						triple[0]=i;
						triple[1]=j;
						triple[2]=k;
						isname=true;
					}
				}
			}
		}
		return triple;
	}
	// set the map with calculate of the var name by the function varName for every triple
	public static int[][][] varsMap(int n) { 
			int[][][] map = new int [n][n][n];
		for (int i = 0 ;i < n ; i=i+1) {
			for (int j = 0 ;j < n ; j=j+1) {
				for (int k = 0 ;k < n ; k=k+1) {
				map[i][j][k]=varName(i, j ,k ,n); 
				}
			}
		}
		return map;
	}
}
