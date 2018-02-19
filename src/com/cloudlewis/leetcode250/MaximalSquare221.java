package com.cloudlewis.leetcode250;

/**
 * @formatter:off
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 
 * Return 4.
 * 
 * @formatter:on
 * @author xiao
 *
 */

// asking if ok to change the content of the matrix
// go with ok
// !!! REVISIT

/*
 * Top, Left, and Top Left decides the size of the square. If all of them are
 * same, then the size of square increases by 1. If they're not same, they can
 * increase by 1 to the minimal square.
 */
public class MaximalSquare221 {

	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length, result = 0;
		int[][] b = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
					result = Math.max(b[i][j], result); // update result
				}
			}
		}
		return result * result;
	}
}
