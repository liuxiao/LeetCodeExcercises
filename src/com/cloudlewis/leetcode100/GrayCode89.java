package com.cloudlewis.leetcode100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 * @formatter:off
 * 00 - 0 
 * 01 - 1 
 * 11 - 3 
 * 10 - 2 
 * 
 * @formatter:on
 * Note: For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the
 * above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code
 * sequence. Sorry about that.
 */

// https://en.wikipedia.org/wiki/Gray_code#Constructing_an_n-bit_Gray_code

// intutive way is to solve it in recursive way, generate two and cancatenate


public class GrayCode89 {
	public List<Integer> grayCodeRecursive(int n) {
		List<Integer> rs = new ArrayList<>();
		if ( n == 0) {
			rs.add(0);
			return rs;
		}
		grayRecursive(n, rs);
		return rs;
	}
	
	private void grayRecursive(int n, List<Integer> rs) {
		if (n == 1) {
			rs.add(0); // base case
			rs.add(1);
			return;
		}
		grayRecursive(n -1, rs);
		for (int i = rs.size() - 1; i>=0; i--)
			rs.add(rs.get(i) | 1<< (n - 1));
	}
	
	public static void main(String[] args) {
		GrayCode89 t = new GrayCode89();
		System.out.println(t.grayCodeRecursive(0));
		System.out.println(t.grayCodeRecursive(2));
	}
	
	// what the hack is this solution?!!!
	public List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
	    for (int i = 0; i < 1<<n; i++) 
	    	result.add(i ^ i>>1);
	    return result;
	}
}
