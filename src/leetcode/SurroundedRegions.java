package leetcode;

import java.util.*;

public class SurroundedRegions {

public LinkedList<Integer> queue = new LinkedList<Integer>();
    
    public void solve(char[][] board) {
        
        if(board.length == 0) return ;
        
        int row = board.length, col = board[0].length;
        
        // judge whether there are Os in the first row and last row, if have, mark as #
        for(int i = 0; i < col; i++){
            bfs(board,0,i);
            bfs(board,row-1,i);
        }
        
        // judge whether there are Os in the first column and last column, if have, mark as #
        for(int j = 0; j < row; j++){
            bfs(board,j,0);
            bfs(board,j,col-1);
        }
        
        // at this time, all the Os which will not be replaced as X have been marked
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    
    public void bfs(char[][] board, int row, int col){
        int columnlen = board[0].length; // used to get the postion of board[row][col]
        
        fillCell(board,row,col);
        
        while(!queue.isEmpty()){
            int position = queue.poll();
            
            int x = position/columnlen, y = position%columnlen;
            
            fillCell(board,x+1,y);
            fillCell(board,x-1,y);
            fillCell(board,x,y+1);
            fillCell(board,x,y-1);
        }
    }
    
    public void fillCell(char[][] board,int row,int col){
        int rowlen = board.length, columnlen = board[0].length;
        
        if(row < 0 || row >= rowlen || col < 0 || col >= columnlen || board[row][col] != 'O')
            return ;
            
        queue.add(row*columnlen+col);
        board[row][col] = '#';
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'X','X','X','X'},{'X','O','O','X'},
				{'X','X','O','X'},{'X','O','X','X'}};
		
		new SurroundedRegions().solve(matrix);
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println();
		}
	}

}
