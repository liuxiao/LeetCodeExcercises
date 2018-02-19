package com.cloudlewis.leetcode250;

/**
 * 
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * @author xiao
 *
 */

// what? brute force?
// this might not pass with time limit problem?
// specically we need to handle negative problem? or overflow?
public class BitwiseANDofNumbersRange201 {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == 0)
			return 0;
		int rs = m;
		for (int i = m + 1; i <= n; i++) {
			rs &= i;
			if (rs == 0) // can terminate early
				return 0;
		}
		return rs;
	}

	// if we have 2 number and, that digit will be zero already
	// we don't even need to check for the 3rd iteration
	public int rangeBitwiseAndSmart(int m, int n) {
		int step = 0;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			step++;
		}
		return m << step;
	}

	public static void main(String[] args) {
		BitwiseANDofNumbersRange201 t = new BitwiseANDofNumbersRange201();
		System.out.println(t.rangeBitwiseAnd(5, 7));
	}
}
