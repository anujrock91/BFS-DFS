package Snippet;

public class SurroundedRegions {
	
	
	public char[][] surround(char mat[][]){
		int rows = mat.length;
		int cols = mat[0].length;
		//Scanning the top and bottom rows
		for(int col=0;col<mat[0].length;col++){
			if(mat[0][col] == '0'){	DFS(0, col, mat); }
			if(mat[rows-1][col] == '0'){ DFS(rows-1, col, mat); }
		}
		
		//scanning the right and left columns
		for(int row = 0;row<mat.length;row++){
			if(mat[row][0] == '0'){ DFS(row, 0, mat); }
			if(mat[row][cols-1] == '0'){ DFS(row, cols-1, mat); }
		}
		
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(mat[i][j] == '0'){ mat[i][j] = 'X'; }
				if(mat[i][j] == '#'){ mat[i][j] = '0'; }
			}
		}
		
		return mat;
	}
	
	
	public void DFS(int row, int col, char [][] mat){
		if(row<0 || row>=mat.length){
			return;
		}
		if(col<0 || col>=mat[0].length){
			return;
		}
		if(mat[row][col] == 'X'){
			return;
		}
		if(mat[row][col] == '#'){ 
			return; 
		}
		mat[row][col] = '#';
		DFS(row+1,col, mat);
		DFS(row-1,col, mat);
		DFS(row,col+1, mat);
		DFS(row,col-1, mat);
		
	}
	
	
	public static void main(String args[]){
		char[][] mat = new char[][]{
		{'X', 'X', 'X', 'X'},
		{'X', '0', '0', 'X'},
		{'X', 'X', '0', 'X'},
		{'X', '0', 'X', 'X'}};
		
		mat = new SurroundedRegions().surround(mat);
		for(char row[] : mat){
			for(char i: row){
				System.out.print( i + " | ");
			}
			System.out.println();
		}
	}
	
	
}
