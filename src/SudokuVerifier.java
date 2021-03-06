import java.util.BitSet;

public class SudokuVerifier {
	
	public static int verify(String candidateSolution) {		
		
		int[][] candidateSolutionM = toM2(candidateSolution,9);
		return 0;
		
	}
	
	public static int[][] toM2(String candidateSolution, int N) { //Converts a string into a matrix
		
		int[] arr = new int[candidateSolution.length()];

	    for (int i = 0; i < candidateSolution.length(); i++){
	        arr[i] = candidateSolution.charAt(i) - '0';
	    }

		int M = (arr.length + N - 1) / N;
		    int[][] mat = new int[M][];
		    int start = 0;
		    for (int r = 0; r < M; r++) {
		    	int L = Math.min(N, arr.length - start);
		    	mat[r] = java.util.Arrays.copyOfRange(arr, start, start + L);
		    	start += L;
		    }
		    return mat;
	}
	
	public static int verifyLength(int[][] candidateSolution) {		

		if (candidateSolution.length*candidateSolution.length == 81) 
			return 0;
		else
			return 1;
	}
	
	
	public static int verifyRow(int[][] candidateSolution) {		
			
		for(int i=0; i<candidateSolution.length; i++){
			BitSet row = new BitSet(9);
			for(int j=0; j<candidateSolution[i].length; j++){
				if(row.get(candidateSolution[i][j]-1))
					return 1;
				else 
					row.set(candidateSolution[i][j]-1);
			}
		}
		return 0;
	}
	
	public static int verifyColumn(int[][] candidateSolution) {		
		
		for(int i=0; i<candidateSolution.length; i++){
			BitSet column = new BitSet(9);
			for(int j=0; j<candidateSolution[i].length; j++){
				if(column.get(candidateSolution[j][i]-1))
					return 1;
				else 
					column.set(candidateSolution[j][i]-1);
			}
		}
		return 0;
	}
	
public static int verify3x3(int[][] candidateSolution) {		
		
		for(int row=0; row<9; row+=3){
			for(int column=0; column<9; column+=3){
				BitSet block = new BitSet(9);
				for(int i=row; i<row+3; i++){
					for(int j=column; j<column+3; j++){
						if(block.get(candidateSolution[i][j]-1))
							return 1;
						else 
							block.set(candidateSolution[i][j]-1);
					}	
				}
			}
		}
		return 0;
	}
}
