package com.cloudlewis.leetcode50;

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author xiao
 *
 */

// empty string?

public class LongestCommonPrefix14 {
	public String longestCommonPrefix(String[] strs) {

		int size = strs.length;
		if (size == 0)
			return "";
		if (size == 1)
			return strs[0];
		int cursor = 0;
		char val;

		while (true) {
			if (cursor >= strs[0].length()){
				if (cursor == 0) 
					return "";
				return strs[0].substring(0, cursor);
			}
			val = strs[0].charAt(cursor);
			for (int i = 0; i < size; i++) {			
				if (cursor >= strs[i].length()) {
					return strs[i].substring(0, cursor);
				}
				else if (strs[i].charAt(cursor) != val)
					return strs[i].substring(0, cursor);
			}
			cursor ++;
		}
	}
	
	public static void main (String[] args) {
		LongestCommonPrefix14 t = new LongestCommonPrefix14();
		String[] strs = {"", "ab", "abcd"};
		System.out.println(t.longestCommonPrefix(strs));
	}
}
