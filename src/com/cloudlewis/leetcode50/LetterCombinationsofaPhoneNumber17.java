package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * 
 * Note: Although the above answer is in lexicographical order, your answer
 * could be in any order you want.
 * 
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 * 
 * @author xiao
 *
 */

// how to handle 1? is this valid input?

public class LetterCombinationsofaPhoneNumber17 {
	public List<String> letterCombinations(String digits) {
		List<String> l = new ArrayList<String>();
		List<String> tmp = new ArrayList<String>();
		char[][] map = new char[][] {{}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		int len = digits.length();
		if (len == 0)
			return l;
		l.add("");
		for (int i = 0; i < len; i++) {
			char c = digits.charAt(i);
			int idx = c - '0'; // mapped to 0 -9, 0 and 1 is not used
			char[] candidate = map[idx];
			for (String s : l) {
				for (int j=0; j< candidate.length; j++) {
					tmp.add(s + candidate[j]);
				}
			}
			l.clear();
			l.addAll(tmp);
			tmp.clear();
		}
		return l;
	}
	
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber17 t = new LetterCombinationsofaPhoneNumber17();
		List<String> l = t.letterCombinations("23");
		System.out.println(l);
	}
}
