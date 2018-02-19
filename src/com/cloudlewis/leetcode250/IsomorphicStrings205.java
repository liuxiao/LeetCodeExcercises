package com.cloudlewis.leetcode250;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note: You may assume both s and t have the same length.
 * 
 * 
 * @author xiao
 *
 */

// very easy question.
// can we do it with hashmap?
// we can do it with an array --> similar to hashmap
// we can do it on one character or number, bit operation, constant space
public class IsomorphicStrings205 {
	public boolean isIsomorphic(String s, String t) {
		// !!! TRICKY, need to map reverse
		Map<Character, Character> map = new HashMap<>();
		Map<Character, Character> rmap = new HashMap<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (map.containsKey(s.charAt(i)))
					if (map.get(s.charAt(i)) != t.charAt(i) )
						return false;
				if (rmap.containsKey(t.charAt(i))) {
					if (rmap.get(t.charAt(i)) != s.charAt(i))
						return false;
				}
			}
			else { // if ==, we need to make sure it is not mapped
				if (map.containsKey(s.charAt(i)))
					if (map.get(s.charAt(i)) != t.charAt(i) )
						return false;
			}
			map.put(s.charAt(i), t.charAt(i));
			rmap.put(t.charAt(i), s.charAt(i));
		}
		return true;
	}

	public boolean isIsomorphicArr(String s, String t) {
		int[] m1 = new int[256], m2 = new int[256];
		int n = t.length();
		for (int i = 0; i < n; ++i) {
			if (m1[s.charAt(i)] != m2[t.charAt(i)])
				return false;
			m1[s.charAt(i)] = i + 1;
			m2[t.charAt(i)] = i + 1;
		}
		return true;
	}

	public static void main(String[] args) {
		IsomorphicStrings205 t = new IsomorphicStrings205();
		System.out.println(t.isIsomorphic("aba", "baa"));
		System.out.println(t.isIsomorphic("egg", "add"));
		System.out.println(t.isIsomorphic("foo", "bar"));
		System.out.println(t.isIsomorphic("paper", "title"));
		System.out.println(t.isIsomorphic("ab", "aa"));
	}
}
