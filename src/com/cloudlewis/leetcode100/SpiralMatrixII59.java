package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.Util;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * @formatter:off
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * @formatter:on
 * @author xiao
 *
 */

// solution 1. use direction point to go through spiral

// solution 2. find math pattern and just to allocate each location
public class SpiralMatrixII59 {
	public int[][] generateMatrix(int n) {
		int[][] map = new int[n][n];
		if (n == 0)
			return map;
		int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
		int num = 1;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			for (int i = colBegin; i <= colEnd; i++)
				map[rowBegin][i] = num++;

			rowBegin++;

			for (int i = rowBegin; i <= rowEnd; i++)
				map[i][colEnd] = num++;

			colEnd--;

			if (rowBegin <= rowEnd) {
				for (int i = colEnd; i >= colBegin; i--)
					map[rowEnd][i] = num++;
			}
			rowEnd--;

			if (colBegin < colEnd) {
				for (int i = rowEnd; i >= rowBegin; i--)
					map[i][colBegin] = num++;
			}
			colBegin++;
		}
		return map;
	}
	
	public static void main(String []args) {
		SpiralMatrixII59 t = new SpiralMatrixII59();
		Util.printArrayArray(t.generateMatrix(3));
		Util.printArrayArray(t.generateMatrix(5));
	}
}
