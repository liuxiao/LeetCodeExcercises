package com.cloudlewis.leetcode50;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * @formatter:off
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * //@formatter:on
 * @author xiao
 *
 */

// ******RIVISIT

//@formatter:off
// assume the source string does not contains special character, and no need to consider scape
// two dimension, use DP
// dp[i][j], where i for s, j for p
// there will be 3 cases for p
// if p.charAt(j) == s.charAt(i) : dp[i][j] = dp[i-1][j-1], i.e. match
// if p.charAt(j) == '.'         : dp[i][j] = dp[i-1][j-1], i.e. match
// if p.charAt(j) == '*'		 :
// 						if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2], p* match empty, look back two place
//						if p.charAt(j-1) == s.charAt(i) | p.charAt(j-1) == '.' :
//										   dp[i][j] = dp[i][j-2] , p* matches empty, i.e. p* is useless, s is matched with previous p
//										or dp[i][j] = dp[i][j-1] , p* matches one, i.e. p is the match
//										or dp[i][j] = dp[i-1][j] , p* match multiple, i.e. 


//@formatter:on
public class RegularExpressionMatching10 {
	public boolean isMatch(String s, String p) {
		int m = s.length();
		int n = p.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true; // empty matches empty
		// this assume the * does not come either as first or last
		for (int j = 0; j < n; j++) { 
			if (p.charAt(j) == '*' && dp[0][j - 1])
				dp[0][j + 1] = true; // why j+1?
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.')
					dp[i + 1][j + 1] = dp[i][j];
				else if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
						dp[i + 1][j + 1] = (dp[i + 1][j - 1] | dp[i + 1][j] | dp[i][j + 1]);
					}
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		RegularExpressionMatching10 t = new RegularExpressionMatching10();
		System.out.println(t.isMatch("aa", "a"));
		System.out.println(t.isMatch("aa", "aa"));
		System.out.println(t.isMatch("aaa", "aa"));
		System.out.println(t.isMatch("aa", "a*"));
		System.out.println(t.isMatch("aa", ".*"));
		System.out.println(t.isMatch("ab", ".*"));
		System.out.println(t.isMatch("aab", "c*a*b"));

	}
}
