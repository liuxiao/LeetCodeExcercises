package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 * @formatter:off
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * @formatter:on
 * @author xiao
 *
 */

// cannot make assumption that matrix is a square, it is explicitly said m x n

public class SpiralMatrix54 {

	// d is actually redundant here, can be removed
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int n = matrix.length;
		if (n == 0)
			return list;
		int m = matrix[0].length;
		if (m == 0)
			return list;
		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;

		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			// right
			for (int i = colBegin; i <= colEnd; i++)
				list.add(matrix[rowBegin][i]);
			rowBegin++;

			// down
			for (int i = rowBegin; i <= rowEnd; i++)
				list.add(matrix[i][colEnd]);
			colEnd--;

			// left
			if (rowBegin <= rowEnd) { // need this, otherwise case #2 failed
				for (int i = colEnd; i >= colBegin; i--)
					list.add(matrix[rowEnd][i]);
			}
			rowEnd--;

			// up
			if (colBegin <= colEnd) { // need this, otherwise case #2 failed
				for (int i = rowEnd; i >= rowBegin; i--)
					list.add(matrix[i][colBegin]);
			}
			colBegin++;
		}
		return list;
	}

	// [ 1, 2, 3 ]
	// [ 4, 5, 6 ]
	// [ 7, 8, 9 ]
	public static void main(String[] args) {
		SpiralMatrix54 t = new SpiralMatrix54();
		int[][] c = new int[2][1];
		c[0][0] = 2;
		c[1][0] = 3;
		System.out.println(t.spiralOrder(c));

		// #case 2
		int[][] s = new int[1][2];
		s[0][0] = 2;
		s[0][1] = 3;
		System.out.println(t.spiralOrder(s));

		int[][] m = new int[3][3];
		m[0][0] = 1;
		m[1][0] = 2;
		m[2][0] = 3;
		m[0][1] = 4;
		m[1][1] = 5;
		m[2][1] = 6;
		m[0][2] = 7;
		m[1][2] = 8;
		m[2][2] = 9;
		System.out.println(t.spiralOrder(m));

	}
}
