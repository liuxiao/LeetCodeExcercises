package com.cloudlewis.leetcode200;

/**
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 *
 * @formatter:off
 * Example 1:
 * 
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * 
 * @formatter:on
 * @author xiao
 *
 */

// no one said cannot change the original data
// if so , we can do a clone
// idea is to check on each cell, if the cell is 1, then it will be an island
// for sure, because whole thing is surrounded by water, we jsut need to call
// another subroutine to flip all 1's to 0

public class NumberofIslands200 {
	public int numIslands(char[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int num = 0;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					num++;
					discoverland(grid, i, j);
				}
			}
		}
		return num;
	}

	private void discoverland(char[][] grid, int i, int j) {
		grid[i][j] = 'X';
		if (i + 1 < grid.length && grid[i + 1][j] == '1')
			discoverland(grid, i + 1, j);
		if (j + 1 < grid[0].length && grid[i][j + 1] == '1')
			discoverland(grid, i, j + 1);
		if (i - 1 >= 0 && grid[i - 1][j] == '1')
			discoverland(grid, i - 1, j);
		if (j - 1 >= 0 && grid[i][j - 1] == '1')
			discoverland(grid, i, j - 1);
	}

	public static void main(String[] args) {
		NumberofIslands200 t = new NumberofIslands200();
		char[][] grid1 = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		char[][] grid2 = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		System.out.println(t.numIslands(grid1));
		System.out.println(t.numIslands(grid2));
	}
}
