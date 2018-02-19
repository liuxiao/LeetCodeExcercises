package com.cloudlewis.leetcode100;

/**
 * 
 * @formatter:off
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * 
 * @formatter:on
 * @author xiao
 *
 */

// Solution 1 is from question #95, but hit timelimit error when trying 19
// no problem running in eclipse, takes a little while

// Solution 2 using DP
// https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i

public class UniqueBinarySearchTrees96 {
	public int numTrees(int n) {
		return gen(1, n);
	}
	
	public int numTreesDP(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		if ( n <= 1)
			return dp[n];
		for(int i=2; i<= n; i++) {
			for (int j=1;j<=i;j++) {
				dp[i] += dp[i-j] * dp[j-1];
			}
		}
		return dp[n];
	}

	// !!! Time Limit Exceeded
	private int gen(int start, int end) {
		if (start > end)
			return 0;
		else if (start == end) {
			return 1;
		}
		int local = 0;
		for (int i = start; i <= end; i++) {
			int l = gen(start, i - 1);
			int r = gen(i + 1, end);
			if (l > 0 && r > 0)
				local += l * r;
			else if (l > 0)
				local += l;
			else
				local += r;
		}
		return local;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees96  t = new UniqueBinarySearchTrees96();
		System.out.println(t.numTrees(19));
		System.out.println(t.numTreesDP(19));
		System.out.println(t.numTrees(3));
		System.out.println(t.numTreesDP(3));
	}
}
