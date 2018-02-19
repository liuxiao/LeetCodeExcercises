package com.cloudlewis.leetcode200;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * 
 * @author xiao
 *
 */

// idea is to check number, only most significant bit matters
// if two number is the same on first digit and :
// --- same length, take a bigger one
// --- diff length, check next digit, and pick bigger one
// -----------------no next digit, pick this one

// any benefit to sort the array?

public class LargestNumber179 {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";

		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			s_num[i] = String.valueOf(nums[i]);

		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1); // reverse order here, so we can do
											// append() later
			}
		};

		Arrays.sort(s_num, comp);
		// An extreme edge case by lc, say you have only a bunch of 0 in your
		// int array
		if (s_num[0].charAt(0) == '0')
			return "0";

		StringBuilder sb = new StringBuilder();
		for (String s : s_num)
			sb.append(s);

		return sb.toString();

	}
}
