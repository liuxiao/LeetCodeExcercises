package com.cloudlewis.leetcode150;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples:
 * 
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * 
 * ["4", "13","5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author xiao
 *
 */

// asking assume the input is valid

// very much like using a stack

public class EvaluateReversePolishNotation150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		int len = tokens.length;
		for (int i = 0; i < len; i++) {
			if (tokens[i].equals("+")) {
				int p1 = s.pop();
				int p2 = s.pop();
				int rs = p1 + p2;
				s.push(rs);
			} else if (tokens[i].equals("-")) {
				int p1 = s.pop();
				int p2 = s.pop();
				int rs = p2 - p1;
				s.push(rs);
			} else if (tokens[i].equals("*")) {
				int p1 = s.pop();
				int p2 = s.pop();
				int rs = p1 * p2;
				s.push(rs);
			} else if (tokens[i].equals("/")) {
				int p1 = s.pop();
				int p2 = s.pop();
				int rs = p2 / p1; // assume no zero?!
				s.push(rs);
			} else { // numbers
				s.push(Integer.parseInt(tokens[i]));
			}
		}
		// ideally there is only one entry
		return s.pop();
	}

	public static void main(String[] args) {
		String[] t1 = { "2", "1", "+", "3", "*" };
		String[] t2 = { "4", "13", "5", "/", "+" };
		EvaluateReversePolishNotation150 t = new EvaluateReversePolishNotation150();
		System.out.println(t.evalRPN(t1));
		System.out.println(t.evalRPN(t2));
	}
}
