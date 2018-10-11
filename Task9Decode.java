// Tasks 9 Dncode is translate the solution of the sat to resolve board of sudoku 

public class Task9Decode {
	
	public static int cellValue(int[][][] map, int i, int j, boolean[] assignment) {
			int cellV=0;
		boolean iscellV = false;// stop the for loop when found the true value
		for(int k = 0; k <= map.length & !iscellV ; k = k + 1 ) {
			//check if the value true
			if (assignment[Task7Map.varName(i, j, k, map.length)]) {
				cellV = k+1;
				iscellV = true;
			}
		}
		if(cellV==0)
			throw new RuntimeException("there is no solution to the indexs");
		return cellV;
	}
	
	public static int[][] mapToBoard(int[][][] map, int n, boolean[] assignment) {
			int [][] board= new int [n][n];
			// set the board with the value that get true
			for(int i=0;i<n;i=i+1) {
			for(int j=0; j < n; j = j + 1 ) { 
				board[i][j]= cellValue(map, i, j, assignment );
			}	
		}
		return board;
	}
}
