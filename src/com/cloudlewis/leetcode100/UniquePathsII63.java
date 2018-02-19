package com.cloudlewis.leetcode100;

/**
 * 
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * @formatter:off
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 * @formatter:on
 * @author xiao
 *
 */

// sounds like the same as previous question, but everytime when we consult, we
// can derive a zero

public class UniquePathsII63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int [][] map = new int [m][n];
		if (obstacleGrid[0][0] == 1)
			return 0;
		map[0][0] = 1; // first cannot be obsatle otherwise, it will die
		for (int i=1; i< m; i++) {
			if (obstacleGrid[i][0] != 1) //not ob, then copy
				map[i][0] = map[i-1][0];
			else // once ob, entire row is 0 after
				map[i][0] = 0;
		}
		for (int i=1; i<n ; i ++) {
			if (obstacleGrid[0][i] != 1)
				map[0][i] = map[0][i-1];
			else
				map[0][i] = 0;
		}
		for (int i = 1; i<m; i++) {
			for (int j= 1; j<n ;j++) {
				if (obstacleGrid[i][j] == 1)
					map[i][j] = 0;
				else
					map[i][j] = map[i][j-1] + map[i-1][j];
			}
		}
		return map[m-1][n-1];
	}
	
	public static void main(String[] args) {
		UniquePathsII63 t= new UniquePathsII63();
		int [][] obstacleGrid= new int[][] {{0,0,0}, {0,1,0}, {0,0,0}};
		System.out.println(t.uniquePathsWithObstacles(obstacleGrid));
	}
}
