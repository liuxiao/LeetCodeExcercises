package com.cloudlewis.leetcode50;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author xiao
 *
 */
public class LongestValidParentheses32 {

	public int tlongestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '(')
				stack.push(j);
			else {
				if (stack.isEmpty())
					left = j;
				else {
					stack.pop();
					if (stack.isEmpty())
						max = Math.max(max, j - left);
					else
						max = Math.max(max, j - stack.peek());
				}
			}
		}
		return max;
	}

	// https://discuss.leetcode.com/topic/7234/simple-java-solution-o-n-time-one-stack
	public int longestValidParentheses(String s) {
		Deque<Integer> q = new ArrayDeque<>();
		int len = s.length();
		if (len < 2)
			return 0;
		int start = -1;
		int max = 0;
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '(')
				q.push(i);
			else {
				if (q.isEmpty()) {
					start = i; // not valid until i
				} else {
					q.pop();
					if (q.isEmpty())
						max = Math.max(max, i - start);
					else
						max = Math.max(max, i - q.peek());
				}
			}
		}
		return max;
	}

	/**
	 * this does not work! first draft; thinking without using extra space
	 * 
	 * @param s
	 * @return
	 */
	public int longestValidParenthesesNoStack(String s) {
		int len = s.length();
		int start = -1;
		int open = 0, i = 0;
		int max = 0;
		while (i < len) {
			if (s.charAt(i) == '(') {
				if (start == -1)
					start = i; // assign the first valid location
				open++;
			} else {
				open--;
				if (open == 0 && (i - start + 1) > max)
					max = i - start + 1;
				if (open < 0) { // screw up all previous
					start = -1; // start from scratch
					open = 0;
				}
			}
			i++;
		}
		// speical case where string ended, but open != 0
		// ((((() = 6 - 0 - 4 = 2
		// (()(() = 6 - 0 - 2 = 4 -- wrong
		// (()((())
		// int special = len - start - open;
		return max;
	}

	public int longestByMask(String s) {
		int max = 0;
		int lmax = 0;
		int len = s.length();
		char[] str = s.toCharArray();
		if (len < 2)
			return 0;
		for (int i = 0; i < len; i++) {
			if (str[i] == ')') { // find the matching bracket and mark it as 0
				for (int j = i - 1; j >= 0; j--) {
					if (str[j] == '(') {
						str[i] = '0';
						str[j] = '0';
						break;
					}
				}
			}
		}
		// find the longest 0 seq
		for (int i = 0; i < len; i++) {
			if (str[i] == '0')
				lmax++;
			else { // not equal
				if (lmax > max)
					max = lmax;
				lmax = 0;
			}
		}
		return Math.max(max, lmax);
	}

	public static void main(String[] args) {
		LongestValidParentheses32 t = new LongestValidParentheses32();
		System.out.println(t.longestValidParentheses("()()")); // 4
		System.out.println(t.longestValidParentheses("(()")); // 2
		System.out.println(t.longestValidParentheses(")()())")); // 4
		System.out.println(t.longestValidParentheses(")")); // 0
		System.out.println(t.longestValidParentheses("(")); // 0
		System.out.println(t.longestValidParentheses("(()(()")); // 2
	}
}
