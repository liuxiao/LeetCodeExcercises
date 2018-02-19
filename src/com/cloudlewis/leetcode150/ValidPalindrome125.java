package com.cloudlewis.leetcode150;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author xiao
 *
 */

// as simple as two pointer and move towards center?

public class ValidPalindrome125 {
	public boolean isPalindrome(String s) {
		if (s.isEmpty())
			return true;
		s = s.toLowerCase(); // easy to handle
		int i = 0, j = s.length() - 1;
		while (i < j) { // ? equal --- not needed
			while (i < j && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') && !(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
				i++;
			while (j > i && !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') && !(s.charAt(j) >= '0' && s.charAt(j) <= '9'))
				j--;
			if (i > j) // can equal, so next can compare same word
				return false;
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome125 t = new ValidPalindrome125();
		System.out.println(t.isPalindrome("1b1"));
		System.out.println(t.isPalindrome("0p")); //treated 0 as special char
		System.out.println(t.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(t.isPalindrome("race a car"));
	}
}
