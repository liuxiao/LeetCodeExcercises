package com.cloudlewis.leetcode200;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author xiao
 *
 */

/*
 * find number zero in a factorial result; using dp to calculate the result? and
 * then really counting zeros? this is a O(n) solution
 * 
 * 10 is the product of 2 and 5. In n!, we need to know how many 2 and 5, and
 * the number of zeros is the minimum of the number of 2 and the number of 5.
 * 
 * Since multiple of 2 is more than multiple of 5, the number of zeros is
 * dominant by the number of 5.
 * 
 * Note the duplication: multiple of 25 is also multiple of 5, so multiple of 25
 * only provides one extra 5. return n/5 + n/25 + n/125 + n/625 + n/3125+...;
 * 
 * i.e. we just need to calculate how many 5 are there
 * 
 */
public class FactorialTrailingZeroes172 {
	public int trailingZeroes(int n) {
		int num = 0;
		while (n > 0) {
			num += n / 5;
			n /= 5;
		}
		return num;
	}

	// translated to count number of 5
	public int trailingZeroesRecursive(int n) {
		return (n == 0) ? 0 : n / 5 + trailingZeroesRecursive(n /5);
	}

	public static void main(String[] args) {
		FactorialTrailingZeroes172 t = new FactorialTrailingZeroes172();
		System.out.println(t.trailingZeroesRecursive(10));
		System.out.println(t.trailingZeroes(10));

		System.out.println(t.trailingZeroesRecursive(21));
		System.out.println(t.trailingZeroes(21));
	}
}
