package com.cloudlewis.leetcode100;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * @author xiao
 *
 */

// !!!! REVISIT

// first idea is to use recursive

// can be also resolved by BFS

// Solution 3
// and by DP
// @formatter:off
// if s1 and s2 empty, s3 is empty too : interleaving. 
// if only s1 empty, if previous s2 position is interleaving and current s2 char equals to s3 current char : interleaving. 
// if only s2 empty, if previous s1 position is interleaving and current s1 char equals to s3 current char : interleaving. 
// if s1 and s2 is not empty, 
//     if we arrive i,j from i-1, j, then if i-1,j is already interleaving and i and current s3 position equal : interleaving. 
//     dp[i][j] = db[i-1][j] && s1.charAt(i) == s3.charAt(i+j)
//     if we arrive i,j from i, j-1, then if i, j-1 is already interleaving and j and current s3 position equal : interleaving.
//
// @formatter:on
// https://discuss.leetcode.com/topic/3532/my-dp-solution-in-c

public class InterleavingString97 {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i <= s1.length(); i++) {
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0 && j == 0)
					dp[i][j] = true;
				else if (i == 0)
					dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j + i - 1);
				else if (j == 0)
					dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(j + i - 1);
				else
					dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j + i - 1))
							|| (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(j + i - 1));

			}
		}
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		InterleavingString97 t = new InterleavingString97();
		System.out.println(t.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(t.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}
