// Tasks 10 Solve get hints and n and return aboard with a solution to the sudoku 

public class Task10Solve {
	
	public static int[][] solve(int sqrtN, int[][] hints) {
			int n = sqrtN*sqrtN;
			int [][][] map = Task7Map.varsMap(n);// set the map of the variables
		Task8Encode.encode(sqrtN, hints, map);// set the SATSolver of solution
		boolean[] assignment = SATSolver.getSolution() ;// get the SATSolver solution
		int [][] board =new int [n][n];
		 if (assignment.length == 0)// there is no solution 
			 board = null ;
		
		 else
		 {
			 board = Task9Decode.mapToBoard(map, n, assignment);//set the board with the SAT solutionss			 
			 boolean verify = Task5Verify.isSolution(sqrtN, hints, board);// check the verify of the board for the sudoku
			 if (!verify)
				 throw new RuntimeException("Illegal Solution");
				 
		 }
		 
		return board; 
	}
	}

