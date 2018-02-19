package com.cloudlewis.leetcode50;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author xiao
 *
 */

// asking what about overflow, after reverted
// what about 100, 10, will be 1?

// missed overflow case to return 0;
// 2,147,483,647

public class ReverseInteger7 {
	public int reverse(int x) {
		if (x == 0) return 0;
		int num = 0;
		while( x != 0) {
			int newnum = num * 10 + x %10;
			if (newnum /10 != num)
				return 0;
			num = newnum;
			x /= 10;
		}
		return num;
	}
	
	// overflow test 1534236469
	public static void main(String[] args) {
		ReverseInteger7 t = new ReverseInteger7();
		System.out.println(t.reverse(1534236469));
	}
}

