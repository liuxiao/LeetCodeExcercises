package com.cloudlewis.leetcode50;

/**
 * Implement pow(x, n).
 * 
 * @author xiao
 *
 */

// key is to decrement n expoentialy, so that it is efficient
// n can be positive or negative
// https://leetcode.com/problems/powx-n/#/solutions

// ??? overflow of n?

// REVISIT

public class Pow50 {
	public double myPow(double x, int n) {
		if (n == 0 || x == 1)
			return 1;
		if (n == Integer.MIN_VALUE)
			return 0;
		if (n < 0) {
			x = 1 / x;
			n = -n; // this might cause overflow
		}
		double ans = 1;
		while (n > 0) {
			if (n % 2 == 1)
				ans *= x;
			x *= x;
			n /= 2;
		}
		return ans;
	}

	public static void main(String[] args) {
		Pow50 t = new Pow50();
		System.out.println(t.myPow(2, 10));
		System.out.println(t.myPow(3, 3));
		System.out.println(t.myPow(3, -3));
	}
}
