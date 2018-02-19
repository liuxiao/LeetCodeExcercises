package com.cloudlewis.leetcode100;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * @formatter:off
 * 
 * 
 * Follow up: 
 * Did you use extra space? 
 * A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * 
 * @formatter:on
 * @author xiao
 *
 */

// extra space is easy, scan one, store in array; scan second time and set zeros

// constant space can be cheated by using a number in binary format
// MAXINT is 32 bits, but not big enough

// or cheat to set value to MIN_INT, but might be a valid value in matrix

// key idea is if the row is about to set zero, then it does not matter to use it

public class SetMatrixZeroes73 {
	public void setZeroes(int[][] matrix) {
		int col0 = 1, rows = matrix.length, cols = matrix[0].length;
		for (int i=0; i<rows; i++) {
			if (matrix[i][0] == 0 )
				col0 = 0;
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 0)
					matrix[i][0] = matrix[0][j] = 0;
			}
		}
		// 2nd pass
		for (int i = rows -1 ; i>=0 ; i--) {
			for (int j= cols -1 ; j>=0;j--) {
				if (matrix[i][0] == 0 || matrix[0][j] ==0 )
					matrix[i][j] = 0;
			}
			if (col0 == 0)
				matrix[i][0] = 0;
		}
	}
}
