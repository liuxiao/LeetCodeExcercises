package com.cloudlewis.leetcode50;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author xiao
 *
 */

// asking for input validation and what should happen
// no integer
// mixed, with some integer
// integer too big/small, overflow
// white space, special character
// minus sign, what about plus sign
public class StringtoInteger8 {
	public int myAtoi(String str) {
		if (str == null || str.isEmpty())
			return 0;
		int len = str.length();
		int num = 0;
		boolean pos = true;
		boolean hasSign = false;
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (c == '-' || c == '+') {
				if (hasSign)
					return 0;
				else
					hasSign = true;
				if (c == '-') {
					pos = false;
					continue;
				}
			}
			if (c <= '9' && c >= '0') {
				int newnum = num * 10 + (c - '0');
				if (newnum / 10 != num)
					return (pos) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				num = newnum;
			}
		}
		if (!pos)
			return -num;
		return num;
	}
	
	public static void main(String[] args) {
		StringtoInteger8 t = new StringtoInteger8();
		System.out.println(t.myAtoi("010"));
	}
}
