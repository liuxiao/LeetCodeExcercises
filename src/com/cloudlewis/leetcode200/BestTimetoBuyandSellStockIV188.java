package com.cloudlewis.leetcode200;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author xiao
 *
 */

// !!! REVISIT

// find local max, k of them
// ideally find all upward interval into a set
// and sort them, and merge for max until size of set is equal to k

// https://discuss.leetcode.com/topic/8984/a-concise-dp-solution-in-java
// can using DP
// tmpMax = Math.max(tmpMax, t[i - 1][j-1] - prices[j]); 
//
// tmpMax means the maximum profit of just doing at most i-1 transactions, using
// at most first j-1 prices, and buying the stock at price[j] - this is used for
// the next loop.

/* @formatter:off
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 * @formatter:on
 */

public class BestTimetoBuyandSellStockIV188 {
	public int maxProfit(int k, int[] prices) {
		if (k > prices.length / 2)
			return harvestAll(prices);
		int len = prices.length;
		int[][] dp = new int[k + 1][len];
		int lmax = 0;
		for (int i = 1; i < k; i++) {
			lmax = -prices[0];
			for (int j = 1; j < len; j++) {
				dp[i][j] = Math.max(dp[i][j-1], prices[j] + lmax); // current price might be smaller
				lmax = Math.max(lmax, dp[i-1][j-1] - prices[j]);
			}
		}
		return dp[k][len-1];
	}

	// need to harvest every uptrend
	private int harvestAll(int[] prices) {
		int sum = 0;
		for (int i = 0; i < prices.length - 1; i++)
			sum += (prices[i + 1] - prices[i] > 0) ? prices[i + 1] - prices[i] : 0;
		return sum;
	}
}
