package com.cloudlewis.leetcode50;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer. Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * @author xiao
 *
 */

// *******RIVISIT
//@formatter:off
// solution 1. use stupid way; iteration each position and extend
// extend function run O(n), and pick pivot run O(n), total is O(n^2), space O(1)

// solution 2. having a map to store the data if at particular location
// if table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j) => table[i][j] == 1

// solution 3. in linear time, https://en.wikipedia.org/wiki/Longest_palindromic_substring

// solution 4. at bottom; take partial solution of 1, but we could move to the next window with "max string"
// 				size
//@formatter:on
public class LongestPalindromicSubstring5 {

	String rs = "";

	public String longestPalindrome(String s) {
		if (s.length() == 1 || (s.length() == 2 && s.charAt(0) == s.charAt(1)))
			return s;
		int len = s.length();
		for (int i = 0; i < len - 1; i++) {
			extend(s, i, i);
			extend(s, i, i + 1);
		}
		return rs;
	}

	private void extend(String s, int left, int right) {
		int len = s.length();
		if (s.charAt(left) != s.charAt(right))
			return;

		while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
			if (rs.length() < right - left + 1)
				rs = s.substring(left, right + 1);
			left--;
			right++;

		}
	}

	public String longestPalindromeWithDP(String s) {
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		String rs = "";
		int max = 0;
		for (int k = 0; k < len; k++) {
			for (int i = 0; i < len - 1; i++) {
				int j = i + 1;
				if (s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1] == true)
					dp[i][j] = true;
				if (j - i + 1 > max) {
					max = j - i + 1;
					rs = s.substring(i, j);
				}
			}
		}
		return rs;
	}

	public String longestPalindromea(String s) {
		if (s == null || s.length() <= 1)
			return s;

		int len = s.length();
		int maxLen = 1;
		boolean[][] dp = new boolean[len][len];

		String longest = null;
		for (int l = 0; l < s.length(); l++) {
			for (int i = 0; i < len - l; i++) {
				int j = i + l;
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					dp[i][j] = true;

					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						longest = s.substring(i, j + 1);
					}
				}
			}
		}
		if (longest == null)
			return s.substring(0, 1);
		return longest;
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring5 t = new LongestPalindromicSubstring5();
		System.out.println(t.getLPwDP("babad"));
		System.out.println(t.getLPwDP("cbbd"));
		System.out.println(t.getLPwDP("aa"));
		System.out.println(t.getLPwDP("aba"));
		System.out.println(t.getLPwDP("abcda"));
		System.out.println(t.getLPwDP("abcddcba"));
		System.out.println(t.getLPwDP("abcdcba"));
	}

	//@formatter:off
    // duplicate solution as above, exercise
    public String getLPwDP(String s) {
    	if (s.length() == 1)
    		return s;
    	int len = s.length();
    	boolean[][] flag = new boolean[len][len]; // by default all false
    	String max = "";
    	int maxlen = 0;
    	for (int i=0; i<len; i++)
    		flag[i][i] =true;
    	// i is the left cursor, j is the right cursor, no need to cross
    	for (int j=1;j<len;j++) { // we can reduce big loop by 1, since j will cover it
    		for (int i= j-1 ; i >= 0; i--) { // can always increase one, because it is covered;
    			//if (i== j) //special case, diagonal
    			//	flag[i][j] = true;
    			if (s.charAt(i) == s.charAt(j) && (j - i <=2 || flag[i+1][j-1] == true)) { // case, aa and aba
    				flag[i][j] = true;
    				if (j-i +1 > maxlen)
    					max = s.substring(i,j+1);
    			}
    			//else
    				//break; // no need to work, all false already
    		}
    	}
    	if (max.isEmpty())
    		return s.substring(0,1);
    	return max;
    }
    //@formatter:on
	// DP solution will save time when visit existing discovered code;
	// can use another way to optimize, not DP, but given max len, we don't have
	// to check anything shorter; this optimization does not work for DP,
	// because DP need each building block
    
   

}
