package com.cloudlewis.leetcode150;

/**
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * @author xiao
 *
 */

// !!! REVISIT

// using DP
// tricky part is question #131 and #132 are solved completely different
// #131 is finding a solution, while #132 is map it to a math problem and
// progressive find the answer

/*
 * @formatter:off
 * each cut at i+j is calculated by scanning (i-j)'s minimum cut + 1 if s[i-j,
 * i+j] is a palindrome
 *
 * This divide-and-conquer algorithm utilize the symmetry of palindromes, so
 * there is no need to cache the result of whether s[i:j) is a palindrome.
 *
 * Say that it started at s[i] = 'b', and s[i-1,i+1] is a palindrome "aba": 
 * 
 * .......aba...
 * |<-X->| ^
 * |<---Y-->|
 * 
 * And we know the least cuts for s[0,i-1) is X, then the least cuts for s[0,i+1] Y
 * is not greater than X+1. Last, we need to find out all the palindromes in
 * s[0,i+1] so as to minimize the number of cuts.
 * 
 * @formatter:on
 */

public class PalindromePartitioningII132 {
	public int minCut(String s) {
		int len = s.length();
		int[] dp = new int[len + 1];
		for (int i = 0; i <= len; i++)
			dp[i] = i - 1; // min cut cannot smaller than string len -1
		for (int i = 0; i < len; i++) {
			for (int j = 0; i - j >= 0 && i + j < len && s.charAt(i + j) == s.charAt(i - j); j++)
				dp[i + j + 1] = Math.min(dp[i + j + 1], 1 + dp[i - j]); // odd
																		// length
																		// palindrome
			for (int j = 1; i - j + 1 >= 0 && i + j < len && s.charAt(i + j) == s.charAt(i - j + 1); j++)
				dp[i + j + 1] = Math.min(dp[i + j + 1], 1 + dp[i - j + 1]); // even
		}
		return dp[len];
	}
}
