package com.cloudlewis.leetcode100;

/**
 * 
 * @formatter:off
 * Given a string s1, we may represent it as a binary tree by partitioning it to
 * two non-empty substrings recursively.
 * 
 * Below is one possible representation of s1 = "great":
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may
 * choose any non-leaf node and swap its two children.
 * 
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 * 
 *
 *      rgeat
 *      /    \
 *     rg    eat
 *    / \    /  \
 *   r   g  e   at
 *             / \
 *            a   t
 *
 * We say that "rgeat" is a scrambled string of "great".
 * 
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it
 * produces a scrambled string "rgtae".
 * 
 *       rgtae
 *      /    \
 *     rg    tae
 *    / \    /  \
 *   r   g  ta  e
 *         / \
 *        t   a
 * 
 * We say that "rgtae" is a scrambled string of "great".
 * 
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 * 
 * @author xiao
 *
 */

// Solution 1. failed to execute
// idea is to scramble one string, backtracing and compare it with s2
// untill it exhaust all possible scamble
// to keep node, we could use stack

// Solution 2. using recursive

public class ScrambleString87 {
	 public boolean isScramble(String s1, String s2) {
	        int len = s1.length();;
	        if (len != s2.length())
	        	return false;
	        if (s1.equalsIgnoreCase(s2)) // lazy
	        	return true;
	        int count[] = new int[255];
	        for(int i=0; i<len; i++)
	        {
	            count[s1.charAt(i)-'a']++;
	            count[s2.charAt(i)-'a']--;
	        }
	        
	        for(int i=0; i<26; i++)
	        {
	            if(count[i]!=0)
	                return false;
	        }
	        for (int i=1; i<= len - 1; i++){
	        	if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
	        		return true;
	        	if (isScramble(s1.substring(0, i), s2.substring(len -i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))
	        		return true;
	        }
	        return false;
	    }
	 
	 public static void main(String [] args) {
		 ScrambleString87 t = new ScrambleString87();
		 System.out.println(t.isScramble("rgtae", "great"));
	 }
}
