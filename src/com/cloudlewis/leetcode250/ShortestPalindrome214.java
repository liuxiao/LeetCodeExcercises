package com.cloudlewis.leetcode250;

/**
 * 
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author xiao
 *
 */

/*
 * !!! REVISIT
 * 
 * Solution 1. Brute Force if == 1, return if == 2, if same, return if >= 3,
 * start from 2nd char
 * 
 * Solution 2. use reverse recursion
 */
public class ShortestPalindrome214 {

	public String shortestPalindrome(String s) {
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == s.charAt(j)) {
				j += 1;
			}
		}
		if (j == s.length()) {
			return s;
		}
		String suffix = s.substring(j);
		return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
	}
	
	public static void main(String [] args) {
		ShortestPalindrome214 t = new ShortestPalindrome214();
		System.out.println(t.shortestPalindrome("abcd")); //dcbabcd
		System.out.println(t.shortestPalindrome("aacecaaa")); //aaacecaaa
	}
}
