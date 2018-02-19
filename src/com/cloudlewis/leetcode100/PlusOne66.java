package com.cloudlewis.leetcode100;

import com.cloudlewis.leetcode.common.Util;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus
 * one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number
 * 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * 
 * @author xiao
 *
 */

// seems like the trick is the carry for the first digit
public class PlusOne66 {
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int carry = 1;
		for (int i=len - 1; i >=0; i--) {
			int local = digits[i] + carry;
			digits[i] = local % 10;
			carry = local / 10;
		}
		if (carry == 0)
			return digits;
		else {
			int[] rs = new int[len + 1];
			rs[0] = 1;
			for (int i= 0; i< len; i++)
				rs[i + 1] = digits[i];
			return rs;
		}
	}
	
	public static void main(String[] args) {
		PlusOne66 t = new PlusOne66();
		Util.printArray(t.plusOne(new int[] {1,2,3,4,5}));
		Util.printArray(t.plusOne(new int[] {1,2,3,4,9}));
		Util.printArray(t.plusOne(new int[] {9,9,9}));
	}
}
