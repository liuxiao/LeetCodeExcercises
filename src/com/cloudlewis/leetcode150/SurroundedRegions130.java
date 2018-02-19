package com.cloudlewis.leetcode150;

/**
 * 
 * @formatter:off
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * After running your function, the board should be:
 *  
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * @formatter:on
 * @author xiao
 *
 */

// @formatter:off
// we perform check row by row with two for loop;
// if we hit one space, 
//    if left or top is not filled, continue
//    else we get in another loop, right and down only;
//         if we find it is closed; fill it
//    
// @formatter:on
public class SurroundedRegions130 {
	
	// !!! THIS IS a GOOD way to solve problem, but cannot rely on
	// same data, hard to find boundry sections;
	public void solve(char[][] board) {
		int rows = board.length;
		if (rows < 3)
			return;
		int cols = board[0].length;
		if (cols < 3)
			return;
		for (int i = 1; i < rows - 1; i++) { // no need to check O on edges
			for (int j = 1; j < cols - 1; j++) {
				// this condition makes sure we only look at most top left; if O
				// on edge, left it
				if (board[i][j] == 'O' && board[i - 1][j] != 'O' && board[i][j - 1] != 'O') {
					if (isClosedArea(board, i, j))
						fillArea(board, i, j);
				}
			}
		}
	}

	// because we always search from most left and top, then they just have to
	// be X
	private boolean isClosedArea(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		if (board[i][j] == 'X')
			return true;
		if (board[i-1][j] == 'O' || board[i][j-1]== 'O') 
			return false; // check edges, they cannot be 'O'
		return isClosedArea(board, i + 1, j) && isClosedArea(board, i, j + 1);
	}

	private void fillArea(char[][] board, int i, int j) {
		if (board[i][j] == 'X')
			return;
		else
			board[i][j] = 'X';
		fillArea(board, i + 1, j);
		fillArea(board, i, j + 1);

	}

	// ----------------------------

	public void solveWith2Pass(char[][] board) {
		int w = board.length;
		if (w == 0)
			return;
		int h = board[0].length;
		if (h == 0)
			return;
		// scanning edages
		for (int i = 0; i < w; i++) {
			if (board[i][0] == 'O')
				maskArea(board, i, 0, w, h);
			if (board[i][h - 1] == 'O')
				maskArea(board, i, h - 1, w, h);
		}
		for (int i = 0; i < h; i++) {
			if (board[0][i] == 'O')
				maskArea(board, 0, i, w, h);
			if (board[w - 1][i] == 'O')
				maskArea(board, w - 1, i, w, h);
		}
		// one pass, change mask to 'O' and 'O' to 'X'
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (board[j][i] == 'O')
					board[j][i] = 'X';
				if (board[j][i] == 'M')
					board[j][i] = 'O';
			}
		}
	}

	public void maskArea(char[][] board, int x, int y, int w, int h) {
		if (board[x][y] == 'O') {
			board[x][y] = 'M';
			// current is 0, then extends
			if (x + 1 < w)
				maskArea(board, x + 1, y, w, h);
			if (y + 1 < h)
				maskArea(board, x, y + 1, w, h);
			if (x - 1 > 0)
				maskArea(board, x - 1, y, w, h);
			if (y - 1 > 0)
				maskArea(board, x, y - 1, w, h);
		}
	}

	public static void main(String[] args) {
		char[][] b = new char[][] { { 'O', 'X', 'O', 'O', 'X', 'X' }, { 'O', 'X', 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'O', 'X', 'O', 'O' }, { 'X', 'O', 'X', 'X', 'X', 'X' }, { 'O', 'O', 'X', 'O', 'X', 'X' },
				{ 'X', 'X', 'O', 'O', 'O', 'O' } };
		char[][] bb = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		SurroundedRegions130 t = new SurroundedRegions130();
		t.solve(b);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}
}
