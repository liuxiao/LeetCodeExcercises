package com.cloudlewis.leetcode250;

/**
 * 
 * @formatter:off
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, 
 * s = "anagram", t = "nagaram", return true. 
 * s = "rat", t = "car", return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt
 * your solution to such case?
 * 
 * @formatter:on
 * @author xiao
 *
 */
public class ValidAnagram242 {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] array = new int[256];
		for (int i = 0; i < s.length(); i++) {
			array[s.charAt(i)]++;
			array[t.charAt(i)]--;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0)
				return false;
		}
		return true;
	}
}
