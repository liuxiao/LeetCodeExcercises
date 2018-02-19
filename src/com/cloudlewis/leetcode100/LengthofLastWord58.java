package com.cloudlewis.leetcode100;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author xiao
 *
 */
public class LengthofLastWord58 {
	public int lengthOfLastWord(String s) {
		int len = s.length();
		int words = -1;
		for (int i = len -1; i>=0 ; i--){
			if (s.charAt(i) == ' ' && words != -1)
				return (words - i -1);
			else if (s.charAt(i) != ' ' && words == -1)
				words = i + 1;		
		}
		if (words > 0) // missed part!!!
			return words;
		return 0;
	}
	
	public static void main(String[] args) {
		LengthofLastWord58 t = new LengthofLastWord58();
		System.out.println(t.lengthOfLastWord("    "));
		System.out.println(t.lengthOfLastWord("a"));
		System.out.println(t.lengthOfLastWord("aa "));
		System.out.println(t.lengthOfLastWord("  a  "));
		System.out.println(t.lengthOfLastWord("  asdfw "));
		System.out.println(t.lengthOfLastWord("    qwef"));
		System.out.println(t.lengthOfLastWord(" qwef  ee "));
	}
}
