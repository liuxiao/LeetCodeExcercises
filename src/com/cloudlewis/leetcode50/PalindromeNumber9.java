package com.cloudlewis.leetcode50;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author xiao
 *
 */

// negative?
// reverse and compare, but if reverse, might overflow -> only happen on MAX_INT case
// only reverse half of the sequence, so no overflow
// if overflow, then it is not a palindrome number
// what about 0? --- true

public class PalindromeNumber9 {
	public boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x%10 ==0)) return false;
		int rev = 0;
		while (x > rev) {
			rev = rev * 10  + x % 10;
			x = x /10;
		}
		return ( rev == x || rev / 10 == x);
	}
	
	public static void main(String [] args) {
		PalindromeNumber9 t = new PalindromeNumber9();
		System.out.println(t.isPalindrome(1233454321));
	}
}
