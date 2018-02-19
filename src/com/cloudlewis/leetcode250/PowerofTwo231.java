package com.cloudlewis.leetcode250;

/**
 * 
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author xiao
 *
 */
public class PowerofTwo231 {
	public boolean isPowerOfTwo(int n) {
		if ( n <=0)
			return false;
		if (n == 1)
			return true; // 2^0
		while (n > 2) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}

	public static void main(String[] args) {
		PowerofTwo231 t = new PowerofTwo231();
		System.out.println(t.isPowerOfTwo(2));
		System.out.println(t.isPowerOfTwo(64));
		System.out.println(t.isPowerOfTwo(29));
	}
}
