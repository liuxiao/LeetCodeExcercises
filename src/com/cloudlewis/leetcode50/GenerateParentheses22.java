package com.cloudlewis.leetcode50;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * @formatter:off
 *[
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 *]
 *
 *@formatter:on
 * 
 * @author xiao
 *
 */

// tried to use iterative, but failed; hard to control the closing bracket
// switch to use recursive

public class GenerateParentheses22 {
	public List<String> generateParenthesis(int n) {
		List<String> rs = new ArrayList<String>();
		generateParenthesis(rs, "", 0, 0, n);
		return rs;
	}
	
	//backtracing
	private void generateParenthesis(List<String> list, String s, int f, int b, int n) {
		if (s.length() == n + n) {
			list.add(s);
			return;
		}
		if (f < n)
			generateParenthesis(list, s + "(", f +1, b, n);
		if (b < f)
			generateParenthesis(list, s + ")", f, b+1, n);
	}
	
	
	
	public static void main(String[] args) {
		GenerateParentheses22 t = new GenerateParentheses22();
		System.out.println(t.generateParenthesis(3));
	}
}
