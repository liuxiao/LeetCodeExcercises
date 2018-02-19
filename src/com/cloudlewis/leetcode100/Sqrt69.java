package com.cloudlewis.leetcode100;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author xiao
 *
 */

// x can be odd, and result is fractional number
// x cannot < 1, by x as int

public class Sqrt69 {
	public int mySqrt(int x) {
		if (x <= 0)
			return 0;
		int i = 1, j = x;
		while (true) {
			int m = i + (j - i) / 2;
			if (m > x / m)
				j = m - 1;
			else {
				if (m + 1 > x / (m + 1)) // it should smaller, look ahead
					return m;
				else
					i = m + 1;
			}
		}
	}

	public static void main(String[] args) {
		Sqrt69 t = new Sqrt69();
		System.out.println(t.mySqrt(0));
		System.out.println(t.mySqrt(1));
		System.out.println(t.mySqrt(2));
		System.out.println(t.mySqrt(-4));
		System.out.println(t.mySqrt(5));
		System.out.println(t.mySqrt(16));
		
		System.out.println();
		
		System.out.println(t.sqrtRevisit(0));
		System.out.println(t.sqrtRevisit(1));
		System.out.println(t.sqrtRevisit(2));
		System.out.println(t.sqrtRevisit(-4));
		System.out.println(t.sqrtRevisit(5));
		System.out.println(t.sqrtRevisit(16));

	}

	public int sqrtRevisit(int x) {
		if (x <= 0)
			return 0;
		int i = 1, j = x;
		while (true) {
			int m = i + (j - i) / 2; // binary search, start from half
			if (m * m > x) {
				j = m -1;
			} else {
				// where m * m <= x
				if ((m + 1) * (m + 1) > x)
					return m;
				else
					i= m + 1;
			}
		}
	}
}
