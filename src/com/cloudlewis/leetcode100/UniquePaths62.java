package com.cloudlewis.leetcode100;

/**
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * @author xiao
 *
 */

// very simple dp question; init array, edge has only one move

public class UniquePaths62 {
	public int uniquePaths(int m, int n) {
		int [][] map = new int [m][n];
		for (int i=0; i< m; i++)
			map[i][0] = 1;
		for (int i=0; i<n ; i ++)
			map[0][i] = 1;
		for (int i = 1; i<m; i++) {
			for (int j= 1; j<n ;j++) {
				map[i][j] = map[i][j-1] + map[i-1][j];
			}
		}
		return map[m-1][n-1];
	}
}
