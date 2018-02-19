package com.cloudlewis.leetcode150;

/**
 * 
 * Given a string S and a string T, count the number of distinct subsequences of
 * S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 * 
 * @author xiao
 *
 */

// !! REIVIST

/*
 * https://discuss.leetcode.com/topic/9488/easy-to-understand-dp-in-java/2
 * 
 * @formatter:off
 * solution 1. string check substring, can use dp 
 * special case when t is empty? one or zero 
 * it will have intervening characters
 * dp[i+1][j+1] means that S[0..j] contains T[0..i] that many times as distinct subsequences.
 * build array rows-by-rows: 
 * first row must be filled with 1, because empty string is a subsequence of any string but only 1 time. 
 * dp[0][j] = 1 for every j. 
 * 
 * first column of every rows except the first must be 0, because an empty string cannot contain a non-empty string as a substring
 * dp[0][0] = 1, because an empty string contains the empty string 1 time.
 * 
 * for each i, j : if S[j] == T[i] we add the previous item and the previous item in the previous row, 
 * otherwise we copy the previous item in the same row.
 *
 * if the current character in S doesn't equal to current character T, 
 * then we have the same number of distinct subsequences as we had without the new character.
 * dp[i][j] = dp[i][j-1]
 * 
 * if the current character in S equal to the current character T, 
 * then the distinct number of subsequences: the number before + distinct number of subsequences less longer T and less longer S.
 * dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
 * 
 * @formatter:on
 * 
 * 
 */

public class DistinctSubsequences115 {
	public int numDistinct(String s, String t) {
		int slen = s.length(), tlen = t.length();
		if (tlen > slen || slen == 0)
			return 0;
		int[][] dp = new int[tlen + 1][slen +1];
		for (int j=0; j<= slen;j ++)
			dp[0][j] = 1;
		
		for (int i=0;i<tlen; i++) {
			for (int j=0;j<slen;j++) {
				if (s.charAt(j) == t.charAt(i))
					dp[i + 1][j +1] = dp[i][j] + dp[i + 1][j];
				else
					dp[i + 1][j + 1] = dp[i + 1][j];
			}
		}
		return dp[tlen][slen];
	}
}
