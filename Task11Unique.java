// Tasks 11 Unique check if there is onther solution to the sudoku

public class Task11Unique {
	
	public static int[][] solveUnique(int sqrtN, int[][] hints) {
   
	int [][] board = Task10Solve.solve(sqrtN, hints);// get the first solution to check if his unique
		int n = sqrtN * sqrtN; 
		if (board!=null) {
		boolean[] assignment = SATSolver.getSolution() ;
		//set onther codition to the sat for onther solution
		int [] othersolution = new int[assignment.length-2];
		for(int i=1 ; i < assignment.length-1; i=i+1) {
				if(assignment[i])
			othersolution[i-1]= (i) * (-1);
				else
					othersolution[i-1]= (i);
				
		}
		
		int [][][] map = Task7Map.varsMap(n);
		Task8Encode.encode(sqrtN, hints, map);
		SATSolver.addClause(othersolution);
		boolean[] newassignment = SATSolver.getSolution() ;// making new assignment to check if there is onther solution
		boolean isunique = true;
		  if (newassignment == null)
			 throw new RuntimeException("TIME OUT");
		 
		 else if(newassignment.length!=0)// if newassignment.length = 0 there unique solution to the board but i can't to approach to newassignment 
		 {
			
			 
				for (int i=0 ; i < newassignment.length & isunique; i=i+1) {
				
					if (assignment[i]!=newassignment[i]) {// if the solutions is diffrent, hence the firs borad is not unique solution
					isunique = false;
					board = null;
				}
				}
		 }
		}

		return board ;
	}
	}