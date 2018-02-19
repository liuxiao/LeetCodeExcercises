package com.cloudlewis.leetcode100;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Note: Given n will be a positive integer.
 * 
 * @author xiao
 *
 */

// looks like to be easy question - positive integer, will not be 0
// doing recursive, but if Integer.MAX, then it will take a long time to run
// first solution is just to use recursive and when hit n <= 0, but you will
// actually take 1 step if you are there

// it makes me to think to use dp, to track how many way to hit each step

public class ClimbingStairs70 {
	public int climbStairs(int n) {
		if ( n < 3)
			return n; 
		int[] dp = new int[n];
		dp[0] = 0; // we do not care first
		dp[n-1] = 1;
		dp[n-2] = 2;
		for (int i= n-3; i >= 0; i--) {
			dp[i] = dp[i +1] + dp[i+2];
		}
		return dp[0];
	}


	public static void main(String[] args) {
		ClimbingStairs70 t = new ClimbingStairs70();
		System.out.println(t.climbStairs(4));
	}
}
