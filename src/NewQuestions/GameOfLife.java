package NewQuestions;

public class GameOfLife {
	private int max_x;
	private int max_y;
	
	public void gameOfLife(int[][] board) {
	    max_x = board.length - 1;
	    max_y = board[0].length - 1;
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[i].length; j++) {
	            applyRule(board, i, j, countOfLive(board, i, j));
	        }
	    }
	
	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[i].length; j++) {
	            if (board[i][j] == 2) {
	                board[i][j] = 1;
	            }
	            if (board[i][j] == -1) {
	                board[i][j] = 0;
	            }
	        }
	    }
	}
	
	
	private int countOfLive(int[][] board, int x, int y) {
	    int count = 0;
	    if (x - 1 >= 0) {
	        if (isLive(board[x - 1][y])) {
	            count++;
	        }
	        if (y - 1 >= 0) {
	            if (isLive(board[x - 1][y - 1])) {
	                count++;
	            }
	        }
	        if (y + 1 <= max_y) {
	            if (isLive(board[x - 1][y + 1])) {
	                count++;
	            }
	        }
	    }
	
	    if (x + 1 <= max_x) {
	        if (isLive(board[x + 1][y])) {
	            count++;
	        }
	        if (y - 1 >= 0) {
	            if (isLive(board[x + 1][y - 1])) {
	                count++;
	            }
	        }
	        if (y + 1 <= max_y) {
	            if (isLive(board[x + 1][y + 1])) {
	                count++;
	            }
	        }
	    }
	
	    if (y - 1 >= 0) {
	        if (isLive(board[x][y - 1])) {
	            count++;
	        }
	    }
	
	    if (y + 1 <= max_y) {
	        if (isLive(board[x][y + 1])) {
	            count++;
	        }
	    }
	
	
	    return count;
	}
	
	private void applyRule(int[][] board, int x, int y, int count) {
	    int life = board[x][y];
	    if (life == 1) {
	        if (count < 2 || count > 3) {
	            board[x][y] = -1;
	        }
	    }
	    if (life == 0) {
	        if (count == 3) {
	            board[x][y] = 2;
	        }
	    }
	
	}
	
	
	//-1 is for live->dead, 2 is for dead -> live
	private boolean isLive(int life) {
		if (life == 1 || life == -1) {   // -1代表之前是1的状态，但是现在死了
		    return true;
		} else {
		    return false;
		}
	}
}
