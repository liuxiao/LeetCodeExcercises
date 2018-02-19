package com.cloudlewis.leetcode50;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * Empty cells are indicated by the character '.'.
 * 
 * You may assume that there will be only one unique solution.
 * 
 * @author xiao
 *
 */

// asking if a solution is guaranteed or not

// solution 1. reuse the utility func, isValid
// try each every number, if failed, trace back O(n *n *10) complexity, valid
// will go
// through every cell, and try on every cell

public class SudokuSolver37 {
	
	ValidSudoku36 v = new ValidSudoku36(); 
	
	public void solveSudoku(char[][] board) {
		int len = board.length;
		for (int i=0;i<len;i++) {
			for (int j =0; j<len;j++) {
				if (board[i][j] == '.') {
					for (char t = '0'; t<='9';t++ ){
						board[i][j] = t;
						if (v.isValidSudoku(board))
							solveSudoku(board);
						else
							board[i][j] = '.'; // not solvable, set back to .
					}
				}
			}
		}
	}
}
