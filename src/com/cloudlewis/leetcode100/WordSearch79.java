package com.cloudlewis.leetcode100;

/**
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * @formatter:off
 * [
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @formatter:on
 * @author xiao
 *
 */

// DFS?

/*
 * solution can be shorten and optimized
 */

public class WordSearch79 {
	public boolean exist(char[][] board, String word) {
		int rows = board.length;
		if (rows == 0)
			return false;
		int cols = board[0].length;
		if (cols == 0)
			return false;
		if (word.isEmpty())
			return false;
		char[] words = word.toCharArray();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boolean[][] fp = new boolean[rows][cols];
				if (search(board, words, i, j, 0, fp))
					return true;
			}
		}
		return false;
	}

	// must have a step, and make sure we do not reuse element
	private boolean search(char[][] board, char[] words, int locx, int locy, int step, boolean[][] fp) {
		int len = words.length;
		int rows = board.length;
		int cols = board[0].length;
		if (board[locx][locy] == words[step]) {
			if (step == len - 1)
				return true;
			boolean found = false;
			fp[locx][locy] = true;
			if (locx - 1 >= 0 && !fp[locx - 1][locy]) {
				found = found || search(board, words, locx - 1, locy, step + 1, fp);
			}
			if (locy - 1 >= 0 && !fp[locx][locy - 1]) {
				found = found || search(board, words, locx, locy - 1, step + 1, fp);
			}

			if (locx + 1 < rows && !fp[locx + 1][locy]) {
				found = found || search(board, words, locx + 1, locy, step + 1, fp);
			}

			if (locy + 1 < cols && !fp[locx][locy + 1]) {
				found = found || search(board, words, locx, locy + 1, step + 1, fp);
			}
			fp[locx][locy] = false;
			return found;
		} else
			return false;

	}

	public static void main(String[] args) {
		WordSearch79 t = new WordSearch79();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(t.exist(board, "ABCCED"));
		System.out.println(t.exist(board, "SEE"));
		System.out.println(t.exist(board, "ABCB"));
		
		char[][] ba = {{'A','B', 'C', 'E'},{'S','F','E','S'},{'A','D','E','E'}};
		System.out.println(t.exist(ba, "ABCESEEEFS"));
				
	}
	
}
