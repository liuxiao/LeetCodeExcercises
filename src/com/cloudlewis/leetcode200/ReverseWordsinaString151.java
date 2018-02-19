package com.cloudlewis.leetcode200;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * @author xiao
 *
 */

// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.

public class ReverseWordsinaString151 {
    public String reverseWords(String s) {
    	if (s.trim().isEmpty())
    		return "";
        String[] str = s.split(" ");
        StringBuilder b = new StringBuilder();
        for (int i=str.length - 1; i>=0; i--)
        	if(!str[i].isEmpty())
        		b.append(str[i] + " ");
        return b.deleteCharAt(b.length() - 1).toString(); // delete last space
    }
}
