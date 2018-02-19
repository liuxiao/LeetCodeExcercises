package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author xiao
 *
 */

// HOW to think about this question in DP!!

// Solution 1.
// this is very similar to Palindrome - take 0-i out and then pass i into
// function recursively

// Solution 2.
// using DP

public class WordBreak139 {

	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		if (len == 0)
			return false;
		boolean[] dp = new boolean[len + 1];
		dp[0] = true; // empty string match, as base case
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (wordDict.contains(s.substring(j, i)) && dp[j]) {
					dp[i] = true;
					break;// ? no need to check further, i is marked true already
				}
			}
		}
		return dp[len];
	}

	// this will have Time Limit issue online judge
	public boolean wordBreakRecursive(String s, List<String> wordDict) {
		return wbreak(s, 0, wordDict);
	}

	private boolean wbreak(String s, int loc, List<String> wordDict) {
		if (wordDict.contains(s.substring(loc)))
			return true;
		for (int i = loc; i < s.length(); i++) {
			if (wordDict.contains(s.substring(loc, i + 1))) {
				if (wbreak(s, i + 1, wordDict))
					return true;
			} // if head is not, then we could just continue
		}
		return false;
	}

	public static void main(String[] args) {
		WordBreak139 t = new WordBreak139();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(t.wordBreak("leetcode", wordDict));
	}
}
