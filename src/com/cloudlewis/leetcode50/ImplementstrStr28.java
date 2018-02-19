package com.cloudlewis.leetcode50;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author xiao
 *
 */

// solution 1. using brute-force

// solution 2. using KMP - Knuth Morris Pratt
// The worst case complexity of Naive algorithm is O(m(n-m+1)). Time complexity of KMP algorithm is O(n) in worst case.
// http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/

public class ImplementstrStr28 {
	public int strStr(String haystack, String needle) {
		int slen = haystack.length();
		int nlen = needle.length();
		if (nlen > slen)
			return -1;
		if (nlen == 0 || slen == 0)
			return 0;
		int cursor = 0;
		int match = 0;
		while (cursor <= slen - nlen) { // !!! EQUAL sign, when two string has same length
			for(int i =0; i <nlen; i++) {
				if (haystack.charAt(cursor + i) == needle.charAt(i)) {
					match++;
					if (match == nlen)
						return cursor;
				}
				else{
					match = 0;
					break;
				}
			}
			cursor++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		ImplementstrStr28 t= new ImplementstrStr28();
		System.out.println(t.strStr("qiweghqpwiejfq", "wegh")); //2
		System.out.println(t.strStr("abc", "wegh")); // -1
		System.out.println(t.strStr("abc", "a")); // 0
		System.out.println(t.strStr("abc", "c")); // 2
		System.out.println(t.strStr("baaa", "abbb")); // -1
		System.out.println(t.strStr("a", "a")); // -1
		System.out.println(t.strStr("mississippi", "issip")); // 4
	
	}
}
