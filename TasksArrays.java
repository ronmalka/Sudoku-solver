// Tasks Array running check and function on matrix and them row columns and blocks.

public class TasksArrays { 
	
	public static boolean isAllDiff(int[] array) {
			boolean alldiff=true;
			//check for every index i that index j is diffrent
		for (int i=0; i<array.length ; i=i+1){
			for (int j=i+1;j<array.length;j=j+1){
				if(array[i]==array[j]){
					alldiff=false;
				}
			}
		}
		return alldiff ;
	}
	//check if the value is between max and min and check if the length of the matrix is equal to n
	public static boolean isMatrixBetween(int[][] matrix, int n, int min, int max) {
			boolean ismat=false;
		if (matrix!=null){         // for not  to approach to null value
		if (matrix.length == n){  // to asure that the length of array matrix is equal to n
			ismat=true;
			for (int i = 0;i < matrix.length & ismat; i = i + 1){
				if(matrix[i]!=null){        // for not  to approach to null value
				if(matrix[i].length==n){   // to asure that the length of array matrix[] is equal to n
					for(int j=0; j < matrix[i].length & ismat; j = j + 1){
						if( matrix[i][j] < min | matrix[i][j] > max){
							ismat = false;
						}
					}
				}
				else ismat=false;//matrix[i].length != n
				}
				else ismat=false;//matrix[i] != null
			}
		}
		}
		return ismat;
	}
	// switch between the columns and the row with a temporary variable
	public static int[][] columns (int[][] matrix) { 
			for(int i =0 ; i < matrix.length; i=i+1 ){
			for ( int j = i+1; j < matrix.length; j = j+1){
				int tmp =  matrix [i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}		
	}
	
	return matrix;	
	}
	//switch the blocks and the rows
	public static int[][] blocks(int[][] matrix, int sqrtN) {
			int countcol=0;
		int countrow=0;

		int [][] sortmat = new int [matrix.length][matrix.length];

		for(int i=0; i<sqrtN*sqrtN; i= i+1) {
			for(int j=0  ; j<sqrtN*sqrtN; j=j +1) {
			int row = j/sqrtN + (i/sqrtN)*sqrtN;// formula to calculate the rigth index for the row in the block
			int col = countrow*sqrtN + countcol;// formula to calculate the rigth index for the col in the block
			sortmat[i][j]=matrix[row][col];
		countcol=countcol + 1;// counter for the col in the blocks
		if (countcol==sqrtN)
			countcol=0;
			}
			countrow = countrow+1;// counter for the row in the blocks
			if (countrow==sqrtN)
				countrow=0;
		}	

			return sortmat;
	}
	}



