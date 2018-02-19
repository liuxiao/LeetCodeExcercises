package com.cloudlewis.leetcode50;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up: Could you do this in-place?
 * 
 * @author xiao
 *
 */


public class RotateImage48 {
	public void rotate(int[][] matrix) {
		// exchange x and y
        int n = matrix.length;
        int odd = n%2;
        int scanSize = n/2;
        for (int i=0; i< scanSize + odd; i++) {
            for (int j=0; j< scanSize; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
	}
}
