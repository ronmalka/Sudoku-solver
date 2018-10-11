import java.util.Arrays;

public class test {
 public static void  main(String[] args) {
	 // The hint is displayed as follows:{row, column, hint}
	 int [][] hints1 = {
			 		  {0,5,5},{0,6,7},{0,7,4},{0,8,6},
			 		  {1,1,2},{1,5,3},{1,7,9},
			 		  {2,8,8},
			 		  {3,0,6},{3,2,7},{3,3,5},
			 		  {4,2,1},{4,6,4},
			 		  {5,1,8},{5,2,5},{5,3,9},{5,5,4},
			 		  {6,3,3},{6,7,7},
			 		  {7,3,7},{7,4,6},
			 		  {8,2,4},{8,6,1},{8,8,2}
			 		  };
	 int [][] board1 = Task10Solve.solve(3, hints1);
	 int[][] hints2 = {{0,0,2}, {1,2,1}, {2,1,2}, {3,3,4}};
	 int [][] board2 = Task10Solve.solve(2, hints2);
	 System.out.println(Arrays.deepToString(board1));
	 System.out.println(Arrays.deepToString(board2));
	 }
 }

