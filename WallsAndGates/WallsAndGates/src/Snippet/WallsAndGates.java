package Snippet;

public class WallsAndGates {

	public int[][] getGates(int [][] mat){
		
		for(int row=0;row<mat.length;row++){
			for(int col=0;col<mat[0].length;col++){
				if(mat[row][col] == Integer.MAX_VALUE){
					DFS(mat, row, col);
				}
			}
		}
		return mat;
	}
	
	private int DFS(int[][] mat, int row, int col){
		if(row<0 || row>=mat.length){
			return Integer.MAX_VALUE;
		}
		if(col<0 || col >=mat[0].length){
			return Integer.MAX_VALUE;
		}
		if(mat[row][col] == -1){
			return Integer.MAX_VALUE;
		}
		if(mat[row][col] == 0){
			return 1;
		}
		if(mat[row][col] != Integer.MAX_VALUE){//Visited
			if(mat[row][col] == Integer.MIN_VALUE){ return Integer.MAX_VALUE; }
			else{ return mat[row][col]+1; }
		}
		mat[row][col] = Integer.MIN_VALUE;
		int d1 = DFS(mat, row+1, col);
		int d2 = DFS(mat, row-1, col);
		int d3 = DFS(mat, row, col+1);
		int d4 = DFS(mat, row, col-1);
		int minD = Math.min(Math.min(d1, d2), Math.min(d3, d4));
		mat[row][col] = minD;
		return minD==Integer.MAX_VALUE?Integer.MAX_VALUE:minD+1;
	}
	
	
	public static void main(String args[]){
		int[][]mat= new int[][]{
			{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
			{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
			{0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
		};
		
		int[][] d = new WallsAndGates().getGates(mat);
		for(int row[]: d){
			for(int i: row){
				System.out.print(i+" | ");
			}
			System.out.println();
		}
	}
}