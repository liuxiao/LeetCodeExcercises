package com.cloudlewis.leetcode100;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author xiao
 * 
 * https://leetcode.com/problems/minimum-window-substring/#/solutions
 *
 */

// **** REVISIT

// t should be smaller, and check
// assume no space
// what if T is "" ?

public class MinimumWindowSubstring76 {
	public String minWindow(String s, String t) {
		int slen = s.length(), tlen = t.length();
		if (slen == 0 || tlen == 0 || tlen > slen)
			return "";
		int[]map = new int[512];
		for (int i=0; i<tlen; i++)
			map[t.charAt(i)] ++;
		int cur = 0, start = 0, count = t.length(), minS = 0 ,minE = Integer.MAX_VALUE;
		while (cur < slen){
			if (map[s.charAt(cur)] > 0)
				count--;
			map[s.charAt(cur)]--;
			cur++;
			// found a valid window
			while(count == 0) {
				if (cur - start < minE) {
					minE = cur - start;
					minS = start;
				}
				map[s.charAt(start)]++;
				if (map[s.charAt(start)] > 0)
					count++;
				start++;
			}
		}
		return minE == Integer.MAX_VALUE ? "" : s.substring(minS, minE + minS);
	}
	
	public static void main(String[] args) {
		MinimumWindowSubstring76 t = new MinimumWindowSubstring76();
		System.out.println(t.minWindow("ADOBECODEBANC", "ABC"));
	}
}
