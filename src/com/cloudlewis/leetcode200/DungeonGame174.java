package com.cloudlewis.leetcode200;

/**
 * https://leetcode.com/problems/dungeon-game/#/description
 * 
 * @author xiao
 *
 */

// this sounds like a standard dp problem?! - easy? why hard?
// the problem is those positive numbers

// @formatter:off
// becuase of the negative number, cannot use Dijkstra
// try to Bellman-Ford, which can handle negatvie
// https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm
// Bellman–Ford runs in  O(|V| * |E|)} time, where  |V| and |E| are the number of vertices and edges respectively.
// @formatter:on

public class DungeonGame174 {
	public int calculateMinimumHPwithDP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0)
			return 0;

		int m = dungeon.length;
		int n = dungeon[0].length;

		int[][] health = new int[m][n];
		health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
		// to survive, either 1, or 1 + dugeon if negative
		// from destination back to origin, intialize the two edge, right and
		// bottom
		for (int i = m - 2; i >= 0; i--)
			health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
		for (int i = n - 2; i >= 0; i--)
			health[m - 1][i] = Math.max(health[m - 1][i + 1] - dungeon[m - 1][i], 1);
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				health[i][j] = Math.min(Math.max(health[i][j + 1] - dungeon[i][j], 1),
						Math.max(health[i + 1][j] - dungeon[i][j], 1));
			}
		}
		return health[0][0];
	}
	
	public static void main(String [] args) {
		DungeonGame174 t= new DungeonGame174();
		int [][] dungeon = new int[][] {{-2,-3,3},{-5,-10,1}, {10,30,-5}};
		System.out.println(t.calculateMinimumHPwithDP(dungeon));
	}
}
