package com.cloudlewis.leetcode400;

/**
 * 
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16 Returns: True Example 2:
 * 
 * Input: 14 Returns: False
 * 
 * @author xiao
 *
 */

/*
 * stupid way is to find from 1...num/2 better way is to use binary search
 */
public class ValidPerfectSquare367 {
	public boolean isPerfectSquare(int num) {
		int left = 0, right = num;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if (mid * mid == num)
				return true;
			else if (mid * mid > num)
				right = (int)mid -1;
			else // (mid * mid < num)
				left = (int)mid + 1;
		}
		return false;
	}

	// use newton's method
	// https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
	public boolean isPerfectSquareNT(int num) {
		if (num < 0)
			return false;
		long x = num / 2 + 1;
		while (x * x > num) {
			x = (num / x + x) >> 1;
		}
		return (x * x == num);
	}

	public static void main(String[] args) {
		ValidPerfectSquare367 t = new ValidPerfectSquare367();
		System.out.println(t.isPerfectSquare(808201));
		//System.out.println(t.isPerfectSquare(16));
		//System.out.println(t.isPerfectSquare(1024));
		//System.out.println(t.isPerfectSquare(45));

		System.out.println(t.isPerfectSquareNT(808201));
		System.out.println(t.isPerfectSquareNT(1));
		System.out.println(t.isPerfectSquareNT(16));
		System.out.println(t.isPerfectSquareNT(1024));
		System.out.println(t.isPerfectSquareNT(45));
	}
}
