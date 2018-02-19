package com.cloudlewis.leetcode50;

import java.util.HashSet;
import java.util.Set;

/**
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'. Note: A valid Sudoku board (partially filled) is not
 * necessarily solvable. Only the filled cells need to be validated. 9*9 plane
 * 3*3 small block
 * 
 * @author xiao
 *
 */
public class ValidSudoku36 {
	public boolean isValidSudoku(char[][] board) {
		Set<Character> set = new HashSet<Character>();
		// scan horizontal
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (set.contains(c))
					return false;
				if (c != '.')
					set.add(board[i][j]);
			}
			set.clear();
		}

		set.clear();
		// scan vertical
		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length; i++) {
				char c = board[i][j];
				if (set.contains(c))
					return false;
				if (c != '.')
					set.add(board[i][j]);
			}
			set.clear();
		}

		set.clear();
		// scan 3*3 block
		for (int i = 0; i < board.length; i += 3) {
			for (int j = 0; j < board[0].length; j += 3) {
				for (int m = i; m < i + 3; m++) {
					for (int n = j; n < j + 3; n++) {
						char c = board[m][n];
						if (set.contains(c))
							return false;
						if (c != '.')
							set.add(board[m][n]);
					}
				}
				set.clear();
			}
			set.clear();
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] n = new int[5][3];
		System.out.println(n.length);
		System.out.println(n[0].length);
	}
}
