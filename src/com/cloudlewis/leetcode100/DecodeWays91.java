package com.cloudlewis.leetcode100;

/**
 * @formatter:off
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 * @formatter:on
 * @author xiao
 *
 */

// standard problem to use DP
// dp[i] = dp[i-1] + isWord(i-1, i)? dp[i-2]

// !!! REIVIST for boundary condition

public class DecodeWays91 {
	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		int[] dp = new int[n + 1];
		dp[n] = 1; // !!! SMART to from end, because 0 can be deected, only 10
					// is valid, not 01
		dp[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;
		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '0')
				continue;
			else
				dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
		}
		return dp[0];
	}

	public static void main(String[] args) {
		DecodeWays91 t = new DecodeWays91();
		System.out.println(t.numDecodings("123")); // ABC, LC, AW
		System.out.println(t.numDecodings("10")); // only 1
	}
}
