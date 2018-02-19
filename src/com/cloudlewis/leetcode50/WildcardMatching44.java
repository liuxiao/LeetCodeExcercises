package com.cloudlewis.leetcode50;

/**
 * @formatter:off
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * is Match("aa", "*") ? true
 * isMatch("aa", "a*") ? true
 * isMatch("ab", "?*") ? true
 * isMatch("aab", "c*a*b") ? false
 * 
 * 
 */

// follow concept in question 10, using DP, but extends conditions
// this seems eaiser, because * will just match everything

//two dimension, use DP
//dp[i][j], where i for s, j for p
//there will be 3 cases for p
//if p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1], i.e. match
//if p.charAt(j) == '?'         : dp[i][j] = dp[i-1][j-1], i.e. match
//if p.charAt(j) == '*'		    : dp[i][j] = dp[i][j-1] , p* matches empty, i.e. p* is useless, s is matched with previous p
//							   or dp[i][j] = dp[i-1][j-1] , p* match multiple anything
//@formatter:on

public class WildcardMatching44 {
	public boolean isMatch(String s, String p) {
		int slen = s.length(), plen = p.length();
		// alg will look back, to make it generic, make size bigger
		boolean[][] dp = new boolean[slen + 1][plen + 1];
		dp[0][0] = true;
		// in case first characters is *, which we backtrace, we fill them first
		for (int i = 1; i <= plen; i++) {
			if (p.charAt(i - 1) == '*')
				dp[0][i] = true;
			else
				break;
			// this break is important, this should only work at beginning;
			// set true in middel will causing rest of the matching to be "true"
			// always
		}
		for (int i = 1; i < slen + 1; i++) {
			for (int j = 1; j < plen + 1; j++) {
				if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?')
					dp[i][j] = dp[i - 1][j - 1];
				else if (p.charAt(j - 1) == '*') {
					dp[i][j] = (dp[i][j - 1] | dp[i - 1][j]);
				} // default false, no else
			}
		}
		return dp[slen][plen];
	}

	public static void main(String[] args) {
		WildcardMatching44 t = new WildcardMatching44();
		System.out.println(t.isMatch("aa", "a")); // false
		System.out.println(t.isMatch("aa", "aa")); // true
		System.out.println(t.isMatch("aaa", "aa")); // false
		System.out.println(t.isMatch("aa", "*")); // true
		System.out.println(t.isMatch("aa", "a*"));// true
		System.out.println(t.isMatch("ab", "?*")); // true
		System.out.println(t.isMatch("aab", "c*a*b")); // false
		System.out.println(t.isMatch("aadwefb", "*a*b")); // true
	}
}
