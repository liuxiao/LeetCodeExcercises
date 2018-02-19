package com.cloudlewis.leetcode100;

/**
 * @formatter:off
 * Given two words word1 and word2, find the minimum number of steps 
 * required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * @formatter:on
 * @author xiao
 *
 */

// empty string
// reversed string, assume should replace all? or what, no, at least 1, find
// same character in order
// need to simply the problem, what will happen in different cases
// question would be how many characters can collide at max
// - > can move one word one at and time, and see if they have same character
// word 1 : abcd
// word 2 : abbw
// : abbw

// Linkedin
public class EditDistance72 {

	// !!!! THIS METHOD NEED TO REWORK
	// NEED TO BE ABLE TO WRITE A LOOP LIKE THIS!
	public int minDistanceCompareString(String word1, String word2) {
		// create a array
		int len1 = word1.length(), len2 = word2.length();
		int shift = len2 + len1 - 1; // real value, because loop start from 0
		int[] match = new int[shift];
		int offset = len2 - 1;
		for (int i = 0; i < shift; i++) {
			int count = 0;
			// figure out a good j
			int j = (i - len2 > 0) ? i - len2 : 0;
			for (; j < len1; j++) {
				int k = shift - j;
				if (word2.charAt(j) == word1.charAt(k))
					count++;
			}
			// put it in place
			match[i] = count;
		}
		return 0;
	}

	/* @formatter:off
	 * dp[i][0] = i;
	 * dp[0][j] = j;
     * dp[i][j] = dp[i - 1][j - 1], if word1[i - 1] = word2[j - 1];
     * dp[i][j] = min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1, dp[i][j - 1] + 1), otherwise.
     * @formatter:on
     * 
     * https://leetcode.com/problems/edit-distance/#/solutions
     * below is an implementation with dp[l1][l2], where array is not fully used
	 */
	public int minDistance(String s1, String s2) {
		int l1 = s1.length(), l2 = s2.length();
		int[][] dp = new int[l1 + 1][l2 + 1];
		for (int i = 1; i <= l1; i++)
            dp[i][0] = i;
        for (int j = 1; j <= l2; j++)
            dp[0][j] = j;  
        for (int i=1; i<=l1; i++) {
        	for (int j=1; j<= l2; j++) {
        		if (s1.charAt(i - 1) == s2.charAt(j-1))
        			dp[i][j] = dp[i-1][j-1];
        		else
        			dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) +1;
        	}
        }
        return dp[l1][l2];
	}
	
	public static void main(String[] args) {
		EditDistance72 t = new EditDistance72();
		System.out.println(t.minDistance("bae", "bea"));
	}
	
	// !! READ --swapping the content
	public int minDistanceLinearSpace(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] cur = new int[m + 1];
        for (int i = 1; i <= m; i++)
            cur[i] = i;
        for (int j = 1; j <= n; j++) {
            int pre = cur[0];
            cur[0] = j;
            for (int i = 1; i <= m; i++) {
                int temp = cur[i];
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cur[i] = pre;
                else cur[i] = Math.min(pre + 1, Math.min(cur[i] + 1, cur[i - 1] + 1));
                pre = temp;
            }
        }
        return cur[m]; 
    }
}
