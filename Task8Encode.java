// Tasks 8 Encode is make the clauses to the sat solver with the reletive hints and  the conditions of the sudoku board

public class Task8Encode {
	
	public static void encode(int sqrtN, int[][] hints, int[][][] map) {
			int n = sqrtN * sqrtN;
			int nVars = n * n * n +1 ;
		SATSolver.init(nVars);//set the sat solver
		
		for(int i = 0 ; i < hints.length; i= i+1)
		{		
	     	SATSolver.addClause(hintsCNF(n, hints[i], map));
		}//turn the hints to clause to cnf
		for ( int i =0 ;i <n;i=i+1) {
			for(int j=0;j<n;j=j+1)
			{
			SATSolver.addClauses(Task6Cnf.exactlyOne(map[i][j]));
			} 
		}// turn every cell  to cnf
		for(int i = 0  ; i< n;i=i+1) {// turn every row  to cnf
			for(int j=0;j<n;j=j+1){
			int[][] rows = rowsCNF(map,i, n);
			SATSolver.addClauses(Task6Cnf.exactlyOne(rows[j]));
			}
		}//end turn every row  to cnf
		for(int i = 0  ; i< n;i=i+1) {// turn every columns to cnf
			for(int j=0;j<n;j=j+1){
			int[][] columns = columnsCNF(map,i, n);
			SATSolver.addClauses(Task6Cnf.exactlyOne(columns[j]));
			}
	  }// end turn every columns to cnf
		for(int i = 0  ; i< n;i=i+1) {// turn every block  to cnf
			for(int j=0;j<n;j=j+1){
			int[][] blocks = blocksCNF(map,i, sqrtN);
			SATSolver.addClauses(Task6Cnf.exactlyOne(blocks[j]));
			}
		}// end turn every block  to cnf
		
		
	}
	
	
	public static int[][] rowsCNF(int [][][]map, int num , int n) {// turn every row  to cnf
		int[][] row = new int [n][n];
		for ( int i =0 ;i <n;i=i+1) {
			for(int j=0;j<n;j=j+1) {
			row[i][j]=map[i][j][num];
			 
			}
		}
		return row;
			
		
	}//end  turn every row  to cnf
	public static int[] hintsCNF(int n , int [] hints , int[][][] map) {//turn the hints to clause to cnf by varName
		int [] clause=new int[1];
		clause[0]=Task7Map.varName(hints[0], hints[1], hints[2], n) -1;
		return clause;
	}// end turn the hints to clause to cnf by varName
	public static int[][][] sortcolumns (int[][][] matrix) {
		
		for(int i =0 ; i < matrix.length; i=i+1 ){// sort columns  to row
				for ( int j = i+1; j < matrix.length; j = j+1){// switch between the columns and the row with a temporary variable
					int[] tmp =  matrix [i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = tmp;
					
		}
		}
		return matrix;	
		}// end sort columns  to row
public static int[][] columnsCNF (int [][][]map, int num , int n) {// turn every columns  to cnf
		map= sortcolumns(map);
		int[][] columns = rowsCNF(map,num,n);	
		map= sortcolumns(map); 
		return columns;
		}// end every columns  to cnf
public static int[][][] sortblocks(int[][][] matrix, int sqrtN) {// sort block to row
	int countcol=0;
	int countrow=0;
	int [][][] sortmat = new int [matrix.length][matrix.length][matrix.length];
	for(int i=0; i<sqrtN*sqrtN; i= i+1) {
		for(int j=0  ; j<sqrtN*sqrtN; j=j +1) {
		int row = j/sqrtN + (i/sqrtN)*sqrtN;// formula to calculate the rigth index for the row in the block
		int col = countrow*sqrtN + countcol;// formula to calculate the rigth index for the col in the block
		sortmat[i][j]=matrix[row][col];
	countcol=countcol + 1;// counter for the col in the blocks
	if (countcol==sqrtN)
		countcol=0;
		}
		countrow = countrow+1;// counter for the row in the blocks;
		if (countrow==sqrtN)
			countrow=0;
	}	

		return sortmat;
}// end sort block to row
public static int[][] blocksCNF (int [][][]map, int num , int sqrtN) {
	map= sortblocks(map,sqrtN);
	int[][] blocks = rowsCNF(map,num,sqrtN*sqrtN);
	return blocks;
	}// turn every blocks  to cnf
}


