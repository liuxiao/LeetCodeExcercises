package com.cloudlewis.leetcode100;

/**
 * 
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 *
 * @formatter:off
 * Consider the following matrix:
 *
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * @formatter:on
 * @author xiao
 *
 */

// using binary search to determine row, and then col O(logN) *2 

public class Searcha2DMatrix74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		if (rows == 0) return false;
		int cols = matrix[0].length;
		if (cols == 0)
			return false;
		int row = findRow(matrix, rows, cols, target);
		if (row == -1)
			return false;
		return findCol(matrix, row, cols, target);
	}
	
	private int findRow(int[][] matrix, int rows, int cols, int target) {
		int start = 0, end = rows - 1;
		while( start <= end) {
			int mid = start + (end -start) /2;
			if (matrix[mid][cols-1] < target) // greater than the biggest on this row
				start = mid + 1;
			else if (matrix[mid][0] > target)
				end = mid - 1;
			else
				return mid;
		}
		return -1;
	}
	
	private boolean findCol(int[][] matrix, int row,  int cols, int target) {
		int start = 0, end = cols - 1;
		while( start <= end) {
			int mid = start + (end -start) /2; // tend to smaller
			if (matrix[row][mid] == target)
				return true;
			else if (matrix[row][mid] < target)
				start = mid + 1;
			else {
				end = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Searcha2DMatrix74 t = new Searcha2DMatrix74();
		 int [][] m = {{1,   3,  5,  7}, {10, 11, 16, 20},{23, 30, 34, 50}};
		 System.out.println(t.searchMatrix(m, 2));
	}
}
