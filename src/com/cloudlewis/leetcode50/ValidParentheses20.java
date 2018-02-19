package com.cloudlewis.leetcode50;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * 
 * @author xiao
 *
 */
public class ValidParentheses20 {
	public boolean isValid(String s) {
		int len = s.length();
		if (len == 0) return true;
		if (len == 1) return false;
		if (len % 2 == 1) return false; // given string only contains brackets
		Deque<Character> stack = new ArrayDeque<>();
		for (int i=0; i< len; i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c== '[')
				stack.push(c);
			else {
				// we need to pop out the exact match
				if (stack.isEmpty()) // empty, e.g. 1st elem is )
					return false;
				char p = stack.peek();
				if (c == ')' && p == '(')
					stack.pop();
				else if (c == ']' && p == '[')
					stack.pop();
				else if (c=='}' && p == '{')
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String [] args) {
		ValidParentheses20 t = new ValidParentheses20();
		System.out.println(t.isValid("()"));
		System.out.println(t.isValid("([{}])"));
		System.out.println(t.isValid("(()])"));
	}
}
