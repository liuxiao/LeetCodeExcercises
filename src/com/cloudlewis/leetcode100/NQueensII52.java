package com.cloudlewis.leetcode100;

/**
 * Follow up for N-Queens problem.
 * 
 * Now, instead outputting board configurations, return the total number of
 * distinct solutions.
 * 
 * @author xiao
 *
 */
public class NQueensII52 {
	public int totalNQueens(int n) {
		int[] total = new int[1];
		boolean[][] map = new boolean[n][n];
		placeOnRow(map, n, 0, total);
		return total[0];
	}

	private void placeOnRow(boolean[][] map, int n, int p, int[] total) {
		if (p >= n) { // find solution
			total[0]++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isValid(map, p, i, n)) {
				map[p][i] = true;
				placeOnRow(map, n, p + 1, total);
				map[p][i] = false;
			}
		}
	}

	private boolean isValid(boolean[][] map, int row, int col, int n) {
		// check if the column had a queen before.
		for (int i = 0; i != row; ++i)
			if (map[i][col] == true)
				return false;
		// check if the 45° diagonal had a queen before.
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j)
			if (map[i][j] == true)
				return false;
		// check if the 135° diagonal had a queen before.
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j)
			if (map[i][j] == true)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		NQueensII52 t = new NQueensII52();
		System.out.println(t.totalNQueens(5));
	}
}
