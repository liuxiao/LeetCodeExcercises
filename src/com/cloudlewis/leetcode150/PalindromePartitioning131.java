package com.cloudlewis.leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @formatter:off
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * 
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 * @formatter:on
 * @author xiao
 *
 */
public class PalindromePartitioning131 {
	List<List<String>> rs = new ArrayList<>();
	List<String> currPath = new ArrayList<>();

	public List<List<String>> partition(String s) {
		partition(s, 0);
		return rs;
	}

	private void partition(String s, int loc) {
		if (loc == s.length())
			rs.add(new ArrayList<>(currPath));
		else {
			// single character is always palindrome
			for (int i = loc; i < s.length(); i++) { // using substring, can
														// equal
				if (isPalindrome(s, loc, i)) {
					if (loc == i)
						currPath.add(String.valueOf(s.charAt(i)));
					else
						currPath.add(s.substring(loc, i + 1));
					partition(s, i + 1);
					currPath.remove(currPath.size() - 1);
				}
				// if current is not, we just move to the next
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
