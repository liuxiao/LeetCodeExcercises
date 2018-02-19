package com.cloudlewis.leetcode200;

/**
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author xialiliu
 *
 */

// !!! REVISIT

// this is like a DFS, with a carried path and global max to update
// figured we don't need th path at all? just keep current sum
public class HouseRobber198 {

	public int rob(int[] nums) {
		int a = 0;
		int b = 0;
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				a = Math.max(a + nums[i], b);
			else
				b = Math.max(a, b + nums[i]);
		}

		return Math.max(a, b);
	}

	public int robWithDP(int[] num) {
		int[][] dp = new int[num.length + 1][2];
		for (int i = 1; i <= num.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
			dp[i][1] = num[i - 1] + dp[i - 1][0];
		}
		return Math.max(dp[num.length][0], dp[num.length][1]);
	}
	// dp[i][1] means we rob the current house and dp[i][0] means we don't,

	// so it is easy to convert this to O(1) space

	public int robWithDPO1(int[] num) {
		int prevNo = 0;
		int prevYes = 0;
		for (int n : num) {
			int temp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = n + temp;
		}
		return Math.max(prevNo, prevYes);
	}
	
	public int rob(int[] num, int lo, int hi) {
	    int include = 0, exclude = 0;
	    for (int j = lo; j <= hi; j++) {
	        int i = include, e = exclude;
	        include = e + num[j];
	        exclude = Math.max(e, i);
	    }
	    return Math.max(include, exclude);
	}
}
