package com.cloudlewis.leetcode150;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * @author xiao
 *
 */

// !!! REVISIT

/*
 * @formatter:off
 * 
 * first time solve this problem failed, because getting the wrong thinking to find two biggest up slope.
 * in fact, you can combine two slope together to have a bigger one
 * 
 * !!! IMPORTANT 
 * Generalized pattern for any given k:
 * dp[k, i] represents the max profit up until prices[i] (Note: NOT ending with prices[i]) using at most k transactions. 
 * dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j]) { j in range of [0, i-1] } -- last is the big, or a new one
 *          = max(dp[k, i-1], prices[i] + max(dp[k-1, j] - prices[j]))
 * dp[0, i] = 0; 0 times transation makes 0 profit
 * dp[k, 0]  = 0; if there is only one price data point you can't make any money no matter how many times you can trade
 * 
 * https://discuss.leetcode.com/topic/4766/a-clean-dp-solution-which-generalizes-to-k-transactions
 * 
 * @formatter:on
 */
public class BestTimetoBuyandSellStockIII123 {
	
	public int maxProfit(int[] prices) {
		if (prices.length < 2)
			return 0;
		int kk = 2;
		int[][] dp = new int[kk + 1][prices.length]; // no need to init edge, all 0 both case
		for (int k = 1; k <= kk; k++) {
			int jTempMax = dp[k-1][0] - prices[0];
			for (int i =1; i< prices.length; i++) {
				dp[k][i] = Math.max(dp[k][i-1], prices[i] + jTempMax);
				jTempMax = Math.max(jTempMax, dp[k-1][i] - prices[i]);
			}
		}
		return dp[kk][prices.length - 1];
	}
	
	// this answer is wrong, because thinking was wrong !
	// not calculating the big slope, because you can keep it for small down turn
    public int maxProfitWrong(int[] prices) {
    	int max1 = 0, max2 = 0, curr = 0, i =0;
    	while(i < prices.length - 1) {
    		while (i +1 < prices.length && prices[i + 1] > prices[i])
    			i++;
    		int gain = prices[i] - prices[curr]; // harvest
    		if (gain > max1 || gain > max2) {
    			if (max1 > max2)
    				max2 = gain;
    			else
    				max1 = gain;
    		}
    		i++;
    		curr = i;
    	}
    	return max1 + max2;
    }
    
    public static void main(String[] agrs) {
    	BestTimetoBuyandSellStockIII123 t = new BestTimetoBuyandSellStockIII123();
    	System.out.println(t.maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0}));
    }
}
