package com.cloudlewis.leetcode250;

import java.util.Stack;

/**
 * @formatter:off
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples: 
 * 
 * "3+2*2" = 7 
 * " 3/2 " = 1 
 * " 3+5 / 2 " = 5
 * 
 * @formatter:on
 */

// !!! REVISIT
// LinkedIn
public class BasicCalculatorII227 {
	public int calculate(String s) {
		char[] str = s.toCharArray();
		int rs = 0;
		int num = 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < str.length; i++) {
			char c = str[i];
			if (Character.isDigit(c))
				num = num * 10 + c - '0';
			if (!Character.isDigit(c) && c != ' ' || i == str.length - 1) {
				if (sign == '+')
					stack.push(num);
				else if (sign == '-')
					stack.push(-num);
				else if (sign == '*')
					stack.push(stack.pop() * num);
				else if (sign == '/')
					stack.push(stack.pop() / num);
				sign = c;
				num = 0;
			}
		}
		while (!stack.isEmpty())
			rs += stack.pop();

		return rs;
	}

	public static void main(String[] args) {
		BasicCalculatorII227 t = new BasicCalculatorII227();
		System.out.println(t.calculate("3+2*2"));
		System.out.println(t.calculate(" 3/2"));
		System.out.println(t.calculate(" 3+5 / 2 "));
	}
}
