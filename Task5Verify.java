// Tasks 5 verify running check the verify of solution to sudoku board. 

public class Task5Verify {
public static boolean isSolution(int sqrtN, int[][] hints, int[][] board){
   boolean ans =true;
   if ( sqrtN *sqrtN != board.length ){  //check if the length of the matrix is equal to n
	   throw new RuntimeException("The size of the sqrt is not the size of the board");
   }
   else{
	   for (int i = 0 ; i < board.length & ans; i= i+1){
		 for(int j = 0 ; j < board.length & ans; j= j+1){
			//check if the value is between max and min and check if the length of the rows in the matrix is equal to n
			 if (board.length!=board[i].length | board [i][j]> sqrtN * sqrtN | board[i][j]<= 0 ){
				throw new RuntimeException("the of the row:" + i + "is not the  rigth size or is not between 0, " + sqrtN * sqrtN ); 
			 }
			else{
				//check the verify hints in the reletive board 
				for ( int counthints=0 ; counthints< hints.length & ans; counthints=counthints+1){
				 if(i == hints[counthints][0] & j == hints[counthints][1] & board[i][j]!=hints[counthints][2]){
				  ans=false;	
				}
				}//end check hints
				if(ans){
				ans=TasksArrays.isAllDiff(board[i]);// check row
				 if(ans){
					TasksArrays.columns(board);// switching rows and columns
					ans=TasksArrays.isAllDiff(board[i]);//check columns
					TasksArrays.columns(board);// switching back
					 if(ans){
						TasksArrays.blocks(board,sqrtN);// switching rows and blocks
						ans=TasksArrays.isAllDiff(board[i]);//check blocks
						TasksArrays.blocks(board,sqrtN);// switching back 
					 }
				}
			} 
		 }  
	   }
	 }
   }
   return ans;
 }
}
