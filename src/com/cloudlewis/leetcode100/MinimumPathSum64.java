package com.cloudlewis.leetcode100;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * @author xiao
 *
 */

// standard dp problem, easy
// think again, can i do it in place? yes, i think i can

public class MinimumPathSum64 {
	public int minPathSum(int[][] grid) {
		// do the edge first
		for (int i=1; i<grid.length; i++) 
			grid[i][0] += grid[i-1][0];
		for (int i=1; i<grid[0].length; i++)
			grid[0][i] += grid[0][i-1];
		
		for (int i=1; i<grid.length; i++) {
			for (int j=1; j<grid[0].length; j++)
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
		}
		
		return grid[grid.length -1][grid[0].length-1];
	}
	
	public static void main(String []agrs) {
		MinimumPathSum64 t = new MinimumPathSum64();
		int[][] grid = new int[][] {{1,2,5},{3,2,1}};
		int [][] grid1 = new int[][] {{1,2},{5,6},{1,1}};
		System.out.println(t.minPathSum(grid));
		System.out.println(t.minPathSum(grid1));
	}
}
