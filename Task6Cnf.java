// Tasks 6 CNF make CNF from reletive variables to the sat solver . 

public class Task6Cnf {
	// check if the is  at least one true in clause n>=1
	public static int[][] atLeastOne(int[] vars) { 
		int [][] atleast= new int [1][vars.length];
		atleast[0]=vars;
		return atleast;
	}
	// check if there is at most one true in clause to every i,j in vars array  with the formula (-Xi,-Xj), n<=1
	public static int[][] atMostOne(int[] vars) {
			int numrow = (vars.length * (vars.length -1))/2;//formula to pick 2 from n
		int [][] atmost= new int [numrow][2];               
		 int count0 = 0;
		 int count1 = 1; // the counters for 
		 for (int i = 0 ; i<atmost.length;i=i+1) {
			atmost[i][0]=vars[count0]*(-1);
            atmost[i][1]= vars[count1]*(-1);
            count1 = count1+1;
            if(count1==vars.length) {
            	count0 = count0 +1;
            	count1 = count0 + 1;
            }
    
		}
		
		
		return atmost;
	}
	
	public static int[][] exactlyOne(int[] vars) {  //check if there is exactly one trune in clause with the combination of at most one and at least one
                                                   //	n<=1 & n>=1 <=> n=1
		int [][] exactlyA=atLeastOne(vars);
		int [][] exactlyB=atMostOne(vars);
		int numrow = (vars.length * (vars.length -1))/2;
		int [][] exactly = new int[numrow+1][];
		exactly[0]=exactlyA[0];
		for(int i =1 ; i <exactly.length;i=i+1) {
			exactly[i]=new int [2];
			exactly[i]=exactlyB[i-1];
		}
		
		
		return exactly;
		
	}
	}

