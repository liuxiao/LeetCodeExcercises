package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

import com.cloudlewis.leetcode.common.Util;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both 
 * indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 *
 * @formatter:off
 * [
 * [".Q..",  // Solution 1
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *  "Q...",
 *  "...Q",
 *  ".Q.."]
 * ]
 *
 * @formatter:on
 * @author xiao
 *
 */
public class NQueens51 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> list = new ArrayList<>();
		char[][] map = new char[n][n];
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++)
				map[i][j] = '.';
		}
		// using back tracing way
		solve(map, n, 0, list);
		return list;
	}

	private void solve(char[][] map, int n, int row, List<List<String>> list) {
		if (row == n) {
			// found solution
			// if (isValid(map)) no need to validate here, because previously is
			// done
			addSolution(map, list);
			return;
		}
		for (int i = 0; i < n; i++) {

			// point / optimazation is we don't need to check entire, but only
			// current
			if (isValid(map, row, i, n)) {// !!!!! i was using the bad isValid
											// function;
				map[row][i] = 'Q';
				solve(map, n, row + 1, list);
				map[row][i] = '.';
			}
		}
	}

	private void addSolution(char[][] map, List<List<String>> list) {
		for (int i = 0; i < map.length; i++) {
			List<String> line = new ArrayList<String>();
			line.add(String.valueOf(map[i]));
			list.add(line);
		}
	}

	private boolean isValid(char[][] map, int row, int col, int n) {
		// check if the column had a queen before.
		for (int i = 0; i != row; ++i)
			if (map[i][col] == 'Q')
				return false;
		// check if the 45° diagonal had a queen before.
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j)
			if (map[i][j] == 'Q')
				return false;
		// check if the 135° diagonal had a queen before.
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j)
			if (map[i][j] == 'Q')
				return false;
		return true;
	}

	// bad implemenation
	@SuppressWarnings("unused")
	private boolean badisValid(boolean[][] map) {
		// horizonal
		boolean line = false;
		int n = map.length; // square
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] && line)
					return false;
				else if (map[i][j] == true)
					line = true;
			}
			line = false;
		}

		// vertical
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[j][i] && line)
					return false;
				else if (map[j][i] == true)
					line = true;
			}
			line = false;
		}

		// diagonal, lower half
		for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
			if (map[i][j] && line)
				return false;
			else if (map[i][j] == true)
				line = true;
			line = false;
		}

		// diagonal, top half
		for (int i = 0, j = 0; i < n && j < n; i++, j++) {
			if (map[i][j] && line)
				return false;
			else if (map[i][j] == true)
				line = true;
			line = false;
		}

		return true;
	}

	public static void main(String[] args) {
		NQueens51 t = new NQueens51();
		Util.printListList(t.solveNQueens(4));
	}
}
